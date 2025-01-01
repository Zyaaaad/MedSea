package com.example.medsea;

import java.util.Random;

/**
 * Represents a prey species in the Mediterranean Sea ecosystem.
 * Prey species can flee, fight, migrate, and reproduce.
 */
public class Prey extends Animal implements Survivor {

    /**
     * The predator that hunts this prey.
     */
    private String correspondingPredator;

    /**
     * Whether the prey species forms a school (group).
     */
    private boolean school;

    /**
     * Constructs a Prey with specified attributes.
     *
     * @param health             The health of the prey.
     * @param fertility          The fertility status of the prey.
     * @param presence           Whether the prey is present in the ecosystem.
     * @param race               The race or species of the prey.
     * @param status             The status (e.g., active or inactive) of the prey.
     * @param correspondingPredator The predator that hunts this prey.
     * @param school             Whether the prey forms a school.
     */
    public Prey(int health, boolean fertility, boolean presence, String race, boolean status, String correspondingPredator, boolean school) {
        super(health, fertility, presence, race, status);
        this.correspondingPredator = correspondingPredator;
        this.school = school;
    }

    /**
     * Gets the predator that hunts this prey.
     *
     * @return The corresponding predator.
     */
    public String getCorrespondingPredator() {
        return correspondingPredator;
    }

    /**
     * Sets the predator that hunts this prey.
     *
     * @param correspondingPredator The new predator.
     */
    public void setCorrespondingPredator(String correspondingPredator) {
        this.correspondingPredator = correspondingPredator;
    }

    /**
     * Gets whether the prey species forms a school.
     *
     * @return True if the prey forms a school, otherwise false.
     */
    public boolean isSchool() {
        return school;
    }

    /**
     * Sets whether the prey species forms a school.
     *
     * @param school Whether the prey forms a school.
     */
    public void setSchool(boolean school) {
        this.school = school;
    }

    /**
     * Reproduces a new prey if conditions are met.
     * The offspring inherits half the health of the parent and other attributes.
     *
     * @return A new Prey instance if reproduction is successful, otherwise null.
     */
    @Override
    public LivingSpecies reproduce() {
        if (isFertility() && isPresence()) {
            Prey prey = new Prey(getHealth() / 2, true, true, getRace(), isStatus(), getCorrespondingPredator(), isSchool());
            System.out.println("A new " + getRace() + " was born! With health " + prey.getHealth() + ".");
            return prey;
        } else {
            System.out.println("The " + getRace() + " cannot reproduce.");
            return null;
        }
    }

    /**
     * Simulates the prey fleeing from predators.
     * The prey attempts to escape by hiding or blending with the school.
     *
     * @return The amount of prey that successfully flees.
     */
    public int flee() {
        Random random = new Random();
        int amount = random.nextInt(100) + 1; // Random value between 1 and 100 inclusive
        System.out.println(amount + " of " + getRace() + " flee by hiding or blending in with the school.");
        return amount;
    }

    /**
     * Simulates the prey fighting. This can be expanded to simulate defense mechanisms.
     */
    public void fight() {
        // Placeholder for fighting logic
        System.out.println(getRace() + " is fighting.");
    }

    /**
     * Simulates the prey migrating to a new location.
     */
    public void migrate() {
        System.out.println(getRace() + " migrated.");
    }
}
