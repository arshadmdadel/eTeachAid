package com.example.edutech;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Studentnext extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.edutech.TutorApplication.class.getResource("studentnext.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("E-TeachAid");
        stage.setScene(scene);
        stage.show();
    }
}
