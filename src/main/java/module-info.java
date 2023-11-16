module com.example.javafxbrocodecourse {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.TorinoPizza_Project to javafx.fxml;
    exports com.example.TorinoPizza_Project;
}