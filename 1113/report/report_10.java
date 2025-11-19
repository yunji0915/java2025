package chaptor_10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame2 extends JFrame {

    public MyFrame2() {
        setTitle("블록 생성 및 드래깅 배치");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);
        c.addKeyListener(new MyKeyListener());

        setSize(500, 500);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();
    }
}

class MyKeyListener extends KeyAdapter {
    public void keyPressed(KeyEvent e) {
        Container c = (Container) e.getSource();
        if (e.getKeyChar() == 'm') {
            JLabel la = new JLabel();
            int r = (int) (Math.random() * 256);
            int g = (int) (Math.random() * 256);
            int b = (int) (Math.random() * 256);

            la.setSize(80, 80);
            la.setOpaque(true);
            la.setBackground(new Color(r, g, b));
            la.setLocation(100, 100);

            // 마우스 리스너 추가
            MouseAdapter ma = new MouseAdapter() {
                private Point initialClick;

                public void mousePressed(MouseEvent e) {
                    initialClick = e.getPoint();
                    la.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }

                public void mouseReleased(MouseEvent e) {
                    la.setCursor(Cursor.getDefaultCursor());
                }

                public void mouseDragged(MouseEvent e) {
                    int thisX = la.getLocation().x;
                    int thisY = la.getLocation().y;

                    int xMoved = e.getX() - initialClick.x;
                    int yMoved = e.getY() - initialClick.y;

                    int X = thisX + xMoved;
                    int Y = thisY + yMoved;
                    la.setLocation(X, Y);
                }
            };

            la.addMouseListener(ma);
            la.addMouseMotionListener(ma);
            c.add(la);
            c.revalidate();
            c.repaint();
        }
    }
}

public class report_10 {
    public static void main(String[] args) {
        new MyFrame2();
    }
}
