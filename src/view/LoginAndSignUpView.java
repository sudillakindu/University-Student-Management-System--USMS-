package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginAndSignUpView extends JPanel {

    private JFrame loginAndSignUpViewFrame;

    private JPanel mainPane;
    private JPanel sidePane;
    private JPanel loginPane;
    private JPanel signUpPane;
    private JPanel groupPane;

    private ImageIcon sidePaneExitImageIcon, smoothSidePaneExitImageIcon;
    private ImageIcon sidePaneCapImageIcon, smoothSidePaneCapImageIcon;
    private ImageIcon sidePaneMainImageIcon, smoothSidePaneMainImageIcon;
    private ImageIcon loginPaneImageIcon, smoothLoginPaneImageIcon;
    private ImageIcon signUpPaneImageIcon, smoothSignUpPaneImageIcon;

    private Image exitImgSidePane;
    private Image capImgSidePane;
    private Image mainImgSidePane;
    private Image imgLoginPane;
    private Image imgSignUpPane;

    private JLabel sidePaneExitImage;
    private JLabel sidePaneCapImage;
    private JLabel sidePaneMainImage;
    private JLabel loginPaneImageLabel;
    private JLabel signUpPaneImageLabel;

    private JTextField loginUsernameTextField, signUpUsernameTextField;
    private JTextField signUpEmailTextField;
    private JTextField signUpPasswordTextField;
    private JPasswordField loginPasswordField;

    private JComboBox<String> signUpSelectRoleComboBox;

    private JButton loginButton;
    private JButton signUpButton;
    private JButton createAnAccountButton;
    private JButton forgotPasswordButton;
    private JButton showPasswordButton;
    private JButton newLoginButton;

    private JLabel mainNoteLabel;
    private JLabel welcomeLabel;
    private JLabel welcomeNoteLabel;
    private JLabel selectRoleLabel;
    private JLabel usernameLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel endNoteLabel;

    public LoginAndSignUpView() {

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        loginAndSignUpViewFrame = new JFrame();
        loginAndSignUpViewFrame.setUndecorated(true);
        loginAndSignUpViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginAndSignUpViewFrame.setSize(1024, 768);
        loginAndSignUpViewFrame.setLayout(null);
        loginAndSignUpViewFrame.setBackground(Color.WHITE);
        addDragFunctionality(loginAndSignUpViewFrame);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Side Pane (Left)
        sidePane = new JPanel();
        sidePane.setLayout(null);
        sidePane.setBackground(new Color(141, 11, 65)); // #8D0B41
        sidePane.setBounds(0, 0, 550, 768);
        loginAndSignUpViewFrame.add(sidePane);

        // Main Note Label
        mainNoteLabel = new JLabel("<html><center>University Student<br>Management System</center></html>");
        mainNoteLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 38));
        mainNoteLabel.setForeground(new Color(211, 157, 85));
        mainNoteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainNoteLabel.setBounds(29, 74, 493, 142);
        sidePane.add(mainNoteLabel);

        // Side Pane Image
        sidePaneExitImageIcon = new ImageIcon("resources/images/icons8-exit-50.png");
        exitImgSidePane = sidePaneExitImageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        smoothSidePaneExitImageIcon = new ImageIcon(exitImgSidePane);
        sidePaneExitImage = new JLabel(smoothSidePaneExitImageIcon);
        sidePaneExitImage.setBounds(10, 10, 25, 25);
        sidePane.add(sidePaneExitImage);

        // Add click functionality to the exit image
        sidePaneExitImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        loginAndSignUpViewFrame,
                        "Are you sure you want to exit?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

