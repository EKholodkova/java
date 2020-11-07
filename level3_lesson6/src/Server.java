import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private static final Logger logger = Logger.getLogger(Server.class.getName());
    public static final int PORT = 8882;
    private AuthService authService;
    private Set<ClientHandler> clientHandlers;  //список уже вошедших в систему пользователей

    public Server() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            authService = new BasicAuthService();
            logger.log(Level.INFO, "Auth is started up");
            clientHandlers = new HashSet<>();

            while (true) {
                logger.log(Level.INFO, "Waiting for connection...");
                Socket socket = serverSocket.accept();
                logger.log(Level.INFO, "Client connected: " + socket);
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Server error", e);
        }
    }

    public AuthService getAuthService() {
        return authService;
    }
    public synchronized boolean isOccupied(AuthService.Record record) { //проверка учетной записи на занятость
        for(ClientHandler ch : clientHandlers) {
            if(ch.getRecord().equals(record)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void subscribe(ClientHandler ch) {
        clientHandlers.add(ch);
    }
    public synchronized void unsubscribe(ClientHandler ch) {
        clientHandlers.remove(ch);
    }
    public synchronized void broadcastMessage(String message) { //рассылка сообщения всем зарегистрированным пользователям
        for(ClientHandler ch : clientHandlers) {
            ch.sendMessage(message);
        }
    }
}
