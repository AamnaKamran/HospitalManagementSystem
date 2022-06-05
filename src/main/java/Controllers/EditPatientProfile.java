package Controllers;

import Entities.HmsUser;
import Main.Main;
import Utilities.SignedInUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class EditPatientProfile {

    @FXML
    private TextField email_address;

    @FXML
    private TextField first_name;

    @FXML
    private TextField last_name;

    @FXML
    private TextField password;

    @FXML
    private Button saveButton;

    @FXML
    private Button goBack;

    @FXML
    void onClickSave(MouseEvent event) {
        String _first_name = first_name.getText();
        String _last_name = last_name.getText();
        String _email_address = email_address.getText();
        String _password = password.getText();
        HmsUser hmsUser = HmsUser.updateSignedInUser(_first_name, _last_name, _email_address, _password);
        SignedInUser signedInUser = SignedInUser.getInstance();
        signedInUser.setUser(hmsUser);

        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/Patient/ViewProfile.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }
    }

    public void backToProfile(MouseEvent mouseEvent) {
        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/Patient/ViewProfile.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }
    }
}

