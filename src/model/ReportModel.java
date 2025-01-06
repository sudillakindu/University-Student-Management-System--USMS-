package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReportModel {
    public List<AttendanceRecord> findAttendanceRecords() {
        List<AttendanceRecord> records = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            try {
                String query = "SELECT a.studentID, s.name AS studentName, a.date AS attendanceDate, a.status " +
                        "FROM attendance a JOIN students s ON a.studentID = s.studentID";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    String studentID = resultSet.getString("studentID");
                    String studentName = resultSet.getString("studentName");
                    String attendanceDate = resultSet.getString("attendanceDate");
                    String status = resultSet.getString("status");

                    AttendanceRecord record = new AttendanceRecord(studentID, studentName, attendanceDate, status);
                    records.add(record);
                }

            } catch (SQLException e) {
                System.out.println("Error fetching attendance records from the database.");
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Database connection is null.");
        }

        return records;
    }


    public static class AttendanceRecord {
        private String studentID;
        private String studentName;
        private String attendanceDate;
        private String status;

        public AttendanceRecord(String studentID, String studentName, String attendanceDate, String status) {
            this.studentID = studentID;
            this.studentName = studentName;
            this.attendanceDate = attendanceDate;
            this.status = status;
        }

        public String getStudentID() {
            return studentID;
        }
        public void setStudentID(String studentID) {
            this.studentID = studentID;
        }
        public String getStudentName() {
            return studentName;
        }
        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }
        public String getAttendanceDate() {
            return attendanceDate;
        }
        public void setAttendanceDate(String attendanceDate) {
            this.attendanceDate = attendanceDate;
        }
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
    }





}

