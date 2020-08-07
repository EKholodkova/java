import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8888;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client() throws InterruptedException {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openConnection() throws IOException, InterruptedException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        WaiterIn waiterIn = new WaiterIn();
        Thread t1 = new Thread(waiterIn);
        t1.start();

        WaiterOut waiterOut = new WaiterOut(in);
        Thread t2 = new Thread(waiterOut);
        t2.start();

        while (true) {
            Thread.sleep(1);
            String user2Message = waiterIn.getText();
            if (user2Message != null) {
                out.writeUTF(user2Message);
                if (user2Message.equals("/end\n")) {
                    socket.close();
                    break;
                }
            }
            String str = waiterOut.getText();
            if (str != null) {
                System.out.print(str);
                if (str.equals("/end\n")) {
                    socket.close();
                    break;
                }
            }
        }
    }


}
