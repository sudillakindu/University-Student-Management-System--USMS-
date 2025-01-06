package model;

import javax.swing.*;
import java.sql.*;

public class RegistrationModel {

    public RegistrationModel() {
    }

    public boolean insertStudent(String studentID, String name, String dob, String address, String contactNumber, int enrollmentYear) {
        String query = "INSERT INTO students (studentID, name, dob, address, contactNumber, enrollmentYear) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, studentID);
            stmt.setString(2, name);
            stmt.setDate(3, Date.valueOf(dob));
            stmt.setString(4, address);
            stmt.setString(5, contactNumber);
            stmt.setInt(6, enrollmentYear);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
            return false;
        }
    }

    public boolean deleteStudent(String studentID) {
        String query = "DELETE FROM students WHERE studentID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, studentID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
            return false;
        }
    }

    public boolean updateStudent(String studentID, String name, String dob, String address, String contactNumber, int enrollmentYear) {
        String query = "UPDATE students SET name = ?, dob = ?, address = ?, contactNumber = ?, enrollmentYear = ? WHERE studentID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setDate(2, Date.valueOf(dob));
            stmt.setString(3, address);
            stmt.setString(4, contactNumber);
            stmt.setInt(5, enrollmentYear);
            stmt.setString(6, studentID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
            return false;
        }
    }

    public ResultSet getAllStudents() {
        String query = "SELECT * FROM students ORDER BY studentID DESC";
        Connection connection = DatabaseConnection.getConnection(); // Don't close it immediately.
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query); // Return the ResultSet without closing the connection.
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
            return null;
        }
    }

}
