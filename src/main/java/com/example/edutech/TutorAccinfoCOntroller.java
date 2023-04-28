package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TutorAccinfoCOntroller implements Initializable {

    @FXML
    private TextField address;

    @FXML
    private TextField age;

    @FXML
    private Button chooseimage;

    @FXML
    private TextField conpass;

    @FXML
    private TextField email;

    @FXML
    private CheckBox female;
    @FXML
    private TextField classs;

    @FXML
    private ImageView imagefield;

    @FXML
    private TextField institue;

    @FXML
    private CheckBox male;

    @FXML
    private TextField name;

    @FXML
    private Button next;

    @FXML
    private TextField pass;

    @FXML
    private TextField preferarea;

    @FXML
    private TextField prefersub;

    @FXML
    private TextField prefertime;

    @FXML
    private Label username;

    @FXML
    private TextField work;

    @FXML
    private TextField workexp;




    @FXML
    void female(ActionEvent event) {

    }

    @FXML
    void handleCollectImage(ActionEvent event) throws FileNotFoundException {
        {
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
                imagefield.setImage(imageshow);
            }


        }

    }

    @FXML
    void male(ActionEvent event) {

    }

    @FXML
    void onnextclick(ActionEvent event) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/com/example/edutech/tutor.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();

        // Find the account information that needs to be modified
        String accountToModify = "John,Smith,123-45-6789";
        int indexToModify = -1;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith(accountToModify)) {
                indexToModify = i;
                break;
            }
        }
        if (indexToModify == -1) {
            System.out.println("Account not found.");
            return;
        }

        // Modify the account information
        String newAccountInfo = "John,Smith,987-65-4321,5000.00";
        lines.set(indexToModify, newAccountInfo);

        // Write the modified account information back to the file
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/com/example/edutech/tutor.txt"));
        for (String modifiedLine : lines) {
            writer.write(modifiedLine + "\n");
        }
        writer.close();

        System.out.println("Account information modified successfully.");


    }
    String subjct="";
    String time="";
    String clas="";
    String area="";
    String expre="";
                       String Username="";
                        String Pass="";
                        String cnpass="";
                        String Name="";
                        String Age="";
                        String Institue="";
                        String Work;
                        String Address="";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Getsetusername a=new Getsetusername();
            String Username=a.getUsername();
            BufferedReader read=new BufferedReader(new FileReader("src/main/resources/com/example/edutech/tutor.txt"));
            while (true){
                String line=read.readLine();
                if (line==null){
                    break;
                }
                else{
                    String []parts=line.split("%s%d");
                    if (parts[1].equals(Username)){
                        username.setText(parts[1]);

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

                        for (int i = 10; i < parts.length; i++) {
                            if (parts[i].startsWith("PreferSubject")) {
                                String subString = parts[i].replaceFirst("PreferSubject", " ");
                                subjct = subjct.concat(subString);
                            } else if (parts[i].startsWith("PreferTime")) {
                                String timeString = parts[i].replaceFirst("PreferTime", " ");
                                time = time.concat(timeString);
                            } else if (parts[i].startsWith("PreferClass")) {
                                String genString = parts[i].replaceFirst("PreferClass", " ");
                                clas = clas.concat(genString);
                            } else if (parts[i].startsWith("PreferArea")) {
                                String salaryString = parts[i].replaceFirst("PreferArea", " ");
                                area = area.concat(salaryString);
                            } else if (parts[i].startsWith("Experience")) {
                                String desyString = parts[i].replaceFirst("Experience", " ");
                                expre = desyString;
                            }


                        }
                        prefersub.setText(subjct);
                        preferarea.setText(area);
                        classs.setText(clas);
                        prefertime.setText(time);
                        workexp.setText(expre);
                        break;
                    }
                }
            } read.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

