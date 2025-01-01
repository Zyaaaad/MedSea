package com.example.medsea;

import java.util.Random;

/**
 * Represents an oil tanker, a type of vehicle specialized in drilling and transporting oil.
 */
public class OilTanker extends Vehicle implements OilDriller {

    /**
     * Current oil capacity of the tanker in barrels.
     */
    private double oilCapacity;

    /**
     * Maximum oil capacity of the tanker in barrels.
     */
    private double maxOilCapacity;

    /**
     * Random instance used for simulating operations.
     */
    private static final Random random = new Random();

    /**
     * Constructs a new OilTanker with a given name and maximum oil capacity.
     *
     * @param name           The name of the tanker.
     * @param maxOilCapacity The maximum oil capacity of the tanker in barrels.
     */
    public OilTanker(String name, double maxOilCapacity) {
        super(name);
        this.oilCapacity = 0;
        this.maxOilCapacity = maxOilCapacity;
    }

    /**
     * Gets the current oil capacity of the tanker.
     *
     * @return The current oil capacity in barrels.
     */
    public double getOilCapacity() {
        return oilCapacity;
    }

    /**
     * Displays information about the oil tanker, including its name, current oil capacity,
     * maximum capacity, and damage level.
     */
    @Override
    public void displayInfo() {
        System.out.println("Oil Tanker: " + getName() +
                ", Current Oil: " + String.format("%.1f", oilCapacity) + " barrels" +
                ", Max Capacity: " + String.format("%.1f", maxOilCapacity) + " barrels" +
                ", Damage Level: " + String.format("%.1f", getDamageLevel()) + "%.");
    }

    /**
     * Repairs the oil tanker by reducing its damage level.
     * The repair amount is randomly determined between 0 and 30%.
     */
    @Override
    public void repair() {
        double repairAmount = random.nextDouble() * 30; // Repair between 0 and 30%
        setDamageLevel(getDamageLevel() - repairAmount);
        if (getDamageLevel() < 5) { // Ensure a minimum damage level of 5%
            setDamageLevel(5);
        }
        System.out.println("Repaired " + String.format("%.1f", repairAmount) +
                "%. Current damage level: " + String.format("%.1f", getDamageLevel()) + "%.");
    }

    /**
     * Drills oil and increases the tanker's oil capacity.
     * The amount of oil drilled is randomly determined, but it cannot exceed the maximum capacity.
     * Drilling also increases the tanker's damage level.
     */
    @Override
    public void drillOil() {
        if (getDamageLevel() >= 100) {
            System.out.println("The tanker is too damaged to drill oil.");
            return;
        }

        double oilDrilled = random.nextDouble() * 200; // Drill between 0 and 200 barrels
        if (oilCapacity + oilDrilled > maxOilCapacity) {
            oilDrilled = maxOilCapacity - oilCapacity; // Limit to max capacity
        }

        oilCapacity += oilDrilled;
        setDamageLevel(getDamageLevel() + oilDrilled * 0.02); // Increase damage slightly
        System.out.println("Drilled " + String.format("%.1f", oilDrilled) + " barrels of oil.");
    }
}
