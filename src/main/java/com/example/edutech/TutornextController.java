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

public class TutornextController {
    @FXML
    private RadioButton BIO;

    @FXML
    private RadioButton CHEM;

    @FXML
    private RadioButton EVENING;

    @FXML
    private RadioButton GM;

    @FXML
    private RadioButton GS;

    @FXML
    private RadioButton HM;

    @FXML
    private RadioButton MORNING;

    @FXML
    private RadioButton OTHER;

    @FXML
    private RadioButton PHY;

    @FXML
    private RadioButton SS;

    @FXML
    private Button back;

    @FXML
    private RadioButton bang;

    @FXML
    private RadioButton eng;

    @FXML
    private TextField exprn;

    @FXML
    private RadioButton four;

    @FXML
    private RadioButton one;

    @FXML
    private TextField parea;

    @FXML
    private Button submit;

    @FXML
    private RadioButton three;

    @FXML
    private RadioButton two;

    @FXML
    void BIO(ActionEvent event) throws IOException {
        filewrite("PreferSubject BIOLOGY");

    }

    @FXML
    void CHEM(ActionEvent event) throws IOException {
        filewrite("PreferSubject CHEMISTRY");

    }

    @FXML
    void EVENING(ActionEvent event) throws IOException {
        filewrite("PreferTime EVENING");

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
    void MORNING(ActionEvent event) throws IOException {
        filewrite("PreferTime MORNING");

    }

    @FXML
    void OTHER(ActionEvent event) throws IOException {
        filewrite("PreferSubject OTHER");

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
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Tutor.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));

    }

    @FXML
    void bang(ActionEvent event) throws IOException {
        filewrite("PreferSubject BANGLA");

    }

    @FXML
    void eng(ActionEvent event) throws IOException {
        filewrite("PreferSubject ENGLISH");

    }



    @FXML
    void four(ActionEvent event) throws IOException {
        filewrite("PreferClass XI-XII");

    }

    @FXML
    void one(ActionEvent event) throws IOException {
        filewrite("PreferClass I-IV");

    }

    @FXML
    void submit(ActionEvent event) throws IOException {

        if (parea.getText().isEmpty() || exprn.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }

        String Experience=exprn.getText();
        String area=parea.getText();
        PrintWriter wr = new PrintWriter(new FileWriter("src/main/resources/com/example/edutech/tutor.txt",true));
        wr.println("PreferArea " + area + "%s%dExperience " + Experience);
        wr.close();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("tuitionDashboard.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));




    }

    @FXML
    void three(ActionEvent event) throws IOException {
        filewrite("PreferClass IX-X");

    }

    @FXML
    void two(ActionEvent event) throws IOException {
        filewrite("PreferClass V-VIII");

    }
    String name;

    void filewrite(String name) throws IOException{
        PrintWriter wr = new PrintWriter(new FileWriter("src/main/resources/com/example/edutech/tutor.txt",true));

        wr.write(name+"%s%d");

        wr.close();

    }
}
