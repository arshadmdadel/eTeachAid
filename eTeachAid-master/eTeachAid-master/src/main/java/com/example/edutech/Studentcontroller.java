package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Studentcontroller {

  @FXML
  private Button button;

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
  void nextbtn(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Studentnext.fxml")));
    Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
    loginStage.setScene(new Scene(root));
  }

}
