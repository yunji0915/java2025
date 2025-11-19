package chaptor_10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame extends JFrame{
	JLabel la = new JLabel("C");
	
	public MyFrame() {
		setTitle("클릭 연습 응용프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addMouseListener(new MyMouseAdapter());
				
		c.setLayout(null);
		la.setLocation(100, 100);
		la.setSize(50, 50);
		c.add(la);
		
		setSize(500, 500);
		setVisible(true);
		
		la.setFocusable(true);
		la.requestFocus();
	}
}

class MyMouseAdapter extends MouseAdapter{
	public void mouseClicked(MouseEvent e) {
		Container c = (Container)e.getSource();
		int x = (int)(Math.random()*300);
		int y = (int)(Math.random()*300);
		
		c.setLocation(x, y);
	}
}

public class report_5 {
	public static void main(String[] args) {
		MyFrame my = new MyFrame();
	}
}
