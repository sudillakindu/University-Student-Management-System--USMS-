import controller.LoginAndSignUpController;
import model.LoginAndSignUpModel;
import view.LoginAndSignUpFormView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static void main(String[] args) {

        LoginAndSignUpFormView view = new LoginAndSignUpFormView();
        LoginAndSignUpModel model = new LoginAndSignUpModel();
        LoginAndSignUpController controller = new LoginAndSignUpController(view,model);

        // Create a JFrame to display the UI
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(view);
        frame.pack();

        //frame.setContentPane(loginAndSignUpFormView);

        frame.setSize(1024, 768);
        frame.setLocationRelativeTo(null);
        addDragFunctionality(frame);
        frame.setVisible(true);

    }

    // Method to add drag functionality
    private static void addDragFunctionality(JFrame frame) {
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
