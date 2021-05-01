//Tiba Al Anssari fso799

package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
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

Class: LoginController
Description: This class has the code for LoginPage.fxml actions

*/

public class LoginController {

  @FXML
  private TextField LoginUsername;

  @FXML
  private PasswordField LoginPassword;

  @FXML
  private AnchorPane mainPane;

  public static String username;

  public static String password;

  /*
 	Method: passUsername
 	Description: passes username to be used during displaying posts
 	Parameters: none
 	Return: none
 	*/

  public static String passUsername() {

    return username;
  }

  /*
   	Method: verifyingLoginInfo
   	Description: verifies login info. If login info is correct it allows you to login. If not it will display an error message and the reason why the login was unsuccessful.
   	Parameters: event
   	Return: none
   	*/

  public void verifyingLoginInfo(ActionEvent event) throws IOException {
    File inFile = new File("LoginInfo.properties");
    if (!(inFile.exists())) {
      inFile.createNewFile();
    }

    username = LoginUsername.getText().toString();
    password = LoginPassword.getText().toString();

    passUsername();

    HashMap < String, String > loginInfo = new HashMap < String, String > ();
    File file = new File("LoginInfo.properties");

    FileInputStream reader = new FileInputStream(file);
    Properties properties = new Properties();
    properties.load(reader);
    reader.close();

    for (String key: properties.stringPropertyNames()) {
      loginInfo.put(key, properties.get(key).toString());
    }

    if (loginInfo.containsKey(username)) {

      if (password.equals(loginInfo.get(username))) {

        loginSuccessfulMessage(); //display login successful message
        changeSceneToMenuController(event); //call method that would go to option display scene
      } else {
        loginUnsuccessfulMessage(); //display error in user or pass message	
      }

    } else {

      accountDoesNotExistMessage(); //display no such account exists message

    }
  }

  //Displaying  Messages to User

  /*
   	Method: loginSuccessfulMessage
   	Description: Pops up a confirmation message if login in was successful 
   	Parameters: none
   	Return: none
   	*/

  public void loginSuccessfulMessage() {
    Alert a = new Alert(AlertType.NONE);
    a.setAlertType(AlertType.CONFIRMATION);
    a.setContentText("Login is successful!");
    a.show();

  }

  /*
   	Method: loginUnsuccessfulMessage
   	Description: Pops up an error message if login in was unsuccessful because the account password was entered wrong
   	Parameters: none
   	Return: none
   	*/

  public void loginUnsuccessfulMessage() {

    Alert a = new Alert(AlertType.NONE);
    a.setAlertType(AlertType.ERROR);
    a.setContentText("Login is unsuccesful! Please enter a correct password.");
    a.show();

  }

  /*
   	Method: accountDoesNotExistMessage
   	Description: Pops up an error message if login in was unsuccessful because the account does not exist
   	Parameters: none
   	Return: none
   	*/

  public void accountDoesNotExistMessage() {

    Alert a = new Alert(AlertType.NONE);
    a.setAlertType(AlertType.ERROR);
    a.setContentText("Login is unsuccesful! No account with this username exists.");
    a.show();

  }

  //Changing Scenes 

  /*
   	Method: changeSceneToWelcomePage
   	Description: changes scene from LoginPage.fxml to WelcomePage.fxml
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

  /*
   	Method: changeSceneToOptionDisplay
   	Description: changes scene from LoginPage.fxml to OptionDisplay.fxml
   	Parameters: event
   	Return: none
   	*/

  @FXML
  void changeSceneToMenuController(ActionEvent event) throws IOException {

    mainPane = FXMLLoader.load(getClass().getResource("MenuController.fxml"));
    Scene LoginScene = new Scene(mainPane);
    Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
    window.setScene(LoginScene);
    window.show();
    mainPane.setBackground(new Background(new BackgroundFill(Color.rgb(151, 187, 255, 1), null, null)));
  }

}