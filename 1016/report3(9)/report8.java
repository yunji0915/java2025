package gui;

import javax.swing.*;
import java.awt.*;

public class Exam_8 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("16장의 카드 뒷면에 숨겨진 이미지 찾기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500); // 높이 살짝 늘림

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout(10, 10));

        // 상단 제목 라벨
        JLabel titleLabel = new JLabel("숨겨진 이미지 찾기", SwingConstants.CENTER);
        contentPane.add(titleLabel, BorderLayout.NORTH);

        // 가운데 카드 버튼들
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new GridLayout(4, 4, 5, 5));
        for (int i = 0; i < 16; i++) {
            JButton card = new JButton(String.valueOf(i + 1));
            cardPanel.add(card);
        }
        contentPane.add(cardPanel, BorderLayout.CENTER);

        // 하단 실행 버튼
        JButton startButton = new JButton("실행 시작");
        contentPane.add(startButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
