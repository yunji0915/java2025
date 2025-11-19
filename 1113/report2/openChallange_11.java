package openchallenge;


import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.awt.*;

public class OpenChallenge_11 extends JFrame {
	private JLabel imageLabel;
	private ImageIcon [] images = {new ImageIcon("images/instagram.png"),
								   new ImageIcon("images/tiktok.png"),
								   new ImageIcon("images/youtube.png")};
	int count;
	
	public OpenChallenge_11() {
		setTitle("Open Challenge 11");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
	
		imageLabel = new JLabel(images[count]);
		c.add(imageLabel, BorderLayout.CENTER);
		c.add(new menuPanel(), BorderLayout.SOUTH);
		
		setSize(1000,1000);
		setVisible(true);
	}
	
	class menuPanel extends JPanel{
		public menuPanel() {
			ImageIcon leftImg = new ImageIcon("images/left.png");
			ImageIcon rightImg = new ImageIcon("images/right.png");
			
			JButton leftLabel = new JButton(leftImg);
			JButton rightLabel = new JButton(rightImg);
			
			
			leftLabel.addMouseListener(new LeftBtn());
			rightLabel.addMouseListener(new RightBtn());
			
			add(leftLabel);
			add(rightLabel);
			
			setBackground(Color.DARK_GRAY);
		}	
	}
		class LeftBtn extends MouseAdapter{
			public void mouseClicked(MouseEvent e) {
				if(count > 0) {
					count--;
					imageLabel.setIcon(images[count]);
				}
			}
		}
		class RightBtn extends MouseAdapter{
			public void mouseClicked(MouseEvent e) {
				if(count < images.length -1) {
					count++;
					imageLabel.setIcon(images[count]);
				}
			}	
		}
	public static void main(String [] args) {
		new OpenChallenge_11();
	}
} 
