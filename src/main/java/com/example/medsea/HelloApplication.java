package com.example.medsea;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));

            // Load the root layout from FXML
            BorderPane root = fxmlLoader.load();

            // Load the background image
            Image backgroundImage = new Image(getClass().getResource("Mediterranean.jpg").toExternalForm());
            BackgroundImage bg = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(
                            BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false
                    )
            );
            root.setBackground(new Background(bg));

            // Set the scene
            Scene scene = new Scene(root, 800, 600); // Adjust width and height to fit your screen
            stage.setTitle("Med Sea Ecosystem");
            stage.setScene(scene);
            stage.setResizable(false); // Optional: Prevent resizing
            stage.show();

            // Access the controller (optional)
            HelloController controller = fxmlLoader.getController();
            System.out.println("Controller initialized: " + controller);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
