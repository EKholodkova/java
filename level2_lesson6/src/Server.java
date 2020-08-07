import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {

    public Server() throws InterruptedException {
        try{
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Server is running. Waiting for connection.");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            WaiterIn waiterIn = new WaiterIn();
            Thread t1 = new Thread(waiterIn);
            t1.start();

            WaiterOut waiterOut = new WaiterOut(in);
            Thread t2 = new Thread(waiterOut);
            t2.start();


            while (true) {
                Thread.sleep(1);
                String user2Message = waiterIn.getText();
                if(user2Message != null) {
                    out.writeUTF(user2Message);
                    if(user2Message.equals("/end\n")) {
                        socket.close();
                        break;
                    }
                }
                String str = waiterOut.getText();
                if(str != null) {
                    System.out.print(str);
                    if(str.equals("/end\n")) {
                        socket.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
