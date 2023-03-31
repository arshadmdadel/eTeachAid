package com.example.edutech;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Studentnext {
    public static void main(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Student.class.getResource("Studentnext.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("E-TeachAid");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