//        sidePaneCapImageIcon = new ImageIcon("resources/images/icons8-university-100.png");
//        capImgSidePane = sidePaneCapImageIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
//        smoothSidePaneCapImageIcon = new ImageIcon(capImgSidePane);
//        sidePaneCapImage = new JLabel(smoothSidePaneCapImageIcon);
//        sidePaneCapImage.setBounds(60, 60, 55, 55);
//        sidePane.add(sidePaneCapImage);

        sidePaneMainImageIcon = new ImageIcon("resources/images/happy-university.png");
        mainImgSidePane = sidePaneMainImageIcon.getImage().getScaledInstance(622, 616, Image.SCALE_SMOOTH);
        smoothSidePaneMainImageIcon = new ImageIcon(mainImgSidePane);
        sidePaneMainImage = new JLabel(smoothSidePaneMainImageIcon);
        sidePaneMainImage.setBounds(-21, 213, 622, 616);
        sidePane.add(sidePaneMainImage);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Login Pane (Right)
        loginPane = new JPanel();
        loginPane.setLayout(null);
        loginPane.setBackground(Color.WHITE);
        loginPane.setBounds(550, 0, 474, 768);
        loginAndSignUpViewFrame.add(loginPane);

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
        loginPane.add(welcomeLabel);

        // Welcome to Note Label
        welcomeNoteLabel = new JLabel("Please enter your details");
        welcomeNoteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        welcomeNoteLabel.setBounds(113, 325, 249, 25);
        loginPane.add(welcomeNoteLabel);

        // Username Label
        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        usernameLabel.setBounds(113, 370, 249, 25);
        loginPane.add(usernameLabel);

        // Username TextField with custom styling
        loginUsernameTextField = new JTextField();
        loginUsernameTextField.setBounds(113, 399, 249, 30);
        loginUsernameTextField.setBackground(new Color(255, 255, 255));
        loginUsernameTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        loginUsernameTextField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(141, 11, 65), 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        loginPane.add(loginUsernameTextField);

        // Password Label
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        passwordLabel.setBounds(113, 445, 249, 25);
        loginPane.add(passwordLabel);

        // Password TextField with custom styling
        loginPasswordField = new JPasswordField();
        loginPasswordField.setBounds(113, 474, 249, 30);
        loginPasswordField.setBackground(new Color(255, 255, 255));
        loginPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        loginPasswordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(141, 11, 65), 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        loginPane.add(loginPasswordField);

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
            if (loginPasswordField.getEchoChar() == 0) {
                loginPasswordField.setEchoChar('•');
                showPasswordButton.setText("show");
            } else {
                loginPasswordField.setEchoChar((char) 0);
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
        loginAndSignUpViewFrame.add(signUpPane);

        signUpPane.setVisible(false);

        // Sign Up Pane Image
        signUpPaneImageIcon = new ImageIcon("resources/images/online-registration.png");
        imgSignUpPane = signUpPaneImageIcon.getImage().getScaledInstance(257, 171, Image.SCALE_SMOOTH);
        smoothSignUpPaneImageIcon = new ImageIcon(imgSignUpPane);
        signUpPaneImageLabel = new JLabel(smoothSignUpPaneImageIcon);
        signUpPaneImageLabel.setBounds(119, 46, 257, 171);
        signUpPane.add(signUpPaneImageLabel);

        // Welcome message in Sign Up Pane
        welcomeLabel = new JLabel("Create an account", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
        welcomeLabel.setBounds(80, 217, 314, 42);
        signUpPane.add(welcomeLabel);

        // Welcome to Note Label
        welcomeNoteLabel = new JLabel("Your service is necessary for us!");
        welcomeNoteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        welcomeNoteLabel.setBounds(80, 266, 197, 18);
        signUpPane.add(welcomeNoteLabel);

        // Select Role Label label
        selectRoleLabel = new JLabel("Select Role");
        selectRoleLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        selectRoleLabel.setBounds(80, 306, 249, 20);
        signUpPane.add(selectRoleLabel);

        // Create a JComboBox
        signUpSelectRoleComboBox = new JComboBox<>();
        signUpSelectRoleComboBox.setBounds(80, 334, 249, 35); // Set position and size
        signUpSelectRoleComboBox.setBackground(new Color(255, 255, 255)); // Background color
        //signUpSelectRoleComboBox.setForeground(new Color(51, 51, 51)); // Text color
        signUpSelectRoleComboBox.setFont(new Font("Arial", Font.PLAIN, 14)); // Font size
        signUpSelectRoleComboBox.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(141, 11, 65), 2), // Outer border
                BorderFactory.createEmptyBorder(0, 0, 0, 0) // Padding
        ));
        signUpSelectRoleComboBox.addItem("admin");
        signUpSelectRoleComboBox.addItem("user");
        signUpPane.add(signUpSelectRoleComboBox);

        // Username field and label
        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        usernameLabel.setBounds(80, 382, 249, 20);
        signUpPane.add(usernameLabel);

        // Username TextField with custom styling
        signUpUsernameTextField = new JTextField();
        signUpUsernameTextField.setBounds(80, 410, 249, 35);
        signUpUsernameTextField.setBackground(new Color(255, 255, 255));
        signUpUsernameTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        signUpUsernameTextField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(141, 11, 65), 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        signUpPane.add(signUpUsernameTextField);

        // Email field and label
        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        emailLabel.setBounds(80, 458, 249, 20);
        signUpPane.add(emailLabel);

        // Email TextField with custom styling
        signUpEmailTextField = new JTextField();
        signUpEmailTextField.setBounds(80, 486, 249, 35);
        signUpEmailTextField.setBackground(new Color(255, 255, 255));
        signUpEmailTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        signUpEmailTextField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(141, 11, 65), 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        signUpPane.add(signUpEmailTextField);

        // Password field and label
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        passwordLabel.setBounds(80, 534, 249, 20);
        signUpPane.add(passwordLabel);

        // Password TextField with custom styling
        signUpPasswordTextField = new JTextField();
        signUpPasswordTextField.setBounds(80, 562, 249, 35);
        signUpPasswordTextField.setBackground(new Color(255, 255, 255));
        signUpPasswordTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        signUpPasswordTextField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(141, 11, 65), 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        signUpPane.add(signUpPasswordTextField);

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
        signUpButton.setBounds(80, 620, 314, 40);
        signUpButton.setContentAreaFilled(false);
        signUpButton.setBorderPainted(false);
        signUpButton.setFocusPainted(false);
        signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpPane.add(signUpButton);

        // End Note Label and New Login Button Group
        groupPane = new JPanel();
        groupPane.setLayout(null);
        groupPane.setBounds(118, 675, 249, 32);
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
        });

        signUpPane.add(groupPane);

        loginAndSignUpViewFrame.setLocationRelativeTo(null);
        loginAndSignUpViewFrame.setVisible(true);
    }

    public String getLoginUsername() {
        return loginUsernameTextField.getText();
    }
    public String getLoginPassword() {
        return new String(loginPasswordField.getPassword());
    }
    public void addForgotPasswordButtonListener(ActionListener listener) {
        forgotPasswordButton.addActionListener(listener);
    }
    public void addLoginButtonListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public String getSignUpSelectRoleComboBox() {
        return (String) signUpSelectRoleComboBox.getSelectedItem();
    }
    public String getSignUpUsername() {
        return signUpUsernameTextField.getText();
    }
    public String getSignUpEmail() {
        return signUpEmailTextField.getText();
    }
    public String getSignUpPassword() {
        return signUpPasswordTextField.getText();
    }
    public void addSignUpButtonListener(ActionListener listener) {
        signUpButton.addActionListener(listener);
    }

    public JPanel getLoginPane() {
        return loginPane;
    }
    public JPanel getSignUpPane() {
        return signUpPane;
    }
    public JFrame getLoginAndSignUpViewFrame() {
        return loginAndSignUpViewFrame;
    }

    // Method to add drag functionality
    public static void addDragFunctionality(JFrame frame) {
        final int[] mousePosition = {0, 0};

        // Add mouse listener to capture the click position
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePosition[0] = e.getX();
                mousePosition[1] = e.getY();
            }
        });

        // Add mouse motion listener to move the frame
        frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen() - mousePosition[0];
                int y = e.getYOnScreen() - mousePosition[1];
                frame.setLocation(x, y);
            }
        });
    }

}
