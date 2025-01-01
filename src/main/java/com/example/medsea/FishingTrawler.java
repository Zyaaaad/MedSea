package com.example.medsea;

import java.util.Random;

/**
 * Represents a fishing trawler, a type of vehicle used for catching fish in the ecosystem.
 * It has attributes for fish capacity, maximum capacity, and functionality to fish and repair itself.
 */
public class FishingTrawler extends Vehicle implements Movable {
    /**
     * The current amount of fish on the trawler, in tons.
     */
    private double fishCapacity;

    /**
     * The maximum fish capacity of the trawler, in tons.
     */
    private double maxFishCapacity;

    private static final Random random = new Random();

    /**
     * Constructs a FishingTrawler instance with the specified name and maximum capacity.
     *
     * @param name           The name of the trawler.
     * @param maxFishCapacity The maximum fish capacity of the trawler in tons.
     */
    public FishingTrawler(String name, double maxFishCapacity) {
        super(name);
        this.fishCapacity = 0;
        this.maxFishCapacity = maxFishCapacity;
    }

    /**
     * Gets the current amount of fish on the trawler.
     *
     * @return The current fish capacity in tons.
     */
    public double getFishCapacity() {
        return fishCapacity;
    }

    /**
     * Displays detailed information about the fishing trawler.
     * Includes the name, current fish capacity, maximum capacity, and damage level.
     */
    @Override
    public void displayInfo() {
        System.out.println("Fishing Trawler: " + getName() +
                ", Current Fish: " + String.format("%.1f", fishCapacity) + " tons" +
                ", Max Capacity: " + String.format("%.1f", maxFishCapacity) + " tons" +
                ", Damage Level: " + String.format("%.1f", getDamageLevel()) + "%.");
    }

    /**
     * Simulates the movement of the fishing trawler to a new fishing area.
     *
     * @return {@code true} indicating the trawler has moved.
     */
    @Override
    public boolean move() {
        System.out.println("Fishing boat is moving to a new fishing area.");
        return true;
    }

    /**
     * Simulates the fishing process by catching a random amount of fish.
     * If the trawler is too damaged, it cannot fish.
     * The amount of fish caught is limited by the maximum capacity.
     */
    public void fish() {
        double fishCaught = random.nextDouble() * 20; // Catch up to 20 tons
        if (getDamageLevel() >= 100) {
            System.out.println("The trawler is too damaged to fish.");
            return;
        }

        if (fishCapacity + fishCaught > maxFishCapacity) {
            fishCaught = maxFishCapacity - fishCapacity; // Limit to max capacity
        }

        fishCapacity += fishCaught;
        setDamageLevel(getDamageLevel() + fishCaught * 0.05); // Increase damage slightly
        System.out.println("Caught " + String.format("%.1f", fishCaught) + " tons of fish.");
    }

    /**
     * Repairs the fishing trawler by reducing its damage level.
     * The repair amount is random and capped at 20%.
     * Ensures a minimum damage level of 5%.
     */
    @Override
    public void repair() {
        double repairAmount = random.nextDouble() * 20; // Repair between 0 and 20%
        setDamageLevel(getDamageLevel() - repairAmount);
        if (getDamageLevel() < 5) {  // Ensure a minimum damage level of 5%
            setDamageLevel(5);
        }
        System.out.println("Repaired " + String.format("%.1f", repairAmount) + "%. Current damage level: " +
                String.format("%.1f", getDamageLevel()) + "%.");
    }
}
