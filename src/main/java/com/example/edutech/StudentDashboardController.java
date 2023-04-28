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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class StudentDashboardController implements Initializable {

    @FXML
    private BorderPane bp;

    @FXML
    private Circle imagefield;

    @FXML
    private ScrollPane scroll;

    @FXML
    private VBox vbox;

    @FXML
    void Acceptetutor(MouseEvent event) throws IOException {

            vbox.getChildren().clear();
            bp.setCenter(scroll);
            List<Tutordetais> accepttutor=new ArrayList<>(accepttutor());
            for (int i=0;i< accepttutor().size();i++){
                FXMLLoader fxmlLoader=new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("acceptedtutor.fxml"));
                try { VBox vvbox=fxmlLoader.load();
                    AcceptedtutorController cic=fxmlLoader.getController();
                    cic.setData(accepttutor.get(i));
                    vbox.getChildren().add(vvbox);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }



    }

    @FXML
    void Accouninfo(MouseEvent event) {

    }

    @FXML
    void Tutorrequest(MouseEvent event) throws IOException {
        vbox.getChildren().clear();
        bp.setCenter(scroll);
        List<Tutordetais> requestttutor=new ArrayList<>(requestttutor());
        for (int i=0;i< requestttutor().size();i++){
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("TutorRequest.fxml"));
            try { VBox vvbox=fxmlLoader.load();
                TutorRequestController cic=fxmlLoader.getController();
                cic.setData(requestttutor.get(i));
                vbox.getChildren().add(vvbox);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    @FXML
    void about(MouseEvent event) {

    }

    @FXML
    void contact(MouseEvent event) {

    }

    @FXML
    void createnewpost(MouseEvent event) {
        loadpage("");

    }

    @FXML
    void message(MouseEvent event) {

    }

    @FXML
    void postedtuition(MouseEvent event) throws IOException {
        vbox.getChildren().clear();
        bp.setCenter(scroll);
        List<Tuitionpost> potedTuition=new ArrayList<>(potedTuition());
        for (int i=0;i< potedTuition().size();i++){
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("postedtuition.fxml"));
            try { VBox vvbox=fxmlLoader.load();
                PostedtuitionController cic=fxmlLoader.getController();
                cic.setData(potedTuition.get(i));
                vbox.getChildren().add(vvbox);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

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
    private List<Tuitionpost> potedTuition() throws IOException {
        Getsetusername a=new Getsetusername();
        String usernam=a.getUsername();
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
                if (usernam.contains(parts[2])){
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




    private List<Tutordetais> accepttutor() throws IOException{
        BufferedReader readr =new BufferedReader(new FileReader("src/main/resources/com/example/edutech/ApplytutorandAcceptutor.txt"));
        Getsetusername a=new Getsetusername();
        String usernam=a.getUsername();
        String tuiionid="";
        String tuitorid="";
        while (true){
            String line=readr.readLine();
            if (line==null){
                break;
            } else {
                String []parts =line.split("%s%d");
                if (parts[1].startsWith("Accept")){
                    String subString = parts[1].replaceFirst("Accept", " ");
                    tuiionid = tuiionid.concat(subString);
                    tuitorid=tuitorid.concat(parts[0]+" ");
                }
            }
        }readr.close();
        List<Tutordetais> ls = new ArrayList<>();
        Tutordetais tutordetais;
        BufferedReader reade = new BufferedReader(new FileReader("src/main/resources/com/example/edutech/studenttuituionpost.txt"));
        while (true) {
            String line = reade.readLine();
            if (line == null) {
                break;
            } else {

                String[] parts = line.split("%s%d");
                if (tuiionid.contains(parts[1])){

                    BufferedReader Read = new BufferedReader(new FileReader("src/main/resources/com/example/edutech/tutor.txt"));
                    while (true){
                        String Line= Read.readLine();
                        if (Line==null){
                            break;
                        }else {

                            tutordetais = new Tutordetais();
                            String subjct = "";
                            String time = "";
                            String classs = "";
                            String exp = "";

                            String []pat=line.split("%s%d");
                            if(tuitorid.contains(parts[0])){
                                tutordetais.setResult(pat[0]);
                                tutordetais.setName("Name  : "+pat[4]);
                                tutordetais.setSalary(pat[6]);
                                tutordetais.setProfession(pat[7]);
                                tutordetais.setAdress("Address  : "+pat[8]);
                                tutordetais.setPrefertuition(pat[9]+"       Age: "+pat[5]);
                                for (int i = 10; i < parts.length; i++) {
                                    if (parts[i].startsWith("PreferSubject")) {
                                        String subString = parts[i].replaceFirst("PreferSubject", " ");
                                        subjct = subjct.concat(subString);
                                    } else if (parts[i].startsWith("PreferTime")) {
                                        String timeString = parts[i].replaceFirst("PreferTime", " ");
                                        time = time.concat(timeString);
                                    } else if (parts[i].startsWith("PreferClass")) {
                                        String genString = parts[i].replaceFirst("PreferClass", " ");
                                        classs = classs.concat(genString);
                                    } else if (parts[i].startsWith("Experience")) {
                                        String salaryString = parts[i].replaceFirst("Experience", " ");
                                        exp = exp.concat(salaryString);
                                    }

                                    }
                                tutordetais.setNumber("Email :"+pat[2]);
                                tutordetais.setSubject(subjct);
                                tutordetais.setClass(classs);
                                tutordetais.setPrefertime(time);
                                tutordetais.setRectangle(pat[1]+"png");
                                ls.add(tutordetais);


                                }


                            }
                        }Read.close();
                    }

                }
            }
        reade.close();
        return ls;
    }
    private List<Tutordetais> requestttutor() throws IOException{
        BufferedReader readr =new BufferedReader(new FileReader("src/main/resources/com/example/edutech/ApplytutorandAcceptutor.txt"));
        Getsetusername a=new Getsetusername();
        String usernam=a.getUsername();
        String tuiionid="";
        String tuitorid="";
        while (true){
            String line=readr.readLine();
            if (line==null){
                break;
            } else {
                String []parts =line.split("%s%d");
                if (parts[1].startsWith("")){
                    String subString = parts[1].replaceFirst("Appield", " ");
                    tuiionid = tuiionid.concat(subString);
                    tuitorid=tuitorid.concat(parts[0]+" ");
                }
            }
        }readr.close();
        List<Tutordetais> ls = new ArrayList<>();
        Tutordetais tutordetais;
        BufferedReader reade = new BufferedReader(new FileReader("src/main/resources/com/example/edutech/studenttuituionpost.txt"));
        while (true) {
            String line = reade.readLine();
            if (line == null) {
                break;
            } else {

                String[] parts = line.split("%s%d");
                if (tuiionid.contains(parts[1])){

                    BufferedReader Read = new BufferedReader(new FileReader("src/main/resources/com/example/edutech/tutor.txt"));
                    while (true){
                        String Line= Read.readLine();
                        if (Line==null){
                            break;
                        }else {

                            tutordetais = new Tutordetais();
                            String subjct = "";
                            String time = "";
                            String classs = "";
                            String exp = "";

                            String []pat=line.split("%s%d");
                            if(tuitorid.contains(parts[0])){
                                tutordetais.setResult(pat[0]);
                                tutordetais.setSalary(pat[6]);
                                tutordetais.setProfession(pat[7]);
                                tutordetais.setPrefertuition(pat[9]+"       Age: "+pat[5]);
                                for (int i = 10; i < parts.length; i++) {
                                    if (parts[i].startsWith("PreferSubject")) {
                                        String subString = parts[i].replaceFirst("PreferSubject", " ");
                                        subjct = subjct.concat(subString);
                                    } else if (parts[i].startsWith("PreferTime")) {
                                        String timeString = parts[i].replaceFirst("PreferTime", " ");
                                        time = time.concat(timeString);
                                    } else if (parts[i].startsWith("PreferClass")) {
                                        String genString = parts[i].replaceFirst("PreferClass", " ");
                                        classs = classs.concat(genString);
                                    } else if (parts[i].startsWith("Experience")) {
                                        String salaryString = parts[i].replaceFirst("Experience", " ");
                                        exp = exp.concat(salaryString);
                                    }

                                }
                                tutordetais.setNumber("Email :"+pat[2]);
                                tutordetais.setSubject(subjct);
                                tutordetais.setClass(classs);
                                tutordetais.setPrefertime(time);
                                ls.add(tutordetais);


                            }


                        }
                    }Read.close();
                }

            }
        }
        reade.close();
        return ls;
    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {        Getsetusername a=new Getsetusername();
            String fileName=a.getUsername();
            Image imageshow = new Image(new FileInputStream(fileName+".png"));
            imagefield.setFill(new ImagePattern(imageshow));
            vbox.getChildren().clear();
            bp.setCenter(scroll);
            List<Tuitionpost> potedTuition=new ArrayList<>(potedTuition());
            for (int i=0;i< potedTuition().size();i++){
                FXMLLoader fxmlLoader=new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("postedtuition.fxml"));
                try { VBox vvbox=fxmlLoader.load();
                    PostedtuitionController cic=fxmlLoader.getController();
                    cic.setData(potedTuition.get(i));
                    vbox.getChildren().add(vvbox);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

}
