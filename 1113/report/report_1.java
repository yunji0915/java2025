package Exam;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Exam_1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Check Box");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JButton button = new JButton("작동 버튼");
		button.setBounds(90,30,120,30);
		frame.add(button);
		
		JCheckBox disableCheck = new JCheckBox("버튼 비활성화");
		disableCheck.setBounds(50,70,200,30);
		frame.add(disableCheck);
		
		JCheckBox hideCheck = new JCheckBox("버튼 감추기");
		hideCheck.setBounds(50,100,200,30);
		frame.add(hideCheck);
		
		// 버튼 클릭 이벤트
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "버튼이 클릭되었습니다."));

		
		disableCheck.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                button.setEnabled(false);
            } else {
                button.setEnabled(true);
            }
        });

        hideCheck.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                button.setVisible(false);
            } else {
                button.setVisible(true);
            }
        });

		frame.setVisible(true);
	}
}
