/*
 * 실습문제 2
 * BorderLayout을 사용하여 실행 결과와 같이 동서남북에 각각 버튼을 배치하고 이들 사이의 수평 수직 간격이
 * 각각 5픽셀, 7픽셀이 되도록 스윙 응용프로그램을 작성하라. (East, West, North, South, Center)
 */

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
