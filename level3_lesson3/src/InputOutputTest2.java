import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputOutputTest2 {
    public static File file = new File("/Users/artist/Desktop/t1.txt");
    public static FileReader fileReader = null;
    public static BufferedReader reader = null;
    public static BufferedWriter bfr = null;
    public static FileWriter fileWriter = null;

    public static void main(String[] args) {
        showRecords();
        addRecords();
        closeStream();
    }

    public static void showRecords() {
        try {
            List<String> readList = new ArrayList<>();
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String s = "";
            while ((s = reader.readLine()) != null) {
                readList.add(s);
            }

            if(readList.size() != 0) {
                if(readList.size() < 100) {
                    for(int i = 0; i < readList.size(); i++) {
                        System.out.println(readList.get(i));
                    }
                } else {
                    for(int i = 100; i>0; i--) {
                        System.out.println(readList.get(readList.size()-i));
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addRecords() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileWriter = new FileWriter(file, true);
            bfr = new BufferedWriter(fileWriter);

            while(true) {
                String str = reader.readLine();
                bfr.write(str + "\n");
                if(str.equals("/end")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeStream() {
        try {
            bfr.close();
            reader.close();
            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
