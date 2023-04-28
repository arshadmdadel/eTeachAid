package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    @FXML
    private TextField stdclasstf;

    @FXML
    private ImageView image;

    @FXML
    private TextField stdnametf;
    String username,email;


    public void handleCollectImage(ActionEvent event) throws FileNotFoundException {
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
            Image imageshow = new Image(new FileInputStream(fileName));

            // Set the image to the image view
            image.setImage(imageshow);
        }


    }
    void setText(String username,String email){
        this.username=username;
        this.email=email;
        emailtf.setText(email);
    }


    public void submit(ActionEvent event) throws IOException{
        UsernameController x=new UsernameController();
        String address=null;
        String Name=nametf.getText();
        String password=passwordtf.getText();
        String cnfpassword=cnfpasswordtf.getText();
        String contact=contacttf.getText();
        String STDName = stdnametf.getText();
        String STDClass = stdclasstf.getText();
        emailtf.setText(email);
        if (password.equals(cnfpassword)) {

            FileWriter f = new FileWriter("src/main/resources/com/example/edutech/Accountinformation.txt");
            PrintWriter write = new PrintWriter(f);
            write.println("Parent%s%d" + username + "%s%d" + email + "%s%d" + password);
            write.close();
            f.close();
            PrintWriter wr = new PrintWriter(new FileWriter("src/main/resources/com/example/edutech/Parentinfo.txt"));
            wr.println(username + "%s%d" + email + "%s%d" + password + "%s%d" + Name + "%s%d" + address + "%s%d" + contact + "%s%d" +STDName+ "%s%d" +STDClass+ "%s%d");
            wr.close();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
            Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            loginStage.setScene(new Scene(root));
        }

    }

    public void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("starting.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow(); // then cast to stage to get the window
        loginStage.setScene(new Scene(root));
    }
}
