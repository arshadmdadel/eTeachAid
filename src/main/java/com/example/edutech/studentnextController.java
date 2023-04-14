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
       filewrite("BIOLOGY");


    }

    @FXML
    void CHEM(ActionEvent event) throws IOException {
      filewrite("CHEMISTRY");

    }

    @FXML
    void GM(ActionEvent event) throws IOException {
       filewrite("GENERAL MATH");
    }

    @FXML
    void GS(ActionEvent event) throws IOException {
      filewrite("GENERAL SCIENCE");
    }

    @FXML
    void HM(ActionEvent event) throws IOException {
     filewrite("HIGHER MATH");
    }

    @FXML
    void PHY(ActionEvent event) throws IOException {
        filewrite("PHYSICS");
    }

    @FXML
    void SS(ActionEvent event) throws IOException {
      filewrite("SOCIAL SCIENCE");
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));


    }

    @FXML
    void bang(ActionEvent event) throws IOException {
       filewrite("BANGLA");
    }



    @FXML
    void eng(ActionEvent event) throws IOException {
      filewrite("ENglish");
    }

    @FXML
    void evening(ActionEvent event) throws IOException {
        filewrite("Evening");
    }

    @FXML
    void female(ActionEvent event) throws IOException {
        filewrite("FEMALE");

    }

    @FXML
    void male(ActionEvent event) throws IOException {
        filewrite("MALE");

    }

    @FXML
    void morning(ActionEvent event) throws IOException {
        filewrite("MORNING");

    }

    @FXML
    void other(ActionEvent event) throws IOException {
        filewrite("OTHERS");

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
        PrintWriter wr = new PrintWriter(new FileWriter("C://Users//USER//project work//eTeachAid-Asif//src//main//resources//com//example//edutech//student.txt",true));
        wr.println("Salary:||" + expsal + "||||" + dsicrp);
        wr.close();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));


    }


    String name;
    void filewrite(String name) throws IOException{
        PrintWriter wr = new PrintWriter(new FileWriter("C://Users//USER//project work//eTeachAid-Asif//src//main//resources//com//example//edutech//student.txt",true));
        wr.write(name+"||");
        wr.close();

    }
}
