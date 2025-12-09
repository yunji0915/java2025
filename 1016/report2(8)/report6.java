package Chapter_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Exam_6 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("색상 버튼과 숫자");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		JPanel westPanel = new JPanel(new GridLayout(11, 1));
		Color[] colors= {
				Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN,
	            Color.BLUE, Color.MAGENTA, Color.PINK, Color.GRAY, Color.DARK_GRAY, Color.BLACK
	            };
		JPanel centerPanel = new JPanel(null);
		centerPanel.setBackground(Color.WHITE);
		
		JLabel numberLabel = new JLabel(String.valueOf(new Random().nextInt(10)));
		numberLabel.setSize(50,50);
		numberLabel.setLocation(randomX(), randomY());
		centerPanel.add(numberLabel);
		
		for(Color color : colors) {
			JButton btn = new JButton();
			btn.setBackground(color);
			btn.setOpaque(true);
			btn.setBorderPainted(false);
			btn.addActionListener(e->numberLabel.setForeground(btn.getBackground()));
			westPanel.add(btn);
		}
		
		centerPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                numberLabel.setLocation(randomX(), randomY());
            }
        });

        frame.add(westPanel, BorderLayout.WEST);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
	private static int randomX() {
		return 50+ new Random().nextInt(151);
	}
	private static int randomY() {
		return 50 + new Random().nextInt(151);
	}
}




















