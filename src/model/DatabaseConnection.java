package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String driver = "com.mysql.cj.jdbc.Driver";

    private static final String url = "jdbc:mysql://localhost:3306/usms";
    private static final String username = "root";
    private static final String password = "";

    private DatabaseConnection() {}

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Connected to the database!");
            }
        } catch (SQLException e) {
            System.err.println("Database connection failed. Check your database URL, username, and password.");
            e.printStackTrace();
            //System.exit(1);
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Ensure it's added to your project dependencies.");
            e.printStackTrace();
            //System.exit(1);
        }

        return connection;
    }
}
