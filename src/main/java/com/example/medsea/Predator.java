package com.example.medsea;

import java.util.Random;

/**
 * Represents a predator in the Mediterranean Sea ecosystem.
 * Predators have health, fertility, presence, a specific race, and corresponding prey species.
 */
public class Predator extends Animal {

    /**
     * The type of prey that this predator hunts.
     */
    private String correspondingPreys;

    /**
     * Constructs a Predator with specified attributes.
     *
     * @param health             The health of the predator.
     * @param fertility          The fertility status of the predator.
     * @param presence           Whether the predator is present in the ecosystem.
     * @param race               The race or species of the predator.
     * @param status             The status (e.g., active or inactive) of the predator.
     * @param correspondingPreys The type of prey this predator hunts.
     */
    public Predator(int health, boolean fertility, boolean presence, String race, boolean status, String correspondingPreys) {
        super(health, fertility, presence, race, status);
        this.correspondingPreys = correspondingPreys;
    }

    /**
     * Gets the type of prey this predator hunts.
     *
     * @return The corresponding prey type.
     */
    public String getCorrespondingPreys() {
        return correspondingPreys;
    }

    /**
     * Sets the type of prey this predator hunts.
     *
     * @param correspondingPreys The new corresponding prey type.
     */
    public void setCorrespondingPreys(String correspondingPreys) {
        this.correspondingPreys = correspondingPreys;
    }

    /**
     * Reproduces a new predator if conditions are met.
     * The offspring inherits half the health of the parent and other attributes.
     *
     * @return A new Predator instance if reproduction is successful, otherwise null.
     */
    @Override
    public LivingSpecies reproduce() {
        if (isFertility() && isPresence()) {
            Predator predator = new Predator(getHealth() / 2, true, true, getRace(), isStatus(), getCorrespondingPreys());
            System.out.println("A new " + getRace() + " was born! With health " + predator.getHealth() + ".");
            return predator;
        } else {
            System.out.println("The " + getRace() + " cannot reproduce.");
            return null;
        }
    }

    /**
     * Simulates the predator hunting for prey.
     * The predator consumes a random amount of prey units between 1 and 20.
     *
     * @return The number of prey units consumed.
     */
    public int hunt() {
        validatePresence("hunt");
        Random random = new Random();
        int amount = random.nextInt(20) + 1; // Random value between 1 and 20 inclusive
        setHealth(getHealth() + amount); // Increase predator's health by the amount consumed
        System.out.println("The " + getRace() + " has eaten " + amount + " units of " + correspondingPreys + ".");
        return amount;
    }
}
