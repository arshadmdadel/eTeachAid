package com.example.edutech;

import java.io.*;

public class Getsetusername {
    private String username;

    public void setUsername(String setU) throws IOException {
        PrintWriter write= new PrintWriter(new FileWriter("src/main/java/com/example/edutech/Accessusername.txt"));
        write.println(setU+"");
        write.close();
    }

    public String getUsername() throws IOException {
        BufferedReader read=new BufferedReader(new FileReader("src/main/java/com/example/edutech/Accessusername.txt"));
        username=read.readLine();
        read.close();
        return username;
    }
    public String id() throws IOException{
        BufferedReader read=new BufferedReader(new FileReader("src/main/java/com/example/edutech/Accessusername.txt"));
        return null;
    }
}
