package com.example.medsea;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;
import org.testfx.api.FxToolkit;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HelloApplicationTest extends ApplicationTest {

    @Override
    public void start(Stage stage) {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/hello-view.fxml"));

            // Load the root layout from FXML
            BorderPane root = fxmlLoader.load();

            // Load the background image
            Image backgroundImage = new Image(getClass().getResource("/Mediterranean.jpg").toExternalForm());
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testStageTitle() throws Exception {
        WaitForAsyncUtils.waitForFxEvents();
        Stage stage = FxToolkit.registerPrimaryStage();
        assertEquals("Med Sea Ecosystem", stage.getTitle());
    }

    @Test
    void testSceneDimensions() throws Exception {
        WaitForAsyncUtils.waitForFxEvents();
        Scene scene = FxToolkit.registerPrimaryStage().getScene();
        assertEquals(800, scene.getWidth());
        assertEquals(600, scene.getHeight());
    }

    @Test
    void testBackgroundImage() throws Exception {
        WaitForAsyncUtils.waitForFxEvents();
        BorderPane root = (BorderPane) FxToolkit.registerPrimaryStage().getScene().getRoot();
        assertNotNull(root.getBackground());
        assertFalse(root.getBackground().getImages().isEmpty());
        assertEquals("Mediterranean.jpg", root.getBackground().getImages().get(0).getImage().getUrl().substring(root.getBackground().getImages().get(0).getImage().getUrl().lastIndexOf('/') + 1));
    }
}