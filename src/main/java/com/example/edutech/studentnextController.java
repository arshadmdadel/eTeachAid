package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class studentnextController {
    @FXML
    private RadioButton BIO;

    @FXML
    private RadioButton CHEM;

    @FXML
    private RadioButton GM;

    @FXML
    private RadioButton GS;

    @FXML
    private RadioButton HM;

    @FXML
    private RadioButton PHY;

    @FXML
    private RadioButton SS;

    @FXML
    private Button back;

    @FXML
    private RadioButton bang;

    @FXML
    private TextField des;

    @FXML
    private RadioButton eng;

    @FXML
    private RadioButton evening;

    @FXML
    private RadioButton female;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton morning;

    @FXML
    private RadioButton other;

    @FXML
    private Button submit;

    @FXML
    private TextField salary;

    String gender;

    @FXML
    void BIO(ActionEvent event) throws IOException {
       filewrite("PreferSubject BIOLOGY");


    }

    @FXML
    void CHEM(ActionEvent event) throws IOException {
      filewrite("PreferSubject CHEMISTRY");

    }

    @FXML
    void GM(ActionEvent event) throws IOException {
       filewrite("PreferSubject GENERAL MATH");
    }

    @FXML
    void GS(ActionEvent event) throws IOException {
      filewrite("PreferSubject GENERAL SCIENCE");
    }

    @FXML
    void HM(ActionEvent event) throws IOException {
     filewrite("PreferSubject HIGHER MATH");
    }

    @FXML
    void PHY(ActionEvent event) throws IOException {
        filewrite("PreferSubject PHYSICS");
    }

    @FXML
    void SS(ActionEvent event) throws IOException {
      filewrite("PreferSubject SOCIAL SCIENCE");
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));


    }

    @FXML
    void bang(ActionEvent event) throws IOException {
       filewrite("PreferSubject BANGLA");
    }



    @FXML
    void eng(ActionEvent event) throws IOException {
      filewrite("PreferSubject ENglish");
    }

    @FXML
    void evening(ActionEvent event) throws IOException {
        filewrite("PreferTime Evening");
    }

    @FXML
    void female(ActionEvent event) throws IOException {
        filewrite("PreferGender FEMALE");

    }

    @FXML
    void male(ActionEvent event) throws IOException {
        filewrite("PreferGender MALE");

    }

    @FXML
    void morning(ActionEvent event) throws IOException {
        filewrite("PreferTime MORNING");

    }

    @FXML
    void other(ActionEvent event) throws IOException {

    }

    @FXML
    void submit(ActionEvent event)throws IOException {

        if (salary.getText().isEmpty()   ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }

        String dsicrp=des.getText();

        String expsal=salary.getText();
        PrintWriter wr = new PrintWriter(new FileWriter("src/main/resources/com/example/edutech/studenttuituionpost.txt",true));
        wr.println("%s%dPreferSalary " + expsal + "%s%dPreferDescription " + dsicrp);
        wr.close();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("tuitionDashboard.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));


    }


    String name;
    void filewrite(String name) throws IOException{
        PrintWriter wr = new PrintWriter(new FileWriter("src/main/resources/com/example/edutech/studenttuituionpost.txt",true));

        wr.write(name+"%s%d");

        wr.close();

    }
}
