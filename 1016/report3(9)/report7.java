package gui;

import javax.swing.*;
import java.awt.*;

public class Exam_7 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,400);
		frame.setLayout(new BorderLayout());
		
		JTextField display = new JTextField();
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setFont(new Font("Arial", Font.BOLD,24));
		frame.add(display, BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,4,5,5));
		
		String[] buttons= {
	            "7", "8", "9", "/",
	            "4", "5", "6", "*",
	            "1", "2", "3", "-",
	            "0", ".", "=", "+"
	            };
		for(String text : buttons) {
			JButton button = new JButton(text);
			button.setFont(new Font("Arial", Font.BOLD, 20));
			buttonPanel.add(button);
		}
		
		frame.add(buttonPanel, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}
}
