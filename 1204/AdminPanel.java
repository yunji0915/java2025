import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File; // File 객체 사용을 위해 추가
import javax.swing.JFileChooser; // 파일 선택 대화상자 사용을 위해 추가

public class AdminPanel extends JPanel {

    private SmartTourismManager parentFrame;
    
    private JLabel[] areaLabels; // 구역 라벨 배열
    private JTextField predictionTimeField; // 예측 시간 필드

    // 예약 데이터 테이블
    private JTable reservationTable;
    
    // 테이블 데이터를 관리할 모델 (JTable에 데이터를 연결하는 역할)
    private ReservationTableModel tableModel; 

    public AdminPanel(SmartTourismManager parentFrame) {
        this.parentFrame = parentFrame;
        
        // AdminPanel의 레이아웃을 BorderLayout으로 설정 (탭 패널을 중앙에 배치)
        setLayout(new BorderLayout()); 

        // 탭 패널 생성 (화면 전환의 핵심)
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        tabbedPane.setOpaque(false); // 탭 배경색 제거
        
        // 탭 1: 예약 및 사용자 관리 (JTable 구현 예정)
        JPanel tabReservation = createReservationManagementTab();
        tabbedPane.addTab("🗄️ 예약 및 사용자 관리", tabReservation);

        // 탭 2: 혼잡도 예측 및 지도 시각화 (향후 구현)
        // JPanel tabCongestion = createPlaceholderTab("🗺️ 혼잡도 예측 및 지도", Color.LIGHT_GRAY);
        JPanel tabCongestion = createCongestionTab();
        tabbedPane.addTab("🗺️ 혼잡도 예측 및 지도 시각화", tabCongestion);
        
        // 탭 3: 통계 및 분석 (향후 구현)
        //JPanel tabStatistics = createPlaceholderTab("📊 통계 및 분석", Color.LIGHT_GRAY);
        JPanel tabStatistics = createStatisticsTab();
        tabbedPane.addTab("📊 통계 및 분석", tabStatistics);

        // 로그아웃 버튼을 우측 상단에 배치
        JButton logoutBtn = new JButton("로그아웃");
        logoutBtn.addActionListener(e -> parentFrame.showPanel("LOGIN"));
        // 버튼 디자인
        logoutBtn.setBackground(Color.decode("#2C73D2")); // 빨간색 계열로 경고/종료 느낌 부여
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setOpaque(true);
        logoutBtn.setBorderPainted(false);
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel("관리자 모드 대시보드", JLabel.CENTER), BorderLayout.WEST);
        topPanel.add(logoutBtn, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // 탭 패널을 메인 패널의 중앙에 추가
        add(tabbedPane, BorderLayout.CENTER);
    }

