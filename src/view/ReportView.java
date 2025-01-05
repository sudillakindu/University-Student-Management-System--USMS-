package view;

import javax.swing.*;
import java.awt.*;

public class ReportView {

    private JPanel reportViewPanel;

    public ReportView() {

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
    }

    public JPanel getReportViewPanel() {
        return reportViewPanel;
    }
}
