package controller;

import model.DashboardModel;
import view.DashboardView;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;

public class DashboardController {

    private DashboardView view;
    private DashboardModel model;

    public DashboardController(DashboardView view) {
        this.view = view;
        this.model = new DashboardModel();

        update_TotalStudents_TotalCourses_TotalEnrollments();
        updateChart();
    }

    // Method to update the chart with enrollment data
    public void updateChart() {
        List<DashboardModel.EnrollmentDate> enrollmentDates = model.getEnrollmentDate();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Add data to the dataset
        for (DashboardModel.EnrollmentDate enrollmentDate : enrollmentDates) {
            dataset.addValue(enrollmentDate.getCount(), "Enrollment", String.valueOf(enrollmentDate.getYear()));
        }

        // Create a new chart with the updated dataset
        JFreeChart chart = view.createLineChart(dataset);
        view.updateChart(chart);
    }

    public void update_TotalStudents_TotalCourses_TotalEnrollments() {
        view.bluePanelLabel2().setText(String.valueOf(model.getStudentCount()));
        view.rosePanelLabel2().setText(String.valueOf(model.getCourseCount()));
        view.greenPanelLabel2().setText(String.valueOf(model.getEnrollmentCount()));
    }

}
