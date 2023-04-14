package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class parentcontroller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private PasswordField passwordtf;
    @FXML
    private PasswordField cnfpasswordtf;
    @FXML
    private TextField nametf;
    @FXML
    private TextField contacttf;
    @FXML
    private TextField emailtf;
    String username,email;

    void setText(String username,String email){
        this.username=username;
        this.email=email;
        emailtf.setText(email);
    }


    public void submit(ActionEvent event) throws IOException{
        UsernameController x=new UsernameController();
        String address=null;
        String name=nametf.getText();
        String password=passwordtf.getText();
        String cnfpassword=cnfpasswordtf.getText();
        String contact=contacttf.getText();
        emailtf.setText(email);
        if (password.equals(cnfpassword)) {

            FileWriter f = new FileWriter("C://Users//User//Downloads//Compressed//Aoop//Aoop//src//main//resources//com//example//edutech//Accountinformation.txt");
            PrintWriter write = new PrintWriter(f);
            write.println("Parent :||" + username + "||" + email + "||" + password);
            write.close();
            f.close();
            PrintWriter wr = new PrintWriter(new FileWriter("C://Users//Nirab//Desktop//eTeachAid-master//eTeachAid-master//src//main//resources//com//example//edutech//Parentinfo.txt"));
            wr.println(username + "||" + email + "||" + password + "||" + name + "||" + address + "||" + contact + "||");
            wr.close();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
            Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            loginStage.setScene(new Scene(root));
        }

    }

    public void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); // then cast to stage to get the window
        loginStage.setScene(new Scene(root));
    }
}
