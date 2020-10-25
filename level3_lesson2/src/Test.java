import java.sql.*;

public class Test {
    public static Connection conn;
    public static Statement statement;
    public static ResultSet resultSet;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        setConn();
        createDB();
        writeBD();
        readBD();
        closeDB();
    }

    public static void setConn() throws ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:TEST11.s3db");
    }

    public static void createDB() throws SQLException {
        statement = conn.createStatement();
        statement.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'login' text, 'password' text);");
    }

    public static void writeBD() throws SQLException {
        statement.execute("INSERT INTO 'users' ('name', 'login', 'password') VALUES ('John', 'li', 'p1');");
        statement.execute("INSERT INTO 'users' ('name', 'login', 'password') VALUES ('Tom', 'l2', 'p2');");
        statement.execute("INSERT INTO 'users' ('name', 'login', 'password') VALUES ('Jerry', 'l3', 'p3');");
        statement.execute("INSERT INTO 'users' ('name', 'login', 'password') VALUES ('Sam', 'l4', 'p4');");
        statement.execute("INSERT INTO 'users' ('name', 'login', 'password') VALUES ('Sven', 'l5', 'p5');");
    }

    public static void readBD() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM users");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");

            System.out.println(id + " " + name + " " + login + " " + password);
        }
    }

    public static void closeDB() throws SQLException {
        resultSet.close();
        statement.close();
        conn.close();
    }
}
