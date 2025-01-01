package com.example.medsea;

import java.util.Random;

/**
 * Represents a cruise ship, a specific type of vehicle with passenger capacity
 * and the ability to board passengers and undergo repairs.
 */
public class CruiseShip extends Vehicle {
    /**
     * The current number of passengers on the cruise ship.
     */
    private int passengerCapacity;

    /**
     * The maximum number of passengers the cruise ship can hold.
     */
    private int maxPassengerCapacity;

    /**
     * Random number generator used for simulating passenger boarding and repairs.
     */
    private static final Random random = new Random();

    /**
     * Constructor to initialize the cruise ship with its name and maximum passenger capacity.
     *
     * @param name                The name of the cruise ship.
     * @param maxPassengerCapacity The maximum passenger capacity of the cruise ship.
     */
    public CruiseShip(String name, int maxPassengerCapacity) {
        super(name);
        this.passengerCapacity = 0;
        this.maxPassengerCapacity = maxPassengerCapacity;
    }

    /**
     * Gets the current passenger capacity of the cruise ship.
     *
     * @return The number of passengers currently onboard.
     */
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    /**
     * Displays the current status and information of the cruise ship,
     * including its name, passenger capacity, maximum capacity, and damage level.
     */
    @Override
    public void displayInfo() {
        System.out.println("Cruise Ship: " + getName() +
                ", Current Passengers: " + passengerCapacity +
                ", Max Capacity: " + maxPassengerCapacity +
                ", Damage Level: " + String.format("%.1f", getDamageLevel()) + "%.");
    }

    /**
     * Boards a random number of passengers onto the cruise ship, up to a maximum of 300.
     * If adding the new passengers exceeds the maximum capacity, it limits to the maximum allowed.
     * Also increases the damage level based on the number of new passengers boarded.
     */
    public void boardPassengers() {
        int newPassengers = random.nextInt(300); // Board up to 300 passengers
        if (passengerCapacity + newPassengers > maxPassengerCapacity) {
            newPassengers = maxPassengerCapacity - passengerCapacity; // Limit to max capacity
        }

        passengerCapacity += newPassengers;
        setDamageLevel(getDamageLevel() + newPassengers * 0.01); // Increase damage slightly
        System.out.println("Boarded " + newPassengers + " passengers.");
    }

    /**
     * Repairs the cruise ship by reducing its damage level by a random amount (up to 25%).
     * Ensures that the damage level does not drop below 5%.
     */
    @Override
    public void repair() {
        double repairAmount = random.nextDouble() * 25; // Repair between 0 and 25%
        setDamageLevel(getDamageLevel() - repairAmount);
        if (getDamageLevel() < 5) {  // Ensure a minimum damage level of 5%
            setDamageLevel(5);
        }
        System.out.println("Repaired " + String.format("%.1f", repairAmount) + "%. Current damage level: " +
                String.format("%.1f", getDamageLevel()) + "%.");
    }
}
