package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

public class LoginController {

    String username;
    String password;

    @FXML
    private ImageView id;

    @FXML
    private ImageView pass;

    @FXML
    private PasswordField passwordtextfield;

    @FXML
    private ImageView signin;

    @FXML
    private TextField usertxtfeidl;
    public static  String use="";

    @FXML
    void backbtn(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("starting.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));

    }

    @FXML
    void forgetbtn(MouseEvent event) {

    }

    @FXML
    void rememberbtn(ActionEvent event) {

    }

    @FXML
    void signinbtn(ActionEvent event) throws IOException {


        if (usertxtfeidl.getText().isEmpty() || passwordtextfield.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }


        FileReader fr = new FileReader("src/main/resources/com/example/edutech/Accountinformation.txt");

        BufferedReader br = new BufferedReader(fr);


        while (true) {
            String line = br.readLine();
            if (line == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Password or username doesn't match");
                alert.showAndWait();
                break;
            }
            else if (line.length() != 0) {
                String[] parts = line.split("%s%d");
                String acc=parts[0];
                 username = parts[1];
                 password = parts[3];
                String email = parts[2];

                if (usertxtfeidl.getText().equals(this.username)||usertxtfeidl.getText().equals(email) &&passwordtextfield.getText().equals(this.password)) {
                    if (passwordtextfield.getText().equals(this.password)) {
                        if (parts[0].equals("Tutor")){this.use=username;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("tuitionDashboard.fxml"));
                            Parent root = loader.load();
                            Stage msgStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                            msgStage.setScene(new Scene(root));


                    break;}
                        else if (parts[0].equals("Student")){
                            System.out.println(username);this.use=username;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentDashboard.fxml"));
                            Parent root = loader.load();
                            Stage msgStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                            msgStage.setScene(new Scene(root));
//                            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StudentDashboard.fxml")));
//                            Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
//                            loginStage.setScene(new Scene(root));
                            break;
                        }
                    }
                }


                    }

//                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
//                Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
//                loginStage.setScene(new Scene(root));

            }
        br.close();
        fr.close();

        }


            @FXML
            void signupbtn (ActionEvent event) throws IOException {

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
                Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();

                loginStage.setScene(new Scene(root));
            }

        }



