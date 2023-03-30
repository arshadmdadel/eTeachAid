package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InstituteAccountController {

    @FXML
    private TextField addresstf;

    @FXML
    private PasswordField cnfpasswordtf;

    @FXML
    private TextField contacttf;

    @FXML
    private TextField emailtf;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private TextArea jobtf;

    @FXML
    private TextField nametf;

    @FXML
    private PasswordField passwordtf;

    @FXML
    void backbtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));
    }

    @FXML
    void forgrtpassbtn(MouseEvent event) {

    }

    @FXML
    void rememberbtn(ActionEvent event) {

    }

    @FXML
    void submitbtn(ActionEvent event) {

    }

    @FXML
    void suppotbtn(ActionEvent event) {

    }

}
