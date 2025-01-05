package view;

import controller.DashboardController;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static org.jfree.chart.ChartFactory.createLineChart;

public class DashboardView {

    private JPanel dashboardViewPanel;

    private JLabel bluePanelLabel2;
    private JLabel rosePanelLabel2;
    private JLabel greenPanelLabel2;

    private ChartPanel chartPanel;

    public DashboardView() {

        // Initialize the panel where dashboard elements will be added
        dashboardViewPanel = new JPanel();
        dashboardViewPanel.setLayout(null);
        dashboardViewPanel.setBounds(0, 0, 771, 748);
        dashboardViewPanel.setBackground(new Color(0xFFF8E6)); // Hex color

        // Dashboard Label
        JLabel dashboardLabel1 = new JLabel("Dashboard");
        dashboardLabel1.setFont(new Font("System", Font.BOLD, 30));
        dashboardLabel1.setBounds(25, 15, 300, 40);
        dashboardViewPanel.add(dashboardLabel1);

        // Welcome Label
        JLabel dashboardLabel2 = new JLabel("Welcome to the USMS Dashboard");
        dashboardLabel2.setFont(new Font("System", Font.PLAIN, 15));
        dashboardLabel2.setBounds(25, 60, 400, 20);
        dashboardViewPanel.add(dashboardLabel2);

        // Panel 1: Total Students
        JPanel bluePanel = new JPanel();
        bluePanel.setLayout(null);
        bluePanel.setBounds(25, 115, 224, 133);
        bluePanel.setBackground(new Color(0x308AEC));
        bluePanel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(0, 0, 0), 4, true),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));

        JLabel bluePanelLabel1 = new JLabel("Total Students");
        bluePanelLabel1.setFont(new Font("System", Font.BOLD, 25));
        bluePanelLabel1.setBounds(10, 10, 200, 30);
        bluePanel.add(bluePanelLabel1);

        bluePanelLabel2 = new JLabel("Loading..");
        bluePanelLabel2.setFont(new Font("System", Font.BOLD, 50));
        bluePanelLabel2.setBounds(69, 48, 200, 60);
        bluePanel.add(bluePanelLabel2);

        dashboardViewPanel.add(bluePanel);

        // Panel 2: Total Course
        JPanel rosePanel = new JPanel();
        rosePanel.setLayout(null);
        rosePanel.setBounds(274, 115, 223, 133);
        rosePanel.setBackground(new Color(0x53AA57));
        rosePanel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(0, 0, 0), 4, true),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));

        JLabel rosePanelLabel1 = new JLabel("Total Course");
        rosePanelLabel1.setFont(new Font("System", Font.BOLD, 25));
        rosePanelLabel1.setBounds(10, 10, 200, 30);
        rosePanel.add(rosePanelLabel1);

        rosePanelLabel2 = new JLabel("Loading..");
        rosePanelLabel2.setFont(new Font("System", Font.BOLD, 50));
        rosePanelLabel2.setBounds(69, 48, 200, 60);
        rosePanel.add(rosePanelLabel2);

        dashboardViewPanel.add(rosePanel);

        // Panel 3: Total Enrollment
        JPanel greenPanel = new JPanel();
        greenPanel.setLayout(null);
        greenPanel.setBounds(522, 115, 224, 133);
        greenPanel.setBackground(new Color(0xDD2467));
        greenPanel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(0, 0, 0), 4, true),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));

        JLabel greenPanelLabel1 = new JLabel("Total Enrollment");
        greenPanelLabel1.setFont(new Font("System", Font.BOLD, 25));
        greenPanelLabel1.setBounds(10, 10, 200, 30);
        greenPanel.add(greenPanelLabel1);

        greenPanelLabel2 = new JLabel("Loading..");
        greenPanelLabel2.setFont(new Font("System", Font.BOLD, 50));
        greenPanelLabel2.setBounds(69, 48, 200, 60);
        greenPanel.add(greenPanelLabel2);

        dashboardViewPanel.add(greenPanel);

        // Create and add the LineChart (Using JFreeChart)
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JFreeChart chart = createLineChart(dataset);
        chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(25, 273, 721, 450);
        dashboardViewPanel.add(chartPanel);

    }

    // Create the LineChart with dynamic data
    public JFreeChart createLineChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createLineChart(
                "Student Enrolment Dates",
                "Year",
                "Number of Students",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        chart.setBackgroundPaint(new Color(255, 248, 230));
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(255, 248, 230));
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setDomainGridlinePaint(Color.BLACK);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLabelFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        domainAxis.setTickLabelFont(new Font("Comic Sans MS", Font.PLAIN, 12));

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        rangeAxis.setTickLabelFont(new Font("Comic Sans MS", Font.PLAIN, 12));

        return chart;
    }

    // Method to update the chart with new data
    public void updateChart(JFreeChart chart) {
        chartPanel.setChart(chart);
    }

    public JPanel getDashboardViewPanel() {
        return dashboardViewPanel;
    }

    public JLabel bluePanelLabel2() {
        return bluePanelLabel2;
    }
    public JLabel rosePanelLabel2() {
        return rosePanelLabel2;
    }
    public JLabel greenPanelLabel2() {
        return greenPanelLabel2;
    }
}
