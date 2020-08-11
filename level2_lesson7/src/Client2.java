import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", Server.PORT);
        System.out.println("Client connected to server: " + socket);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            ChatWindow chatWindow = new ChatWindow(socket);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

    }


}

