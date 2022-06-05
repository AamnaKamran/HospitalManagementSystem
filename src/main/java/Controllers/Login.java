package Controllers;

import Entities.HmsUser;
import Exception.LogInException;
import Main.Main;
import Utilities.SignedInUser;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.concurrent.TimeUnit;

public class Login {


    @FXML
    private Label incorrectTextLabel;

    @FXML
    private PasswordField password;

    @FXML
    private Button signInButton;

    @FXML
    private Button signupBtn;

    @FXML
    private TextField username;

    @FXML
    void SignInButtonClicked(MouseEvent event) throws LogInException{

        String _username = username.getText();
        String _password = password.getText();

        String is_doctor = HmsUser.logIn(_username, _password);
        checkLogin(is_doctor);

    }

    @FXML
    void printLabelMsg(String msg){
        incorrectTextLabel.setText(msg);
    }

    @FXML
    void checkLogin(String flag) throws LogInException {
        if (flag.equals("isDoctor") == true) {
            Main main = new Main();
            try {
                HmsUser user = new HmsUser();
                SignedInUser signedInUser = SignedInUser.getInstance();
                signedInUser.setUser(HmsUser.retrieveUser(username.getText(),password.getText()));
                main.changeScene("ScreenFXMLs/Doctor/DashboardDoctor.fxml");
            } catch (Exception e) {
                System.out.println("Dashboard Page not Loaded");
            }
        }
        else if(flag.equals("isPatient")){
            Main main = new Main();
            try {
                HmsUser user = new HmsUser();
                SignedInUser signedInUser = SignedInUser.getInstance();
                signedInUser.setUser(HmsUser.retrieveUser(username.getText(),password.getText()));
                main.changeScene("ScreenFXMLs/Patient/ViewProfile.fxml");
            } catch (Exception e) {
                System.out.println("Admin Dashboard Page not Loaded");
            }
        }
        else if(flag.equals("none")){
            printLabelMsg("Incorrect Username or Password");
            throw new LogInException("Incorrect Username or Password");
        }
        else {
            printLabelMsg("Please enter Username/Password");
            throw new LogInException("Username/Password fields are empty");
        }

    }


    @FXML
    void SignUpButtonClicked(MouseEvent event) {

        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/SignupScreen.fxml");
        } catch (Exception e) {
            System.out.println("Page not Loaded");
        }
    }
}
