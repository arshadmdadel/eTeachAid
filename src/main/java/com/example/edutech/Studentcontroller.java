package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Objects;

public class Studentcontroller {


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

  String username;
  String email;
  String gender;

  void setText(String username,String email){
    this.username=username;
    this.email=email;
    t5.setText(email);
  }

  @FXML
  void onnextclick(ActionEvent event) throws IOException {

    if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || t5.getText().isEmpty() || t6.getText().isEmpty() || t7.getText().isEmpty() || t8.getText().isEmpty() || t9.getText().isEmpty()  ){
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Error");
      alert.setContentText("Please fill all the fields");
      alert.showAndWait();
      return;
    }


    String name=t1.getText();
    String clas=t2.getText();
    String age=t3.getText();
    String institue=t4.getText();
    email=t5.getText();
    String pass=t6.getText();
    String confirmpass=t7.getText();
    String phone=t8.getText();
    String address=t9.getText();
    if(pass.equals(confirmpass)){
      FileWriter f = new FileWriter("src/main/resources/com/example/edutech/student.txt",true);
      PrintWriter write = new PrintWriter(f);
      write.println("Student||" + username + "||" + email + "||" + pass);
      write.close();
      f.close();
      PrintWriter wr = new PrintWriter(new FileWriter("src/main/resources/com/example/edutech/student.txt",true));
      wr.print(username + "||" + email + "||" + pass + "||" + name + "||" + address + "||" + phone + "||" + age+"||"+ clas +"||"+ gender +"||");
      wr.close();
    }

    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Studentnext.fxml")));
    Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
    loginStage.setScene(new Scene(root));
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




}
