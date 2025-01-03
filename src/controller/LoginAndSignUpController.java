package controller;

import model.LoginAndSignUpModel;
import view.LoginAndSignUpFormView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAndSignUpController {

    private LoginAndSignUpFormView view;
    private LoginAndSignUpModel model;

    public LoginAndSignUpController(LoginAndSignUpFormView view, LoginAndSignUpModel model) {
        this.view = view;
        this.model = model;

        this.view.addForgotPasswordButtonListener(new ForgotPasswordButtonListener());
        this.view.addLoginButtonListener(new LoginButtonListener());
        this.view.addSignUpButtonListener(new SignUpButtonListener());
    }

    class ForgotPasswordButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = view.getLoginUsername();

            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(view.getLoginPane(),
                        "Please fill in username field",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(view.getLoginPane(),
                        "Hi, " + username + "!" + "\n" + "This section is not currently functioning.",
                        "Reset Password",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

        }
    }

    class LoginButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = view.getLoginUsername();
            String password = view.getLoginPassword();

//            System.err.println(username);
//            System.err.println(password);

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(view.getLoginPane(),
                        "Please fill in all fields",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String result = model.validateLogin(username, password);
            if (result != null) {
                JOptionPane.showMessageDialog(view.getLoginPane(),
                        result,
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);



                // Add your post-login logic here





            } else {
                JOptionPane.showMessageDialog(view.getLoginPane(),
                        "Invalid username or password",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class SignUpButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String role = view.getSignUpSelectRoleComboBox();
            String username = view.getSignUpUsername();
            String email = view.getSignUpEmail();
            String password = view.getSignUpPassword();

//            System.err.println(role);
//            System.err.println(username);
//            System.err.println(email);
//            System.err.println(password);

            if (role.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(view.getSignUpPane(),
                        "Please fill in all fields",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String result = model.validateSignUp(role, username, email, password);
            if (result != null) {
                JOptionPane.showMessageDialog(view.getSignUpPane(),
                        result,
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(view.getSignUpPane(),
                        "Invalid username or password",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
