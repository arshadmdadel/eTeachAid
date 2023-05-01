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

import java.beans.Statement;
import java.io.*;
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
        String fileName=LoginController.use;
        Image imageshow = new Image(new FileInputStream(fileName+".png"));
        imagefield.setFill(new ImagePattern(imageshow));
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
    void Accouninfo(MouseEvent event) throws IOException {
        String fileName=LoginController.use;
        Image imageshow = new Image(new FileInputStream(fileName+".png"));
        imagefield.setFill(new ImagePattern(imageshow));
        loadpage("studentedit");

    }

    @FXML
    void Tutorrequest(MouseEvent event) throws IOException {

        String fileName=LoginController.use;
        Image imageshow = new Image(new FileInputStream(fileName+".png"));
        imagefield.setFill(new ImagePattern(imageshow));
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
        loadpage("studentnext2");

    }

    @FXML
    void message(MouseEvent event) {

    }

    @FXML
    void postedtuition(MouseEvent event) throws IOException {
        String fileName=LoginController.use;
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
        String usernam=LoginController.use;
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
        List<Tutordetais> ls = new ArrayList<>();
        Tutordetais tutordetais;
        BufferedReader reade = new BufferedReader(new FileReader("src/main/resources/com/example/edutech/studenttuituionpost.txt"));
        String usernam=LoginController.use;
        while (true) {
            String line = reade.readLine();
            if (line == null) {
                break;
            } else {
                if (line.contains(usernam)){
                    String []part=line.split("%s%d");

                    BufferedReader readr =new BufferedReader(new FileReader("src/main/resources/com/example/edutech/ApplytutorandAcceptutor.txt"));
                    while (true){
                        String l=readr.readLine();
                        if (l==null){
                            break;
                        } else {
                            if (l.contains(part[1]) && l.contains("Accept")){

                                BufferedReader Read = new BufferedReader(new FileReader("src/main/resources/com/example/edutech/tutor.txt"));
                                while (true){
                                    String ll= Read.readLine();
                                    if (ll==null){
                                        break;
                                    }else {

                                        tutordetais = new Tutordetais();
                                        String subjct = "";
                                        String time = "";
                                        String classs = "";
                                        String exp = "";

                                        String []pat=ll.split("%s%d");
                                        if(l.contains(pat[1])){
                                            tutordetais.setTuitionid(part[1]);
                                            tutordetais.setUsername(pat[1]);
                                            tutordetais.setRectangle(pat[1]+".png");
                                            tutordetais.setNumber(pat[2]);
                                            tutordetais.setName(pat[4]);
                                            tutordetais.setResult(pat[0]);
                                            tutordetais.setSalary(pat[6]);
                                            tutordetais.setAdress(pat[8]);
                                            tutordetais.setProfession(pat[7]);
                                            tutordetais.setPrefertuition(pat[9]+"       Age: "+pat[5]);
                                            for (int i = 10; i < pat.length; i++) {
                                                if (pat[i].startsWith("PreferSubject")) {
                                                    String subString = pat[i].replaceFirst("PreferSubject", " ");
                                                    subjct = subjct.concat(subString);
                                                } else if (pat[i].startsWith("PreferTime")) {
                                                    String timeString = pat[i].replaceFirst("PreferTime", " ");
                                                    time = time.concat(timeString);
                                                } else if (pat[i].startsWith("PreferClass")) {
                                                    String genString = pat[i].replaceFirst("PreferClass", " ");
                                                    classs = classs.concat(genString);
                                                } else if (pat[i].startsWith("Experience")) {
                                                    String salaryString = pat[i].replaceFirst("Experience", " ");
                                                    exp = exp.concat(salaryString);
                                                }

                                            }
                                            tutordetais.setSubject(subjct);
                                            tutordetais.setlass(classs);
                                            tutordetais.setPrefertime(time);
                                            tutordetais.setWorkexperience(exp);
                                            ls.add(tutordetais);


                                        }


                                    }
                                }Read.close();
                            }
                        }
                    }readr.close();

                }

            }
        }reade.close();return ls;
    }
    private List<Tutordetais> requestttutor() throws IOException{
        List<Tutordetais> ls = new ArrayList<>();
        Tutordetais tutordetais;
        BufferedReader reade = new BufferedReader(new FileReader("src/main/resources/com/example/edutech/studenttuituionpost.txt"));
        String usernam=LoginController.use;

        while (true) {
            String line = reade.readLine();
            if (line == null) {
                break;
            } else { String id="";

                if (line.contains(usernam)){
                    String []part=line.split("%s%d");
                    FileInputStream fis = new FileInputStream("src/main/resources/com/example/edutech/ApplytutorandAcceptutor.txt");
                         BufferedReader br = new BufferedReader(new InputStreamReader(fis));

                        String linE;String []k=line.split("%s%d");
                        while ((linE = br.readLine()) != null) {
                            if (linE.contains("%s%dAccept "+part[1])){
                                id=id.concat(linE+" "); }
                            // process line
                        }fis.close();br.close();





                    BufferedReader readr =new BufferedReader(new FileReader("src/main/resources/com/example/edutech/ApplytutorandAcceptutor.txt"));

                    while (true){
                        String l=readr.readLine();
                        if (l==null){
                            break;
                        } else {String []p=l.split("%s%d");
                            if (l.contains(part[1]) && l.contains("Appield")){


                                BufferedReader Read = new BufferedReader(new FileReader("src/main/resources/com/example/edutech/tutor.txt"));
                                while (true){
                                    String ll= Read.readLine();
                                    if (ll==null){
                                        break;
                                    }else {

                                        tutordetais = new Tutordetais();
                                        String subjct = "";
                                        String time = "";
                                        String classs = "";
                                        String exp = "";

                                        String []pat=ll.split("%s%d");
                                        if(l.contains(pat[1]) && !id.contains(pat[1])) {

                                                tutordetais.setTuitionid(part[1]);
                                            tutordetais.setUsername(pat[1]);
                                            tutordetais.setResult(pat[0]);
                                            tutordetais.setSalary(pat[6]);
                                            tutordetais.setProfession(pat[7]);
                                            tutordetais.setPrefertuition(pat[9] + "       Age: " + pat[5]);
                                            for (int i = 10; i < pat.length; i++) {
                                                if (pat[i].startsWith("PreferSubject")) {
                                                    String subString = pat[i].replaceFirst("PreferSubject", " ");
                                                    subjct = subjct.concat(subString);
                                                } else if (pat[i].startsWith("PreferTime")) {
                                                    String timeString = pat[i].replaceFirst("PreferTime", " ");
                                                    time = time.concat(timeString);
                                                } else if (pat[i].startsWith("PreferClass")) {
                                                    String genString = pat[i].replaceFirst("PreferClass", " ");
                                                    classs = classs.concat(genString);
                                                } else if (pat[i].startsWith("Experience")) {
                                                    String salaryString = pat[i].replaceFirst("Experience", " ");
                                                    exp = exp.concat(salaryString);
                                                }

                                            }
                                            tutordetais.setSubject(subjct);
                                            tutordetais.setlass(classs);
                                            tutordetais.setPrefertime(time);
                                            tutordetais.setWorkexperience(exp);
                                            ls.add(tutordetais);



                                        }


                                    }
                                }Read.close();
                            }
                        }
                    }readr.close();

                }

            }
        }reade.close();return ls;
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            String fileName=LoginController.use;
            System.out.println(LoginController.use);
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