    /**
     * 예약 관리 탭을 구성하고 JTable을 추가합니다. (탭 1)
     */
    private JPanel createReservationManagementTab() {
        JPanel panel = new JPanel(new BorderLayout());

        // ----------------------------------------------------
        // 1. JTable 초기화 (10000명 이상의 데이터 조회 영역)
        // ----------------------------------------------------
        tableModel = new ReservationTableModel(); // 모델 생성
        reservationTable = new JTable(tableModel);
        
        // 테이블 헤더 설정
        reservationTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        reservationTable.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 13));
        reservationTable.setRowHeight(25);
        
        // 스크롤 기능이 추가된 테이블
        JScrollPane scrollPane = new JScrollPane(reservationTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // ----------------------------------------------------
        // 2. 검색 및 등록 버튼 영역 (북쪽)
        // ----------------------------------------------------
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        controlPanel.add(new JLabel("검색 (ID):"));
        controlPanel.add(new JTextField(10));
        controlPanel.add(new JButton("검색"));
        controlPanel.add(new JSeparator(SwingConstants.VERTICAL));
        
        // 10000명 이상 데이터 처리 강조 버튼
        JButton batchBtn = new JButton("💾 CSV 예약 일괄 등록 (10000건)"); 
        batchBtn.addActionListener(e -> generateDummyData()); // 더미 데이터 생성 기능 연결
        controlPanel.add(batchBtn);
        
        JButton refreshBtn = new JButton("🔄 새로고침"); 
        refreshBtn.addActionListener(e -> loadReservations()); // DB 조회 기능 연결
        controlPanel.add(refreshBtn);
        
        // ⭐ NEW: 엑셀 출력 버튼 추가
        JButton exportBtn = new JButton("📄 예약 목록 엑셀 저장 (CSV)"); 
        exportBtn.addActionListener(e -> exportReservations()); // 새 메서드 연결
        controlPanel.add(exportBtn);
        
        panel.add(controlPanel, BorderLayout.NORTH);
        
        // 3. 초기 데이터 로드
        loadReservations();

        return panel;
    }
    
    /**
     * 혼잡도 예측 및 지도 시각화 탭을 구성합니다. (탭 2)
     */
    private JPanel createCongestionTab() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // ----------------------------------------------------
        // 1. 지도 시각화 영역 (중앙)
        // ----------------------------------------------------
        // 
        JPanel mapPanel = new JPanel();
        mapPanel.setLayout(new GridBagLayout()); // 구역을 그리드 레이아웃으로 배치
        mapPanel.setBorder(BorderFactory.createTitledBorder("관광지 구역별 혼잡도 맵 (예측 결과)"));

        // 가상 구역 5개 생성 및 패널에 저장
        areaLabels = new JLabel[5];
        String[] areaNames = {"[A] 정문 광장", "[B] 사파리 존", "[C] 워터파크", "[D] 기념품 거리", "[E] 식당가"};
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        for (int i = 0; i < 5; i++) {
            areaLabels[i] = new JLabel(areaNames[i], JLabel.CENTER);
            areaLabels[i].setOpaque(true); // 배경색을 칠하기 위해 Opaque 설정
            areaLabels[i].setPreferredSize(new Dimension(150, 80));
            areaLabels[i].setFont(new Font("맑은 고딕", Font.BOLD, 14));
            areaLabels[i].setForeground(Color.BLACK);
            
            // 초기 색상은 회색 (데이터 없음)
            areaLabels[i].setBackground(Color.GRAY); 
            
            gbc.gridx = i % 3; // 3열 배치
            gbc.gridy = i / 3;
            mapPanel.add(areaLabels[i], gbc);
        }
        
        panel.add(mapPanel, BorderLayout.CENTER);

        // ----------------------------------------------------
        // 2. 예측 설정 및 실행 영역 (남쪽)
        // ----------------------------------------------------
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        controlPanel.add(new JLabel("날짜 및 시간 설정 (YYYY-MM-DD HH):"));
        
        // 예측 입력 필드 (2025-12-25 14)
        predictionTimeField = new JTextField("2025-12-25 14", 15); 
        controlPanel.add(predictionTimeField);

        JButton predictBtn = new JButton("🔮 혼잡도 예측 및 지도 업데이트");
        predictBtn.addActionListener(e -> predictAndShowCongestion()); // 예측 실행 기능 연결
        controlPanel.add(predictBtn);
        
        panel.add(controlPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    /**
     * DB 데이터(RESERVATION)를 기반으로 구역별 혼잡도를 예측하고 지도에 표시합니다.
     * (간단한 예측 모델: 특정 날짜/구역의 평균 예약 인원 수로 혼잡도 결정)
     */
    private void predictAndShowCongestion() {
        String predictionTime = predictionTimeField.getText().substring(0, 10); // 날짜만 사용 (예: 2025-12-25)
        
        // 각 구역의 현재 총 예약 인원을 저장할 맵
        java.util.Map<String, Integer> areaHeadcounts = new java.util.HashMap<>();
        
        // DB에서 해당 날짜의 예약 데이터를 조회
        String sql = "SELECT area, SUM(headcount) AS total_headcount FROM RESERVATION " +
                     "WHERE visit_date = ? AND status = 'CONFIRMED' GROUP BY area";
        
        try (Connection conn = DBConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, predictionTime);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                areaHeadcounts.put(rs.getString("area"), rs.getInt("total_headcount"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "예측 DB 조회 오류: " + e.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // ----------------------------------------------------
        // 2. 예측 결과에 따라 지도 업데이트 (시각화)
        // ----------------------------------------------------
        int[] congestionThreshold = {300, 500}; // 혼잡도 기준: 300명 이하는 원활, 500명 초과는 혼잡
        
        for (int i = 0; i < areaLabels.length; i++) {
            String areaKey = "Area-" + (i + 1);
            int totalHeadcount = areaHeadcounts.getOrDefault(areaKey, 0);
            
            Color color;
            String status;

            if (totalHeadcount > congestionThreshold[1]) {
                color = Color.decode("#FF6F91"); // 500명 초과: 혼잡
                status = "혼잡 (" + totalHeadcount + "명)";
            } else if (totalHeadcount > congestionThreshold[0]) {
                color = Color.decode("#F9F871"); // 300명 초과: 보통
                status = "보통 (" + totalHeadcount + "명)";
            } else {
                color = Color.GREEN; // 300명 이하: 원활
                status = "원활 (" + totalHeadcount + "명)";
            }
            
            areaLabels[i].setBackground(color);
            // 라벨 텍스트도 업데이트하여 현재 인원수를 표시
            areaLabels[i].setText(areaLabels[i].getText().split(" ")[0] + " - " + status);
        }
        
        JOptionPane.showMessageDialog(this, predictionTime + " 기준 혼잡도 예측이 완료되었습니다.", "예측 성공", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * 통계 및 분석 탭을 구성하고, 간단한 막대 그래프를 표시합니다. (탭 3)
     */
    private JPanel createStatisticsTab() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel title = new JLabel("📊 월간 구역별 예약 선호도 분석", JLabel.CENTER);
        title.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        panel.add(title, BorderLayout.NORTH);
        
        // 그래프 영역 (GridBagLayout으로 유연하게 배치)
        JPanel chartPanel = new JPanel(new GridBagLayout());
        chartPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        // 예시 데이터: 5개 구역의 예약 횟수 (임의 값 또는 DB에서 가져온 값)
        String[] areas = {"[A] 정문 광장", "[B] 사파리 존", "[C] 워터파크", "[D] 기념품 거리", "[E] 식당가"};
        int[] counts = {4500, 7800, 6200, 3100, 5500}; // 예약 횟수 시뮬레이션
        int maxCount = 8000; // 최대 기준 (그래프 높이 결정용)

        GridBagConstraints gbc = new GridBagConstraints();
        // gbc.fill 설정을 제거하거나 NONE으로 변경(막대가 부모 컨데이너를 채우지 않도록 함)
        // gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // 막대 그래프 그리기
        for (int i = 0; i < areas.length; i++) {
            // 1. 라벨 (구역 이름)
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.weightx = 0.0; // 고정 너비 (데이터에 영향을 받지 않음)
            chartPanel.add(new JLabel(areas[i], JLabel.RIGHT), gbc);

            // 2. 막대 (시각화)
            gbc.gridx = 1;
            // gbc.weightxfmf 0.8에서 0.0으로 변경하거나, 아예 설정 X
            // 막대가 차지하는 공간은 'bar'의 preferredSize에 의존하게 한다.
            gbc.weightx = 0.0;
            
            // 예약 횟수에 비례하여 너비를 계산 (최대 400픽셀)
            int barWidth = (int) ((double) counts[i] / maxCount * 400); 
            
            // 막대 역할을 할 패널 생성
            JPanel bar = new JPanel();
            bar.setPreferredSize(new Dimension(barWidth, 25)); // 높이는 고정, 너비는 데이터에 따라 변경
            bar.setBackground(Color.decode("#0081CF")); // 초록색 계열
            
            // 수치 표시 라벨
            JLabel countLabel = new JLabel(String.valueOf(counts[i]) + "건", JLabel.RIGHT);
            countLabel.setForeground(Color.WHITE);
            bar.setLayout(new BorderLayout());
            bar.add(countLabel, BorderLayout.CENTER);
            
            chartPanel.add(bar, gbc);
            
            // 3. 수치 (막대 오른쪽)
            gbc.gridx = 2;
            gbc.weightx = 1.0; // 오른쪽 공간이 남으면 이 컬럼이 가져가도록 설정 
            chartPanel.add(new JLabel(" (" + String.format("%.1f", (double)counts[i] / maxCount * 100) + "%)", JLabel.LEFT), gbc);
        }
        
        panel.add(chartPanel, BorderLayout.CENTER);

        return panel;
    }
    
    /**
     * JTable의 데이터를 CSV 파일로 내보내는 프로세스를 시작합니다.
     */
    private void exportReservations() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("CSV 파일로 저장");
        
        // 기본 파일명 설정 (예: Reservation_Data_1703000000.csv)
        fileChooser.setSelectedFile(new File("Reservation_Data_" + System.currentTimeMillis() + ".csv"));

        // 사용자에게 저장 위치를 물어봅니다.
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            
            // 확장자가 없으면 .csv를 붙여줍니다.
            if (!fileToSave.getAbsolutePath().endsWith(".csv")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".csv");
            }
            
            // ReservationTableModel의 CSV 내보내기 로직 호출
            if (tableModel.exportToCsv(fileToSave)) {
                JOptionPane.showMessageDialog(this, 
                    "엑셀 파일(CSV) 저장 성공!\n" + fileToSave.getAbsolutePath(), 
                    "성공", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "파일 저장 중 오류가 발생했습니다.", 
                    "오류", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * 임시로 다른 탭을 생성하는 메서드 (향후 이 메서드를 수정하여 기능 구현)
     */
    private JPanel createPlaceholderTab(String title, Color bg) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bg);
        JLabel label = new JLabel(title + " - 구현 예정", JLabel.CENTER);
        label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
    
    // 이 부분에 DB 조회 및 더미 데이터 생성 메서드가 들어갑니다.
    // loadReservations()와 generateDummyData()는 다음 단계에서 구현합니다.
    private void loadReservations() {
        // 예약 데이터를 DB에서 가져와 테이블 모델에 업데이트하는 코드가 들어갈 예정
        // 현재는 임시로 빈 데이터만 로드합니다.
        System.out.println("예약 데이터 로드 준비...");
        tableModel.loadFromDB(); 
    }
    
    private void generateDummyData() {
        // 10000건 이상의 더미 데이터를 생성하여 DB에 삽입하는 코드가 들어갈 예정
        System.out.println("10000건 더미 데이터 생성 및 삽입 준비...");
        tableModel.generateAndLoadDummyData();
        loadReservations(); // 삽입 후 테이블 새로고침
    }
}
