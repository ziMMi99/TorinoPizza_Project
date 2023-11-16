package com.example.TorinoPizza_Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private VBox ordersVBox;

    private static int orderCounter = 1;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToBestilling(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tilføjBestilling.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addOrder(List<String> foodItems, List<String> drinkItems) {
        HBox orderHBox = new HBox();
        Label orderLabel = new Label("Order: " + orderCounter++);
        int amountFood = 0;
        int amountDrink = 0;

        // Create labels for each food item
        for (String food : foodItems) {
            amountFood++;
        }
        Label foodOrderContent = new Label(amountFood + "x");
        orderHBox.getChildren().add(foodOrderContent);
        Label foodLabel = new Label(" Pizza ");
        orderHBox.getChildren().add(foodLabel);

        // Create labels for each drink item
        for (String drink : drinkItems) {
            amountDrink++;
        }
        Label drinkOrderContent = new Label(amountDrink + "x");
        orderHBox.getChildren().add(drinkOrderContent);
        Label drinkLabel = new Label(" drink ");
        orderHBox.getChildren().add(drinkLabel);

        // Add the new order HBox to the VBox
        ordersVBox.getChildren().add(orderLabel);
        ordersVBox.getChildren().add(orderHBox);
        System.out.println("add HBox");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (BestillingController.foodItems == null && BestillingController.drinkItems == null) {
            System.out.println("no Orders");
        } else {
            addOrder(BestillingController.foodItems, BestillingController.drinkItems);
        }
    }
}