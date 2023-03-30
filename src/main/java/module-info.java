module com.example.aoop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.edutech to javafx.fxml;
    exports com.example.edutech;
}