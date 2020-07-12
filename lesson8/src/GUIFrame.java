import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFrame extends JFrame {
    public GUIFrame() {
        setTitle("My first Java GUI");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 500);

        setBackground(new Color(202, 114, 14));


        GridLayout gridLayout = new GridLayout(3, 3);
        setLayout(gridLayout);

        JTextField textField = new JTextField();
        textField.setBackground(new Color(0xA2E44C));
        add(textField);

        ButtonListener buttonListener = new ButtonListener(textField);

        for (int i = 1; i <= 9; i++) {
            JButton jButton = new JButton(String.valueOf(i));
            jButton.addActionListener(buttonListener);
            add(jButton);
        }

        JButton plusButton = new JButton("+");
        plusButton.addActionListener(buttonListener);
        add(plusButton);

        JButton minusButton = new JButton("-");
        minusButton.addActionListener(buttonListener);
        add(minusButton);

        JButton timesButton = new JButton("*");
        timesButton.addActionListener(buttonListener);
        add(timesButton);

        JButton divideButton = new JButton("/");
        divideButton.addActionListener(buttonListener);
        add(divideButton);

        JButton pushButton = new JButton("Push");
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                String[] splitted = text.split(" ");
                int val = 0;
                char currentOperation = '+'; // +, -, * , /
                for (int i = 0; i < splitted.length; i++) {
                    if (i % 2 == 0) { // число
                        int digit = Integer.parseInt(splitted[i]);
                        switch (currentOperation) {
                            case '+':
                                val += digit;
                                break;
                            case '-':
                                val -= digit;
                                break;
                            case '*':
                                val *= digit;
                                break;
                            case '/':
                                val /= digit;
                                break;
                        }
                    } else { // операция
                        currentOperation = splitted[i].charAt(0);
                    }
                }
                textField.setText(String.valueOf(val));
            }
        });

        add(pushButton);

        setVisible(true);
    }
}
