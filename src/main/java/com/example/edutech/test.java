package com.example.edutech;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {

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
                if (parts[1].startsWith("Appield")){
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
                if (usernam.equals(parts[1])){

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
                            if(tuitorid.contains(pat[1])){
                                tutordetais.setName(pat[0]);
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



//    private List<Tutordetais> requestttutor() throws IOException {
//        List<Tutordetais> ls = new ArrayList<>();
//        Tutordetais tutordetais;
//        BufferedReader reade = new BufferedReader(new FileReader("src/main/resources/com/example/edutech/studenttuituionpost.txt"));
//        Getsetusername a=new Getsetusername();
//        String usernam=a.getUsername();
//        while (true) {
//            String line = reade.readLine();
//            if (line == null) {
//                break;
//            } else {
//                if (line.contains(usernam)){
//                    String []part=line.split("%s%d");
//
//                    BufferedReader readr =new BufferedReader(new FileReader("src/main/resources/com/example/edutech/ApplytutorandAcceptutor.txt"));
//                    Getsetusername b=new Getsetusername();
//                    while (true){
//                        String l=readr.readLine();
//                        if (l==null){
//                            break;
//                        } else {
//                            if (l.contains(part[1]) && l.contains("Appield")){
//
//                                    BufferedReader Read = new BufferedReader(new FileReader("src/main/resources/com/example/edutech/tutor.txt"));
//                                    while (true){
//                                    String ll= Read.readLine();
//                                    if (ll==null){
//                                        break;
//                                    }else {
//
//                                        tutordetais = new Tutordetais();
//                                        String subjct = "";
//                                        String time = "";
//                                        String classs = "";
//                                        String exp = "";
//
//                                        String []pat=line.split("%s%d");
//                                        if(l.contains(pat[1])){
//                                            tutordetais.setName(pat[1]);
//                                            tutordetais.setResult(pat[0]);
//                                            tutordetais.setSalary(pat[6]);
//                                            tutordetais.setProfession(pat[7]);
//                                            tutordetais.setPrefertuition(pat[9]+"       Age: "+pat[5]);
//                                            for (int i = 10; i < pat.length; i++) {
//                                                if (pat[i].startsWith("PreferSubject")) {
//                                                    String subString = pat[i].replaceFirst("PreferSubject", " ");
//                                                    subjct = subjct.concat(subString);
//                                                } else if (pat[i].startsWith("PreferTime")) {
//                                                    String timeString = pat[i].replaceFirst("PreferTime", " ");
//                                                    time = time.concat(timeString);
//                                                } else if (pat[i].startsWith("PreferClass")) {
//                                                    String genString = pat[i].replaceFirst("PreferClass", " ");
//                                                    classs = classs.concat(genString);
//                                                } else if (pat[i].startsWith("Experience")) {
//                                                    String salaryString = pat[i].replaceFirst("Experience", " ");
//                                                    exp = exp.concat(salaryString);
//                                                }
//
//                                            }
//                                            tutordetais.setNumber("Email :"+pat[2]);
//                                            tutordetais.setSubject(subjct);
//                                            tutordetais.setClass(classs);
//                                            tutordetais.setPrefertime(time);
//                                            ls.add(tutordetais);
//
//
//                                        }
//
//
//                                    }
//                                }Read.close();
//                            }
//                        }
//                    }readr.close();
//
//                }
//
//            }
//        }reade.close();return ls;
//    }
}


