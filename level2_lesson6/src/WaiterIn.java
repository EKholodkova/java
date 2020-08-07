import java.util.Scanner;

public class WaiterIn implements Runnable {
    final StringBuilder text = new StringBuilder();

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String message = sc.nextLine();
            if(message.equals("/end")) {
                text.append(message + "\n");
                break;
            }
            synchronized (text) {
                text.append(message + "\n");
            }
        }
    }

    public String getText() {
        synchronized (text) {
            if (text.length() == 0) {
                return null;
            }
            String str = text.toString();
            text.delete(0, text.length());
            return str;
        }
    }
}
