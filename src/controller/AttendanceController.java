package controller;

import model.AttendanceModel;
import view.AttendanceView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AttendanceController {
    private AttendanceView attendanceView;
    private AttendanceModel attendanceModel;

    public AttendanceController(AttendanceView attendanceView, AttendanceModel attendanceModel) {
        this.attendanceView = attendanceView;
        this.attendanceModel = attendanceModel;

        // Add listener for the Insert button
        attendanceView.addInsertListener(new InsertListener());
        attendanceView.addDeleteListener(new DeleteListener());

        // Load data into the table
        loadAttendanceData();
    }

    private void loadAttendanceData() {
        List<String[]> attendanceData = attendanceModel.getAllAttendance();
        DefaultTableModel tableModel = (DefaultTableModel) attendanceView.getTable().getModel();
        tableModel.setRowCount(0); // Clear the table
        for (String[] row : attendanceData) {
            tableModel.addRow(row);
        }
    }

    private class InsertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (attendanceView.validateForm()) {
                String[] formData = attendanceView.getFormData();

                boolean isInserted = attendanceModel.insertAttendance(
                        formData[0], // Attendance ID
                        formData[1], // Student ID
                        formData[2], // Course ID
                        formData[3], // Date
                        formData[4]  // Status
                );

                if (isInserted) {
                    JOptionPane.showMessageDialog(attendanceView.getAttendanceViewPanel(),
                            "Attendance record inserted successfully!");
                    loadAttendanceData(); // Refresh the table
                } else {
                    JOptionPane.showMessageDialog(attendanceView.getAttendanceViewPanel(),
                            "Failed to insert attendance record. Please try again.",
                            "Insert Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String enrollmentID = attendanceView.getSelectedAttendanceID();

            // Ensure that an enrollment is selected before attempting to delete
            if (enrollmentID == null || enrollmentID.trim().isEmpty()) {
                JOptionPane.showMessageDialog(attendanceView.getAttendanceViewPanel(), "Please select an enrollment to delete.");
                return;
            }

            // Confirm the deletion
            int confirmDelete = JOptionPane.showConfirmDialog(attendanceView.getAttendanceViewPanel(),
                    "Are you sure you want to delete the selected enrollment?", "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION);

            if (confirmDelete == JOptionPane.YES_OPTION) {
                // Attempt to delete the enrollment and refresh the table
                if (attendanceModel.deleteAttendance(enrollmentID)) {
                    JOptionPane.showMessageDialog(attendanceView.getAttendanceViewPanel(), "Enrollment deleted successfully.");
                    loadAttendanceData();  // Refresh the table after deletion
                } else {
                    JOptionPane.showMessageDialog(attendanceView.getAttendanceViewPanel(), "Failed to delete enrollment.");
                }
            }
        }
    }
}
