package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.io.*;

public class TutorRequestController {


    @FXML
    private Button Apply;

    @FXML
    private Label Salary;

    @FXML
    private TextField cla;

    @FXML
    private Label prefertime;

    @FXML
    private Label prefertuition;

    @FXML
    private Label profession;

    @FXML
    private Label result;

    @FXML
    private Label subject;

    @FXML
    private Label tuitionid;

    @FXML
    private TextArea workexperience;
    String ap,usenam;
    void setData(Tutordetais tutordetais) throws FileNotFoundException {
        profession.setText(tutordetais.getProfession());
        tuitionid.setText(tutordetais.getTuitionid());
        subject.setText(tutordetais.getSubject());
        prefertuition.setText(tutordetais.getPrefertuition());
        prefertime.setText(tutordetais.getPrefertime());
        subject.setText(tutordetais.getSubject());
        workexperience.setText(tutordetais.getWorkexperience());
        result.setText(tutordetais.getResult());
        cla.setText(tutordetais.getlass());
        Salary.setText(tutordetais.getSalary());
        ap=tutordetais.getTuitionid();
        usenam=tutordetais.getUsername();
    }

    @FXML
    void Accept(ActionEvent event) throws IOException {
        Apply.setVisible(false);
        PrintWriter write = new PrintWriter(new FileWriter("src/main/resources/com/example/edutech/ApplytutorandAcceptutor.txt",true));
        write.println(usenam+"%s%dAccept "+ap);
        write.close();
    }

}
