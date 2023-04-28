package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

import java.awt.*;
import java.io.IOException;

public class studentedit {



        @FXML
        private TextArea addresstf;

        @FXML
        private TextArea agetf;

        @FXML
        private TextArea classtf;

        @FXML
        private TextArea conpasstf;

        @FXML
        private TextArea emailtf;

        @FXML
        private TextArea institutetf;

        @FXML
        private TextArea nametf;

        @FXML
        private TextArea passtf;

        @FXML
        private TextArea phonetf;
        @FXML
        private RadioButton genderfemale;

        @FXML
        private RadioButton gendermale;

    public void submit(ActionEvent event) throws IOException {
        String name=nametf.getText();
        String clas=classtf.getText();
        String age=agetf.getText();
        String institue=institutetf.getText();
        String email = emailtf.getText();
        String pass=passtf.getText();
        String confirmpass=conpasstf.getText();
        String phone=phonetf.getText();
        String address=addresstf.getText();
        
    }

    }

