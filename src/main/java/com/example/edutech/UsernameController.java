package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

public class UsernameController {
    private int x;
    void setTxt(int x){
        this.x=x;
    }

    @FXML
    private TextField emailtf;

    @FXML
    private Label notification;

    @FXML
    private TextField usernametf;
    String username,email;
    @FXML
    void submitbtn(ActionEvent event) throws IOException {
        username=usernametf.getText();
        email=emailtf.getText();
        BufferedReader read=new BufferedReader(new FileReader("C://Users//USER//project work//eTeachAid-Asif//src//main//resources//com//example//edutech//Accountinformation.txt"));
        while (true){
            String line= read.readLine();

                if(line==null ) {

                 if (x == 1) {
                        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Parent.fxml")));
                        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                        loginStage.setScene(new Scene(root));

                    } else if (x == 2) {
                     Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Coaching.fxml")));
                     Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                     loginStage.setScene(new Scene(root));
                 }
                    else if (x == 3) {
                     FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
                     Parent root = loader.load();
                     InstituteAccountController d = loader.getController();
                     d.setText(username,email);
                     Stage msgStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                     msgStage.setScene(new Scene(root));
                    }
                    else if (x == 4) {
                     FXMLLoader loader = new FXMLLoader(getClass().getResource("instituteAccount.fxml"));
                     Parent root = loader.load();
                     InstituteAccountController d = loader.getController();
                     d.setText(username,email);
                     Stage msgStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                     msgStage.setScene(new Scene(root));

                    }
                    else if (x == 5) {
                        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Tutor.fxml")));
                        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                        loginStage.setScene(new Scene(root));

                    }
                    break;
                }
                else
                {
                    String []parts =line.split("||");
                    if(parts[1].equals(username)||parts[2].equals(email)){
                        notification.setText("THis information already used \n please try another");
                        break;
                    }
            }
                
        }read.close();
    }


}
