package com.example.medsea;

import java.util.Random;

enum Season {
    SPRING, SUMMER, AUTUMN, WINTER
}

public class Climate {
    private Season currentSeason;
    private double temperature;
    private double pollution;
    private final Random random = new Random();

    public Climate(Season season, double pollution) {
        this.currentSeason = season;
        this.pollution = Math.max(0, Math.min(100, pollution));
        adjustConditions();
    }

    public double getPollution() {
        return pollution;
    }

    public void setPollution(double pollution) {
        this.pollution = Math.max(0, Math.min(100, pollution));
        adjustConditions();
    }

    public void setSeason(Season newSeason) {
        this.currentSeason = newSeason;
        adjustConditions();
    }

    public Season getCurrentSeason() {
        return currentSeason;
    }

    public double getTemperature() {
        return temperature;
    }

    public void incrementPollution(double amount) {
        this.pollution += amount;
        System.out.println("Pollution increased by " + amount + ". Total pollution: " + pollution);
    }

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

    public boolean overheat() {
        double threshold; // Définir le seuil de surchauffe en fonction de la saison
        switch (currentSeason) {
            case SPRING:
                threshold = 30; // Par exemple, 30°C pour le printemps
                break;
            case SUMMER:
                threshold = 40; // Par exemple, 40°C pour l'été
                break;
            case AUTUMN:
                threshold = 25; // Par exemple, 25°C pour l'automne
                break;
            case WINTER:
                threshold = 10; // Par exemple, 10°C pour l'hiver
                break;
            default:
                threshold = 20;
        }

        return temperature > threshold; // Retourne vrai si la température dépasse le seuil
    }

    private double randomInRange(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

    @Override
    public String toString() {
        return String.format("Pollution: %.1f, Temperature: %.1f°C", pollution, temperature);
    }
}
