//Tyler Holstein hnq631

package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*

Class: MenuController
Description: This class contains the event handlers, message displays, and more

*/
public class PostController {

	@FXML private Button discardBtn;
	@FXML private Button postBtn; 
	@FXML private Button menuBtn;
	@FXML private TextField usernameTxt;
	@FXML private TextArea postTxt;
	@FXML private AnchorPane mainPane;
	
	
	//changing scenes 
	
	/*
   	Method: homeScene
   	Description: changes scenes from PostController.fxml back to MenuController.fxml 
   	Parameters: event
   	Return: none
   	*/
	
	    public void homeScene(ActionEvent event) throws IOException {
		mainPane = FXMLLoader.load(getClass().getResource("MenuController.fxml"));
        Scene LoginScene = new Scene(mainPane);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
        mainPane.setBackground(new Background(new BackgroundFill(Color.rgb(151, 187, 255, 1), null, null)));
	}
	
	    /*
	   	Method: addPost
	   	Description: This method takes the user's post and stores it within a hashmap along with their username attached to the post
	   	Parameters: event
	   	Return: none
	   	*/   
	    
	public void addPost(ActionEvent event) throws IOException {
		String userInput = postTxt.getText(); // gathers user input from the post text area
		String username = usernameTxt.getText(); // gathers username from the textfield 
		
		model.Model.addPost(event, username, userInput);
		
        usernameTxt.clear(); //clears the txt area and txt fields
        postTxt.clear(); 	
        
	}
	
	/*
   	Method: discardTxt
   	Description: When the user clicks the button, it discards the post the user was writing
   	Parameters: event
   	Return: none
   	*/
	
	public void discardTxt(ActionEvent event) {
		postTxt.clear();
	}
	
	/*
   	Method: initialize
   	Description: This populates the usernameTxt textfield with the user name that was givn at the login stage
   	Parameters: none
   	Return: none
   	*/
	
	public void initialize() throws IOException{
		
        usernameTxt.setText(LoginController.passUsername());
        
	}
}

