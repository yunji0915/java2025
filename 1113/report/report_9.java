package Exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Exam_9 extends JFrame {
	private ArrayList<JLabel> labels = new ArrayList<>();
	private int nextNumber = 0;
	private final int LABEL_SIZE = 40;
	
	public Exam_9() {
		setTitle("숫자 순서 클릭 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLayout(null);
		
		initGame();
		setVisible(true);
	}
	
	private void initGame() {
		getContentPane().removeAll();
		labels.clear();
		nextNumber = 0;
		
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i=0; i<10; i++) numbers.add(i);
		Collections.shuffle(numbers);
		
		for(int i=0; i<10; i++) {
			JLabel label = new JLabel(String.valueOf(numbers.get(i)), SwingConstants.CENTER);
			label.setOpaque(true);
			label.setBackground(Color.cyan);
			label.setBounds(randomX(), randomY(), LABEL_SIZE, LABEL_SIZE);
			label.setFont(new Font("Arial", Font.BOLD, 16));
			label.setBorder(BorderFactory.createLineBorder(Color.black));
			label.addMouseListener(new LabelClickListener());
			labels.add(label);
			add(label);
		}
		
		repaint();
		revalidate();
	}
	
	private int randomX() {
		return (int) (Math.random()*(getWidth()-LABEL_SIZE -20));
	}
	
	private int randomY() {
		return (int) (Math.random()*(getHeight()-LABEL_SIZE-40));
	}
	
	private class LabelClickListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			JLabel clicked = (JLabel) e.getSource();
			int number = Integer.parseInt(clicked.getText());
			
			if(number==nextNumber) {
				clicked.setVisible(false);
				nextNumber++;
				if(nextNumber==10) {
					JOptionPane.showMessageDialog(null, "성공! 다시합니다");
					initGame();
				}
			} else {
				JOptionPane.showMessageDialog(null, "순서 틀림! 다시 시작");
				initGame();
			}
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()-> new Exam_9());
	}
}

























