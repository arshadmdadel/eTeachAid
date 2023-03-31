package com.example.edutech;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class Home extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    double x,y=0;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
        stage.initStyle(StageStyle.UNDECORATED);
        root.setOnMousePressed(event ->{
            x=event.getSceneX();
            y=event.getSceneY();
        } );
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        } );
        stage.setScene(new Scene(root,800,500));
        stage.show();

    }
}
