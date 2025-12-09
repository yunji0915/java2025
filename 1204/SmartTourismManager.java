import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SmartTourismManager extends JFrame {
	
	private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    
    // 각 화면(패널) 인스턴스
    private LoginPanel loginPanel;
    private AdminPanel adminPanel; // 관리자 모드
    private UserPanel userPanel;  // 사용자 모드
    
    public SmartTourismManager() {
        // 1. DB 초기화
        DBConnector.initializeDB();

        setTitle("🗺️ 스마트 관광지 관리 시스템 (Smart Tourism Manager)");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙에 배치

        // 2. 패널 인스턴스 생성 및 CardLayout에 추가
        loginPanel = new LoginPanel(this);
        //adminPanel = createPlaceholderPanel("관리자 모드 (혼잡도/예약/통계)", new Color(200, 255, 200));
        adminPanel = new AdminPanel(this); // 새로 만든 AdminPanel 객체를 사용합니다.
        //userPanel = createPlaceholderPanel("사용자 모드 (예약 조회/발권/혼잡도)", new Color(200, 200, 255));
        userPanel = new UserPanel(this);
        
        mainPanel.add(loginPanel, "LOGIN");
        mainPanel.add(adminPanel, "ADMIN");
        mainPanel.add(userPanel, "USER");

        add(mainPanel);
        
     // 첫 화면은 로그인 화면
        showPanel("LOGIN");
        
        // 닫기 버튼 누를 시 DB 연결 해제 (생략)
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // DB 연결 종료 로직 추가 가능
            }
        });

        setVisible(true);
    }
    
    /**
     * CardLayout을 이용해 지정된 화면으로 전환합니다.
     */
    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    /**
     * 관리자/사용자 모드 접속 후 첫 화면 전환
     */
    public void loginSuccess(String role) {
        if ("ADMIN".equals(role)) {
            showPanel("ADMIN");
        } else {
            showPanel("USER");
        }
    }
    
 // 임시 패널 생성 메서드 (실제로는 복잡한 GUI가 들어갈 곳)
   /* private JPanel createPlaceholderPanel(String title, Color bg) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bg);
        JLabel label = new JLabel(title, JLabel.CENTER);
        label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        panel.add(label, BorderLayout.CENTER);
        
        // 로그아웃 버튼 추가 (모드 전환 기능 확인용)
        JButton logoutBtn = new JButton("로그아웃");
        logoutBtn.addActionListener(e -> showPanel("LOGIN"));
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(logoutBtn);
        panel.add(topPanel, BorderLayout.NORTH);
        
        return panel;
    }*/
    
    public static void main(String[] args) {
    	// [추가 코드 시작] LookAndFeel 변경을 통해 UI/UX 개선
        try {
            // 옵션 1: Nimbus LookAndFeel (가장 현대적이고 부드러움)
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
            // 옵션 2: Windows LookAndFeel (사용자의 OS 스타일을 따름)
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            
        } catch (Exception e) {
            // Nimbus를 찾을 수 없는 경우 기본 LookAndFeel 사용
        }
        // [추가 코드 끝]
        
        // Swing GUI는 EDT(Event Dispatch Thread)에서 실행해야 합니다.
        SwingUtilities.invokeLater(SmartTourismManager::new);
    }
    
        
}
