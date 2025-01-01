package com.example.medsea;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * A UI component that displays information about the current season, pollution level,
 * and species count in the ecosystem.
 * Extends {@link HBox} to provide a horizontal layout for the displayed information.
 */
public class HeadCount extends HBox {

    /**
     * A label to display information about the season, pollution level, and species count.
     */
    private final Label infoLabel;

    /**
     * Constructs a {@code HeadCount} component with default information.
     * The initial display shows the season as Spring and the pollution level as Low.
     */
    public HeadCount() {
        infoLabel = new Label("Season: Spring | Pollution: Low");
        this.getChildren().add(infoLabel);
        this.setStyle("-fx-padding: 10; -fx-background-color: rgba(255, 255, 255, 0.8);");
    }

    /**
     * Updates the display to show the current species count.
     *
     * @param count The number of species in the ecosystem.
     */
    public void updateCount(int count) {
        infoLabel.setText("Species count: " + count);
    }

    /**
     * Updates the display to show the current season and pollution level.
     *
     * @param season         The current season (e.g., "Spring", "Summer").
     * @param pollutionLevel The current pollution level (e.g., "Low", "High").
     */
    public void updateSeason(String season, String pollutionLevel) {
        infoLabel.setText("Season: " + season + " | Pollution: " + pollutionLevel);
    }
}
