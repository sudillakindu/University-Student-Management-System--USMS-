package controller;

import model.LoginAndSignUpModel;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {

    private MainView mainView;

    public MainController(MainView mainView) {
        this.mainView = mainView;

        this.mainView.addDashboardButtonListener(new MainController.DashboardButtonListener());
        this.mainView.addRegistrationButtonListener(new MainController.RegistrationButtonListener());
        this.mainView.addCourseButtonListener(new MainController.CourseButtonListener());
        this.mainView.addEnrollmentButtonListener(new MainController.EnrollmentButtonListener());
        this.mainView.addAttendanceButtonListener(new MainController.AttendanceButtonListener());
        this.mainView.addGradeButtonListener(new MainController.GradeButtonListener());
        this.mainView.addReportButtonListener(new MainController.ReportButtonListener());
        this.mainView.addLogOutButtonListener(new MainController.LogOutButtonListener());
    }

    private void showErrorMessage(Component messageLocation, String message) {
        JOptionPane.showMessageDialog(messageLocation, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showInfoMessage(Component messageLocation, String message) {
        JOptionPane.showMessageDialog(messageLocation, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    class DashboardButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            DashboardView dashboardView = new DashboardView();
            DashboardController dashboardController = new DashboardController(dashboardView);
            addItemToMainViewPane(dashboardView.getDashboardViewPanel());

            //showInfoMessage(mainView.getMainViewPane(), "Dashboard\nThis section is not currently functioning.");
        }
    }
    class RegistrationButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            RegistrationView registrationView = new RegistrationView();
            addItemToMainViewPane(registrationView.getRegistrationViewPanel());

            //showInfoMessage(mainView.getMainViewPane(), "Registration\nThis section is not currently functioning.");
        }
    }
    class CourseButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CourseView courseView = new CourseView();
            addItemToMainViewPane(courseView.getCourseViewPanel());

            showInfoMessage(mainView.getMainViewPane(), "Course\nThis section is not currently functioning.");
        }
    }
    class EnrollmentButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EnrollmentView enrollmentView = new EnrollmentView();
            addItemToMainViewPane(enrollmentView.getEnrollmentViewPanel());

            //showInfoMessage(mainView.getMainViewPane(), "Enrollment\nThis section is not currently functioning.");
        }
    }
    class AttendanceButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AttendanceView attendanceView = new AttendanceView();
            addItemToMainViewPane(attendanceView.getAttendanceViewPanel());

            //showInfoMessage(mainView.getMainViewPane(), "Attendance\nThis section is not currently functioning.");
        }
    }
    class GradeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GradeView gradeView = new GradeView();
            addItemToMainViewPane(gradeView.getGradeViewPanel());

            showInfoMessage(mainView.getMainViewPane(), "Grade\nThis section is not currently functioning.");
        }
    }
    class ReportButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            RegistrationView registrationView = new RegistrationView();
            addItemToMainViewPane(registrationView.getRegistrationViewPanel());

            //showInfoMessage(mainView.getMainViewPane(), "Report\nThis section is not currently functioning.");
        }
    }
    class LogOutButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int confirm = JOptionPane.showConfirmDialog(
                    mainView.getMainViewPane(),
                    "Are you sure you want to log out?",
                    "Log Out Confirmation",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                showLoginAndSignUpViewFrame();
            }
        }
    }

    private void showLoginAndSignUpViewFrame() {
        LoginAndSignUpView loginAndSignUpView = new LoginAndSignUpView();
        LoginAndSignUpModel loginAndSignUpModel = new LoginAndSignUpModel();
        LoginAndSignUpController loginAndSignUpController = new LoginAndSignUpController(loginAndSignUpView, loginAndSignUpModel);
        mainView.getMainViewFrame().dispose();
    }

    private void addItemToMainViewPane(Component component) {
        mainView.getMainViewPane().removeAll();
        mainView.getMainViewPane().add(component);
        mainView.getMainViewPane().setLayout(null);
        mainView.getMainViewPane().revalidate();
        mainView.getMainViewPane().repaint();
//        mainView.getMainViewFrame().revalidate();
//        mainView.getMainViewFrame().repaint();
    }

}
