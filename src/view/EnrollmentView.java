package view;

import javax.swing.*;
import java.awt.*;

public class EnrollmentView {

    private JPanel enrollmentViewPanel;

    public EnrollmentView() {

        // Initialize the panel where enrollment elements will be added
        enrollmentViewPanel = new JPanel();
        enrollmentViewPanel.setLayout(null);
        enrollmentViewPanel.setBounds(0, 0, 771, 748);
        enrollmentViewPanel.setBackground(new Color(0xFFF8E6)); // Hex color

        // Enrollment Label
        JLabel Label1 = new JLabel("Enrollment");
        Label1.setFont(new Font("System", Font.BOLD, 30));
        Label1.setBounds(25, 15, 300, 40);
        enrollmentViewPanel.add(Label1);

        // Welcome Label
        JLabel Label2 = new JLabel("Welcome to the USMS Enrollment");
        Label2.setFont(new Font("System", Font.PLAIN, 15));
        Label2.setBounds(25, 60, 400, 20);
        enrollmentViewPanel.add(Label2);
    }

    public JPanel getEnrollmentViewPanel() {
        return enrollmentViewPanel;
    }
}
