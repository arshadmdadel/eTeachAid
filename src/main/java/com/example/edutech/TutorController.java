package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class TutorController {


    @FXML
    Button next;

    @FXML
    private Button Back;

    @FXML
    private TextField address;

    @FXML
    private TextField age;

    @FXML
    private TextField conpass;

    @FXML
    private TextField email;

    @FXML
    private CheckBox female;

    @FXML
    private Button chooseimage;

    @FXML
    private TextField institue;

    @FXML
    private CheckBox male;

    @FXML
    private TextField name;


    @FXML
    private TextField pass;

    @FXML
    private TextField work;

    String username;

    String E;

    String Gender;

    String Name = name.getText();

     @FXML
     public void handleCollectImage(ActionEvent event) {
         JFileChooser fileChooser = new JFileChooser();
         FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
         fileChooser.setFileFilter(filter);
         int result = fileChooser.showOpenDialog(null);
         if (result == JFileChooser.APPROVE_OPTION) {
             File selectedFile = fileChooser.getSelectedFile();
             String fileName = username+".png";
             Path destination = Paths.get( fileName); // Specify the destination folder where you want to store the picture
             try (InputStream inputStream = Files.newInputStream(selectedFile.toPath());
                  OutputStream outputStream = new FileOutputStream(destination.toFile())) {
                 byte[] buffer = new byte[4096];
                 int length;
                 while ((length = inputStream.read(buffer)) > 0) {
                     outputStream.write(buffer, 0, length);
                 }
                 System.out.println("Picture has been stored successfully.");
             } catch (IOException e) {
                 e.printStackTrace();
             }
             // Load the image from a file


             // Set the image to the image view

         }


     }

    void setText(String username, String email) {
        this.username = username;
        this.E = email;

    }


    @FXML
    void female(ActionEvent event) {
        Gender = "female";

    }

    @FXML
    void male(ActionEvent event) {
        Gender = "Male";

    }

    @FXML
    void onbackclick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));

    }



    @FXML
    void onnextclick(ActionEvent event) throws IOException {

        if (name.getText().isEmpty() || pass.getText().isEmpty() || work.getText().isEmpty() || work.getText().isEmpty() || conpass.getText().isEmpty() || work.getText().isEmpty() || institue.getText().isEmpty() || email.getText().isEmpty() || age.getText().isEmpty() || address.getText().isEmpty()  ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }


        String profession = work.getText();
        String Age = age.getText();
        String Institue = institue.getText();
        String Email = email.getText();
        String password = pass.getText();
        String confirmpass = conpass.getText();
        String Address = address.getText();
        if (password.equals(confirmpass)) {
            FileWriter f = new FileWriter("src/main/resources/com/example/edutech/Accountinformation.txt", true);
            PrintWriter write = new PrintWriter(f);
            write.println("Tutor%s%d" + username + "%s%d" + Email + "%s%d" + password);
            write.close();
            f.close();

            PrintWriter wr = new PrintWriter(new FileWriter("src/main/resources/com/example/edutech/tutor.txt", true));
            wr.print("Tutor%s%d" + Name + "%s%d" + Email + "%s%d" + Age + "%s%d" + Institue + "%s%d" + profession + "%s%d" + Address + "%s%d" + Gender);
            wr.close();


            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("tutornext.fxml")));
            Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            loginStage.setScene(new Scene(root));
        }

    }
}