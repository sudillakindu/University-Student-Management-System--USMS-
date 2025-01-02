package view;

import javax.swing.*;
import java.awt.*;

public class LoginFormView extends JPanel {

    private JPanel sidePane;
    private JPanel loginPane;
    private JPanel signUpPane;
    private JPanel groupPane;

    private ImageIcon sidePaneImageIcon, smoothSidePaneImageIcon;
    private ImageIcon loginPaneImageIcon, smoothLoginPaneImageIcon;
    private ImageIcon signUpPaneImageIcon, smoothSignUpPaneImageIcon;

    private Image imgSidePane;
    private Image imgLoginPane;
    private Image imgSignUpPane;

    private JLabel sidePaneImage;
    private JLabel loginPaneImageLabel;
    private JLabel signUpPaneImageLabel;

    private JTextField usernameTextField;
    private JTextField emailTextField;
    private JTextField passwordTextField;
    private JPasswordField passwordPasswordField;

    private JButton loginButton;
    private JButton signUpButton;
    private JButton createAnAccountButton;
    private JButton forgotPasswordButton;
    private JButton showPasswordButton;
    private JButton newLoginButton;

    private JLabel mainNoteLabel;
    private JLabel welcomeLabel;
    private JLabel usernameLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel welcomeNoteLabel;
    private JLabel endNoteLabel;

