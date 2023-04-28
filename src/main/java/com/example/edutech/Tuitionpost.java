package com.example.edutech;

import javafx.scene.Parent;

public class Tuitionpost {
    private String Time;
    private String id;
    private String description;
    private String prefertutor;
    private String prefertime;
    private String prefersubject;
    private String salary;
    private String Clas;
    private String address;
    private  String number;

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getClas() {
        return Clas;
    }

    public void setClas(String clas) {
        Clas = clas;
    }

    public String getTime() {
        return Time;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getPrefertutor() {
        return prefertutor;
    }

    public String getPrefertime() {
        return prefertime;
    }

    public String getPrefersubject() {
        return prefersubject;
    }

    public String getSalary() {
        return salary;
    }

    public void setTime(String time) {
        Time = time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrefertutor(String prefertutor) {
        this.prefertutor = prefertutor;
    }

    public void setPrefertime(String prefertime) {
        this.prefertime = prefertime;
    }

    public void setPrefersubject(String prefersubject) {
        this.prefersubject = prefersubject;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
