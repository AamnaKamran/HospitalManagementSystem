package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Entities.HmsUser;
import Main.Main;
import Utilities.SignedInUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ViewPatientProfile implements Initializable {

    @FXML
    private ImageView BookBtn;

    @FXML
    private ImageView LogOut;

    @FXML
    private ImageView editButton;

    @FXML
    private Label email_address;

    @FXML
    private ImageView findDocBtn;

    @FXML
    private Label fname;

    @FXML
    private Label lname;

    @FXML
    private ImageView historyBtn;

    @FXML
    private Label password;

    @FXML
    private Label patients_name;

    @FXML
    private ImageView profileBtn;

    @FXML
    private Label signedInUserLabel;

    @FXML
    private Label username;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        SignedInUser signedInUser = SignedInUser.getInstance();
        patients_name.setText(signedInUser.getUser().getFirstName() + " "+signedInUser.getUser().getLastName());
        patients_name.setVisible(true);
        username.setText(signedInUser.getUser().getId());
        username.setVisible(true);
        email_address.setText(signedInUser.getUser().getEmailAddress());
        email_address.setVisible(true);
        fname.setText(signedInUser.getUser().getFirstName());
        fname.setVisible(true);
        lname.setText(signedInUser.getUser().getLastName());
        lname.setVisible(true);
        password.setText(signedInUser.getUser().getPassword());
        password.setVisible(true);

    }

    @FXML
    void BackToLogin(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/LoginScreen.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }
    }

    @FXML
    void Booking(MouseEvent event) {

        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/Patient/BookAppointment.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }

    }

    @FXML
    void ViewProfile(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/Patient/ViewProfile.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }
    }

    @FXML
    void editButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/Patient/EditProfile.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }
    }

    @FXML
    void findDoctor(MouseEvent event) {

        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/Patient/FindDoctor.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }

    }

    @FXML
    void viewVisitingHistory(MouseEvent event) {

        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/Patient/ViewPrescriptions.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }
    }


}
