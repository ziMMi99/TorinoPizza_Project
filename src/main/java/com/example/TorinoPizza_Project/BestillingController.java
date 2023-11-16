package com.example.TorinoPizza_Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class BestillingController implements Initializable {

    public static List<String> foodItems = new ArrayList<>();
    public static List<String> drinkItems = new ArrayList<>();

    @FXML
    private ChoiceBox<String> myChoiceBoxPizza;
    @FXML
    private ChoiceBox<String> myChoiceBoxDrink;

    @FXML
    private Button myButton;

    String[] pizza = {"Pepperoni", "Margherita", "Hawaii", "Duvbo"};
    String[] drink = {"Pepsi", "Coca cola", "Faxe Kondi", "Fanta"};

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void alertMessage(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Bekræft bestilling");
        alert.setContentText("Tryk OK hvis bestillingen er korrekt!");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isEmpty()) {
            System.out.println("Alert closed");
        } else if (result.get() == ButtonType.OK) {
            switchToMain(event);
        } else if (result.get() == ButtonType.CANCEL) {
            System.out.println("Cancelled");
        }

    }

    public void switchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-page.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void tilføjTilBestilling(ActionEvent event) {
        String pizzaValg = myChoiceBoxPizza.getValue();
        String drinkValg = myChoiceBoxDrink.getValue();

        if (myChoiceBoxPizza.getValue() == null) {
            System.out.println();
        } else {
            foodItems.add(pizzaValg);
            myChoiceBoxPizza.setValue(null);
        }

        if (myChoiceBoxDrink.getValue() == null) {
            System.out.println();
        } else {
            drinkItems.add(drinkValg);
            myChoiceBoxDrink.setValue(null);
        }

        System.out.println(foodItems);
        System.out.println(drinkItems);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBoxPizza.getItems().addAll(pizza);
        myChoiceBoxDrink.getItems().addAll(drink);
    }
}
