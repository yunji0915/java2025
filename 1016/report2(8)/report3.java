package Chapter_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exam_3 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("문자열 회전");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Love Java");
		frame.add(label);
		
		frame.setFocusable(true);
		frame.requestFocus();
		
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				String text = label.getText();
				if(text.length()>0) {
					String rotated = text.substring(1)+text.charAt(0);
					label.setText(rotated);
				}
			}
		});
		
		frame.setVisible(true);
	}
}
