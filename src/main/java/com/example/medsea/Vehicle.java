package com.example.medsea;

public abstract class Vehicle {
    private String name;
    private double damageLevel;

    /**
     * Constructor to initialize vehicle with a name and default damage level.
     *
     * @param name Name of the vehicle.
     */
    public Vehicle(String name) {
        this.name = name;
        this.damageLevel = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDamageLevel() {
        return damageLevel;
    }

    public void setDamageLevel(double damageLevel) {
        this.damageLevel = damageLevel;
    }

    /**
     * Abstract method for displaying vehicle-specific information.
     */
    public abstract void displayInfo();

    /**
     * Abstract method for vehicle-specific repair behavior.
     */
    public abstract void repair();

    /**
     * A method to simulate the vehicle moving. Can be overridden for specific movement behavior.
     *
     * @return true if the vehicle can move, false otherwise
     */
    public boolean move() {
        System.out.println(name + " is moving.");
        return true; // Default behavior, can be overridden if necessary.
    }

    /**
     * A method to check if the vehicle is damaged. Can be extended in subclasses.
     *
     * @return true if the vehicle is damaged (damage level >= 50%), false otherwise.
     */
    public boolean isDamaged() {
        return damageLevel >= 50.0;
    }
}
