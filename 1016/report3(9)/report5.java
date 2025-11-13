package chaptor_9;

import java.awt.*;
import java.util.concurrent.Flow;

import javax.swing.*;

class MyFrame extends JFrame{
	Color[] color = {Color.red, Color.orange, Color.yellow, Color.green, Color.cyan, Color.blue, Color.magenta, Color.gray, Color.pink, Color.lightGray, Color.white, Color.darkGray, Color.black, Color.orange, Color.blue, Color.magenta};
	public MyFrame() {
		setTitle("4x4 Color 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.setLayout(new GridLayout(4, 4, 0, 0));
		
		for(int i=0; i<16; i++) {
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			panel.setBackground(color[i]);
			panel.add(new JLabel(""+i), BorderLayout.WEST);
			c.add(panel);
		}
		setSize(700,250);
		setVisible(true);
	}
		
}

public class report_5 {
	public static void main(String[] args) {
		MyFrame my = new MyFrame();
	}
}
