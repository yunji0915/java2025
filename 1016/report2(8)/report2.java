package Chapter_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exam_2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("드래깅 배경색 변경");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = frame.getContentPane();
		contentPane.setBackground(Color.GREEN);
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				contentPane.setBackground(Color.YELLOW);
			}
		});
		
		contentPane.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				contentPane.setBackground(Color.GREEN);
			}
		});
		
		frame.setVisible(true);
	}
}
