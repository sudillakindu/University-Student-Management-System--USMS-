package model;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceModel {

    public AttendanceModel() {
    }

    public boolean insertAttendance(String attendanceID, String studentID, String courseID, String date, String status) {
        String sql = "INSERT INTO attendance (attendanceID, studentID, courseID, date, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, attendanceID);
            pstmt.setString(2, studentID);
            pstmt.setString(3, courseID);
            pstmt.setDate(4, Date.valueOf(date));
            pstmt.setString(5, status);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Error : " + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Method to delete an attendance
    public boolean deleteAttendance(String attendance) {
        String query = "DELETE FROM attendance WHERE attendanceID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, attendance);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
            return false;
        }
    }

    public List<String[]> getAllAttendance() {
        List<String[]> attendanceData = new ArrayList<>();
        String sql = "SELECT * FROM attendance ORDER BY attendanceID DESC";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String[] row = new String[5];
                row[0] = rs.getString("attendanceID");
                row[1] = rs.getString("studentID");
                row[2] = rs.getString("courseID");
                row[3] = rs.getDate("date").toString();
                row[4] = rs.getString("status");
                attendanceData.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendanceData;
    }
}
