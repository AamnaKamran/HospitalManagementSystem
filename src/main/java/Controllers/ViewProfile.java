package Controllers;

import Entities.HmsUser;
import Main.Main;
import Utilities.SignedInUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewProfile implements Initializable {

    @FXML
    private ImageView editProfileBtn;

    @FXML
    private Label doctors_name;

    @FXML
    private Label emailAddress;

    @FXML
    private Label fname;

    @FXML
    private Label lname;

    @FXML
    private Label password;

    @FXML
    private Label username;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        SignedInUser signedInUser = SignedInUser.getInstance();
        doctors_name.setText(signedInUser.getUser().getFirstName()+" "+signedInUser.getUser().getLastName());
        fname.setText(signedInUser.getUser().getFirstName());
        fname.setVisible(true);
        lname.setText(signedInUser.getUser().getLastName());
        lname.setVisible(true);
        username.setText(signedInUser.getUser().getId());
        username.setVisible(true);
        emailAddress.setText(signedInUser.getUser().getEmailAddress());
        emailAddress.setVisible(true);
        password.setText(signedInUser.getUser().getPassword());
        password.setVisible(true);
    }

    public void BackToLogin(MouseEvent mouseEvent) {
        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/LoginScreen.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }
    }

    public void BackToDashboard(MouseEvent mouseEvent) {
        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/Doctor/DashboardDoctor.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }
    }

    @FXML
    void ViewPatients(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/Doctor/ViewPatients.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }
    }

    @FXML
    void ViewProfile(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/ViewProfile.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }
    }

    public void ViewAppointments(MouseEvent mouseEvent) {
        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/Doctor/ViewAppointments.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }
    }

    @FXML
    public void editProfile(MouseEvent mouseEvent) {
        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/Doctor/EditProfile.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }
    }
}
