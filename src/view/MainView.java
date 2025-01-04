package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainView {

    private JFrame mainViewFrame;

    private JPanel mainPane;
    private JPanel redPane;
    private JPanel creamPane;
    private JPanel mainViewPane;

    private ImageIcon sidePaneExitImageIcon, smoothSidePaneExitImageIcon;

    private Image exitImgSidePane;

    private JLabel sidePaneExitImage;
    private JLabel dateTimeLabel;
    private JLabel welcomeNoteLabel;
    private JLabel userLabel;

    private JSeparator separateLine;

    private final JButton[] buttons = new JButton[8];

    public MainView(String username) {

        // Frame setup
        mainViewFrame = new JFrame();
        mainViewFrame.setUndecorated(true);
        mainViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainViewFrame.setSize(1024, 768);
        mainViewFrame.setLayout(null);
        mainViewFrame.setBackground(Color.WHITE);
        LoginAndSignUpView.addDragFunctionality(mainViewFrame);

        // Main panel setup
        mainPane = new JPanel(null);
        mainPane.setBounds(0, 0, 1024, 768);
        mainPane.setBackground(new Color(130, 107, 117));
        mainPane.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(141, 11, 65), 4, true),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        mainViewFrame.add(mainPane);

        // Exit button
        sidePaneExitImageIcon = new ImageIcon("resources/images/icons8-exit-50.png");
        exitImgSidePane = sidePaneExitImageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        smoothSidePaneExitImageIcon = new ImageIcon(exitImgSidePane);
        sidePaneExitImage = new JLabel(smoothSidePaneExitImageIcon);
        sidePaneExitImage.setBounds(10, 10, 25, 25);
        mainPane.add(sidePaneExitImage);

        sidePaneExitImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        mainPane,
                        "Are you sure you want to exit?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Side pane (red pane)
        redPane = new JPanel(null);
        redPane.setBounds(35, 45, 208, 678);
        redPane.setBackground(new Color(141, 11, 65));
        redPane.setBorder(BorderFactory.createLineBorder(new Color(211, 157, 85), 0, true));
        mainPane.add(redPane);

        // Cream pane
        creamPane = new JPanel(null);
        creamPane.setBounds(139, 11, 875, 748);
        creamPane.setBackground(new Color(255, 248, 230));
        creamPane.setBorder(BorderFactory.createLineBorder(new Color(255, 248, 230), 0, true));
        mainPane.add(creamPane);

        mainViewPane = new JPanel();
        mainViewPane.setBounds(104, 0, 771, 748);
        mainViewPane.setBackground(new Color(255, 248, 230));
        creamPane.add(mainViewPane);

        // Date and time label
        dateTimeLabel = new JLabel("<html><center>Loading...</center></html>");
        dateTimeLabel.setBounds(88, 10, 107, 43);
        dateTimeLabel.setForeground(Color.WHITE);
        dateTimeLabel.setFont(new Font("System", Font.BOLD, 15));
        redPane.add(dateTimeLabel);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime now = LocalDateTime.now();
                String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy - MM - dd"));
                String formattedTime = now.format(DateTimeFormatter.ofPattern("hh : mm : ss a"));
                dateTimeLabel.setText("<html><div style='text-align: right;'>" +
                        formattedDate + "<br>" + formattedTime +
                        "</div></html>");
            }
        });
        timer.start();

        // Welcome note
        welcomeNoteLabel = new JLabel("<html><center>Welcome to the<br>USMS Platform</center></html>");
        welcomeNoteLabel.setBounds(15, 68, 179, 68);
        welcomeNoteLabel.setForeground(Color.WHITE);
        welcomeNoteLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        redPane.add(welcomeNoteLabel);

        // Buttons
        String[] buttonTexts = {"Dashboard", "Registration", "Course", "Enrollment", "Attendance", "Grade", "Report", "Log Out"};
        int yOffset = 165;
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonTexts[i]);
            if (i == 7) { // Log Out button
                buttons[i].setBounds(24, 577, 160, 34);
                buttons[i].setFocusPainted(false);
                buttons[i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
                buttons[i].setBackground(Color.LIGHT_GRAY);
            } else {
                buttons[i].setBounds(24, yOffset, 160, 34);
                buttons[i].setFocusPainted(false);
                buttons[i].setBorder(BorderFactory.createLineBorder(new Color(154, 105, 40), 2, true));
                buttons[i].setBackground(new Color(211, 157, 85));
            }
            buttons[i].setFont(new Font("System", Font.BOLD, 14));
            buttons[i].setForeground(Color.BLACK);
            yOffset += 52;
            redPane.add(buttons[i]);
        }

        // Separator
        separateLine = new JSeparator();
        separateLine.setBounds(14, 564, 180, 2);
        separateLine.setBackground(Color.WHITE);
        redPane.add(separateLine);

        // User greeting
        userLabel = new JLabel("Hi! , " + username, SwingConstants.CENTER);
        userLabel.setBounds(24, 623, 160, 34);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("System", Font.BOLD, 20));
        redPane.add(userLabel);

        mainViewFrame.setLocationRelativeTo(null);
        mainViewFrame.setVisible(true);
    }

    // Listener methods for each button
    public void addDashboardButtonListener(ActionListener listener) {
        buttons[0].addActionListener(listener);
    }

    public void addRegistrationButtonListener(ActionListener listener) {
        buttons[1].addActionListener(listener);
    }

    public void addCourseButtonListener(ActionListener listener) {
        buttons[2].addActionListener(listener);
    }

    public void addEnrollmentButtonListener(ActionListener listener) {
        buttons[3].addActionListener(listener);
    }

    public void addAttendanceButtonListener(ActionListener listener) {
        buttons[4].addActionListener(listener);
    }

    public void addGradeButtonListener(ActionListener listener) {
        buttons[5].addActionListener(listener);
    }

    public void addReportButtonListener(ActionListener listener) {
        buttons[6].addActionListener(listener);
    }

    public void addLogOutButtonListener(ActionListener listener) {
        buttons[7].addActionListener(listener);
    }

    public JFrame getMainViewFrame() {
        return mainViewFrame;
    }

    public JPanel getMainViewPane() {
        return mainViewPane;
    }
}
