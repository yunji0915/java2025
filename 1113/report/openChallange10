package openchallenge;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame2 extends JFrame{
	private int num;
	private JLabel myLabel = new JLabel("?");
	private JLabel text = new JLabel("무엇일까요?");
	private JButton[] btn = {new JButton("홀"), new JButton("짝"), new JButton("확인"), new JButton("다시")};
	
	public MyFrame2(){
		setLayout(null);
		setTitle("홀짝 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		myLabel.setSize(80, 80);
		myLabel.setLocation(130, 30);
		myLabel.setForeground(Color.yellow);
		myLabel.setBackground(Color.magenta);
		myLabel.setOpaque(true);
		myLabel.setHorizontalAlignment(JLabel.CENTER);
		createNum();
		
		text.setSize(200, 30);
		text.setLocation(70, 120);
		text.setHorizontalAlignment(JLabel.CENTER);
		
		MyActionListener my = new MyActionListener();
		
		add(myLabel);
		add(text);
		
	
		for(int i=0; i<btn.length; i++) {
			btn[i].setLocation(90 * i, 150);
			btn[i].setSize(70, 40);
			add(btn[i]);
			btn[i].addActionListener(my);
		}
		
		setSize(350, 250);
		setVisible(true);
	}
	
	public void createNum() {
		num = (int)(Math.random()*10)+1;
		
		text.setText("무엇일까요?");
		myLabel.setText("?");
	}
	class MyActionListener implements ActionListener {
		public String state;
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("홀")) {
				state = "홀";
			}
			else if(b.getText().equals("짝")) {
				state = "짝";
			}
			else if(b.getText().equals("확인")) {
				check();
				state = null;
			}
			else if(b.getText().equals("다시")) {
				createNum();
				state = null;
			}
		}
	
		public void check(){
			String result;
			
			if(state == null) {
				text.setText("홀이나 짝 먼저 선택!");
				return;
			}
			
			myLabel.setText(Integer.toString(num));	
			
			if(num % 2 == 0) {
				result = "짝";
			}
			else {
				result = "홀";
			}
			
			if(state.equals(result)) {
				text.setText(result += "! 맞았어요.");
			}
			else {
				text.setText(result += "! 아쉽군요");
			}
		}
	}
}

public class OpenChallenge_10 {
	public static void main(String[] args) {
		MyFrame2 my = new MyFrame2();
	}
}
