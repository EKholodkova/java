import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DialogueApp {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static UsersDB usersDB = new UsersDB("TEST_1");

    public static void main(String[] args) throws IOException {
        Pair<String, String> logPass = getData();
        System.out.println(logPass.login);
        System.out.println(logPass.password);
//        usersDB.printData();
        System.out.println(usersDB.findData(logPass));
        doAuth(logPass);
        changeName(logPass);
    }



    public static Pair<String, String> getData() throws IOException {
        System.out.println("Enter your login.");
        String login = reader.readLine();

        System.out.println("Enter your password.");
        String password = reader.readLine();

        Pair<String, String> pair = new Pair<>(login, password);
        return pair;
    }


    public static boolean doAuth(Pair<String, String> pair) throws IOException {
        if(usersDB.findData(pair) == null) {
            System.out.println("There is no such login and password.");
            System.out.println("Would you like to sign in with login and password you've entered? YES/NO.");
            String answer = reader.readLine();
            if(answer.equals("YES")) {
                System.out.println("Please, enter your name.");
                String name = reader.readLine();
                DataItem newItem = new DataItem(name, pair.login, pair.password);
                usersDB.addData(newItem);
                System.out.println("Hi, " + name + "! You are signed in. Your LOGIN is: " + pair.login + ", your PASSWORD is: " + pair.password);
                usersDB.printData();
                return true;
            } else {
                System.out.println("You're not signed in");
                return false;
            }
        } else {
            System.out.println("You are signed in.");
            return true;
        }
    }

    public static void changeName(Pair<String, String> pair) throws IOException {
        if(usersDB.findData(pair) != null) {
            System.out.println("Do you want to change your name? YES/NO");
            String answer = reader.readLine();
            if(answer.equals("YES")) {
                System.out.println("Enter new name.");
                String name = reader.readLine();
                usersDB.changeData(pair, name);
                usersDB.printData();
                System.out.println("Your name was successfully changed");
            } else {
                System.out.println("Your name remains the same");
            }
        }

    }


    public static class Pair<L, P> {
        L login;
        P password;

        public Pair(L l, P p) {
            this.login = l;
            this.password = p;
        }
    }

    public static class DataItem {
        String name;
        String login;
        String password;

        public DataItem(String name, String login, String password) {
            this.name = name;
            this.login = login;
            this.password = password;
        }

        @Override
        public String toString() {
            return "DataItem{" +
                    "name='" + name + '\'' +
                    ", login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
