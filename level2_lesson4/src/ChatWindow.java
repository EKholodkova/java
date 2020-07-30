import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class ChatWindow extends JFrame {
    public ChatWindow() {
        setTitle("Work Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 600, 800);


        JPanel mainPanel = new JPanel(new BorderLayout()); //добавили большое текстовое поле со скроллом
        JTextArea charTextArea = new JTextArea();
        charTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(charTextArea);
        mainPanel.add(scrollPane);
        add(mainPanel);

        //добавляем вниз однострочное текстовое поле
        JPanel controlPanel = new JPanel(new BorderLayout());
        JTextField messageTextField = new JTextField();
        messageTextField.addActionListener(new ActionListener() {
            private StringBuilder stb = new StringBuilder();

            @Override
            public void actionPerformed(ActionEvent e) {
                if(messageTextField.getText().isBlank()) {
                    return;
                }
                stb.append(charTextArea.getText())
                        .append("\n")
                        .append(messageTextField.getText());
                charTextArea.setText(stb.toString());
                messageTextField.setText("");
                stb.setLength(0);
            }
        });
        controlPanel.add(messageTextField);

        JButton submit = new JButton("Submit");
        submit.setBackground(new Color(103, 130, 149));
        submit.setForeground(Color.WHITE);
        submit.setOpaque(true);
        submit.addActionListener(new SubmitButtonListener(messageTextField, charTextArea));
        controlPanel.add(submit, BorderLayout.EAST);


        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
