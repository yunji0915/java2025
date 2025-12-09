package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Exam_6 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Random JLabel Placement");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setLayout(null);
		
		Random rand = new Random();
		
		for(int i=0; i<20; i++) {
			JLabel label = new JLabel();
			label.setSize(10,10);
			label.setOpaque(true);
			
			int x = 10 + rand.nextInt(241);
			int y = 10 + rand.nextInt(241);
			label.setLocation(x,y);
			
			Color randomColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
			label.setBackground(randomColor);
			
			frame.add(label);
		}
		frame.setVisible(true);
	}
}
