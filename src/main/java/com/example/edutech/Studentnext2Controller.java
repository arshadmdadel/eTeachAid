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

import java.io.*;
import java.util.Objects;

public class Studentnext2Controller {

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
    String Subject = "";
    String Time = "";
    String Gender = "";

    @FXML
    void BIO(ActionEvent event) throws IOException {
        Subject = Subject.concat("PreferSubject BIOLOGY %s%d");

    }

    @FXML
    void CHEM(ActionEvent event) throws IOException {
        Subject = Subject.concat("PreferSubject CHEMISTRY %s%d");

    }

    @FXML
    void GM(ActionEvent event) throws IOException {
        Subject = Subject.concat("PreferSubject GENERAL MATH %s%d");
    }

    @FXML
    void GS(ActionEvent event) throws IOException {
        Subject = Subject.concat("PreferSubject GENERAL SCIENCE %s%d");
    }

    @FXML
    void HM(ActionEvent event) throws IOException {
        Subject = Subject.concat("PreferSubject HIGHER MATH %s%d");
    }

    @FXML
    void PHY(ActionEvent event) throws IOException {
        Subject = Subject.concat("PreferSubject PHYSICS %s%d");
    }

    @FXML
    void SS(ActionEvent event) throws IOException {
        Subject = Subject.concat("PreferSubject SOCIAL SCIENCE %s%d");
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StudentDashboard.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));


    }

    @FXML
    void bang(ActionEvent event) throws IOException {
        Subject = Subject.concat("PreferSubject BANGLA %s%d");
    }



    @FXML
    void eng(ActionEvent event) throws IOException {
        Subject = Subject.concat("PreferSubject ENGLISH %s%d");
    }

    @FXML
    void evening(ActionEvent event) throws IOException {
        Time = Time.concat("PreferTime Evening %s%d");
    }

    @FXML
    void female(ActionEvent event) throws IOException {
        Gender = Gender.concat("PreferGender FEMALE %s%d");

    }

    @FXML
    void male(ActionEvent event) throws IOException {
        Gender = Gender.concat("PreferGender MALE %s%d");

    }

    @FXML
    void morning(ActionEvent event) throws IOException {
        Time = Time.concat("PreferTime Morning %s%d");

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

        Getsetusername a = new Getsetusername();String username=a.getUsername();
        CodeandTime c=new CodeandTime();
        String Code=c.generateRandomCode();
        String Time=c.time();
        String name="",phone="",adresss="",classs="",gender="";

        try {
            BufferedReader read=new BufferedReader(new FileReader("src/main/resources/com/example/edutech/student.txt"));
            while (true){
                String line=read.readLine();
                if (line==null){
                    break;
                }
                else{
                    String []parts=line.split("%s%d");
                    if (parts[1].equals(username)){
                        name=parts[4];
                        phone=parts[6];
                        adresss=parts[5];
                        classs=parts[8];
                        gender=parts[9];

                        break;
                    }
                }
            } read.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String dsicrp=des.getText();
        String expsal=salary.getText();
        PrintWriter wr = new PrintWriter(new FileWriter("src/main/resources/com/example/edutech/studenttuituionpost.txt",true));
        wr.println(Time+"%s%d"+Code+"%s%d"+username+"%s%d"+name+"%s%d"+phone+"%s%d"+adresss+"%s%d"+classs+"%s%d"+gender+"%s%d"+Subject+"%s%d"+Time+"%s%d"+Gender+"%s%dPreferSalary " + expsal + "%s%dPreferDescription " + dsicrp);
        wr.close();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StudentDashboard.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));


    }







}
