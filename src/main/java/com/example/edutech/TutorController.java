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

public class TutorController {


    @FXML
    Button next;

    @FXML
    private Button Back;

    @FXML
    private TextField address;

    @FXML
    private TextField age;

    @FXML
    private TextField conpass;

    @FXML
    private TextField email;

    @FXML
    private CheckBox female;

    @FXML
    private TextField institue;

    @FXML
    private CheckBox male;

    @FXML
    private TextField name;


    @FXML
    private TextField pass;

    @FXML
    private TextField work;

    String username;

    String E;

    String Gender;

    void setText(String username, String email) {
        this.username = username;
        this.E = email;

    }


    @FXML
    void female(ActionEvent event) {
        Gender = "female";

    }

    @FXML
    void male(ActionEvent event) {
        Gender = "Male";

    }

    @FXML
    void onbackclick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));

    }


    @FXML
    void onnextclick(ActionEvent event) throws IOException {

        if (name.getText().isEmpty() || pass.getText().isEmpty() || work.getText().isEmpty() || work.getText().isEmpty() || conpass.getText().isEmpty() || work.getText().isEmpty() || institue.getText().isEmpty() || email.getText().isEmpty() || age.getText().isEmpty() || address.getText().isEmpty()  ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }

        String Name = name.getText();
        String profession = work.getText();
        String Age = age.getText();
        String Institue = institue.getText();
        String Email = email.getText();
        String password = pass.getText();
        String confirmpass = conpass.getText();
        String Address = address.getText();
        if (password.equals(confirmpass)) {
            FileWriter f = new FileWriter("C://Users//USER//project work//eTeachAid-Asif//src//main//resources//com//example//edutech//Accountinformation.txt", true);
            PrintWriter write = new PrintWriter(f);
            write.println("Tutor||" + username + "||" + Email + "||" + password);
            write.close();
            f.close();

            PrintWriter wr = new PrintWriter(new FileWriter("C://Users//USER//project work//eTeachAid-Asif//src//main//resources//com//example//edutech//tutor.txt", true));
            wr.print("Tutor : ||" + Name + "||" + Email + "||" + Age + "||" + Institue + "||" + profession + "||" + Address + "||" + Gender);
            wr.close();


            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("tutornext.fxml")));
            Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            loginStage.setScene(new Scene(root));
        }

    }
}