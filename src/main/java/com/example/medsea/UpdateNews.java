package com.example.medsea;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class UpdateNews extends VBox {
    private final Label newsLabel;

    public UpdateNews() {
        newsLabel = new Label("Latest news:");
        this.getChildren().add(newsLabel);
        this.setStyle("-fx-padding: 10; -fx-background-color: rgba(255, 255, 255, 0.8);");
    }

    public void updateNews(String news) {
        newsLabel.setText("Latest news: " + news);
    }
}
