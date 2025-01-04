package controller;

import view.LoginAndSignUpView;
import model.LoginAndSignUpModel;
import view.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAndSignUpController {

    private LoginAndSignUpView loginAndSignUpView;
    private LoginAndSignUpModel loginAndSignUpModel;

    public LoginAndSignUpController(LoginAndSignUpView loginAndSignUpView, LoginAndSignUpModel loginAndSignUpModel) {
        this.loginAndSignUpView = loginAndSignUpView;
        this.loginAndSignUpModel = loginAndSignUpModel;

        this.loginAndSignUpView.addForgotPasswordButtonListener(new ForgotPasswordButtonListener());
        this.loginAndSignUpView.addLoginButtonListener(new LoginButtonListener());
        this.loginAndSignUpView.addSignUpButtonListener(new SignUpButtonListener());
    }

    private void showErrorMessage(Component messageLocation, String message) {
        JOptionPane.showMessageDialog(messageLocation, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showInfoMessage(Component messageLocation, String message) {
        JOptionPane.showMessageDialog(messageLocation, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    class ForgotPasswordButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = loginAndSignUpView.getLoginUsername();

            if (username.isEmpty()) {
                showErrorMessage(loginAndSignUpView.getLoginPane(), "Please fill in the username field.");
                return;
            } else {
                showInfoMessage(loginAndSignUpView.getLoginPane(), "Hi, " + username + "!" + "\nThis section is not currently functioning.");
                return;
            }
        }
    }

    class LoginButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = loginAndSignUpView.getLoginUsername();
            String password = loginAndSignUpView.getLoginPassword();

            if (username.isEmpty() || password.isEmpty()) {
                showErrorMessage(loginAndSignUpView.getLoginPane(), "Please fill in all fields.");
                return;
            }

            String result = loginAndSignUpModel.validateLogin(username, password);
            switch (result) {
                case "return1":
                    showInfoMessage(loginAndSignUpView.getLoginPane(), "Regular User Login Successful!" + "\nHi, " + username + "!");
                    showMainViewFrame(username);
                    break;
                case "return2":
                    showInfoMessage(loginAndSignUpView.getLoginPane(), "Admin Login Successful!" + "\nHi, " + username + "!");
                    showMainViewFrame(username);
                    break;
                case "return3":
                    showErrorMessage(loginAndSignUpView.getLoginPane(), "Invalid username or password!");
                    break;
                default:
                    showErrorMessage(loginAndSignUpView.getLoginPane(), "Unexpected error occurred.");
                    break;
            }

            //System.err.println(result);
        }
    }

    private void showMainViewFrame(String username) {
        MainView mainView = new MainView(username);
        MainController mainController = new MainController(mainView);
        loginAndSignUpView.getLoginAndSignUpViewFrame().dispose();
    }

    class SignUpButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String role = loginAndSignUpView.getSignUpSelectRoleComboBox();
            String username = loginAndSignUpView.getSignUpUsername();
            String email = loginAndSignUpView.getSignUpEmail();
            String password = loginAndSignUpView.getSignUpPassword();

            if (role.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                showErrorMessage(loginAndSignUpView.getSignUpPane(), "Please fill in all fields.");
                return;
            }

            // Ask for the root password via a popup
            String rootpassword = JOptionPane.showInputDialog(
                    loginAndSignUpView.getSignUpPane(),
                    "Enter root password:",
                    "Root Password",
                    JOptionPane.PLAIN_MESSAGE
            );

            // Check if the root password is correct
            if (rootpassword != null && rootpassword.equals("abc")) {
                String result = loginAndSignUpModel.validateSignUp(role, username, email, password);
                switch (result) {
                    case "return4":
                        showInfoMessage(loginAndSignUpView.getSignUpPane(), "User already exists!");
                        break;
                    case "return5":
                        showInfoMessage(loginAndSignUpView.getSignUpPane(), role.toUpperCase() + " successfully registered!");
                        break;
                    case "return6":
                        showErrorMessage(loginAndSignUpView.getSignUpPane(), "Registration failed! Please try again.");
                        break;
                    default:
                        showErrorMessage(loginAndSignUpView.getSignUpPane(), result);
                        break;
                }
            } else if (rootpassword != null) {
                showErrorMessage(loginAndSignUpView.getSignUpPane(), "Invalid root password.");
            } else {
                // If the user cancels the password input
                showErrorMessage(loginAndSignUpView.getSignUpPane(), "Root password input was cancelled.");
            }
        }
    }
}
