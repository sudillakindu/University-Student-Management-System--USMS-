package controller;

import model.CourseModel;
import model.EnrollmentModel;
import model.RegistrationModel;
import view.EnrollmentView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnrollmentController {
    private EnrollmentView view;
    private EnrollmentModel model;

    public EnrollmentController(EnrollmentView view, EnrollmentModel model) {
        this.view = view;
        this.model = model;

        this.view.addInsertListener(new InsertListener());
        this.view.addDeleteListener(new DeleteListener());
        this.view.addUpdateListener(new UpdateListener());
        loadTableData();
    }

    private void loadTableData() {
        ResultSet rs = model.getAllEnrollments();
        DefaultTableModel tableModel = (DefaultTableModel) view.getTable().getModel();
        tableModel.setRowCount(0);

        try {
            while (rs != null && rs.next()) {
                Object[] row = {
                        rs.getString("enrollmentID"),
                        rs.getString("studentID"),
                        rs.getString("courseID"),
                        rs.getDate("enrollmentDate")
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

    class InsertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.validateForm()) {  // Perform validation before proceeding
                String[] formData = view.getFormData();
                if (model.insertEnrollment(formData[0], formData[1], formData[2], formData[3])) {
                    JOptionPane.showMessageDialog(view.getEnrollmentViewPanel(), "Enrollment added successfully.");
                    loadTableData();
                } else {
                    JOptionPane.showMessageDialog(view.getEnrollmentViewPanel(), "Failed to add enrollment.");
                }
            }
        }
    }

    class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String enrollmentID = view.getSelectedEnrollmentID();

            // Ensure that an enrollment is selected before attempting to delete
            if (enrollmentID == null || enrollmentID.trim().isEmpty()) {
                JOptionPane.showMessageDialog(view.getEnrollmentViewPanel(), "Please select an enrollment to delete.");
                return;
            }

            // Confirm the deletion
            int confirmDelete = JOptionPane.showConfirmDialog(view.getEnrollmentViewPanel(),
                    "Are you sure you want to delete the selected enrollment?", "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION);

            if (confirmDelete == JOptionPane.YES_OPTION) {
                // Attempt to delete the enrollment and refresh the table
                if (model.deleteEnrollment(enrollmentID)) {
                    JOptionPane.showMessageDialog(view.getEnrollmentViewPanel(), "Enrollment deleted successfully.");
                    loadTableData();  // Refresh the table after deletion
                } else {
                    JOptionPane.showMessageDialog(view.getEnrollmentViewPanel(), "Failed to delete enrollment.");
                }
            }
        }
    }

    class UpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Validate the form before attempting to update
            if (view.validateForm()) {
                String[] formData = view.getFormData();
                String enrollmentID = formData[0];  // Assuming enrollment ID is entered in the first field

                // Ensure the enrollment ID is provided for update
                if (enrollmentID == null || enrollmentID.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(view.getEnrollmentViewPanel(), "Please enter a valid Enrollment ID.");
                    return;
                }

                // Attempt to update the enrollment data
                if (model.updateEnrollment(enrollmentID, formData[1], formData[2], formData[3])) {
                    JOptionPane.showMessageDialog(view.getEnrollmentViewPanel(), "Enrollment updated successfully.");
                    loadTableData();  // Refresh the table after the update
                } else {
                    JOptionPane.showMessageDialog(view.getEnrollmentViewPanel(), "Failed to update enrollment.");
                }
            }
        }
    }
}
