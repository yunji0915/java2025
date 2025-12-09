package Chapter_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exam_1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mouse Event Example");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("사랑해 자바");
		frame.add(label);
		
		label.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				label.setText("Love Java");
			}
			public void mouseExited(MouseEvent e) {
				label.setText("사랑해 자바");
			}
		});
		
		frame.setVisible(true);
	} 
}



















