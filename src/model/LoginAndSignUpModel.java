package model;

import java.sql.*;
import java.util.Objects;

public class LoginAndSignUpModel {

    public String validateLogin(String username, String password) {
        try (Connection connection = DatabaseConnection.getConnection()) {

            // Query to check user credentials
            String userQuery = "SELECT password FROM users WHERE username = ?";
            PreparedStatement userStmt = connection.prepareStatement(userQuery);
            userStmt.setString(1, username);
            ResultSet userRs = userStmt.executeQuery();
            if (userRs.next()) {
                String storedHashedPassword = userRs.getString("password");
                if (Objects.equals(storedHashedPassword, hashPassword(password))) {
                    return "return1";
                }
            }

            // Query to check admin credentials
            String adminQuery = "SELECT password FROM admins WHERE username = ?";
            PreparedStatement adminStmt = connection.prepareStatement(adminQuery);
            adminStmt.setString(1, username);
            ResultSet adminRs = adminStmt.executeQuery();
            if (adminRs.next()) {
                String storedHashedPassword = adminRs.getString("password");
                if (Objects.equals(storedHashedPassword, hashPassword(password))) {
                    return "return2";
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "return3";
    }

    public String validateSignUp(String role, String username, String email, String password) {
        try (Connection connection = DatabaseConnection.getConnection()) {

            // Query to check if the user already exists
            String userExistsQuery = "SELECT * FROM " + role + "s WHERE username = ? OR email = ?";
            PreparedStatement checkUserStmt = connection.prepareStatement(userExistsQuery);
            checkUserStmt.setString(1, username);
            checkUserStmt.setString(2, email);
            ResultSet rs = checkUserStmt.executeQuery();

            if (rs.next()) {
                return "return4";
            }

            // Hash the password for security
            String hashedPassword = hashPassword(password);

            // Insert the new user into the database
            String insertUserQuery = "INSERT INTO " + role + "s (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement insertUserStmt = connection.prepareStatement(insertUserQuery);
            insertUserStmt.setString(1, username);
            insertUserStmt.setString(2, email);
            insertUserStmt.setString(3, hashedPassword);

            int rowsInserted = insertUserStmt.executeUpdate();
            if (rowsInserted > 0) {
                return "return5";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Database error occurred!" + "\n" + e.getMessage();
        }
        return "return6";
    }

    // Helper method to hash the password (you can use libraries like BCrypt for better security)
    private String hashPassword(String password) {
        return Integer.toHexString(password.hashCode());
    }
}
