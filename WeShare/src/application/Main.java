//WeShare Application
//Group Members: Tiba Al Anssari fso799, Samuel Shiau wbd992, Tyler Holstein hnq631, Lisette Isais szy879, John Le tgy670 

package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

/*

Class: Main
Description: This class opens up the GUI for WelcomePage.fxml 

*/

public class Main extends Application {
  public static final long begin = System.nanoTime(); //used in MenuController.java
  @Override
  public void start(Stage primaryStage) {
    try {
      AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
      Scene scene = new Scene(root, 1300, 900);
      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}