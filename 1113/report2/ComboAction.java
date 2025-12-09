package class11_13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboActionEx extends JFrame{
	private String [] fruits = {"apple", "banana", "mango"};
	private ImageIcon[] images = {
		new ImageIcon(new ImageIcon("C:\\java\\workspace\\class11_13\\src\\class11_13\\apple.png").getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH)),
		new ImageIcon(new ImageIcon("C:\\java\\workspace\\class11_13\\src\\class11_13\\banana.png").getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH)),
		new ImageIcon(new ImageIcon("C:\\java\\workspace\\class11_13\\src\\class11_13\\mango.png").getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH))
		};
	private JLabel imgLabel = new JLabel(images[0]);
	
	public ComboActionEx() {
		setTitle("콤보박스 활용 예제");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JComboBox<String> combo = new JComboBox<String>(fruits);
		c.add(combo); c.add(imgLabel);
		
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				int index = cb.getSelectedIndex();
				imgLabel.setIcon(images[index]);
			}
		});
		setSize(300, 250);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ComboActionEx();
	}

}
