import controller.LoginAndSignUpController;
import controller.MainController;
import model.LoginAndSignUpModel;
import view.DashboardView;
import view.LoginAndSignUpView;
import view.MainView;

public class Main {
    public static void main(String[] args) {
        LoginAndSignUpView loginAndSignUpView = new LoginAndSignUpView();
        LoginAndSignUpModel loginAndSignUpModel = new LoginAndSignUpModel();
        LoginAndSignUpController loginAndSignUpController = new LoginAndSignUpController(loginAndSignUpView, loginAndSignUpModel);
    }
}
