package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DashboardModel {

    public static List<EnrollmentDate> getEnrollmentDate() {
        List<EnrollmentDate> enrollmentDates = new ArrayList<>();

        // SQL query to get the enrollment count per year
        String query = "SELECT YEAR(enrollmentDate) AS year, COUNT(*) AS count " +
                "FROM enrollments " +
                "GROUP BY YEAR(enrollmentDate) " +
                "ORDER BY YEAR(enrollmentDate)";


        // Corrected the try block and connection usage
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int year = rs.getInt("year");
                int count = rs.getInt("count");
                enrollmentDates.add(new EnrollmentDate(year, count));
            }

        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception
            throw new RuntimeException(e);  // Optionally, rethrow or handle differently
        }

        return enrollmentDates;
    }

    // Enrollment class to hold the year and count data
    public static class EnrollmentDate {
        private int year;
        private int count;

        public EnrollmentDate(int year, int count) {
            this.year = year;
            this.count = count;
        }

        public int getYear() {
            return year;
        }

        public int getCount() {
            return count;
        }
    }

    public int getStudentCount() {
        String query = "SELECT COUNT(*) AS total FROM students";
        return getCount(query);
    }

    public int getCourseCount() {
        String query = "SELECT COUNT(*) AS total FROM courses";
        return getCount(query);
    }

    public int getEnrollmentCount() {
        String query = "SELECT COUNT(*) AS total FROM enrollments";
        return getCount(query);
    }

    private int getCount(String query) {
        int count = 0;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                count = resultSet.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }








}

/*package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DashboardModel {

    public static List<EnrollmentDate> getEnrollmentDate() {
        List<EnrollmentDate> enrollmentDates = new ArrayList<>();

        // SQL query to get the year-month and enrollment count
        String query = "SELECT CONCAT(YEAR(enrollmentDate), '-', LPAD(MONTH(enrollmentDate), 2, '0')) AS yearmonth, COUNT(*) AS count " +
                "FROM enrollments " +
                "GROUP BY CONCAT(YEAR(enrollmentDate), '-', LPAD(MONTH(enrollmentDate), 2, '0')) " +
                "ORDER BY yearmonth";

        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String yearMonth = rs.getString("yearmonth"); // Retrieve yearmonth as a string
                int count = rs.getInt("count"); // Retrieve the count as an integer
                enrollmentDates.add(new EnrollmentDate(yearMonth, count)); // Store in the list
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return enrollmentDates;
    }


    // Enrollment class to hold the year and count data
    public static class EnrollmentDate {
        private String yearMonth;
        private int count;

        public EnrollmentDate(String yearMonth, int count) {
            this.yearMonth = yearMonth;
            this.count = count;
        }

        public String getYearMonth() {
            return yearMonth;
        }

        public int getCount() {
            return count;
        }
    }
}
*/
