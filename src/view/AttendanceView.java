package view;

import javax.swing.*;
import java.awt.*;

public class AttendanceView {

    private JPanel attendanceViewPanel;

    public AttendanceView() {

        // Initialize the panel where attendance elements will be added
        attendanceViewPanel = new JPanel();
        attendanceViewPanel.setLayout(null);
        attendanceViewPanel.setBounds(0, 0, 771, 748);
        attendanceViewPanel.setBackground(new Color(0xFFF8E6)); // Hex color

        // Attendance Label
        JLabel Label1 = new JLabel("Attendance");
        Label1.setFont(new Font("System", Font.BOLD, 30));
        Label1.setBounds(25, 15, 300, 40);
        attendanceViewPanel.add(Label1);

        // Welcome Label
        JLabel Label2 = new JLabel("Welcome to the USMS Attendance");
        Label2.setFont(new Font("System", Font.PLAIN, 15));
        Label2.setBounds(25, 60, 400, 20);
        attendanceViewPanel.add(Label2);
    }

    public JPanel getAttendanceViewPanel() {
        return attendanceViewPanel;
    }
}
