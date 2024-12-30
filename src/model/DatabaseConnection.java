package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    private static final String driver = "com.mysql.cj.jdbc.Driver";

    private static final String url = "jdbc:mysql://localhost:3306/usms";
    private static final String username = "admin";
    private static final String password = "admin@123";

    private DatabaseConnection() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL JDBC Driver not found. Ensure it's added to your project dependencies.");
                e.printStackTrace();
                System.exit(1);
            } catch (SQLException e) {
                System.err.println("Database connection failed. Check your database URL, username, and password.");
                e.printStackTrace();
                System.exit(1);
            }
        }
        return connection;
    }
}
