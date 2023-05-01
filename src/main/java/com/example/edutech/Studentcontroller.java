package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.ResourceBundle;

public class Studentcontroller implements Initializable {


  @FXML
  private Button next,back;


  @FXML
  private CheckBox c1;

  @FXML
  private CheckBox c2;

  @FXML
  private Label l1;

  @FXML
  private Label l10;

  @FXML
  private Label l11;

  @FXML
  private Label l2;

  @FXML
  private Label l3;

  @FXML
  private Label l4;

  @FXML
  private Label l5;

  @FXML
  private Label l6;

  @FXML
  private Label l7;

  @FXML
  private Label l8;

  @FXML
  private Label l9;

  @FXML
  private TextField t1;

  @FXML
  private TextField t2;

  @FXML
  private TextField t3;

  @FXML
  private TextField t4;

  @FXML
  private TextField t5;

  @FXML
  private TextField t6;

  @FXML
  private TextField t7;

  @FXML
  private TextField t8;

  @FXML
  private TextField t9;

  @FXML
  private ImageView image;

  @FXML
  private Button chooseimage;

  String username;
  String email;
  String gender;

  String filename="";

  void setText(String username,String email){
    this.username=username;
    this.email=email;
    t5.setText(email);
  }
  public void handleCollectImage(ActionEvent event) throws FileNotFoundException {
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
    fileChooser.setFileFilter(filter);
    int result = fileChooser.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
       filename = username+".png";
      Path destination = Paths.get( filename); // Specify the destination folder where you want to store the picture
      try (InputStream inputStream = Files.newInputStream(selectedFile.toPath());
           OutputStream outputStream = new FileOutputStream(destination.toFile())) {
        byte[] buffer = new byte[4096];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
          outputStream.write(buffer, 0, length);
        }
        System.out.println("Picture has been stored successfully.");
      } catch (IOException e) {
        e.printStackTrace();
      }

      // Load the image from a file
      Image imageshow = new Image(new FileInputStream(filename));

      // Set the image to the image view
      image.setImage(imageshow);
    }


  }

  @FXML
  void onnextclick(ActionEvent event) throws IOException {

    if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || t5.getText().isEmpty() || t6.getText().isEmpty() || t7.getText().isEmpty() || t8.getText().isEmpty() || t9.getText().isEmpty() || filename.isEmpty()) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Error");
      alert.setContentText("Please fill all the fields");
      alert.showAndWait();
    } else {

    String name = t1.getText();
    String clas = t2.getText();
    String age = t3.getText();
    String institue = t4.getText();
    email = t5.getText();
    String pass = t6.getText();
    String confirmpass = t7.getText();
    String phone = t8.getText();
    String address = t9.getText();
    if (pass.equals(confirmpass)) {

      FileWriter f = new FileWriter("src/main/resources/com/example/edutech/Accountinformation.txt", true);

      PrintWriter write = new PrintWriter(f);
      write.println("Student%s%d" + username + "%s%d" + email + "%s%d" + pass);
      write.close();
      f.close();
      PrintWriter wr = new PrintWriter(new FileWriter("src/main/resources/com/example/edutech/student.txt", true));
      wr.println(institue+"%s%d" + username + "%s%d" + email + "%s%d" + pass + "%s%d" + name + "%s%d" + address + "%s%d" + phone + "%s%d" + age + "%s%d" + clas + "%s%d" + gender + "%s%d");
      wr.close();
      CodeandTime a = new CodeandTime();
      String Code = a.generateRandomCode();
      String Time = a.time();
      PrintWriter p = new PrintWriter(new FileWriter("src/main/resources/com/example/edutech/studenttuituionpost.txt", true));
      p.print(Time + "%s%d" + Code + "%s%d" + username + "%s%d" + name + "%s%d" + phone + "%s%d" + address + "%s%d" + clas + "%s%d" + gender + "%s%d+");
      p.close();

      FXMLLoader loader = new FXMLLoader(getClass().getResource("Studentnext.fxml"));
      Parent root = loader.load();
      studentnextController d = loader.getController();
      d.setText(username);
      Stage msgStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
      msgStage.setScene(new Scene(root));
    }
    else {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Fix the Error");
      alert.setContentText("Password or username doesn't match");
      alert.showAndWait();
    }

  }
  }

  @FXML
  void onbackclick(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
    Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
    loginStage.setScene(new Scene(root));
  }
  @FXML
  void female(ActionEvent event) {
    gender="female";


  }

  @FXML
  void male(ActionEvent event) {
gender="male";
  }


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }
}
