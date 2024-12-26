package com.example.medsea;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class HeadCount extends HBox {
    private final Label infoLabel;

    public HeadCount() {
        infoLabel = new Label("Season: Spring | Pollution: Low");
        this.getChildren().add(infoLabel);
        this.setStyle("-fx-padding: 10; -fx-background-color: rgba(255, 255, 255, 0.8);");
    }

    public void updateCount(int count) {
        infoLabel.setText("Species count: " + count);
    }

    public void updateSeason(String season, String pollutionLevel) {
        infoLabel.setText("Season: " + season + " | Pollution: " + pollutionLevel);
    }
}
