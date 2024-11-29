package Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
    private final String URL = "jdbc:mysql://localhost:3306/fruitstore?userSSL = false";
    private final String USERNAME = "root";
    private final String PASSWORD = "kjfhjhh12345";

    public DatabaseConnect(){}

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connect database successfully");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        DatabaseConnect databaseConnect = new DatabaseConnect();
        System.out.println(databaseConnect.getConnection());
    }
}
