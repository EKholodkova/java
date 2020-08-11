import javax.imageio.IIOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private AuthService.Record record;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        doAuth();
                        readMessage();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        closeConnection();
                    }

                }
            })
                    .start();

        } catch(IOException e) {
            throw new RuntimeException("Client handler was not created");
        }
    }

    public AuthService.Record getRecord() {
        return record;
    }

    public void doAuth() throws IOException {
        while (true) {
            System.out.println("Waiting for auth...");
            String message = in.readUTF();
            if(message.startsWith("/auth")) {
                String[] credentials = message.split("\\s");
                AuthService.Record possibleRecord = server.getAuthService().findRecord(credentials[1], credentials[2]);
                if(possibleRecord != null) {
                    if(!server.isOccupied(possibleRecord)) {
                        record = possibleRecord;
                        sendMessage("/authok " + record.getName());
                        server.broadcastMessage("Logged in " + record.getName());
                        System.out.println(record.getName() + " authorized");
                        server.subscribe(this);
                        break;
                    } else {
                        sendMessage(String.format("Current record [%s] is already occupied", possibleRecord.getName()));
                    }
                } else {
                    sendMessage("Record is not found");
                }
            }
        }
    }

    public void sendMessage(String message) { //отправка пользователю сообщения (например, об успешной авторизации)
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readMessage() throws IOException {
        while(true) {
            String message = in.readUTF();
            System.out.println(String.format("Incoming message from %s: %s", record.getName(), message));
            if(message.equals("/end")) {
                return;
            }
            server.broadcastMessage(String.format("%s: %s", record.getName(), message));
        }
    }
    public void closeConnection() {
        server.unsubscribe(this);
        server.broadcastMessage(record.getName() + " left chat");
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientHandler that = (ClientHandler) o;
        return server.equals(that.server) &&
                socket.equals(that.socket) &&
                in.equals(that.in) &&
                out.equals(that.out) &&
                record.equals(that.record);
    }

    @Override
    public int hashCode() {
        return Objects.hash(server, socket, in, out, record);
    }
}
