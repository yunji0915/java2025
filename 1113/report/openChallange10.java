/*
 * 오픈 챌린지
 * 이미지 갤러리 만들기
 * 버튼과 이미지 레이블, Action 리스너를 활용하여 이미지를 순환하면서 보여주는 이미지 갤러리를 작성해보자
 * 아래에는 4개의 실행 화면이 있다. 컨텐트팬의 배치관리자를 BorderLayout 배치 관리자로 설정하고
 * Center 영역에는 이미지를 출력하는 레이블 컴포넌트를 단다. South 영역에는 JPanel을 상속받은
 * MenuPanel을 작성하고 이곳에 좌 우 화살표 이미지를 가진 2개의 버튼을 단다. 오른쪽 화살표 버튼을
 * 클릭하면 Center에 있는 이미지 레이블에 다음 이미지를 출력하고 반대로 왼쪽 화살표 버튼을 클릭하면 
 * 이전 이미지를 레이블에 출력한다. 저자는 4개의 이미지로 실행하였지만, 독자들은 더 많은 이미지로 해도 된다.
 * 
 */

package Exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class OpenChallenge extends JFrame {
    private JLabel imageLabel;
    private ArrayList<ImageIcon> imageList = new ArrayList<>();
    private int currentIndex = 0;

    public OpenChallenge() {
        setTitle("이미지 갤러리");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());

        // 이미지 불러오기
        loadImages();

        // 이미지 레이블 (Center)
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        if (!imageList.isEmpty()) {
            imageLabel.setIcon(imageList.get(currentIndex));
        }
        add(imageLabel, BorderLayout.CENTER);

        // 메뉴 패널 (South)
        MenuPanel menuPanel = new MenuPanel();
        add(menuPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadImages() {
        File dir = new File("images");
        if (!dir.exists() || !dir.isDirectory()) {
            JOptionPane.showMessageDialog(this, "images 폴더가 존재하지 않습니다.");
            return;
        }

        File[] files = dir.listFiles((d, name) -> {
            String lower = name.toLowerCase();
            return lower.endsWith(".jpg") || lower.endsWith(".jpeg") || lower.endsWith(".png") || lower.endsWith(".gif");
        });

        if (files != null) {
            for (File file : files) {
                imageList.add(new ImageIcon(file.getPath()));
            }
        }
    }

    private void showImage(int index) {
        if (!imageList.isEmpty()) {
            imageLabel.setIcon(imageList.get(index));
        }
    }

    // 내부 클래스: 메뉴 패널
    class MenuPanel extends JPanel {
        public MenuPanel() {
            setLayout(new FlowLayout());

            JButton leftButton = new JButton(new ImageIcon("images/left.png"));
            JButton rightButton = new JButton(new ImageIcon("images/right.png"));

            leftButton.addActionListener(e -> {
                currentIndex = (currentIndex - 1 + imageList.size()) % imageList.size();
                showImage(currentIndex);
            });

            rightButton.addActionListener(e -> {
                currentIndex = (currentIndex + 1) % imageList.size();
                showImage(currentIndex);
            });

            add(leftButton);
            add(rightButton);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OpenChallenge());
    }
}





















