package view;

import javax.swing.*;
import java.awt.*;

public class RegistrationView {

    private JPanel registrationViewPanel;

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
    }

    public JPanel getRegistrationViewPanel() {
        return registrationViewPanel;
    }

}

