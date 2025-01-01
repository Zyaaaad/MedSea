package com.example.medsea;

/**
 * Represents a plant in the Mediterranean Sea ecosystem.
 * A plant has density, health, fertility, presence, and the ability to be venomous.
 */
public class Plant extends LivingSpecies implements Survivor {

    /**
     * The density of the plant, which may influence its ability to provide shelter.
     */
    private float density;

    /**
     * Indicates if the plant is venomous.
     */
    private boolean isVenomous;

    /**
     * Constructs a new Plant with specified attributes.
     *
     * @param health     The health of the plant.
     * @param fertility  The fertility status of the plant.
     * @param presence   Whether the plant is present in the ecosystem.
     * @param density    The density of the plant.
     * @param isVenomous Whether the plant is venomous.
     */
    public Plant(int health, boolean fertility, boolean presence, float density, boolean isVenomous) {
        super(health, fertility, presence);
        this.density = density;
        this.isVenomous = isVenomous;
    }

    /**
     * Gets the density of the plant.
     *
     * @return The density of the plant.
     */
    public float getDensity() {
        return density;
    }

    /**
     * Sets the density of the plant.
     *
     * @param density The new density of the plant.
     */
    public void setDensity(float density) {
        this.density = density;
    }

    /**
     * Checks if the plant is venomous.
     *
     * @return True if the plant is venomous, otherwise false.
     */
    public boolean isVenomous() {
        return isVenomous;
    }

    /**
     * Sets whether the plant is venomous.
     *
     * @param venomous The new venomous status of the plant.
     */
    public void setVenomous(boolean venomous) {
        isVenomous = venomous;
    }

    /**
     * Absorbs resources (e.g., nutrients) to maintain or improve health.
     *
     * @param amount The amount of resources absorbed.
     */
    @Override
    public void consumeResources(int amount) {
        validatePresence("absorb resources");
        setHealth(getHealth() + amount);
        System.out.println("Plant is absorbing " + amount + " units of nutrients. Health is now " + getHealth() + ".");
    }

    /**
     * Reproduces a new plant with similar attributes.
     *
     * @return A new Plant instance.
     */

    public LivingSpecies reproduce() {
        validatePresence("reproduce");
        System.out.println("Plant is reproducing.");
        return new Plant(getHealth(), isFertility(), isPresence(), density, isVenomous);
    }

    /**
     * Simulates the death of the plant.
     * Sets the plant's presence to false.
     */
    @Override
    public void die() {
        setPresence(false);
        setHealth(0);
        System.out.println("Plant has died.");
    }

    /**
     * Simulates the disappearance of the plant from the ecosystem.
     */
    @Override
    public void disappear() {
        setPresence(false);
        System.out.println("Plant has disappeared.");
    }

    /**
     * Determines if the plant can be safely eaten.
     *
     * @return True if the plant is not venomous, otherwise false.
     */
    public boolean canBeEaten() {
        if (isVenomous) {
            System.out.println("This plant is venomous and cannot be eaten.");
            return false;
        } else {
            System.out.println("This plant is safe to eat.");
            return true;
        }
    }

    /**
     * Determines if the plant can provide shelter based on its density.
     *
     * @return True if the plant's density is greater than 5.0, otherwise false.
     */
    public boolean provideShelter() {
        if (density > 5.0) {
            System.out.println("Plant is providing shelter.");
            return true;
        } else {
            System.out.println("Plant's density is too low to provide shelter.");
            return false;
        }
    }
}
