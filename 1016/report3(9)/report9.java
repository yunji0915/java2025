package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Exam_9{
	public static void main(String[] args) {
		JFrame frame = new JFrame("별 위치 랜덤 출력");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		
		JPanel starPanel = new JPanel() {
			private final int STAR_COUNT = 15;
			private final Point[] starPositions = new Point[STAR_COUNT];
			private final Random rand = new Random();
			{
				for(int i = 0; i<STAR_COUNT; i++) {
					int x=rand.nextInt(380);
					int y=rand.nextInt(380);
					starPositions[i] = new Point(x,y);
				}
			}
			
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				for(Point p : starPositions) {
					g.drawString("*", p.x, p.y);
				}
			}
		};
		frame.add(starPanel);
		frame.setVisible(true);
	}
	
}

