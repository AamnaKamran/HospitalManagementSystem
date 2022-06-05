package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Entities.HmsDoctor;
import Entities.HmsUser;
import Exception.SignUpException;
import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.regex.Pattern;

public class SignUp {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ExceptionText;

    @FXML
    private Button backButton;

    @FXML
    private TextField cnic;

    @FXML
    private PasswordField confirm_password;

    @FXML
    private TextField email;

    @FXML
    private TextField first_name;

    @FXML
    private CheckBox is_doctor;

    @FXML
    private TextField last_name;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phone_number;

    @FXML
    private Button registerButton;

    @FXML
    private TextField username;

    @FXML
    void backButtonClicked(MouseEvent event) {
        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/LoginScreen.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }
    }

    @FXML
    void setLabelMsg(String msg){
        ExceptionText.setText(msg);
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    @FXML
    void registerButtonClicked(MouseEvent event) throws SignUpException {
        HmsUser kms = new HmsUser();
        HmsDoctor doctor = new HmsDoctor();

        String _password = password.getText();
        String _email = email.getText();
        String _cnic = cnic.getText();
        String _firstName = first_name.getText();
        String _lastName = last_name.getText();
        String _phoneNumber = phone_number.getText();
        String _confirmedPassword = confirm_password.getText();
        String _username = username.getText();
        boolean _isDoctor = is_doctor.isSelected();

        if(_password.length()==0
                ||_email.length()==0
                ||_cnic.length()==0
                ||_firstName.length()==0
                ||_lastName.length()==0
                ||_phoneNumber.length()==0
                ||_confirmedPassword.length()==0
                ||_username.length()==0
        )   {
            setLabelMsg("Please fill the required fields.");
            throw new SignUpException("Empty Text Field(s)");
        }

        if(patternMatches(_firstName,".*[0-9].*")){
            setLabelMsg("Please enter a valid First Name");
            throw new SignUpException("Name contains Digit(s)");
        }

        if(patternMatches(_lastName,".*[0-9].*")){
            setLabelMsg("Please enter a valid Last Name");
            throw new SignUpException("Name contains Digit(s)");
        }

        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if(!patternMatches(_email, regexPattern)){
            setLabelMsg("Please enter a valid Email Address.");
            throw new SignUpException("Invalid Email Address");
        }

        if(cnic.getLength()<16){
            setLabelMsg("CNIC should be 16 digits long.");
            throw new SignUpException("Invalid CNIC length");
        }

        if(patternMatches(_cnic,".*[a-z].*")||patternMatches(_cnic,".*[A-Z].*")){
            setLabelMsg("Invalid CNIC.");
            throw new SignUpException("Invalid CNIC");
        }

        if(phone_number.getLength()<11){
            setLabelMsg("Invalid phone number.");
            throw new SignUpException("Invalid phone number");
        }

        if(patternMatches(_phoneNumber,".*[a-z].*")||patternMatches(_phoneNumber,".*[A-Z].*")){
            setLabelMsg("Invalid phone number.");
            throw new SignUpException("Invalid phone number");
        }

        if(!_password.equals(_confirmedPassword)){
            setLabelMsg("Passwords don't match.");
            throw new SignUpException("Passwords are not equal.");
        }

        if(kms.retrieveUser(_username)!=null){
            setLabelMsg("Username Already Exists");
            throw new SignUpException("Username Already Exists");
        }

        kms.registerAUser(_username, _password, _email, _cnic, _firstName, _lastName, _phoneNumber, _confirmedPassword,_isDoctor);
        //doctor.registerADoctor(_username, _firstName, _lastName);

        Main main = new Main();
        try {
            main.changeScene("ScreenFXMLs/LoginScreen.fxml");
        }
        catch(Exception e) {
            System.out.println("Page not Loaded");
        }
    }

    @FXML
    void initialize() {
        assert ExceptionText != null : "fx:id=\"ExceptionText\" was not injected: check your FXML file 'SignupScreen.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'SignupScreen.fxml'.";
        assert cnic != null : "fx:id=\"cnic\" was not injected: check your FXML file 'SignupScreen.fxml'.";
        assert confirm_password != null : "fx:id=\"confirm_password\" was not injected: check your FXML file 'SignupScreen.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'SignupScreen.fxml'.";
        assert first_name != null : "fx:id=\"first_name\" was not injected: check your FXML file 'SignupScreen.fxml'.";
        assert is_doctor != null : "fx:id=\"is_doctor\" was not injected: check your FXML file 'SignupScreen.fxml'.";
        assert last_name != null : "fx:id=\"last_name\" was not injected: check your FXML file 'SignupScreen.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'SignupScreen.fxml'.";
        assert phone_number != null : "fx:id=\"phone_number\" was not injected: check your FXML file 'SignupScreen.fxml'.";
        assert registerButton != null : "fx:id=\"registerButton\" was not injected: check your FXML file 'SignupScreen.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'SignupScreen.fxml'.";

    }

}
