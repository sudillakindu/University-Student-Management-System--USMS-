package controller;

import model.RegistrationModel;
import view.RegistrationView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class RegistrationController {
    private RegistrationView view;
    private RegistrationModel model;

    public RegistrationController(RegistrationView view, RegistrationModel model) {
        this.view = view;
        this.model = model;

        this.view.addInsertListener(new InsertListener());
        this.view.addDeleteListener(new DeleteListener());
        this.view.addUpdateListener(new UpdateListener());
        loadTableData();
    }

    private void loadTableData() {
        ResultSet rs = model.getAllStudents();
        DefaultTableModel tableModel = (DefaultTableModel) view.getTable().getModel();
        tableModel.setRowCount(0);

        try {
            while (rs != null && rs.next()) {
                Object[] row = {
                        rs.getString("studentID"),
                        rs.getString("name"),
                        rs.getDate("dob"),
                        rs.getString("address"),
                        rs.getString("contactNumber"),
                        rs.getInt("enrollmentYear")
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
                if (model.insertStudent(formData[0], formData[1], formData[2], formData[3], formData[4], Integer.parseInt(formData[5]))) {
                    JOptionPane.showMessageDialog(view.getRegistrationViewPanel(), "Student added successfully.");
                    loadTableData();
                } else {
                    JOptionPane.showMessageDialog(view.getRegistrationViewPanel(), "Failed to add student.");
                }
            }
        }
    }


    class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String studentID = view.getSelectedStudentID();

            // Ensure that a student is selected before attempting to delete
            if (studentID == null || studentID.trim().isEmpty()) {
                JOptionPane.showMessageDialog(view.getRegistrationViewPanel(), "Please select a student to delete.");
                return;
            }

            // Confirm the deletion
            int confirmDelete = JOptionPane.showConfirmDialog(view.getRegistrationViewPanel(),
                    "Are you sure you want to delete the selected student?", "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION);

            if (confirmDelete == JOptionPane.YES_OPTION) {
                // Attempt to delete the student and refresh the table
                if (model.deleteStudent(studentID)) {
                    JOptionPane.showMessageDialog(view.getRegistrationViewPanel(), "Student deleted successfully.");
                    loadTableData();  // Refresh the table after deletion
                } else {
                    JOptionPane.showMessageDialog(view.getRegistrationViewPanel(), "Failed to delete student.");
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
                String studentID = formData[0];  // Assuming student ID is entered in the first field

                // Ensure the student ID is provided for update
                if (studentID == null || studentID.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(view.getRegistrationViewPanel(), "Please enter a valid Student ID.");
                    return;
                }

                // Attempt to update the student data
                if (model.updateStudent(studentID, formData[1], formData[2], formData[3], formData[4], Integer.parseInt(formData[5]))) {
                    JOptionPane.showMessageDialog(view.getRegistrationViewPanel(), "Student updated successfully.");
                    loadTableData();  // Refresh the table after the update
                } else {
                    JOptionPane.showMessageDialog(view.getRegistrationViewPanel(), "Failed to update student.");
                }
            }
        }
    }

}
