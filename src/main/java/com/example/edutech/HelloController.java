package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    int x;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void backbtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("starting.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));
    }

    public void switchtoparent(ActionEvent event) throws IOException{ x=1;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("username.fxml"));
        Parent root = loader.load();
        UsernameController d = loader.getController();
        d.setTxt(x);
        Stage msgStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        msgStage.setScene(new Scene(root));
    }
    public void switchtocoaching(ActionEvent event) throws IOException{ x=2;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("username.fxml"));
        Parent root = loader.load();
        UsernameController d = loader.getController();
        d.setTxt(x);
        Stage msgStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        msgStage.setScene(new Scene(root));
    }
    public void switchtostudent(ActionEvent event) throws IOException{ x=3;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("username.fxml"));
        Parent root = loader.load();
        UsernameController d = loader.getController();
        d.setTxt(x);
        Stage msgStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        msgStage.setScene(new Scene(root));
    }
    public void switchtocoinstitution(ActionEvent event) throws IOException{ x=4;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("username.fxml"));
        Parent root = loader.load();
        UsernameController d = loader.getController();
        d.setTxt(x);
        Stage msgStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        msgStage.setScene(new Scene(root));
    }
    public void switchtotutor(ActionEvent event) throws IOException{ x=5;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("username.fxml"));
        Parent root = loader.load();
        UsernameController d = loader.getController();
        d.setTxt(x);
        Stage msgStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        msgStage.setScene(new Scene(root));
    }


}