package Exam;

import javax.swing.*;
import java.awt.event.*;

public class Exam_2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("콤보박스 추가");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(50,30,200,30);
		frame.add(comboBox);
		
		JTextField textField = new JTextField();
		textField.setBounds(50,70,200,30);
		frame.add(textField);
		
		textField.addActionListener(e->{
			String input = textField.getText().trim();
			if(!input.isEmpty()) {
				comboBox.addItem(input);
				textField.setText("");
			}
		});
		frame.setVisible(true);
	}
}
