package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class RegistrationView {

    private JPanel registrationViewPanel;
    private JTextField[] formFields;
    private JTable table;
    private JButton[] buttons;

    public RegistrationView() {

        // Initialize the panel where registration elements will be added
        registrationViewPanel = new JPanel();
        registrationViewPanel.setLayout(null);
        registrationViewPanel.setBounds(0, 0, 771, 748);
        registrationViewPanel.setBackground(new Color(0xFFF8E6)); // Hex color

        // Registration Label
        JLabel Label1 = new JLabel("Registration");
        Label1.setFont(new Font("System", Font.BOLD, 30));
        Label1.setBounds(25, 15, 300, 40);
        registrationViewPanel.add(Label1);

        // Welcome Label
        JLabel Label2 = new JLabel("Welcome to the USMS Registration");
        Label2.setFont(new Font("System", Font.PLAIN, 15));
        Label2.setBounds(25, 60, 400, 20);
        registrationViewPanel.add(Label2);

        // White Panel for Form
        JPanel whitePanel = new JPanel();
        whitePanel.setLayout(null);
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        whitePanel.setBounds(25, 115, 721, 370);
        registrationViewPanel.add(whitePanel);

        // Form Labels and TextFields
        String[] labels = {"Student ID", "Student Name", "Date Of Birth", "Address", "Contact Number", "Enrollment Year"};
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
            button.setBounds(x, 320, 160, 34);
            button.setFont(new Font("System", Font.BOLD, 14));
            button.setBackground(new Color(211, 157, 85));
            button.setFocusPainted(false);
            whitePanel.add(button);

            buttons[i] = button;  // Store the button in the array
            x += 220;
        }

        // Table
        String[] columnNames = {"Student ID", "Student Name", "Date Of Birth", "Address", "Contact Number", "Enrollment Year"};
        table = new JTable(new DefaultTableModel(columnNames, 0));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 498, 721, 225);
        registrationViewPanel.add(scrollPane);
    }

    public String[] getFormData() {
        String[] data = new String[formFields.length];
        for (int i = 0; i < formFields.length; i++) {
            data[i] = formFields[i].getText();
        }
        return data;
    }

    public String getSelectedStudentID() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            return (String) table.getValueAt(selectedRow, 0);
        }
        return null;
    }

    public JPanel getRegistrationViewPanel() {
        return registrationViewPanel;
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
                JOptionPane.showMessageDialog(this.registrationViewPanel, "All fields are required.");
                return false;
            }
        }

        if (!Pattern.matches("^E[0-9]{4}$", formData[0])) {
            JOptionPane.showMessageDialog(this.registrationViewPanel,
                    "Student ID must start with 'S' followed by 4 digits (e.g., S0001).",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        if (!Pattern.matches("\\d{4}-\\d{2}-\\d{2}", formData[2])) {
            JOptionPane.showMessageDialog(this.registrationViewPanel, "Please enter a valid Date of Birth (yyyy-mm-dd).");
            return false;
        }

        if (!Pattern.matches("\\d{10}", formData[4])) {
            JOptionPane.showMessageDialog(this.registrationViewPanel, "Please enter a valid 10-digit contact number.");
            return false;
        }

        try {
            int enrollmentYear = Integer.parseInt(formData[5]);
            if (enrollmentYear < 1900 || enrollmentYear > 2100) {
                JOptionPane.showMessageDialog(this.registrationViewPanel, "Please enter a valid Enrollment Year.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this.registrationViewPanel, "Please enter a valid number for Enrollment Year.");
            return false;
        }

        return true;
    }

}
