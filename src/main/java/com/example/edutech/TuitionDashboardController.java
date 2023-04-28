package com.example.edutech;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


public class TuitionDashboardController implements Initializable {
    @FXML
    private BorderPane bp;
    @FXML
    private  ScrollPane scroll;
    @FXML
    private Circle imagefield;

    @FXML
    private VBox vbox;
    private String usenam;
    public  void setUsername(String usenam){
        this.usenam=usenam;
    }

    @FXML
    void Acceptetuition(MouseEvent event) throws IOException {
        vbox.getChildren().clear();
        bp.setCenter(scroll);
        List<Tuitionpost> tuitionaccept=new ArrayList<>(tuitionaccept());
        for (int i=0;i< tuitionappliedd().size();i++){
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Acceptution.fxml"));
            try { VBox vvbox=fxmlLoader.load();
                AcceptutionController cic=fxmlLoader.getController();
                cic.setData(tuitionaccept.get(i));
                vbox.getChildren().add(vvbox);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    @FXML
    void Accouninfo(MouseEvent event) {
        loadpage("TutorACCINFO");
    }

    @FXML
    void Searchforajob(MouseEvent event) {
        loadpage("Searchforajob");
    }

    @FXML
    void about(MouseEvent event) {

    }

    @FXML
    void appliedtuition(MouseEvent event) throws IOException {
        vbox.getChildren().clear();
        bp.setCenter(scroll);
        List<Tuitionpost> tuitionappliedd=new ArrayList<>(tuitionappliedd());
        for (int i=0;i< tuitionappliedd().size();i++){
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Appliedtuition.fxml"));
            try { VBox vvbox=fxmlLoader.load();
                AppliedtuitionController cic=fxmlLoader.getController();
                cic.setData(tuitionappliedd.get(i));
                vbox.getChildren().add(vvbox);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void contact(MouseEvent event) {

    }

    @FXML
    void findnewtution(MouseEvent event) throws IOException {
        vbox.getChildren().clear();
                bp.setCenter(scroll);
        List<Tuitionpost> tuitionposts=new ArrayList<>(tuitionposts());
        for (int i=0;i< tuitionposts().size();i++){
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FindnewTuition.fxml"));
            try { VBox vvbox=fxmlLoader.load();
                FindnewController cic=fxmlLoader.getController();
                cic.setData(tuitionposts.get(i));
                vbox.getChildren().add(vvbox);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    private List<Tuitionpost> tuitionposts() throws IOException {
        BufferedReader readr =new BufferedReader(new FileReader("src/main/resources/com/example/edutech/ApplytutorandAcceptutor.txt"));
        Getsetusername a=new Getsetusername();
        String usernam=a.getUsername();
        String tuiionid="";
        while (true){
            String line=readr.readLine();
            if (line==null){
                break;
            } else {
                String []parts =line.split("%s%d");
                if (parts[0].equals(usernam)&&parts[1].startsWith("Appield")){
                    String subString = parts[1].replaceFirst("Appield", " ");
                    tuiionid = tuiionid.concat(subString);
                }
            }
        }readr.close();
        List<Tuitionpost> ls = new ArrayList<>();
        Tuitionpost tuitionpost;
        BufferedReader reade = new BufferedReader(new FileReader("src/main/resources/com/example/edutech/studenttuituionpost.txt"));
        while (true) {
            String line = reade.readLine();
            if (line == null) {
                break;
            } else {

                tuitionpost = new Tuitionpost();
                String subjct = "";
                String time = "";
                String gender = "";
                String salary = "";
                String description = "";
                String[] parts = line.split("%s%d");
                if (!tuiionid.contains(parts[1])){
                tuitionpost.setTime(parts[0]);
                tuitionpost.setId(parts[1]);
                tuitionpost.setClas(parts[6]);
                for (int i = 7; i < parts.length; i++) {
                    if (parts[i].startsWith("PreferSubject")) {
                        String subString = parts[i].replaceFirst("PreferSubject", " ");
                        subjct = subjct.concat(subString);
                    } else if (parts[i].startsWith("PreferTime")) {
                        String timeString = parts[i].replaceFirst("PreferTime", " ");
                        time = time.concat(timeString);
                    } else if (parts[i].startsWith("PreferGender")) {
                        String genString = parts[i].replaceFirst("PreferGender", " ");
                        gender = gender.concat(genString);
                    } else if (parts[i].startsWith("PreferSalary")) {
                        String salaryString = parts[i].replaceFirst("PreferSalary", " ");
                        salary = salary.concat(salaryString);
                    } else if (parts[i].startsWith("PreferDescription")) {
                        String desyString = parts[i].replaceFirst("PreferDescription", " ");
                        description = desyString;
                    }


                }
                tuitionpost.setSalary(salary);
                tuitionpost.setPrefersubject(subjct);
                tuitionpost.setPrefertutor(gender);
                tuitionpost.setPrefertime(time);
                tuitionpost.setDescription(description);
                ls.add(tuitionpost);
            }
            }

        }
        reade.close();
        return ls;
    }
    private List<Tuitionpost> tuitionappliedd() throws IOException{
        BufferedReader readr =new BufferedReader(new FileReader("src/main/resources/com/example/edutech/ApplytutorandAcceptutor.txt"));
        Getsetusername a=new Getsetusername();
        String usernam=a.getUsername();
        String tuiionid="";
        while (true){
            String line=readr.readLine();
            if (line==null){
                break;
            } else {
                String []parts =line.split("%s%d");
                if (parts[0].equals(usernam)&&parts[1].startsWith("Appield")){
                    String subString = parts[1].replaceFirst("Appield", " ");
                    tuiionid = tuiionid.concat(subString);
                }
            }
        }readr.close();
        List<Tuitionpost> ls = new ArrayList<>();
        Tuitionpost tuitionpost;
        BufferedReader reade = new BufferedReader(new FileReader("src/main/resources/com/example/edutech/studenttuituionpost.txt"));
        while (true) {
            String line = reade.readLine();
            if (line == null) {
                break;
            } else {

                tuitionpost = new Tuitionpost();
                String subjct = "";
                String time = "";
                String gender = "";
                String salary = "";
                String description = "";
                String[] parts = line.split("%s%d");
                if (tuiionid.contains(parts[1])){
                    tuitionpost.setTime(parts[0]);
                    tuitionpost.setId(parts[1]);
                    tuitionpost.setClas(parts[6]);
                    for (int i = 7; i < parts.length; i++) {
                        if (parts[i].startsWith("PreferSubject")) {
                            String subString = parts[i].replaceFirst("PreferSubject", " ");
                            subjct = subjct.concat(subString);
                        } else if (parts[i].startsWith("PreferTime")) {
                            String timeString = parts[i].replaceFirst("PreferTime", " ");
                            time = time.concat(timeString);
                        } else if (parts[i].startsWith("PreferGender")) {
                            String genString = parts[i].replaceFirst("PreferGender", " ");
                            gender = gender.concat(genString);
                        } else if (parts[i].startsWith("PreferSalary")) {
                            String salaryString = parts[i].replaceFirst("PreferSalary", " ");
                            salary = salary.concat(salaryString);
                        } else if (parts[i].startsWith("PreferDescription")) {
                            String desyString = parts[i].replaceFirst("PreferDescription", " ");
                            description = desyString;
                        }


                    }
                    tuitionpost.setSalary(salary);
                    tuitionpost.setPrefersubject(subjct);
                    tuitionpost.setPrefertutor(gender);
                    tuitionpost.setPrefertime(time);
                    tuitionpost.setDescription(description);
                    ls.add(tuitionpost);
                }
            }

        }
        reade.close();
        return ls;
    }
    private List<Tuitionpost> tuitionaccept() throws IOException{
        BufferedReader readr =new BufferedReader(new FileReader("src/main/resources/com/example/edutech/ApplytutorandAcceptutor.txt"));
        Getsetusername a=new Getsetusername();
        String usernam=a.getUsername();
        String tuiionid="";
        while (true){
            String line=readr.readLine();
            if (line==null){
                break;
            } else {
                String []parts =line.split("%s%d");
                if (parts[0].equals(usernam)&&parts[1].startsWith("Accept")){
                    String subString = parts[1].replaceFirst("Accept", " ");
                    tuiionid = tuiionid.concat(subString);
                }
            }
        }readr.close();
        List<Tuitionpost> ls = new ArrayList<>();
        Tuitionpost tuitionpost;
        BufferedReader reade = new BufferedReader(new FileReader("src/main/resources/com/example/edutech/studenttuituionpost.txt"));
        while (true) {
            String line = reade.readLine();
            if (line == null) {
                break;
            } else {

                tuitionpost = new Tuitionpost();
                String subjct = "";
                String time = "";
                String gender = "";
                String salary = "";
                String description = "";
                String[] parts = line.split("%s%d");
                if (tuiionid.contains(parts[1])){
                    tuitionpost.setTime(parts[0]);
                    tuitionpost.setId(parts[1]+"         Name : "+parts[3]);
                    tuitionpost.setAddress("Address  :"+parts[5]);
                    tuitionpost.setClas(parts[6]);
                    tuitionpost.setNumber(parts[4]);
                    for (int i = 7; i < parts.length; i++) {
                        if (parts[i].startsWith("PreferSubject")) {
                            String subString = parts[i].replaceFirst("PreferSubject", " ");
                            subjct = subjct.concat(subString);
                        } else if (parts[i].startsWith("PreferTime")) {
                            String timeString = parts[i].replaceFirst("PreferTime", " ");
                            time = time.concat(timeString);
                        } else if (parts[i].startsWith("PreferGender")) {
                            String genString = parts[i].replaceFirst("PreferGender", " ");
                            gender = gender.concat(genString);
                        } else if (parts[i].startsWith("PreferSalary")) {
                            String salaryString = parts[i].replaceFirst("PreferSalary", " ");
                            salary = salary.concat(salaryString);
                        } else if (parts[i].startsWith("PreferDescription")) {
                            String desyString = parts[i].replaceFirst("PreferDescription", " ");
                            description = desyString;
                        }


                    }
                    tuitionpost.setSalary(salary);
                    tuitionpost.setPrefersubject(subjct);
                    tuitionpost.setPrefertutor(gender);
                    tuitionpost.setPrefertime(time);
                    tuitionpost.setDescription(description);
                    ls.add(tuitionpost);
                }
            }

        }
        reade.close();
        return ls;
    }

    @FXML
    void message(MouseEvent event) {
        loadpage("Message");
    }

    @FXML
    void services(MouseEvent event) {

    }

    @FXML
    void signupbtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Stage loginStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        loginStage.setScene(new Scene(root));
    }
    private void loadpage(String page){
        Parent root=null;
        try {
             root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page+".fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        bp.setCenter(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {        Getsetusername a=new Getsetusername();
            String fileName=a.getUsername();
            Image imageshow = new Image(new FileInputStream(fileName+".png"));
            imagefield.setFill(new ImagePattern(imageshow));
            vbox.getChildren().clear();
            bp.setCenter(scroll);
            List<Tuitionpost> tuitionappliedd=new ArrayList<>(tuitionappliedd());
            for (int i=0;i< tuitionappliedd().size();i++){
                FXMLLoader fxmlLoader=new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Appliedtuition.fxml"));
                try { VBox vvbox=fxmlLoader.load();
                    AppliedtuitionController cic=fxmlLoader.getController();
                    cic.setData(tuitionappliedd.get(i));
                    vbox.getChildren().add(vvbox);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
