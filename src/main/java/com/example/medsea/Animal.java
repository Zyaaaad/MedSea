package com.example.medsea;

/**
 * Abstract class representing an animal in the ecosystem.
 * Animals can move, consume resources, reproduce, and die.
 */
public abstract class Animal extends LivingSpecies implements Reproducers, Movable, Survivor {

    /**
     * The species of the animal.
     */
    private String race;

    /**
     * The status of the animal (whether it is alive or not).
     */
    private boolean status;

    /**
     * Constructor for the Animal class.
     *
     * @param health The health of the animal.
     * @param fertility The fertility of the animal.
     * @param presence Whether the animal is present in the ecosystem.
     * @param race The species of the animal.
     * @param status The status of the animal (alive or not).
     */
    public Animal(int health, boolean fertility, boolean presence, String race, boolean status) {
        super(health, fertility, presence);
        this.race = race;
        this.status = status;
    }

    /**
     * Gets the species of the animal.
     *
     * @return The species of the animal.
     */
    public String getRace() {
        return race;
    }

    /**
     * Sets the species of the animal.
     *
     * @param race The new species of the animal.
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * Gets the status of the animal.
     *
     * @return The status of the animal (true if alive, false otherwise).
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets the status of the animal.
     *
     * @param status The new status of the animal.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Allows the animal to consume resources and increase its health.
     *
     * @param foodAmount The amount of food to consume.
     */
    @Override
    public void consumeResources(int foodAmount) {
        validatePresence("eat");
        setHealth(getHealth() + foodAmount);
        System.out.println("The " + getRace() + " eats " + foodAmount + " units of food.");
    }

    /**
     * Simulates the death of the animal, reducing its health to zero and marking it as not present.
     */
    @Override
    public void die() {
        validatePresence("die");
        System.out.println("The " + race + " dies.");
        setPresence(false);
        setHealth(0);
        setStatus(false);
    }

    /**
     * Simulates the disappearance of the animal, marking it as not present.
     */
    @Override
    public void disappear() {
        validatePresence("disappear");
        System.out.println("The " + race + " disappears.");
        setPresence(false);
        setStatus(false);
    }

    /**
     * Allows the animal to move to a new location.
     *
     * @return true if the animal successfully moves.
     */
    @Override
    public boolean move() {
        validatePresence("move to a new location");
        System.out.println("The " + getRace() + " moves to a new location.");
        return true;
    }
}
