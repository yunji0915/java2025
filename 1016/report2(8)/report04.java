package Chapter_10;

import javax.swing.*;
import javax.swing.text.GapContent;

import java.awt.*;
import java.awt.event.*;

public class Exam_4 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("블록 이동");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel() {
			int x = 150;
			int y = 150;
			final int SIZE = 50;
			{
				setBackground(Color.LIGHT_GRAY);
				setFocusable(true);
				requestFocus();
				
				addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent e) {
						int key = e.getKeyCode();
						switch(key) {
						case KeyEvent.VK_LEFT:
							x = Math.max(0,  x-SIZE);
							break;
						case KeyEvent.VK_RIGHT:
							x = Math.min(getWidth()-SIZE, x+SIZE);
							break;
						case KeyEvent.VK_UP:
							y=Math.max(0, y-SIZE);
							break;
						case KeyEvent.VK_DOWN:
							y= Math.min(getHeight()-SIZE, y+SIZE);
							break;
						}
						repaint();
					}
				});
			}
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.BLUE);
				g.fillRect(x,y,SIZE,SIZE);
				for (int i = 0; i < getWidth(); i += SIZE) {
				    for (int j = 0; j < getHeight(); j += SIZE) {
				        g.setColor(Color.GRAY);
				        g.drawRect(i, j, SIZE, SIZE);
				    }
				}

			}
		};
		
		frame.add(panel);
		frame.setVisible(true);
		panel.requestFocusInWindow();
	}
}















