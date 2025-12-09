package gui;

import javax.swing.*;
import java.awt.*;

public class Exam_1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Make a Window using Swing");
		
		frame.setSize(400, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		contentPane.setBackground(Color.YELLOW);
		frame.setVisible(true);
	}
}
