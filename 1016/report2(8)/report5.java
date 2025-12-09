package Chapter_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Exam_5 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("클릭 연습");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JLabel label = new JLabel("C");
		label.setSize(20,20);
		label.setLocation(100,100);
		frame.add(label);
		
		Random rand = new Random();
		
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = rand.nextInt(frame.getContentPane().getWidth()-label.getWidth());
				int y = rand.nextInt(frame.getContentPane().getHeight()-label.getHeight());
				label.setLocation(x,y);
			}
		});
		frame.setVisible(true);
	}
}
