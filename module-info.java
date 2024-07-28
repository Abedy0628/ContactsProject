module com.example.contactproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.contactproject to javafx.fxml;
    exports com.example.contactproject;
}