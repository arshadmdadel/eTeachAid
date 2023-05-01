package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class FindnewController implements Initializable {

    @FXML
    private Label Class;

    @FXML
    private Label Salary;
    @FXML
    private Label number;

    @FXML
    private Label adress;

    @FXML
    private Label dateandtime;

    @FXML
    private TextArea details;

    @FXML
    private Label prefertime;

    @FXML
    private Label prefertuition;

    @FXML
    private Label subject;

    @FXML
    private Label tuitionid;
    @FXML
    private Button Apply;
    String applieid;
    @FXML
    void applybtn(ActionEvent event) throws IOException {
        Apply.setVisible(false);
        Getsetusername a=new Getsetusername();
        String userid=a.getUsername();
        PrintWriter write = new PrintWriter(new FileWriter("src/main/resources/com/example/edutech/ApplytutorandAcceptutor.txt",true));
        write.println(userid+"%s%dAppield "+applieid);
        write.close();
    }

    public  void setData(Tuitionpost tuitionpost){
        dateandtime.setText(tuitionpost.getTime());
        Class.setText(tuitionpost.getClas());
        Salary.setText(tuitionpost.getSalary());
        tuitionid.setText(tuitionpost.getId());
        prefertime.setText(tuitionpost.getPrefertime());
        prefertuition.setText(tuitionpost.getPrefertutor());
        subject.setText(tuitionpost.getPrefersubject());
        details.setText(tuitionpost.getDescription());
        applieid=tuitionpost.getId();
        details.setText(tuitionpost.getDescription());
        adress.setText(tuitionpost.getAddress());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


