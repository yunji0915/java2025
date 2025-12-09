package gui;

import javax.swing.*;
import java.awt.*;

public class Exam_2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("BorderLayout Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout(5,7);
		frame.setLayout(layout);
		
		frame.add(new JButton("North"), BorderLayout.NORTH);
		frame.add(new JButton("South"), BorderLayout.SOUTH);
		frame.add(new JButton("East"), BorderLayout.EAST);
		frame.add(new JButton("West"), BorderLayout.WEST);
		frame.add(new JButton("Center"), BorderLayout.CENTER);
		
		frame.setSize(400, 200);
		frame.setVisible(true);
	}
}
