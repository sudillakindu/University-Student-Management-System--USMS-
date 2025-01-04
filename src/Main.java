import controller.LoginAndSignUpController;
import model.LoginAndSignUpModel;
import view.LoginAndSignUpView;

public class Main {
    public static void main(String[] args) {
        LoginAndSignUpView loginAndSignUpView = new LoginAndSignUpView();
        LoginAndSignUpModel loginAndSignUpModel = new LoginAndSignUpModel();
        LoginAndSignUpController loginAndSignUpController = new LoginAndSignUpController(loginAndSignUpView, loginAndSignUpModel);
    }
}
