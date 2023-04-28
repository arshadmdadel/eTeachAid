package com.example.edutech;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class studentedit {



    @FXML
    private TextArea address;

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
        private RadioButton female;

        @FXML
        private RadioButton male;

    @FXML
    private Label username;

    @FXML
    private ImageView image;


        String name=nametf.getText();
        String clas=classtf.getText();
        String age=agetf.getText();
        String institue=institutetf.getText();
        String email = emailtf.getText();
        String pass=passtf.getText();
        String confirmpass=conpasstf.getText();
        String phone=phonetf.getText();
        String Address=address.getText();


    void handleCollectImage(ActionEvent event) throws FileNotFoundException
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
                image.setImage(imageshow);
            }
        }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Getsetusername a=new Getsetusername();
            String Username=a.getUsername();
            BufferedReader read=new BufferedReader(new FileReader("src/main/resources/com/example/edutech/student.txt"));
            while (true){
                String line=read.readLine();
                if (line==null){
                    break;
                }
                else{
                    String []parts=line.split("%s%d");
                    if (parts[1].equals(Username)){
                        username.setText(parts[1]);
                        emailtf.setText(parts[2]);
                        passtf.setText(parts[3]);
                        conpasstf.setText(parts[3]);
                        nametf.setText(parts[4]);
                        address.setText(parts[5]);
                        phonetf.setText(parts[6]);
                        agetf.setText(parts[7]);
                        classtf.setText(parts[8]);
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

