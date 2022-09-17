package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection con = null;

    static {
        final String url = "jdbc:postgresql://127.0.0.1:5432/twitter";
        final String user = "omid";
        final String pass = "omgin";
        try {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return con;
    }

}
