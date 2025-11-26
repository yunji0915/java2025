package chaptor_14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class IngredientLabel extends JLabel {
    private final int MAX_SIZE = 10;
    private int currentSize;

    public IngredientLabel() {
        currentSize = MAX_SIZE;
    }

    boolean consume() {
        if (currentSize > 0) {
            currentSize--;
            return true;
        } else {
            return false;
        }
    }
    void refill() {
        currentSize = MAX_SIZE;
    }

    boolean isEmpty() {
        return currentSize == 0;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        int y = getHeight() - (currentSize * getHeight() / MAX_SIZE);
        g.fillRect(0, y, getWidth(), getHeight() - y);
        g.setColor(Color.GRAY);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }
}
class BeverageMachinePanel extends JPanel {
    private IngredientLabel[] ingredientLabels = new IngredientLabel[5];
    private JLabel beverageImageLabel;
    private ImageIcon beverageIcon = new ImageIcon("images/coffee.jpg");

    private static final int CUP = 0;
    private static final int COFFEE = 1;
    private static final int WATER = 2;
    private static final int SUGAR = 3;
    private static final int CREAM = 4;

    private String[] ingredientNames = {"Cup", "Coffee", "Water", "Sugar", "Cream"};

    public BeverageMachinePanel() {
        setLayout(null);

        for (int i = 0; i < ingredientLabels.length; i++) {
            ingredientLabels[i] = new IngredientLabel();
            ingredientLabels[i].setLocation(30 + 80 * i, 10);
            ingredientLabels[i].setSize(40, 100);

            JLabel textLabel = new JLabel(ingredientNames[i]);
            textLabel.setLocation(30 + 80 * i, 120);
            textLabel.setSize(50, 30);

            add(ingredientLabels[i]);
            add(textLabel);
        }

        beverageImageLabel = new JLabel();
        beverageImageLabel.setLocation(180, 200);
        beverageImageLabel.setSize(beverageIcon.getIconWidth(), beverageIcon.getIconHeight());

        add(beverageImageLabel);
    }

    public void processCommand(String command) {
        if (command.equals("Black Coffee")) {
            if (ingredientLabels[CUP].isEmpty() || ingredientLabels[COFFEE].isEmpty() || ingredientLabels[WATER].isEmpty()) {
                displayError("부족한 것이 있습니다. 채워주세요.");
                return;
            } else {
                ingredientLabels[CUP].consume();
                ingredientLabels[COFFEE].consume();
                ingredientLabels[WATER].consume();
            }
        } else if (command.equals("Sugar Coffee")) {
            if (ingredientLabels[CUP].isEmpty() || ingredientLabels[COFFEE].isEmpty() || ingredientLabels[WATER].isEmpty() || ingredientLabels[SUGAR].isEmpty()) {
                displayError("부족한 것이 있습니다. 채워주세요.");
                return;
            } else {
                ingredientLabels[CUP].consume();
                ingredientLabels[COFFEE].consume();
                ingredientLabels[WATER].consume();
                ingredientLabels[SUGAR].consume();
            }
        } else if (command.equals("Dabang Coffee")) {
            if (ingredientLabels[CUP].isEmpty() || ingredientLabels[COFFEE].isEmpty() || ingredientLabels[WATER].isEmpty() || ingredientLabels[SUGAR].isEmpty() || ingredientLabels[CREAM].isEmpty()) {
                displayError("부족한 것이 있습니다. 채워주세요.");
                return;
            } else {
                ingredientLabels[CUP].consume();
                ingredientLabels[COFFEE].consume();
                ingredientLabels[WATER].consume();
                ingredientLabels[SUGAR].consume();
                ingredientLabels[CREAM].consume();
            }
        } else {
            for (IngredientLabel ingredientLabel : ingredientLabels) {
                ingredientLabel.refill();
            }
            repaint();
            return;
        }

        repaint();
        beverageImageLabel.setIcon(beverageIcon);

        JOptionPane.showMessageDialog(this, "Enjoy your drink!", "Beverage Ready", JOptionPane.INFORMATION_MESSAGE);

        beverageImageLabel.setIcon(null);
    }

    private void displayError(String message) {
        JOptionPane.showMessageDialog(this, message, "Vending Machine Alert", JOptionPane.INFORMATION_MESSAGE);
    }
}

class HeaderPanel extends JPanel {
    private JLabel titleLabel = new JLabel("Welcome, Hot Coffee !!");

    public HeaderPanel() {
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        setBackground(Color.MAGENTA);
        add(titleLabel);
    }
}

class ControlPanel extends JPanel {
    private JButton[] beverageButtons = new JButton[4];
    private String[] buttonLabels = {"Black Coffee", "Sugar Coffee", "Cream Coffee", "Reset"};

    public ControlPanel(BeverageMachinePanel beverageMachinePanel) {
        for (int i = 0; i < beverageButtons.length; i++) {
            beverageButtons[i] = new JButton(buttonLabels[i]);
            add(beverageButtons[i]);

            beverageButtons[i].addActionListener(new ActionListener() {
            
                public void actionPerformed(ActionEvent e) {
                    beverageMachinePanel.processCommand(e.getActionCommand());
                }
            });
        }
    }
}

public class OpenChallenge_14 extends JFrame {
    private BeverageMachinePanel beverageMachinePanel = new BeverageMachinePanel();

    public OpenChallenge_14() {
        setTitle("Beverage Challenge");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();

        container.add(new HeaderPanel(), BorderLayout.NORTH);
        container.add(beverageMachinePanel, BorderLayout.CENTER);
        container.add(new ControlPanel(beverageMachinePanel), BorderLayout.SOUTH);

        setSize(450, 400);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new OpenChallenge_14();
    }
}
