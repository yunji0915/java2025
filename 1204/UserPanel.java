import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.net.URL;

public class UserPanel extends JPanel {
    
    private SmartTourismManager parentFrame;
    private JTextField reservationIdField; // ⭐추가: 예약 ID 입력 필드

    public UserPanel(SmartTourismManager parentFrame) {
        this.parentFrame = parentFrame;
        
        setLayout(new BorderLayout(30, 30));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        
        JLabel title = new JLabel("Welcome to Tourist Kiosk Mode", JLabel.CENTER);
        title.setFont(new Font("맑은 고딕", Font.BOLD, 28));
        add(title, BorderLayout.NORTH);

        // ----------------------------------------------------
        // 1. 기능 버튼 영역 (중앙)
        // ----------------------------------------------------
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 20, 50));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30,0,30,0));
        
        // 타일 크기 고정 (이미지 크기에 맞게 고정)
        final int TILE_WIDTH = 280; 
        final int TILE_HEIGHT = 160;
        
        // 버튼 2개가 가질 총 너비 + 원하는 간격 (예: 280*2 + 20 = 580)
        final int TARGET_WIDTH = (TILE_WIDTH * 2) + 20;
        //수정
        centerPanel.setPreferredSize(new Dimension(TARGET_WIDTH, (TILE_HEIGHT * 2) + 50)); // 대략적인 높이 지정
        
        // 버튼 스타일 설정
        Font buttonFont = new Font("맑은 고딕", Font.BOLD, 20);
        
// ⭐ 수정된 부분: 이미지 경로를 .png로 변경
        
        // 1-1. 예약 조회 및 발권
        centerPanel.add(createImageButton("user_inquiry_final.png", TILE_WIDTH, TILE_HEIGHT, 
                "① 예약 조회 및 티켓 발권", 
                e -> showReservationInquiryDialog()
        ));
        
        // 1-2. 실시간 혼잡도 조회
        centerPanel.add(createImageButton("user_congestion_final.png", TILE_WIDTH, TILE_HEIGHT, 
                "② 현재 혼잡 구역 조회", 
                e -> JOptionPane.showMessageDialog(this, "현재 혼잡한 구역 정보가 팝업으로 표시됩니다.\n(관리자 모드의 예측 데이터 활용)", "기능 안내", JOptionPane.INFORMATION_MESSAGE)
        ));
        
        // 1-3. 관광지 안내
        centerPanel.add(createImageButton("user_info_final.png", TILE_WIDTH, TILE_HEIGHT, 
                "③ 관광지 이용 안내", 
                e -> JOptionPane.showMessageDialog(this, "운영 시간, 편의시설, 안전 수칙 안내를 제공합니다.", "기능 안내", JOptionPane.INFORMATION_MESSAGE)
        ));
        
        // 1-4. 가상 결제 및 예약
        centerPanel.add(createImageButton("user_reserve_final.png", TILE_WIDTH, TILE_HEIGHT, 
                "④ 현장 예약 및 가상 결제", 
                e -> JOptionPane.showMessageDialog(this, "가상 키패드를 이용한 결제 보안이 적용됩니다.", "보안 강조", JOptionPane.INFORMATION_MESSAGE)
        ));
        
        add(centerPanel, BorderLayout.CENTER);
        
     // ⭐ 핵심 수정 3: centerPanel을 FlowLayout을 쓰는 새 패널에 넣어 중앙 정렬
        JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        wrapperPanel.add(centerPanel);
        
        add(wrapperPanel, BorderLayout.CENTER); // wrapperPanel을 BorderLayout.CENTER에 추가
        
        // ----------------------------------------------------
        // 2. 로그아웃 (하단)
        // ----------------------------------------------------
        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setFont(buttonFont);
        logoutBtn.addActionListener(e -> parentFrame.showPanel("LOGIN"));

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(logoutBtn);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    
    /**
     * 이미지를 버튼으로 만드는 헬퍼 메서드 (리소스 로딩 방식 유지)
     */
    private JButton createImageButton(String imagePath, int width, int height, String fallbackText, ActionListener action) {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(width, height));
        button.addActionListener(action);
        button.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        
        // ClassLoader를 사용하여 리소스 로딩 시도
        // ⭐ 이전에 수정된 ClassLoader를 사용한 리소스 로딩 방식은 그대로 유지합니다.
        URL imageUrl = getClass().getClassLoader().getResource(imagePath);
        
        if (imageUrl != null) {
            // 이미지 로드 성공
            try {
                Image img = new ImageIcon(imageUrl).getImage();
                Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); 
                button.setIcon(new ImageIcon(scaledImg));
                
                button.setBorderPainted(false);
                button.setContentAreaFilled(false);
                button.setFocusPainted(false); 
                
            } catch (Exception e) {
                setupFallbackButton(button, fallbackText, imagePath);
            }
        } else {
            // 이미지 리소스를 찾지 못했을 경우 대체 처리
            setupFallbackButton(button, fallbackText, imagePath);
        }

        return button;
    }
    
    /**
     * 이미지 로드 실패 시 대체 버튼 설정
     */
    private void setupFallbackButton(JButton button, String fallbackText, String imagePath) {
        button.setText(fallbackText + " (리소스 없음)"); 
        
        button.setBorderPainted(true);
        button.setContentAreaFilled(true);
        button.setBackground(Color.LIGHT_GRAY); 
    }
    
    
        /**
         * ⭐ 추가: 예약 번호를 입력받고 DB를 조회하는 다이얼로그
         */
        private void showReservationInquiryDialog() {
            // 다이얼로그 구성
            reservationIdField = new JTextField(10);
            
            JPanel inputPanel = new JPanel();
            inputPanel.add(new JLabel("예약 번호(ID) 입력:"));
            inputPanel.add(reservationIdField);
            
            int result = JOptionPane.showConfirmDialog(this, 
                inputPanel, 
                "예약 조회", 
                JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String resId = reservationIdField.getText().trim();
                if (resId.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "예약 번호를 입력해 주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                queryReservation(resId);
            }
        }

        /**
         * ⭐ 추가: DB에서 특정 예약 ID를 조회하여 결과를 표시
         */
        private void queryReservation(String resId) {
            String sql = "SELECT * FROM RESERVATION WHERE res_id = ?";
            
            try (Connection conn = DBConnector.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, resId);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    // 예약 정보가 있을 경우
                    String details = String.format(
                        "<html><b>✅ 예약 발권 성공</b><br>" +
                        "----------------------------------<br>" +
                        "예약자: %s<br>" +
                        "방문일: %s<br>" +
                        "구역: %s<br>" +
                        "인원: %s명<br>" +
                        "상태: <b>%s</b></html>",
                        rs.getString("user_id"),
                        rs.getString("visit_date"),
                        rs.getString("area"),
                        rs.getString("headcount"),
                        rs.getString("status")
                    );
                    JOptionPane.showMessageDialog(this, details, "티켓 발권 완료", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // 예약 정보가 없을 경우
                    JOptionPane.showMessageDialog(this, "일치하는 예약 번호가 없습니다.", "조회 실패", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "DB 조회 오류: " + e.getMessage(), "시스템 오류", JOptionPane.ERROR_MESSAGE);
            }
    }
}
