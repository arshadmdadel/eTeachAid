package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.ResourceBundle;

public class TutorController implements Initializable {


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
    private ImageView image;


    @FXML
    private TextField pass;

    @FXML
    private TextField work;

    @FXML
    private TextField result;

    String username;

    String E;

    String Gender;

    String Name ;
    String filename="";


     @FXML
     public void handleCollectImage(ActionEvent event) throws FileNotFoundException {
         JFileChooser fileChooser = new JFileChooser();
         FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
         fileChooser.setFileFilter(filter);
         int result = fileChooser.showOpenDialog(null);
         if (result == JFileChooser.APPROVE_OPTION) {
             File selectedFile = fileChooser.getSelectedFile();
              filename = username+".png";
             Path destination = Paths.get( filename); // Specify the destination folder where you want to store the picture
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
             Image imageshow = new Image(new FileInputStream(filename));

             // Set the image to the image view
             image.setImage(imageshow);
         }


     }

    void setText(String username, String mail) {
        this.username = username;
        this.E = mail;
        email.setText(mail);
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

        if (name.getText().isEmpty() || pass.getText().isEmpty() || work.getText().isEmpty() || work.getText().isEmpty() || conpass.getText().isEmpty() || work.getText().isEmpty() || institue.getText().isEmpty() || email.getText().isEmpty() || age.getText().isEmpty() || address.getText().isEmpty()  || filename.isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();

        }
        else {

            String Name = name.getText();
            String profession = work.getText();
            String Age = age.getText();
            String Institue = institue.getText();
            String Email = email.getText();
            String password = pass.getText();
            String confirmpass = conpass.getText();
            String Address = address.getText();
            String resu = result.getText();
            if (password.equals(confirmpass)) {
                FileWriter f = new FileWriter("src/main/resources/com/example/edutech/Accountinformation.txt", true);
                PrintWriter write = new PrintWriter(f);

                write.println("Tutor%s%d" + username + "%s%d" + Email + "%s%d" + password);

                write.close();
                f.close();

                PrintWriter wr = new PrintWriter(new FileWriter("src/main/resources/com/example/edutech/tutor.txt", true));
                wr.print(resu + "%s%d" + username + "%s%d" + Email + "%s%d" + password + "%s%d" + Name + "%s%d" + Age + "%s%d" + Institue + "%s%d" + profession + "%s%d" + Address + "%s%d" + Gender + "%s%d");

                wr.close();


                FXMLLoader loader = new FXMLLoader(getClass().getResource("tutornext.fxml"));
                Parent root = loader.load();
                Stage msgStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                msgStage.setScene(new Scene(root));
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Fix the Error");
                alert.setContentText("Password or username doesn't match");
                alert.showAndWait();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

            String Username=LoginController.use;
            BufferedReader read=new BufferedReader(new FileReader("src/main/resources/com/example/edutech/tutor.txt"));
            while (true){
                String line=read.readLine();
                if (line==null){
                    break;
                }
                else{
                    String []parts=line.split("%s%d");
                    if (parts[1].equals(Username)){
                        email.setText(parts[2]);
                        pass.setText(parts[3]);
                        conpass.setText(parts[3]);
                        name.setText(parts[4]);
                        age.setText(parts[5]);
                        institue.setText(parts[6]);
                        work.setText(parts[7]);
                        address.setText(parts[8]);
                        if (parts[9].equalsIgnoreCase("male")){
                            male.setSelected(true);}
                        else {female.setSelected(true);}

                        break;
                    }
                }
            } read.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}