package view;

import controller.ReportController;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class ReportView extends JFrame {
    private JPanel contentPane;
    private ReportController reportController;
    private JPanel reportViewPanel;

    public ReportView() {
        this.reportController = new ReportController();

        // Initialize the panel where report elements will be added
        reportViewPanel = new JPanel();
        reportViewPanel.setLayout(null);
        reportViewPanel.setBounds(0, 0, 771, 748);
        reportViewPanel.setBackground(new Color(0xFFF8E6)); // Hex color

        // Report Label
        JLabel Label1 = new JLabel("Report");
        Label1.setFont(new Font("System", Font.BOLD, 30));
        Label1.setBounds(25, 15, 300, 40);
        reportViewPanel.add(Label1);

        // Welcome Label
        JLabel Label2 = new JLabel("Welcome to the USMS Report");
        Label2.setFont(new Font("System", Font.PLAIN, 15));
        Label2.setBounds(25, 60, 400, 20);
        reportViewPanel.add(Label2);

        // White Panel1 for Form
        JPanel whitePanel1 = new JPanel();
        whitePanel1.setLayout(null);
        whitePanel1.setBackground(Color.WHITE);
        whitePanel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        whitePanel1.setBounds(25, 115, 721, 291);
        reportViewPanel.add(whitePanel1);

        // White Panel1 Label
        JLabel Label3 = new JLabel("Show Attendance Report");
        Label3.setFont(new Font("System", Font.BOLD, 44));
        Label3.setBounds(97, 71, 529, 66);
        whitePanel1.add(Label3);

        // Report Button
        JButton reportButton1 = new JButton("Generate Report");
        reportButton1.setBounds(261, 171, 200, 44);
        reportButton1.setFont(new Font("System", Font.BOLD, 16));
        reportButton1.setBackground(new Color(211, 157, 85));
        reportButton1.setFocusPainted(false);
        whitePanel1.add(reportButton1);

        reportButton1.addActionListener(e -> showReport());

        // White Panel2 for Form
        JPanel whitePanel2 = new JPanel();
        whitePanel2.setLayout(null);
        whitePanel2.setBackground(Color.WHITE);
        whitePanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        whitePanel2.setBounds(25, 431, 721, 292);
        reportViewPanel.add(whitePanel2);

        // White Panel2 Label
        JLabel Label4 = new JLabel("Attendance Specified Student Report");
        Label4.setFont(new Font("System", Font.BOLD, 35));
        Label4.setBounds(55, 50, 612, 51);
        whitePanel2.add(Label4);

        // White Panel2 Label
        JLabel Label5 = new JLabel("Student ID");
        Label5.setFont(new Font("System", Font.BOLD, 23));
        Label5.setBounds(60, 132, 116, 34);
        whitePanel2.add(Label5);

        // White Panel2 TextField
        JTextField studentIdTextField = new JTextField();
        studentIdTextField.setBounds(332, 132, 329, 34);
        studentIdTextField.setBackground(new Color(255, 255, 255));
        studentIdTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        studentIdTextField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(141, 11, 65), 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        whitePanel2.add(studentIdTextField);

        // Report Button
        JButton reportButton2 = new JButton("Generate Report");
        reportButton2.setBounds(261, 193, 200, 44);
        reportButton2.setFont(new Font("System", Font.BOLD, 16));
        reportButton2.setBackground(new Color(211, 157, 85));
        reportButton2.setFocusPainted(false);
        whitePanel2.add(reportButton2);

        reportButton2.addActionListener(e -> showSpecifyReport(studentIdTextField.getText()));

    }

    private void showReport() {
        try {
            // Adjust the file path as needed
            String sourceFile = "resources/reports/AttendanceSummaryReport.jrxml";
            String compiledFile = "resources/reports/AttendanceSummaryReport.jasper";

            // Ensure the source file exists
            File file = new File(sourceFile);
            if (!file.exists()) {
                throw new FileNotFoundException("File not found: " + file.getAbsolutePath());
            }

            // Compile the JRXML file to Jasper
            JasperCompileManager.compileReportToFile(sourceFile, compiledFile);

            // Load and display the report
            JRDataSource jrDataSource = new JRMapCollectionDataSource(reportController.getAttendanceSummaryReport());
            JasperPrint jasperPrint = JasperFillManager.fillReport(compiledFile, null, jrDataSource);

            // View the report
            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showSpecifyReport(String studentId) {
        try {
            // Adjust the file path as needed
            String sourceFile = "resources/reports/AttendanceSpecifySummaryReport.jrxml";
            String compiledFile = "resources/reports/AttendanceSpecifySummaryReport.jasper";

            // Ensure the source file exists
            File file = new File(sourceFile);
            if (!file.exists()) {
                throw new FileNotFoundException("File not found: " + file.getAbsolutePath());
            }

            // Compile the JRXML file to Jasper
            JasperCompileManager.compileReportToFile(sourceFile, compiledFile);

            // Load and display the report
            JRDataSource jrDataSource = new JRMapCollectionDataSource(reportController.getAttendanceSpecifySummaryReport(studentId));
            JasperPrint jasperPrint = JasperFillManager.fillReport(compiledFile, null, jrDataSource);

            // View the report
            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JPanel getReportViewPanel() {
        return reportViewPanel;
    }

}
