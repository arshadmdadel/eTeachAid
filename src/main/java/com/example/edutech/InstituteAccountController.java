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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
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
    String username,email;



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
    void setText(String username,String email){
        this.username=username;
        this.email=email;
        emailtf.setText(email);
    }
    @FXML
    void submitbtn(ActionEvent event) throws IOException {
        UsernameController x=new UsernameController();
        String address=addresstf.getText();
        String name=nametf.getText();
        String password=passwordtf.getText();
        String cnfpassword=cnfpasswordtf.getText();
        String contact=contacttf.getText();
        emailtf.setText(email);
        String job=jobtf.getText();
        if (password.equals(cnfpassword)) {

            FileWriter f = new FileWriter("C://Users//User//Downloads//Compressed//Aoop//Aoop//src//main//resources//com//example//edutech//Accountinformation.txt");
            PrintWriter write = new PrintWriter(f);
            write.println("intstitute||" + username + "||" + email + "||" + password);
            write.close();
            f.close();
            PrintWriter wr = new PrintWriter(new FileWriter("C://Users//User//Downloads//Compressed//Aoop//Aoop//src//main//resources//com//example//edutech//InstituteAccountinfo.txt"));
            wr.println(username + "||" + email + "||" + password + "||" + name + "||" + address + "||" + contact + "||" + job);
            wr.close();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
            Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            loginStage.setScene(new Scene(root));
        }
    }

    @FXML
    void suppotbtn(ActionEvent event) {

    }

}
