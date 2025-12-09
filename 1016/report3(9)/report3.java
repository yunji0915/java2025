package gui;

import javax.swing.*;
import java.awt.*;

public class Exam_3 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("GridLayout Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(1,10));
		
		for(int i=1; i<=10; i++) {
			frame.add(new JButton(String.valueOf(i)));
		}
		frame.setSize(800, 100);
		frame.setVisible(true);
	}
}
