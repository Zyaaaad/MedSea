package com.example.medsea;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label climateSeasonLabel;
    @FXML
    private Label pollutionLabel;
    @FXML
    private Label temperatureLabel;
    @FXML
    private Label updatesLabel;

    private Climate climate;
    private Human fisherman;
    private FishingTrawler trawler;

    public HelloController() {
        this.climate = new Climate(Season.SPRING, 30.0);
        this.fisherman = new Human(100, true, true, "Fisherman");
        this.trawler = new FishingTrawler("Poseidon", 50.0);
        System.out.println("Controller initialized: " + climate);
    }

    @FXML
    public void initialize() {
        updateClimateDisplay();
        updatesLabel.setText("Welcome to the Med Sea Ecosystem!");
    }

    private void updateClimateDisplay() {
        climateSeasonLabel.setText(climate.getCurrentSeason().toString());
        pollutionLabel.setText(String.format("%.1f", climate.getPollution()));
        temperatureLabel.setText(String.format("%.1f°C", climate.getTemperature()));
    }

    @FXML
    protected void onStartStoryButtonClick() {
        updatesLabel.setText("The story begins with John the Fisherman and his trawler, Poseidon.");
        updateClimateDisplay();
    }

    @FXML
    protected void onFishingButtonClick() {
        int fishCaught = fisherman.fishing("Sardine");
        trawler.fish();
        updatesLabel.setText("John the Fisherman caught " + fishCaught + " sardines.\n"
                + "Poseidon trawler now holds " + String.format("%.1f", trawler.getFishCapacity()) + " tons of fish.");
    }

    @FXML
    protected void onPollutionButtonClick() {
        fisherman.pollute(climate, 15.0);
        updatesLabel.setText("Fishing activities have increased pollution by 15 units.\n"
                + "Current pollution level: " + climate.getPollution());
        updateClimateDisplay();
    }

    @FXML
    protected void onSeasonalRegulationButtonClick() {
        String targetFish = fisherman.regulate(climate);
        updatesLabel.setText("John the Fisherman regulates fishing.\nThis season, he will target: " + targetFish + ".");
    }

    @FXML
    protected void onRepairTrawlerButtonClick() {
        trawler.repair();
        updatesLabel.setText("Poseidon trawler has been repaired.\n"
                + "Current damage level: " + String.format("%.1f", trawler.getDamageLevel()) + "%.");
    }

    @FXML
    protected void onFishermanLifecycleButtonClick() {
        Human newFisherman = (Human) fisherman.reproduce();
        if (newFisherman != null) {
            updatesLabel.setText("A new fisherman is born to continue the legacy!");
        } else {
            updatesLabel.setText("John the Fisherman cannot reproduce due to age or health.");
        }
        fisherman.die();
        updatesLabel.setText(updatesLabel.getText() + "\nJohn the Fisherman has passed away.");
    }

    @FXML
    protected void onEndStoryButtonClick() {
        updatesLabel.setText("The story of the Med Sea Ecosystem has ended.\n"
                + "John the Fisherman lived a life of fishing, regulating, and adapting to the seasons.\n"
                + "The trawler Poseidon remains, ready for new adventures.");
    }
}
