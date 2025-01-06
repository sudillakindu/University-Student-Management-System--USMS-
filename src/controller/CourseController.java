package controller;

import model.CourseModel;
import model.RegistrationModel;
import view.CourseView;
import view.RegistrationView;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseController {
    private CourseView view;
    private CourseModel model;

    public CourseController(CourseView view, CourseModel model) {
        this.view = view;
        this.model = model;

        loadTableData();
    }

    private void loadTableData() {
        ResultSet rs = model.getAllCourses();
        DefaultTableModel tableModel = (DefaultTableModel) view.getTable().getModel();
        tableModel.setRowCount(0);

        try {
            while (rs != null && rs.next()) {
                Object[] row = {
                        rs.getString("courseID"),
                        rs.getString("courseName"),
                        rs.getInt("credits"),
                        rs.getString("duration"),
                        rs.getString("faculty"),
                };
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close(); // Ensure to close the ResultSet after you're done with it.
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