    public LoginFormView() {

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        setLayout(null);
        setPreferredSize(new Dimension(1024, 768));
        setBackground(Color.WHITE);
        // Match the JavaFX rounded corners
        //setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Side Pane (Left)
        sidePane = new JPanel();
        sidePane.setLayout(null);
        sidePane.setBackground(new Color(141, 11, 65)); // #8D0B41
        sidePane.setBounds(0, 0, 550, 768);
        add(sidePane);

        // Main Note Label
        mainNoteLabel = new JLabel("<html><center>University Student<br>Management System</center></html>");
        mainNoteLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 38));
        mainNoteLabel.setForeground(new Color(211, 157, 85));
        mainNoteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainNoteLabel.setBounds(29, 74, 493, 142);
        sidePane.add(mainNoteLabel);

        // Side Pane Image
        sidePaneImageIcon = new ImageIcon("resources/images/happy-university.png");
        imgSidePane = sidePaneImageIcon.getImage().getScaledInstance(622, 616, Image.SCALE_SMOOTH);
        smoothSidePaneImageIcon = new ImageIcon(imgSidePane);
        sidePaneImage = new JLabel(smoothSidePaneImageIcon);
        sidePaneImage.setBounds(-21, 213, 622, 616);
        sidePane.add(sidePaneImage);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Login Pane (Right)
        loginPane = new JPanel();
        loginPane.setLayout(null);
        loginPane.setBackground(Color.WHITE);
        loginPane.setBounds(550, 0, 474, 768);
        add(loginPane);

        // Login Pane Image
        loginPaneImageIcon = new ImageIcon("resources/images/login-access-vector.png");
        imgLoginPane = loginPaneImageIcon.getImage().getScaledInstance(257, 171, Image.SCALE_SMOOTH);
        smoothLoginPaneImageIcon = new ImageIcon(imgLoginPane);
        loginPaneImageLabel = new JLabel(smoothLoginPaneImageIcon);
        loginPaneImageLabel.setBounds(109, 93, 257, 171);
        loginPane.add(loginPaneImageLabel);

        // Welcome Back Label
        welcomeLabel = new JLabel("Welcome back");
        welcomeLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
        welcomeLabel.setBounds(113, 279, 250, 42);
        //welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginPane.add(welcomeLabel);

        // Welcome to Note Label
        welcomeNoteLabel = new JLabel("Please enter your details");
        welcomeNoteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        welcomeNoteLabel.setBounds(113, 325, 249, 25);
        //welcomeNoteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginPane.add(welcomeNoteLabel);

        // Username Label
        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        usernameLabel.setBounds(113, 370, 249, 25);
        loginPane.add(usernameLabel);

        // Username TextField with custom styling
        usernameTextField = new JTextField();
        usernameTextField.setBounds(113, 399, 249, 30);
        usernameTextField.setBackground(new Color(255, 255, 255));
        usernameTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameTextField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(141, 11, 65), 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        loginPane.add(usernameTextField);

        // Password Label
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        passwordLabel.setBounds(113, 445, 249, 25);
        loginPane.add(passwordLabel);

        // Password TextField with custom styling
        passwordPasswordField = new JPasswordField();
        passwordPasswordField.setBounds(113, 474, 249, 30);
        passwordPasswordField.setBackground(new Color(255, 255, 255));
        passwordPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordPasswordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(141, 11, 65), 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        loginPane.add(passwordPasswordField);

        // Show Password Button
        showPasswordButton = new JButton("show");
        showPasswordButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        showPasswordButton.setBounds(318, 451, 60, 25);
        showPasswordButton.setForeground(new Color(141, 11, 65));
        showPasswordButton.setBorderPainted(false);
        showPasswordButton.setContentAreaFilled(false);
        showPasswordButton.setFocusPainted(false);
        showPasswordButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginPane.add(showPasswordButton);

        // Add show/hide password functionality
        showPasswordButton.addActionListener(e -> {
            if (passwordPasswordField.getEchoChar() == 0) {
                passwordPasswordField.setEchoChar('•');
                showPasswordButton.setText("show");
            } else {
                passwordPasswordField.setEchoChar((char) 0);
                showPasswordButton.setText("hide");
            }
        });

        // Forgot Password Button
        forgotPasswordButton = new JButton("<html><u>Forgot password</u></html>");
        forgotPasswordButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        forgotPasswordButton.setBounds(260, 510, 120, 25);
        forgotPasswordButton.setForeground(new Color(141, 11, 65));
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setFocusPainted(false);
        forgotPasswordButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginPane.add(forgotPasswordButton);

        // Forgot Password Button functionality
        forgotPasswordButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "forgotPasswordButton", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        // Login Button with gradient-like effect
        loginButton = new JButton("Log in") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, new Color(141, 11, 65),
                        0, getHeight(), new Color(106, 8, 43));
                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        loginButton.setFont(new Font("Arial", Font.BOLD, 15));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBounds(113, 555, 249, 42);
        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginPane.add(loginButton);

        // Login Button functionality
        loginButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "loginButton", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        // End Note Label and Create Account Button Group
        JPanel groupPanel = new JPanel();
        groupPanel.setLayout(null);
        groupPanel.setBounds(107, 620, 400, 50);
        groupPanel.setBackground(Color.WHITE);

        // End Note Label
        endNoteLabel = new JLabel("Need a USMS account?");
        endNoteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        endNoteLabel.setBounds(0, 7, 150, 25);
        groupPanel.add(endNoteLabel);

        // Create Account Button
        createAnAccountButton = new JButton("<html><u>Create an account</u></html>");
        createAnAccountButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        createAnAccountButton.setBounds(115, 4, 187, 31);
        createAnAccountButton.setForeground(new Color(141, 11, 65));
        createAnAccountButton.setBorderPainted(false);
        createAnAccountButton.setContentAreaFilled(false);
        createAnAccountButton.setFocusPainted(false);
        createAnAccountButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        groupPanel.add(createAnAccountButton);

        // Create Account Button functionality
        createAnAccountButton.addActionListener(e -> {
            loginPane.setVisible(false);
            signUpPane.setVisible(true);
        });

        loginPane.add(groupPanel);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Sign Up Pane (Right)
        signUpPane = new JPanel();
        signUpPane.setLayout(null);
        signUpPane.setBackground(Color.WHITE);
        signUpPane.setBounds(550, 0, 474, 768);
        add(signUpPane);

        signUpPane.setVisible(false);

        // Sign Up Pane Image
        signUpPaneImageIcon = new ImageIcon("resources/images/online-registration.png");
        imgSignUpPane = signUpPaneImageIcon.getImage().getScaledInstance(257, 171, Image.SCALE_SMOOTH);
        smoothSignUpPaneImageIcon = new ImageIcon(imgSignUpPane);
        signUpPaneImageLabel = new JLabel(smoothSignUpPaneImageIcon);
        signUpPaneImageLabel.setBounds(119, 72, 257, 171);
        signUpPane.add(signUpPaneImageLabel);

        // Welcome message in Sign Up Pane
        welcomeLabel = new JLabel("Create an account", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
        welcomeLabel.setBounds(80, 243, 314, 42);
        signUpPane.add(welcomeLabel);

        // Welcome to Note Label
        welcomeNoteLabel = new JLabel("Your service is necessary for us!");
        welcomeNoteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        welcomeNoteLabel.setBounds(80, 292, 197, 18);
        //welcomeNoteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        signUpPane.add(welcomeNoteLabel);

        // Username field and label
        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        usernameLabel.setBounds(80, 330, 249, 20);
        signUpPane.add(usernameLabel);

        // Username TextField with custom styling
        usernameTextField = new JTextField();
        usernameTextField.setBounds(80, 356, 249, 30);
        usernameTextField.setBackground(new Color(255, 255, 255));
        usernameTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameTextField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(141, 11, 65), 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        signUpPane.add(usernameTextField);

        // Email field and label
        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        emailLabel.setBounds(80, 406, 249, 20);
        signUpPane.add(emailLabel);

        // Email TextField with custom styling
        emailTextField = new JTextField();
        emailTextField.setBounds(80, 432, 249, 30);
        emailTextField.setBackground(new Color(255, 255, 255));
        emailTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailTextField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(141, 11, 65), 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        signUpPane.add(emailTextField);

        // Password field and label
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        passwordLabel.setBounds(80, 482, 249, 20);
        signUpPane.add(passwordLabel);

        // Password TextField with custom styling
        passwordTextField = new JTextField();
        passwordTextField.setBounds(80, 508, 249, 30);
        passwordTextField.setBackground(new Color(255, 255, 255));
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordTextField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(141, 11, 65), 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        signUpPane.add(passwordTextField);

        // Sign up button with gradient-like effect
        signUpButton = new JButton("Sign Up") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, new Color(141, 11, 65),
                        0, getHeight(), new Color(106, 8, 43));
                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        signUpButton.setFont(new Font("Arial", Font.BOLD, 15));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBounds(80, 577, 314, 40);
        signUpButton.setContentAreaFilled(false);
        signUpButton.setBorderPainted(false);
        signUpButton.setFocusPainted(false);
        signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpPane.add(signUpButton);

        // Sign up button functionality
        signUpButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "signUpButton", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        // End Note Label and New Login Button Group
        groupPane = new JPanel();
        groupPane.setLayout(null);
        groupPane.setBounds(118, 638, 249, 32);
        groupPane.setBackground(Color.WHITE);

        // End Note Label
        endNoteLabel = new JLabel("Do you have an SMDF account?", JLabel.CENTER);
        endNoteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        endNoteLabel.setBounds(0, 7, 196, 18);
        groupPane.add(endNoteLabel);

        // New Login Button
        newLoginButton = new JButton("<html><u>Login</u></html>");
        newLoginButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        newLoginButton.setBounds(185, 0, 57, 31);
        newLoginButton.setForeground(new Color(141, 11, 65));
        newLoginButton.setBorderPainted(false);
        newLoginButton.setContentAreaFilled(false);
        newLoginButton.setFocusPainted(false);
        newLoginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        groupPane.add(newLoginButton);

        // New Login Button functionality
        newLoginButton.addActionListener(e -> {
            signUpPane.setVisible(false);
            loginPane.setVisible(true);
            //JOptionPane.showMessageDialog(null, "newLoginButton", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        signUpPane.add(groupPane);
    }
}
