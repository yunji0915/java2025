package Chapter_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exam_8 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("카드 번호 교환");
        frame.setSize(600, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 12)); // 12장의 카드 가로 배치
        
        JLabel[] cards = new JLabel[12];
        int[] selected = new int[2];
        int clickCount[]= {0};
        
        for(int i=0; i<cards.length; i++) {
        	JLabel card = new JLabel(String.valueOf(i+1), SwingConstants.CENTER);
        	card.setOpaque(true);
        	card.setBackground(Color.WHITE);
        	card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        	cards[i] = card;
        	
        	final int index = i;
        	card.addMouseListener(new MouseAdapter() {
        		public void mouseClicked(MouseEvent e) {
        			if(clickCount[0] ==0) {
        				selected[0]=index;
        				card.setBackground(Color.LIGHT_GRAY);
        				clickCount[0]++;
        			}else if(clickCount[0]==1 && index != selected[0]) {
        				selected[1] = index;
        				
        				String temp = cards[selected[0]].getText();
        				cards[selected[0]].setText(cards[selected[1]].getText());
        				cards[selected[1]].setText(temp);
        				
        				cards[selected[0]].setBackground(Color.WHITE);
        				clickCount[0]=0;
        			}
        		}
        	});
        	frame.add(card);
        	
        }
        frame.setVisible(true);
	}
}

























