package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AcceptedtutorController {

    @FXML
    private Button Apply;

    @FXML
    private Label Class;

    @FXML
    private Label Salary;

    @FXML
    private Label adress;

    @FXML
    private Label name;

    @FXML
    private Label number;

    @FXML
    private Label prefertime;

    @FXML
    private Label prefertuition;

    @FXML
    private Label profession;

    @FXML
    private Rectangle rectangle;

    @FXML
    private Label result;

    @FXML
    private Label subject;

    @FXML
    private Label tuitionid;

    @FXML
    private TextArea workexperience;
    void setData(Tutordetais tutordetais) throws FileNotFoundException {
        subject.setText(tutordetais.getclass());
        tuitionid.setText(tutordetais.getTuitionid());
        result.setText(tutordetais.getResult());
        prefertime.setText(tutordetais.getPrefertime());
        profession.setText(tutordetais.getProfession());
        prefertuition.setText(tutordetais.getPrefertuition());
        number.setText(tutordetais.getNumber());
        name.setText(tutordetais.getName());
        Salary.setText(tutordetais.getSalary());
        adress.setText(tutordetais.getAdress());
        Class.setText(tutordetais.getclass());
        String r=tutordetais.getRectangle();
        Image imageshow = new Image(new FileInputStream(r));
        rectangle.setFill(new ImagePattern(imageshow));
    }

    @FXML
    void decline(ActionEvent event) {

    }

}

