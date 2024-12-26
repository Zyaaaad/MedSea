package com.example.medsea;

public abstract class Vehicle {
    private String name;
    private double damageLevel;

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

    // Abstract method for specific behavior
    public abstract void displayInfo();
    public abstract void repair();
}
