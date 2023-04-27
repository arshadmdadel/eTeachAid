module com.example.aoop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.edutech to javafx.fxml;
    exports com.example.edutech;
}