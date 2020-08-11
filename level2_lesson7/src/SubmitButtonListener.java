import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;

public class SubmitButtonListener implements ActionListener {
    private final StringBuilder stb = new StringBuilder();
    private final JTextField textField;
    private final JTextArea textArea;
    private DataOutputStream out;

    public SubmitButtonListener(JTextField textField, JTextArea textArea, DataOutputStream out) {
        this.textField = textField;
        this.textArea = textArea;
        this.out = out;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            out.writeUTF(textField.getText());
        } catch (IOException ioException) {
            textArea.append("Your message wasn't sent");
            ioException.printStackTrace();
        }
        textField.setText("");
        stb.setLength(0);
        textField.grabFocus();
    }
}
