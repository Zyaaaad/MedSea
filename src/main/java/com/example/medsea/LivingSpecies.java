package com.example.medsea;

/**
 * Represents a generic living species in the ecosystem.
 * This is an abstract class that provides common properties and behavior
 * for all living species, such as health, fertility, and presence.
 */
public abstract class LivingSpecies {

    /**
     * The health level of the living species.
     */
    private int health;

    /**
     * Indicates whether the species is fertile.
     */
    private boolean fertility;

    /**
     * Indicates whether the species is currently present in the ecosystem.
     */
    private boolean presence;

    /**
     * Constructs a new LivingSpecies object with specified attributes.
     *
     * @param health    The health level of the species.
     * @param fertility The fertility status of the species.
     * @param presence  The presence status of the species.
     */
    public LivingSpecies(int health, boolean fertility, boolean presence) {
        this.health = health;
        this.fertility = fertility;
        this.presence = presence;
    }

    /**
     * Gets the health level of the species.
     *
     * @return The health level.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the health level of the species.
     *
     * @param health The new health level.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Checks whether the species is fertile.
     *
     * @return {@code true} if the species is fertile; otherwise, {@code false}.
     */
    public boolean isFertility() {
        return fertility;
    }

    /**
     * Sets the fertility status of the species.
     *
     * @param fertility The new fertility status.
     */
    public void setFertility(boolean fertility) {
        this.fertility = fertility;
    }

    /**
     * Checks whether the species is currently present in the ecosystem.
     *
     * @return {@code true} if the species is present; otherwise, {@code false}.
     */
    public boolean isPresence() {
        return presence;
    }

    /**
     * Sets the presence status of the species.
     *
     * @param presence The new presence status.
     */
    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    /**
     * Validates whether the species is present before performing an action.
     *
     * @param action The action to validate.
     * @throws IllegalStateException if the species is not present.
     */
    protected void validatePresence(String action) {
        if (!isPresence()) {
            throw new IllegalStateException(getClass().getSimpleName() +
                    " is not present and cannot " + action + ".");
        }
    }

    /**
     * Abstract method to define the behavior of a species when it dies.
     * This must be implemented by subclasses.
     */
    public abstract void die();

    /**
     * Abstract method to define the behavior of a species when it disappears.
     * This must be implemented by subclasses.
     */
    public abstract void disappear();
}
