/*
 * 실습문제 2
 * 실행 예시와 같이 JComboBox로 빈 콤보박스를 만들고, JTextField 입력 창에 문자열을
 * 입력한 후 <Enter> 키를 입력하면 문자열을 콤보박스의 아이템으로 삽입하라.
 */

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
