package Chapter_10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exam_9 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("폰트 크기 조절");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Love Java");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        frame.add(label);
        
        label.addMouseWheelListener(new MouseWheelListener() {
        	int fontSize = 30;
        	
        	public void mouseWheelMoved(MouseWheelEvent e) {
        		int notches = e.getWheelRotation();
        		if(notches <0) {
        			fontSize = Math.max(5, fontSize -5);
        			
        		} else {
        			fontSize += 5;
        		}
        		label.setFont(new Font("Serif", Font.BOLD, fontSize));
        	}
        });
        frame.setVisible(true);
	}
}
