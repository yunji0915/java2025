package chaptor_11;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;

class MyFrame2 extends JFrame {
    Vector<String> v = new Vector<>();
    int count;

    public MyFrame2() {
        setTitle("문장 완성 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(new NorthPanel(), BorderLayout.NORTH);
        c.add(new SouthPanel(), BorderLayout.SOUTH);
        c.add(new CenPanel(), BorderLayout.CENTER);

        setSize(400, 300);
        setVisible(true);
    }

    class NorthPanel extends JPanel {
        JButton btn = new JButton("New Text");

        public NorthPanel() {
            setLayout(new FlowLayout());
            setBackground(Color.gray);

            btn.addMouseListener(new MyMouseAdapter());
            add(new JLabel("단어 조합 게임! 순서대로 단어를 클릭하세요~~"));
            add(btn);
        }

        class MyMouseAdapter extends MouseAdapter {
            public void mouseClicked(MouseEvent e) {
                reset();
            }
        }

        public void reset() {
            Container parent = getParent();
            parent.remove(parent.getComponent(2));
            parent.add(new CenPanel(), BorderLayout.CENTER);
            parent.revalidate();
            parent.repaint();
            v.clear();
            count = 0;
            SouthPanel.addLabel(" ");
        }
    }

    class SouthPanel extends JPanel {
        static JLabel label;

        public SouthPanel() {
            setBackground(Color.yellow);
            label = new JLabel(">>");
            add(label);
        }

        public static void addLabel(String word) {
            if (word.equals(" ")) {
                label.setText(">>");
            } else {
                label.setText(label.getText() + " " + word);
            }
        }
    }

    class CenPanel extends JPanel {
        int index = (int) (Math.random() * 5);
        String[] text = {
            "You are the dancing queen",
            "I'm on energy saving mode.",
            "Atoms make up everything",
            "Got a map? I'm lost in your eyes",
            "My brain has too many tabs open"
        };
        String[] words = text[index].split(" ");

        public CenPanel() {
            setLayout(null);
            for (int i = 0; i < words.length; i++) {
                int x = (int) (Math.random() * 350);
                int y = (int) (Math.random() * 180);
                JLabel label = new JLabel(words[i]);

                label.setLocation(x, y);
                label.setSize(100, 20);

                class MouseClicked extends MouseAdapter {
                    public void mouseClicked(MouseEvent e) {
                        JLabel l = (JLabel) e.getSource();


                        if (words[count].equals(l.getText())) {
                        	l.setForeground(Color.LIGHT_GRAY);
                            count++;
                            v.add(l.getText());
                            SouthPanel.addLabel(v.get(v.size() - 1));
                            
                            if (words.length == count) {
                                SouthPanel.addLabel(">> 성공!");
                                System.out.println("문장을 완성하는데, 성공하였습니다. 다시 하려면 New Text를 눌러주세요.");
                            }
                        }   
                        else {
                            System.out.println("잘못 선택하였습니다. 다시 시작합니다.");
                            reset();
                        }
                    }
                }

                label.addMouseListener(new MouseClicked());
                add(label);
            }
        }

        public void reset() {
            Container parent = getParent();
            parent.remove(parent.getComponent(2));
            parent.add(new CenPanel(), BorderLayout.CENTER);
            parent.revalidate();
            parent.repaint();
            v.clear();
            count = 0;
            SouthPanel.addLabel(" ");
        }
    }
}

public class report_10 {
    public static void main(String[] args) {
        MyFrame2 my = new MyFrame2();
    }
}
