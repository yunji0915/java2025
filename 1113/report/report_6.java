package Exam;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Exam_6 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("텍스트 슬라이더");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("글자 수 : 0");
        label.setBounds(30, 20, 100, 30);
        frame.add(label);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(30, 60, 320, 100);
        frame.add(scrollPane); // ✅ 텍스트 영역 추가

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0); // ✅ 슬라이더 선언
        slider.setBounds(30, 180, 320, 50);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        frame.add(slider); // ✅ 슬라이더 추가

        // 텍스트 입력 시 슬라이더와 라벨 업데이트
        textArea.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String text = textArea.getText();
                if (text.length() > 100) {
                    textArea.setText(text.substring(0, 100));
                }
                int length = textArea.getText().length();
                label.setText("글자 수: " + length);
                slider.setValue(length);
            }
        });

        // 슬라이더 조작 시 텍스트 삭제
        slider.addChangeListener(e -> {
            if (slider.getValueIsAdjusting()) return;
            String currentText = textArea.getText();
            int newLength = slider.getValue();
            if (newLength < currentText.length()) {
                textArea.setText(currentText.substring(0, newLength));
                label.setText("글자 수: " + newLength);
            }
        });

        frame.setVisible(true);
    }
}
