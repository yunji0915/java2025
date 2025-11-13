package chaptor_9;

import java.awt.*;
import javax.swing.*;

class MyFrame2 extends JFrame{
	
	public MyFrame2() {
		setTitle("West Grid 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(new WestPanel(), BorderLayout.WEST);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		
		
		setSize(300, 300);
		setVisible(true);
		
	}
}
class WestPanel extends JPanel{
	Color[] color = {Color.red, Color.gray, Color.blue, Color.yellow, Color.cyan, Color.lightGray, Color.pink, Color.green, Color.orange, Color.magenta};
	
	public WestPanel(){
		setLayout(new GridLayout(10, 1));
		
		for(int i=0; i<10; i++) {
			JButton btn = new JButton();
			btn.setBackground(color[i]);
			add(btn);
		}
		
	}
}
class CenterPanel extends JPanel{
	String [] num = {"0", "1", "2", "3", "4", "5", "6", "7","8", "9"};
	public CenterPanel(){
		setLayout(null);
		
		for(int i=0; i<10; i++) {
			int x = (int)(Math.random()*150)+50;
			int y = (int)(Math.random()*150)+50;
			JLabel label = new JLabel(num[i]);
			label.setLocation(x, y);
			label.setSize(100, 20);
			label.setForeground(Color.red);
			add(label);
		}
	}
}

public class report_10 {
	public static void main(String[] args) {
		MyFrame2 my = new MyFrame2();
	}
}
