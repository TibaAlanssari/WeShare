//Tiba Al Anssari fso799

package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*

Class: SignUpController
Description: This class has the code for SignUpPage.fxml actions

*/

public class SignUpController {

  @FXML
  private TextField SignUpUsername;

  @FXML
  private PasswordField SignUpPassword;

  @FXML
  private AnchorPane mainPane;

  /*
   	Method: storeLoginInfo
   	Description: stores the Sign Up username and password information to be used for Login
   	Parameters: event
   	Return: none
   	*/

  public void storeLoginInfo(ActionEvent event) throws IOException {

    String username = SignUpUsername.getText().toString();
    String password = SignUpPassword.getText().toString();

    model.Model.storeLoginInfo(event, username, password);

    SignUpUsername.clear();
    SignUpPassword.clear();

    changeSceneToWelcomePage(event);
    signUpSuccessfulMessage();

  }

  //Displaying Messages to User

  /*
   	Method: signUpSuccessfulMessage
   	Description: Pops up a confirmation message if sign up was successful 
   	Parameters: none
   	Return: none
   	*/

  public void signUpSuccessfulMessage() {
    Alert a = new Alert(AlertType.NONE);
    a.setAlertType(AlertType.CONFIRMATION);
    a.setContentText("Signup was successful!");
    a.show();
  }

  //Changing Scene

  /*
   	Method: changeSceneToWelcomePage
   	Description: changes scenes from SignUpPage.fxml back to WelcomePage.fxml
   	Parameters: event
   	Return: none
   	*/

  @FXML
  public void changeSceneToWelcomePage(ActionEvent event) throws IOException {

    mainPane = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
    Scene LoginScene = new Scene(mainPane);
    Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
    window.setScene(LoginScene);
    window.show();
    mainPane.setBackground(new Background(new BackgroundFill(Color.rgb(151, 187, 255, 1), null, null)));
  }

}