package chaptor_11;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class MyFrame extends JFrame{
	private JLabel label;
	public MyFrame() {
		setTitle("JSlider Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 100, 200, 150);
		c.setLayout(new FlowLayout());
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(1);
		
		label = new JLabel(Integer.toString(slider.getValue()));
		label.setBackground(Color.green);
		label.setOpaque(true);
		class MyChangedLisner implements ChangeListener{ 
			public void stateChanged(ChangeEvent e) {
				JSlider s = (JSlider)e.getSource();
				
				int value = s.getValue();
				label.setText(Integer.toString(value));
			}
		}
		slider.addChangeListener(new MyChangedLisner());
		
		c.add(slider);
		c.add(label);
		setSize(300, 100);
		setVisible(true);
		
		
	}
}

public class report_5 {
	public static void main(String[] args) {
		MyFrame my = new MyFrame();
	}
}
