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





















