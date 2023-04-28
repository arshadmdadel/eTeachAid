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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        private RadioButton genderfemale;

        @FXML
        private RadioButton gendermale;

    @FXML
    private Label username;

    @FXML
    private ImageView image;

    public void submit(ActionEvent event) throws IOException {
        String name=nametf.getText();
        String clas=classtf.getText();
        String age=agetf.getText();
        String institue=institutetf.getText();
        String email = emailtf.getText();
        String pass=passtf.getText();
        String confirmpass=conpasstf.getText();
        String phone=phonetf.getText();
        String Address=address.getText();

    }
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
                image.setImage(imageshow);
            }


        }

    }

    }

