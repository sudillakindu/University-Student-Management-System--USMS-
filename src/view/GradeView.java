package view;

import javax.swing.*;
import java.awt.*;

public class GradeView {

    private JPanel gradeViewPanel;

    public GradeView() {

        // Initialize the panel where grade elements will be added
        gradeViewPanel = new JPanel();
        gradeViewPanel.setLayout(null);
        gradeViewPanel.setBounds(0, 0, 771, 748);
        gradeViewPanel.setBackground(new Color(0xFFF8E6)); // Hex color

        // Grade Label
        JLabel Label1 = new JLabel("Grade");
        Label1.setFont(new Font("System", Font.BOLD, 30));
        Label1.setBounds(25, 15, 300, 40);
        gradeViewPanel.add(Label1);

        // Welcome Label
        JLabel Label2 = new JLabel("Welcome to the USMS Grade");
        Label2.setFont(new Font("System", Font.PLAIN, 15));
        Label2.setBounds(25, 60, 400, 20);
        gradeViewPanel.add(Label2);
    }

    public JPanel getGradeViewPanel() {
        return gradeViewPanel;
    }
}
