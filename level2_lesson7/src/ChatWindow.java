import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ChatWindow extends JFrame {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public ChatWindow(Socket socket) throws IOException {
        this.socket = socket;
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        setTitle("Work Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 600, 800);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    out.writeUTF("/end");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    in.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    out.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    socket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


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
                try {
                    out.writeUTF(messageTextField.getText());
                } catch (IOException ioException) {
                    charTextArea.append("Your message wasn't sent");
                    ioException.printStackTrace();
                }
                messageTextField.setText("");
                stb.setLength(0);
            }
        });
        controlPanel.add(messageTextField);

        JButton submit = new JButton("Submit");
        submit.setBackground(new Color(103, 130, 149));
        submit.setForeground(Color.WHITE);
        submit.setOpaque(true);
        submit.addActionListener(new SubmitButtonListener(messageTextField, charTextArea, out));
        controlPanel.add(submit, BorderLayout.EAST);


        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try{
                        String message = in.readUTF();
                        charTextArea.append(message);
                        charTextArea.append("\n");
                        if(message.equals("/end")) {
                            System.out.println("Session closed");
                            break;
                        }
                    } catch (IOException e) {
                        charTextArea.append("Server is not available");
                        break;
                    }

                }
            }
        });
        t.start();

    }
}
