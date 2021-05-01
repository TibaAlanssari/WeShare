//Tiba Al Anssari fso799

package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*

Class: WelcomePageController
Description: This class has the code for WelcomePage.fxml actions

*/

public class WelcomePageController {

  @FXML
  private Button LoginButton;

  @FXML
  private Button SignupButton;

  @FXML
  private Button QuitButton;

  @FXML
  private AnchorPane mainPane;

  //changing scenes 

  /*
   	Method: changeSceneToLoginPage
   	Description: changes scene from WelcomePage.fxml to LoginPage.fxml
   	Parameters: event
   	Return: none
   	*/

  @FXML
  public void changeSceneToLoginPage(ActionEvent event) throws IOException {

    mainPane = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
    Scene LoginScene = new Scene(mainPane);
    Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
    window.setScene(LoginScene);
    window.show();
    mainPane.setBackground(new Background(new BackgroundFill(Color.rgb(151, 187, 255, 1), null, null)));
  }

  /*
	Method: changeSceneToSignUpPage
	Description: changes scene from WelcomePage.fxml to SignUpPage.fxml
	Parameters: event
	Return: none
	*/

  @FXML
  public void changeSceneToSignUpPage(ActionEvent event) throws IOException {

    mainPane = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
    Scene LoginScene = new Scene(mainPane);
    Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
    window.setScene(LoginScene);
    window.show();
    mainPane.setBackground(new Background(new BackgroundFill(Color.rgb(151, 187, 255, 1), null, null)));
  }

  //quitting application

  /*
	Method: quitApplication
	Description: quits the application
	Parameters: event
	Return: none
	*/

  @FXML
  public void quitApplication(ActionEvent event) throws IOException {

    Stage stage = (Stage) QuitButton.getScene().getWindow();
    stage.close();
  }

}