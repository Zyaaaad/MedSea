package com.example.medsea;

import java.util.Random;

public class CruiseShip extends Vehicle {
    private int passengerCapacity;
    private int maxPassengerCapacity;

    private static final Random random = new Random();

    public CruiseShip(String name, int maxPassengerCapacity) {
        super(name);
        this.passengerCapacity = 0;
        this.maxPassengerCapacity = maxPassengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Cruise Ship: " + getName() +
                ", Current Passengers: " + passengerCapacity +
                ", Max Capacity: " + maxPassengerCapacity +
                ", Damage Level: " + String.format("%.1f", getDamageLevel()) + "%.");

    }

    public void boardPassengers() {
        int newPassengers = random.nextInt(300); // Board up to 300 passengers
        if (passengerCapacity + newPassengers > maxPassengerCapacity) {
            newPassengers = maxPassengerCapacity - passengerCapacity; // Limit to max capacity
        }

        passengerCapacity += newPassengers;
        setDamageLevel(getDamageLevel()+ newPassengers * 0.01); // Increase damage slightly
        System.out.println("Boarded " + newPassengers + " passengers.");
    }

    @Override
    public void repair() {
        double repairAmount = random.nextDouble() * 25; // Repair between 0 and 25%
        setDamageLevel(getDamageLevel()- repairAmount);
        if (getDamageLevel() < 5) {  // Ensure a minimum damage level of 5%
            setDamageLevel(5);
        }
        System.out.println("Repaired " + String.format("%.1f", repairAmount) + "%. Current damage level: " + String.format("%.1f", getDamageLevel()) + "%.");
    }

}
