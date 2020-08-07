import java.io.DataInputStream;
import java.io.IOException;

public class WaiterOut implements Runnable {
    final StringBuilder text = new StringBuilder();
    private DataInputStream in;

    public WaiterOut(DataInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try{
            while (true) {
                String message = in.readUTF();
                synchronized (text) {
                    text.append(message + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
