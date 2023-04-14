package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

public class LoginController {

    String username;
    String password;

    @FXML
    private ImageView id;

    @FXML
    private ImageView pass;

    @FXML
    private PasswordField passwordtextfield;

    @FXML
    private ImageView signin;

    @FXML
    private TextField usertxtfeidl;

    @FXML
    void backbtn(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("starting.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));

    }

    @FXML
    void forgetbtn(MouseEvent event) {

    }

    @FXML
    void rememberbtn(ActionEvent event) {

    }

    @FXML
    void signinbtn(ActionEvent event) throws IOException {

        if (usertxtfeidl.getText().isEmpty() || passwordtextfield.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }

        Reader fr = new FileReader("C://Users//USER//project work//eTeachAid-Asif//src//main//resources//com//example//edutech//Accountinformation.txt");
        BufferedReader br = new BufferedReader(fr);


        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            if (line.length() != 0) {
                String[] parts = line.split("||");


                String username = parts[1];
                this.username = username;
                String pass = parts[3];
                this.password = pass;
                String email = parts[2];
            }


                if (usertxtfeidl.getText().equals(this.username) && passwordtextfield.getText().equals(this.password)) {
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
                    Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                    loginStage.setScene(new Scene(root));

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error");
                    alert.setContentText("Password or username doesn't match");
                    alert.showAndWait();
                    return;

                }


//                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
//                Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
//                loginStage.setScene(new Scene(root));

            }
        br.close();
        fr.close();

        }


            @FXML
            void signupbtn (ActionEvent event) throws IOException {

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
                Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();

                loginStage.setScene(new Scene(root));
            }

        }



