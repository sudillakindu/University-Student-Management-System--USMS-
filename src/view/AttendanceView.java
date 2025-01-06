package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class AttendanceView {

    private JPanel attendanceViewPanel;
    private JTextField[] formFields;
    private JTable table;
    private JButton[] buttons;
    private JComboBox<String> statusComboBox;

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

        // White Panel for Form
        JPanel whitePanel = new JPanel();
        whitePanel.setLayout(null);
        whitePanel.setBackground(Color.WHITE);
        whitePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        whitePanel.setBounds(25, 115, 721, 325);
        attendanceViewPanel.add(whitePanel);

        // Form Labels and TextFields
        String[] labels = {"Attendance ID", "Student ID", "Course ID", "Date", "Status"};
        formFields = new JTextField[labels.length - 1]; // Exclude "Status" for JTextField
        int y = 20;
        for (int i = 0; i < labels.length - 1; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setFont(new Font("System", Font.BOLD, 23));
            label.setBounds(60, y, 200, 34);
            whitePanel.add(label);

            // Create a JTextField for other labels
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

        // Create a JComboBox for "Status"
        statusComboBox = new JComboBox<>(new String[]{"Present", "Absent"});
        statusComboBox.setBounds(330, y, 330, 34);
        statusComboBox.setBackground(new Color(255, 255, 255));
        statusComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        statusComboBox.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(141, 11, 65), 2),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)
        ));
        whitePanel.add(statusComboBox);

        // Set Today's Date
        String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        formFields[3].setText(todayDate);

        // Buttons
        String[] buttonLabels = {"Insert", "Delete"};
        int x = 281;
        buttons = new JButton[buttonLabels.length];  // Array to store buttons

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.setBounds(x, 272, 160, 34);
            button.setFont(new Font("System", Font.BOLD, 14));
            button.setBackground(new Color(211, 157, 85));
            button.setFocusPainted(false);
            whitePanel.add(button);

            buttons[i] = button;  // Store the button in the array
            x += 220;
        }

        // Table
        String[] columnNames = {"Attendance ID", "Student ID", "Course ID", "Date", "Status"};
        table = new JTable(new DefaultTableModel(columnNames, 0));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 458, 721, 265);
        attendanceViewPanel.add(scrollPane);
    }

    public String[] getFormData() {
        String[] data = new String[formFields.length + 1]; // Include the Status field
        for (int i = 0; i < formFields.length; i++) {
            data[i] = formFields[i].getText();
        }
        data[4] = (String) statusComboBox.getSelectedItem(); // Get selected Status
        return data;
    }

    public String getSelectedAttendanceID() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            return (String) table.getValueAt(selectedRow, 0);
        }
        return null;
    }

    public JPanel getAttendanceViewPanel() {
        return attendanceViewPanel;
    }

    public JTable getTable() {
        return table;
    }

    public void addInsertListener(ActionListener listener) {
        buttons[0].addActionListener(listener);
    }
    public void addDeleteListener(ActionListener listener) {
        buttons[1].addActionListener(listener);
    }

    // Method to validate the form
    public boolean validateForm() {
        String[] formData = getFormData();

        for (String data : formData) {
            if (data.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this.attendanceViewPanel, "All fields are required.");
                return false;
            }
        }

        if (!Pattern.matches("^A[0-9]{4}$", formData[0])) {
            JOptionPane.showMessageDialog(this.attendanceViewPanel,
                    "Attendance ID must start with 'A' followed by 4 digits (e.g., A0001).",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        if (!Pattern.matches("^S[0-9]{4}$", formData[1])) {
            JOptionPane.showMessageDialog(this.attendanceViewPanel,
                    "Student ID must start with 'S' followed by 4 digits (e.g., S0001).",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        if (!Pattern.matches("^C[0-9]{4}$", formData[2])) {
            JOptionPane.showMessageDialog(this.attendanceViewPanel,
                    "Course ID must start with 'C' followed by 4 digits (e.g., C0001).",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        // Inside the validation method
        if (!formData[3].equals(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))) {
            JOptionPane.showMessageDialog(this.attendanceViewPanel, "Date must be today's date.");
            return false;
        }

        return true;
    }
}
