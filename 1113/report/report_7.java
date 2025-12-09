package Exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Exam_7 extends JFrame{
	private JLabel label;
	private JSlider slider;
	
	public Exam_7() {
		setTitle("폰트 크기 조절 슬라이더");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		
		label = new JLabel("폰트 크기를 조절해보세요!!", JLabel.CENTER);
		label.setFont(new Font("Serif", Font.PLAIN, 20));
		add(label, BorderLayout.CENTER);
		
		slider = new JSlider(JSlider.HORIZONTAL, 1, 100, 20);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		add(slider,BorderLayout.NORTH);
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int fontSize = slider.getValue();
				label.setFont(new Font("Serif", Font.PLAIN, fontSize));
			}
		});
		setVisible(true);
	}
	public static void main(String[] args) {
		new Exam_7();
	}
}
