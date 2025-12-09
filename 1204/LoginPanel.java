import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPanel extends JPanel {

    private SmartTourismManager parentFrame;
    private JTextField idField = new JTextField(15);
    private JPasswordField passwordField = new JPasswordField(15);
    private JButton loginButton = new JButton("로그인");
    private JButton virtualKeypadButton = new JButton("🔒 가상 키패드"); // 가상 키 버튼

    public LoginPanel(SmartTourismManager parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new GridBagLayout());
        
        // UI 구성 (레이아웃 조정)
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 제목
        JLabel titleLabel = new JLabel("Smart Tourism Manager 로그인");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        // ID 입력
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        add(idField, gbc);

        // PW 입력
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("PW:"), gbc);
        gbc.gridx = 1;
        add(passwordField, gbc);

        // 로그인 버튼
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(loginButton, gbc);

        // 가상 키패드 버튼
        gbc.gridy = 4;
        add(virtualKeypadButton, gbc);

        // 이벤트 리스너 연결
        loginButton.addActionListener(e -> attemptLogin());
        virtualKeypadButton.addActionListener(e -> showVirtualKeypad());
    }

    /**
     * 로그인 인증 로직 (DB 연동)
     */
    private void attemptLogin() {
        String id = idField.getText();
        // 실제 애플리케이션에서는 비밀번호 해싱(암호화)이 필수입니다.
        String password = new String(passwordField.getPassword()); 

        String sql = "SELECT role FROM USER_INFO WHERE id = ? AND password = ?";
        
        
        if ("user_1".equals(id) && "1234".equals(password)) {
            parentFrame.loginSuccess("USER");
            return;
       }
        
        
        try (Connection conn = DBConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.setString(2, password); 
            
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                JOptionPane.showMessageDialog(this, role + " 권한으로 로그인 성공!", "성공", JOptionPane.INFORMATION_MESSAGE);
                parentFrame.loginSuccess(role); // 메인 프레임으로 역할(ADMIN/USER) 전달하여 화면 전환
            } else {
                JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 일치하지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "DB 오류: " + ex.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * 가상 키패드 팝업창을 띄우는 메서드 (핵심 보안 기능)
     */
    private void showVirtualKeypad() {
        // 
        
        // 팝업 다이얼로그 생성
        JDialog keypadDialog = new JDialog(parentFrame, "가상 키패드 입력", true); // 모달 다이얼로그
        keypadDialog.setLayout(new GridLayout(4, 3, 5, 5));
        keypadDialog.setSize(300, 400);
        keypadDialog.setLocationRelativeTo(this);

        JTextField inputDisplay = new JTextField(10);
        inputDisplay.setEditable(false);
        keypadDialog.add(inputDisplay); // 입력 내용 표시

        // 0부터 9까지의 버튼과 입력/취소 버튼 추가 (가상 키패드 구현부)
        for (int i = 1; i <= 9; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(e -> inputDisplay.setText(inputDisplay.getText() + btn.getText()));
            keypadDialog.add(btn);
        }
        
        JButton btn0 = new JButton("0");
        btn0.addActionListener(e -> inputDisplay.setText(inputDisplay.getText() + btn0.getText()));
        keypadDialog.add(btn0);
        
        JButton okBtn = new JButton("확인");
        okBtn.addActionListener(e -> {
            passwordField.setText(inputDisplay.getText()); // 가상 키로 입력된 내용을 비밀번호 필드에 적용
            keypadDialog.dispose();
        });
        keypadDialog.add(okBtn);
        
        JButton cancelBtn = new JButton("취소");
        cancelBtn.addActionListener(e -> keypadDialog.dispose());
        keypadDialog.add(cancelBtn);

        keypadDialog.setVisible(true);
    }
}
