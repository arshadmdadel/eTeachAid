package com.example.edutech;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class CodeandTime {
        public  String generateRandomCode() throws IOException {
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%&*";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 6; i++) {
                int index = random.nextInt(characters.length());
                char randomChar = characters.charAt(index);
                sb.append(randomChar);
            }
            BufferedReader read=new BufferedReader(new FileReader("src/main/resources/com/example/edutech/studenttuituionpost.txt"));
            String line;
            while (true){
                line=read.readLine();
                if(line==null)break;
                else {
                String []parts =line.split("%s%d");
                if(parts[1].equals(sb.toString())){
                    generateRandomCode();
                }
                }

            }
            return sb.toString();
        }
        public String time(){
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);
            return formattedDateTime;
    }

}
