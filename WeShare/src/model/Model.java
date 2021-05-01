//Tiba Al Anssari fso799 & Tyler Holstein hnq631

package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import javafx.event.ActionEvent;

public class Model {

  /*
   	Method: addPost
   	Description: This method takes the user's post and stores it within a hashmap along with their username attached to the post
   	Parameters: event, username, userInput
   	Return: none
   	*/

  public static void addPost(ActionEvent event, String username, String userInput) throws IOException {
    File inFile = new File("post.properties"); //opens the properties file within the application package

    HashMap < String, String > h = new HashMap < String, String > (); //creates a hashmap object that contains string and string
    FileInputStream reader = new FileInputStream(inFile); //sets reader object 
    Properties properties = new Properties(); //creates properties object 
    properties.load(reader); //loads the reader object 
    reader.close(); //closes the reader object

    for (String key: properties.stringPropertyNames()) { //takes the existing contents within the properties file and puts it into a hashmap 
      h.put(key, properties.get(key).toString());
    }

    h.put(username, userInput); //takes the username and post input and puts it into the hashmap

    Properties prop = new Properties();

    prop.putAll(h); // puts all of the hashmap data into a prop object
    //System.out.println(h); //this would print the hashmap contents in the console
    File outFile = new File("post.properties"); //creates a file object that contains the properties file we have been using
    FileOutputStream writer = new FileOutputStream(outFile, false);
    prop.store(writer, null); //stores the properties object within the post.properties file

  }

  /*
   	Method: storeLoginInfo
   	Description: stores the Sign Up username and password information to be used for Login
   	Parameters: event, username, password
   	Return: none
   	*/

  public static void storeLoginInfo(ActionEvent event, String username, String password) throws IOException {
    File inFile = new File("LoginInfo.properties");
    if (!(inFile.exists())) {
      inFile.createNewFile();
    }

    HashMap < String, String > loginInfo = new HashMap < String, String > ();
    Properties properties = new Properties();
    loginInfo.put(username, password);

    properties.putAll(loginInfo);

    File outFile = new File("LoginInfo.properties");
    FileOutputStream writer = new FileOutputStream(outFile, true);
    properties.store(writer, null);
  }

}