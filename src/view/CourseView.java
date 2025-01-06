package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CourseView {

    private JPanel courseViewPanel;
    private JTable table;

    public CourseView() {

        // Initialize the panel where course elements will be added
        courseViewPanel = new JPanel();
        courseViewPanel.setLayout(null);
        courseViewPanel.setBounds(0, 0, 771, 748);
        courseViewPanel.setBackground(new Color(0xFFF8E6)); // Hex color

        // Course Label
        JLabel Label1 = new JLabel("Course");
        Label1.setFont(new Font("System", Font.BOLD, 30));
        Label1.setBounds(25, 15, 300, 40);
        courseViewPanel.add(Label1);

        // Welcome Label
        JLabel Label2 = new JLabel("Welcome to the USMS Course");
        Label2.setFont(new Font("System", Font.PLAIN, 15));
        Label2.setBounds(25, 60, 400, 20);
        courseViewPanel.add(Label2);

        // Table
        String[] columnNames = {"Course ID", "Course Name", "Credits", "Duration", "Faculty"};
        table = new JTable(new DefaultTableModel(columnNames, 0));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 115, 721, 608);
        courseViewPanel.add(scrollPane);
    }

    public JPanel getCourseViewPanel() {
        return courseViewPanel;
    }
    public JTable getTable() {
        return table;
    }
}
