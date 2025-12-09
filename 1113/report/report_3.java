/*
 * 실습문제 3
 * 실행예시화면을 구성하고, 금액을 입력한 후 "계산" 버튼을 클릭하면 오만원권,
 * 만원권, 천원권, 500원짜리 동전, 100원짜리 동전, 50원짜리 동전, 10원짜리 동전, 1원짜리 동전으로
 * 분할하여 개수를 출력하라. 이때 가장 큰 액수부터 채워라.
 */

package Exam;

import javax.swing.*;
import java.awt.event.*;

public class Exam_3 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("화폐 단위 계산기");
		frame.setSize(350,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JLabel label = new JLabel("금액 입력 : ");
		label.setBounds(30,20,80,30);
		frame.add(label);
		
		JTextField textField = new JTextField();
		textField.setBounds(110,20,150,30);
		frame.add(textField);
		
		JButton calcButton = new JButton("계산");
		calcButton.setBounds(270,20,60,30);
		frame.add(calcButton);
		
		String[] unitNames = {
				"오만원권", "만원권", "천원권", "500원", "100원", "50원", "10원", "1원"
		};
		int[] unitValues = {
				50000, 10000, 1000, 500, 100 , 50, 1
		};
		JLabel[] resultLabels = new JLabel[unitNames.length];
		
		for(int i =0; i<unitNames.length; i++) {
			JLabel unitLabel = new JLabel(unitNames[i]+":");
			unitLabel.setBounds(30,70+i*30,80,30);
			frame.add(unitLabel);
			
			resultLabels[i] = new JLabel("0개");
			resultLabels[i].setBounds(110, 70+i*30, 100, 30);
			frame.add(resultLabels[i]);
		}
		
		calcButton.addActionListener(e->{
			try {
				int amount = Integer.parseInt(textField.getText());
				for(int i=0; i<unitValues.length; i++) {
					int count = amount / unitValues[i];
					amount %=unitValues[i];
					resultLabels[i].setText(count+"개");
				}
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(frame, "숫자를 정확이 입력하세요");
			}
		});
		frame.setVisible(true);
	}
}


























