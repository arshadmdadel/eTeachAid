package com.example.edutech;
import com.example.edutech.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;



public class TuitionDashboardController {
    @FXML
    private BorderPane bp;

    @FXML
    private AnchorPane homepan;

    @FXML
    void Acceptetuition(MouseEvent event) {
        loadpage("Acceptution");
    }

    @FXML
    void Accouninfo(MouseEvent event) {
        loadpage("TutorACCINFO");
    }

    @FXML
    void Searchforajob(MouseEvent event) {
        loadpage("Searchforajob");
    }

    @FXML
    void about(MouseEvent event) {

    }

    @FXML
    void appliedtuition(MouseEvent event) {
        bp.setCenter(homepan);
    }

    @FXML
    void contact(MouseEvent event) {

    }

    @FXML
    void findnewtution(MouseEvent event) {
        loadpage("FindnewTuition");
    }

    @FXML
    void message(MouseEvent event) {
        loadpage("Message");
    }

    @FXML
    void services(MouseEvent event) {

    }

    @FXML
    void signupbtn(ActionEvent event) {
        loadpage("login");
    }
    private void loadpage(String page){
        Parent root=null;
        try {
             root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page+".fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        bp.setCenter(root);
    }


}
