package model;

import javax.swing.*;
import java.sql.*;

public class EnrollmentModel {

    public EnrollmentModel() {
    }

    // Method to insert an enrollment
    public boolean insertEnrollment(String enrollmentID, String studentID, String courseID, String enrollmentDate) {
        String query = "INSERT INTO enrollments (enrollmentID, studentID, courseID, enrollmentDate) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, enrollmentID);
            stmt.setString(2, studentID);
            stmt.setString(3, courseID);
            stmt.setDate(4, Date.valueOf(enrollmentDate));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
            return false;
        }
    }

    // Method to delete an enrollment
    public boolean deleteEnrollment(String enrollmentID) {
        String query = "DELETE FROM enrollments WHERE enrollmentID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, enrollmentID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
            return false;
        }
    }

    // Method to update an enrollment
    public boolean updateEnrollment(String enrollmentID, String studentID, String courseID, String enrollmentDate) {
        String query = "UPDATE enrollments SET studentID = ?, courseID = ?, enrollmentDate = ? WHERE enrollmentID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, studentID);
            stmt.setString(2, courseID);
            stmt.setDate(3, Date.valueOf(enrollmentDate));
            stmt.setString(4, enrollmentID);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
            return false;
        }
    }

    // Method to get all enrollments
    public ResultSet getAllEnrollments() {
        String query = "SELECT * FROM enrollments ORDER BY enrollmentID DESC";
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
