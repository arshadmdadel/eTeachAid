package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class PostedtuitionController {

    @FXML
    private Button Apply;

    @FXML
    private Label Class;

    @FXML
    private Label Salary;

    @FXML
    private Label adress;

    @FXML
    private Label dateandtime;

    @FXML
    private TextArea details;

    @FXML
    private Label number;

    @FXML
    private Label prefertime;

    @FXML
    private Label prefertuition;

    @FXML
    private Label subject;

    @FXML
    private Label tuitionid;

    public  void setData(Tuitionpost tuitionpost){
        dateandtime.setText(tuitionpost.getTime());
        Class.setText(tuitionpost.getClas());
        Salary.setText(tuitionpost.getSalary());
        tuitionid.setText(tuitionpost.getId());
        prefertime.setText(tuitionpost.getPrefertime());
        prefertuition.setText(tuitionpost.getPrefertutor());
        subject.setText(tuitionpost.getPrefersubject());
        details.setText(tuitionpost.getDescription());
        number.setText("Number :"+tuitionpost.getNumber());
        adress.setText(tuitionpost.getAddress());
    }

    @FXML
    void applybtn(ActionEvent event) {

    }

}
