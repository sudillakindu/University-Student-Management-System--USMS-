package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class EnrollmentView {

    private JPanel enrollmentViewPanel;
    private JTextField[] formFields;
    private JTable table;
    private JButton[] buttons;

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

        // White Panel for Form
        JPanel whitePanel = new JPanel();
        whitePanel.setLayout(null);
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        whitePanel.setBounds(25, 115, 721, 278);
        enrollmentViewPanel.add(whitePanel);

        // Form Labels and TextFields
        String[] labels = {"Enrollment ID", "Student ID", "Course ID", "Enrollment Date"};
        formFields = new JTextField[labels.length];
        int y = 20;
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setFont(new Font("System", Font.BOLD, 23));
            label.setBounds(60, y, 200, 34);
            whitePanel.add(label);

            formFields[i] = new JTextField();
            formFields[i].setBounds(330, y, 330, 34);
            formFields[i].setBackground(new Color(255, 255, 255));
            formFields[i].setFont(new Font("Arial", Font.PLAIN, 14));
            formFields[i].setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(141, 11, 65), 2),
                    BorderFactory.createEmptyBorder(5, 10, 5, 10)
            ));
            whitePanel.add(formFields[i]);

            y += 50;
        }

        // Buttons
        String[] buttonLabels = {"Insert", "Update", "Delete"};
        int x = 60;
        buttons = new JButton[buttonLabels.length];  // Array to store buttons

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.setBounds(x, 223, 160, 34);
            button.setFont(new Font("System", Font.BOLD, 14));
            button.setBackground(new Color(211, 157, 85));
            button.setFocusPainted(false);
            whitePanel.add(button);

            buttons[i] = button;  // Store the button in the array
            x += 220;
        }

        // Table
        String[] columnNames = {"Enrollment ID", "Student ID", "Course ID", "Enrollment Date"};
        table = new JTable(new DefaultTableModel(columnNames, 0));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 411, 721, 312);
        enrollmentViewPanel.add(scrollPane);
    }

    public String[] getFormData() {
        String[] data = new String[formFields.length];
        for (int i = 0; i < formFields.length; i++) {
            data[i] = formFields[i].getText();
        }
        return data;
    }

    public String getSelectedEnrollmentID() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            return (String) table.getValueAt(selectedRow, 0);
        }
        return null;
    }

    public JPanel getEnrollmentViewPanel() {
        return enrollmentViewPanel;
    }
    public JTable getTable() {
        return table;
    }

    public void addInsertListener(ActionListener listener) {
        buttons[0].addActionListener(listener);
    }
    public void addUpdateListener(ActionListener listener) {
        buttons[1].addActionListener(listener);
    }
    public void addDeleteListener(ActionListener listener) {
        buttons[2].addActionListener(listener);
    }

    // Method to validate the form
    public boolean validateForm() {
        String[] formData = getFormData();

        for (String data : formData) {
            if (data.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this.enrollmentViewPanel, "All fields are required.");
                return false;
            }
        }

        if (!Pattern.matches("^E[0-9]{4}$", formData[0])) {
            JOptionPane.showMessageDialog(this.enrollmentViewPanel,
                    "Enrollment ID must start with 'E' followed by 4 digits (e.g., E0001).",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        if (!Pattern.matches("^S[0-9]{4}$", formData[1])) {
            JOptionPane.showMessageDialog(this.enrollmentViewPanel,
                    "Student ID must start with 'S' followed by 4 digits (e.g., S0001).",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        if (!Pattern.matches("^C[0-9]{4}$", formData[2])) {
            JOptionPane.showMessageDialog(this.enrollmentViewPanel,
                    "Course ID must start with 'C' followed by 4 digits (e.g., C0001).",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        if (!Pattern.matches("\\d{4}-\\d{2}-\\d{2}", formData[3])) {
            JOptionPane.showMessageDialog(this.enrollmentViewPanel, "Please enter a valid Enrollment Date (yyyy-mm-dd).");
            return false;
        }

        return true;
    }


}
