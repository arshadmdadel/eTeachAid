package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

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

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));

    }

    @FXML
    void signupbtn(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();

        loginStage.setScene(new Scene(root));
    }

}
