//Lisette Isais' assigned part for WeShare Project

package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
  
Class: Main
Description: This class displays posts that were created and allows users to comment on them
 
 */

public class ViewPosts {

  @FXML
  private TextArea UserName;

  @FXML
  private TextArea PostContent;

  @FXML
  private Button Next;

  @FXML
  private ListView<String> commentDisplay;

  @FXML
  private TextArea commentBox;

  @FXML
  private Button Post;

  @FXML
  private Button MenuButton;

  @FXML
  private AnchorPane ViewPostsPane;

  @FXML
  private AnchorPane mainPane;

  public int count = 2;
  public int totalPost = 0;

  @FXML

  /*
   * Method: initialize() Description: will display the first post when scene is
   * opened along with previous comments for that post. Parameters: none Return:
   * none
   */

  public void initialize() throws IOException {

    File file = new File("post.properties");
    File comments = new File("comment.properties");

    if (!(comments.exists())) {
      comments.createNewFile();
    }
    if (!(file.exists())) {
      file.createNewFile();
    }

    Map<String, String> h = new LinkedHashMap<>();
    Map<String, String> c = new LinkedHashMap<>();

    FileInputStream reader = new FileInputStream(file);

    Properties properties = new Properties();

    FileInputStream inFile = new FileInputStream(comments);
    Properties Two = new Properties();
    Two.load(inFile);
    inFile.close();

    properties.load(reader);
    reader.close();

    for (String key : properties.stringPropertyNames()) {
      h.put(key, properties.get(key).toString());
      totalPost++;
    }

    for (String key : Two.stringPropertyNames()) {
      c.put(key, Two.get(key).toString());
    }
    Map.Entry<String, String> entry = h.entrySet().iterator().next();
    String user = entry.getKey();
    String message = entry.getValue();
    UserName.setText(user);
    PostContent.setText(message);

    String s1 = UserName.getText();
    commentDisplay.getItems().add(c.get(s1));

  }

  /*
   * Method: nextPost() Description: shows user different posts when the "next"
   * button is clicked and allows for them to comment Parameters: event Return:
   * none
   */

  @FXML
  public void nextPost(ActionEvent event) throws IOException {
    File file = new File("post.properties");
    if (!(file.exists())) {
      file.createNewFile();
    }

    Map<String, String> h = new LinkedHashMap<>();

    FileInputStream reader = new FileInputStream(file);
    Properties properties = new Properties();

    properties.load(reader);
    reader.close();

    for (String key : properties.stringPropertyNames()) {
      h.put(key, properties.get(key).toString());
    }

    Map.Entry<String, String> entry = h.entrySet().iterator().next();

    Iterator<String> valueIterator = h.values().iterator(); // iterate through values
    Iterator<String> keyIterator = h.keySet().iterator(); // iterate through keys
    String user;
    String message;

    if (count <= totalPost) {
      for (int i = 0; i < count; i++) {
        user = entry.getKey();
        message = entry.getValue();
        user = valueIterator.next();
        message = keyIterator.next();

        if (i == count - 1) {
          UserName.setText(message);
          PostContent.setText(user);
          commentDisplay.getItems().clear();
        }
      }
    }
    count++;

  }

  /*
   * Method: displayComments() Description: displays comments from text area to
   * the list view box to demonstrate posted comments Parameters: event Return:
   * none
   */

  @FXML
  public void displayComments(ActionEvent event) throws IOException {
    File file = new File("comment.properties");
    if (!(file.exists())) {
      file.createNewFile();
    }
    String input = commentBox.getText();

    HashMap<String, String> h = new HashMap<String, String>();
    FileInputStream reader = new FileInputStream(file);
    Properties properties = new Properties();

    properties.load(reader);
    reader.close();

    commentDisplay.getItems().add(input);

    // stores items into hashmap
    for (String key : properties.stringPropertyNames()) {
      h.put(key, properties.get(key).toString());
    }

    h.put(UserName.getText(), input);

    Properties prop = new Properties();
    prop.putAll(h);

    File outFile = new File("comment.properties");
    FileOutputStream writer = new FileOutputStream(outFile);
    prop.store(writer, null);

    commentBox.clear();

  }

  /*
   * Method: goToMenu() Description: takes the user back to the MenuController
   * Parameters: event Return: none
   */

  public void goToMenu(ActionEvent event) throws IOException {

    mainPane = FXMLLoader.load(getClass().getResource("MenuController.fxml"));
    Scene LoginScene = new Scene(mainPane);
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(LoginScene);
    window.show();
    mainPane.setBackground(new Background(new BackgroundFill(Color.rgb(151, 187, 255, 1), null, null)));

  }

}