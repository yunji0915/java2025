package Chapter_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exam_7 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("버튼 클릭 카운터");
		frame.setSize(400, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		JButton[] buttons = new JButton[5];
		int[] counts = new int [5];
		for(int i = 0; i<buttons.length; i++) {
			JButton btn = new JButton("0");
			int index = i;
			
			btn.addActionListener(e->{
				counts[index]++;
				btn.setText(String.valueOf(counts[index]));
			});
			buttons[i] = btn;
			frame.add(btn);
		}
		frame.setVisible(true);
	}
}
