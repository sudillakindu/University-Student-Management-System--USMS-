package model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseModel {

    public CourseModel() {
    }

    public ResultSet getAllCourses() {
        String query = "SELECT * FROM courses ORDER BY courseID DESC";
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
