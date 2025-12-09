/*
 * 실습문제 4
 * 실습문제 3번에 체크박스를 추가하여, 사용자가 선택한 체크박스에 해당하는 돈으로만 바꿀 수 있도록 하라.
 */

package Exam;

import javax.swing.*;
import java.awt.event.*;

public class Exam_4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("선택 화폐 단위 계산기");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("금액 입력 : ");
        label.setBounds(30, 20, 80, 30);
        frame.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(110, 20, 150, 30);
        frame.add(textField);

        JButton calcButton = new JButton("계산");
        calcButton.setBounds(270, 20, 80, 30);
        frame.add(calcButton);

        String[] unitNames = {
            "오만원권", "만원권", "천원권", "500원", "100원", "50원", "10원", "1원"
        };
        int[] unitValues = {
            50000, 10000, 1000, 500, 100, 50, 10, 1
        };

        JCheckBox[] unitChecks = new JCheckBox[unitNames.length];
        JLabel[] resultLabels = new JLabel[unitNames.length];

        for (int i = 0; i < unitNames.length; i++) {
            unitChecks[i] = new JCheckBox(unitNames[i]);
            unitChecks[i].setBounds(30, 70 + i * 40, 100, 30);
            frame.add(unitChecks[i]);

            resultLabels[i] = new JLabel("0개");
            resultLabels[i].setBounds(150, 70 + i * 40, 100, 30);
            frame.add(resultLabels[i]);
        }

        calcButton.addActionListener(e -> {
            try {
                int amount = Integer.parseInt(textField.getText());

                for (int i = 0; i < unitValues.length; i++) {
                    if (unitChecks[i].isSelected()) {
                        int count = amount / unitValues[i];
                        amount %= unitValues[i];
                        resultLabels[i].setText(count + "개");
                    } else {
                        resultLabels[i].setText("0개");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "숫자를 정확히 입력하세요.");
            }
        });

        frame.setVisible(true);
    }
}
