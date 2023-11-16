package com.example.TorinoPizza_Project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader root = new FXMLLoader(Application.class.getResource("main-page.fxml"));
        Scene scene = new Scene(root.load());
        stage.setTitle("PizzaOrderingSystem");
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}