package openchallenge;

import java.awt.*;
import javax.swing.*;

class MyFrame extends JFrame{
	public MyFrame() {
		setTitle("Open Challenge 9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		c.add(new CenPanel(), BorderLayout.CENTER);
		
		setSize(400, 300);
		setVisible(true);
	}
}
class NorthPanel extends JPanel{
	public NorthPanel() {
		setLayout(new FlowLayout());
		setBackground(Color.gray);
		add(new JLabel("단어 조합 게임! 순서대로 단어를 클릭하세요~~"));
		add(new JButton("New Text"));
	}
}
class SouthPanel extends JPanel{
	public SouthPanel() {
		setBackground(Color.yellow);
		
		add(new JLabel("이름"));
		add(new JTextField("                           "));
	}
}
class CenPanel extends JPanel{
	String text = "I can't help falling in love with you";
	String []words = text.split(" ");
	
	public CenPanel() {	
		setLayout(null);
		
		for(int i=0; i<words.length; i++) {
			int x = (int)(Math.random()*350);
			int y = (int)(Math.random()*180);
			
			JLabel label = new JLabel(words[i]);
			
			label.setLocation(x, y);
			label.setSize(100, 20);
			add(label);
		}
	}
}

public class OpenChallenge_9 {
	public static void main(String[] args) {
		MyFrame my = new MyFrame();
	}
}
