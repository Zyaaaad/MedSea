package com.example.medsea;

import java.util.Random;

/**
 * Represents the climate conditions in an ecosystem.
 * This class tracks the current season, temperature, and pollution levels,
 * and adjusts conditions based on these parameters.
 */
enum Season {
    SPRING, SUMMER, AUTUMN, WINTER
}

public class Climate {
    /**
     * The current season of the ecosystem.
     */
    private Season currentSeason;

    /**
     * The current temperature in the ecosystem.
     */
    private double temperature;

    /**
     * The level of pollution in the ecosystem (from 0 to 100).
     */
    private double pollution;

    /**
     * Random number generator used for generating random values within a range.
     */
    private final Random random = new Random();

    /**
     * Constructor for the Climate class.
     * Initializes the climate conditions based on the season and pollution level.
     *
     * @param season The current season in the ecosystem.
     * @param pollution The initial pollution level in the ecosystem (from 0 to 100).
     */
    public Climate(Season season, double pollution) {
        this.currentSeason = season;
        this.pollution = Math.max(0, Math.min(100, pollution));
        adjustConditions();
    }

    /**
     * Gets the current pollution level.
     *
     * @return The current pollution level (between 0 and 100).
     */
    public double getPollution() {
        return pollution;
    }

    /**
     * Sets the pollution level and adjusts the climate conditions accordingly.
     *
     * @param pollution The new pollution level (between 0 and 100).
     */
    public void setPollution(double pollution) {
        this.pollution = Math.max(0, Math.min(100, pollution));
        adjustConditions();
    }

    /**
     * Sets the current season and adjusts the climate conditions accordingly.
     *
     * @param newSeason The new season to set for the ecosystem.
     */
    public void setSeason(Season newSeason) {
        this.currentSeason = newSeason;
        adjustConditions();
    }

    /**
     * Gets the current season of the ecosystem.
     *
     * @return The current season (Spring, Summer, Autumn, or Winter).
     */
    public Season getCurrentSeason() {
        return currentSeason;
    }

    /**
     * Gets the current temperature of the ecosystem.
     *
     * @return The current temperature in degrees Celsius.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Increases the pollution level by a given amount and prints the new pollution level.
     *
     * @param amount The amount to increase the pollution by.
     */
    public void incrementPollution(double amount) {
        this.pollution += amount;
        System.out.println("Pollution increased by " + amount + ". Total pollution: " + pollution);
    }

    /**
     * Adjusts the climate conditions (pollution and temperature) based on the current season.
     */
    private void adjustConditions() {
        adjustPollutionBySeason();

        switch (currentSeason) {
            case SPRING:
                temperature = randomInRange(15, 25) + pollutionEffectOnTemperature();
                break;
            case SUMMER:
                temperature = randomInRange(25, 35) + pollutionEffectOnTemperature();
                break;
            case AUTUMN:
                temperature = randomInRange(10, 20) + pollutionEffectOnTemperature();
                break;
            case WINTER:
                temperature = randomInRange(-5, 5) + pollutionEffectOnTemperature();
                break;
        }
    }

    /**
     * Adjusts the pollution level based on the current season.
     */
    private void adjustPollutionBySeason() {
        switch (currentSeason) {
            case SPRING:
                pollution = pollution + randomInRange(-5, 5);
                break;
            case SUMMER:
                pollution = pollution + randomInRange(10, 20);
                break;
            case AUTUMN:
                pollution = pollution + randomInRange(-5, 5);
                break;
            case WINTER:
                pollution = pollution - randomInRange(5, 15);
                break;
        }
        pollution = Math.max(0, Math.min(100, pollution));
    }

    /**
     * Calculates the effect of pollution on the temperature based on the current season.
     *
     * @return The adjustment to the temperature based on pollution.
     */
    private double pollutionEffectOnTemperature() {
        switch (currentSeason) {
            case SUMMER:
                return pollution * 0.1;
            case SPRING:
                return pollution * 0.08;
            case AUTUMN:
                return pollution * 0.05;
            case WINTER:
                return pollution * 0.02;
            default:
                return 0;
        }
    }

    /**
     * Determines if the current temperature exceeds a threshold for overheating.
     * The threshold varies depending on the season.
     *
     * @return true if the temperature exceeds the threshold for overheating.
     */
    public boolean overheat() {
        double threshold; // Define the overheat threshold based on the season
        switch (currentSeason) {
            case SPRING:
                threshold = 30; // For Spring, threshold is 30°C
                break;
            case SUMMER:
                threshold = 40; // For Summer, threshold is 40°C
                break;
            case AUTUMN:
                threshold = 25; // For Autumn, threshold is 25°C
                break;
            case WINTER:
                threshold = 10; // For Winter, threshold is 10°C
                break;
            default:
                threshold = 20;
        }

        return temperature > threshold; // Returns true if the temperature exceeds the threshold
    }

    /**
     * Generates a random number within a given range.
     *
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     * @return A random double value between min and max.
     */
    private double randomInRange(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

    /**
     * Provides a string representation of the current climate conditions.
     *
     * @return A string describing the current pollution and temperature.
     */
    @Override
    public String toString() {
        return String.format("Pollution: %.1f, Temperature: %.1f°C", pollution, temperature);
    }
}
