package com.example.medsea;

public class Plant extends LivingSpecies implements Survivor{
    private float density;
    private boolean isVenomous; // Indique si la plante est vénéneuse

    public Plant(int health, boolean fertility, boolean presence, float density, boolean isVenomous) {
        super(health, fertility, presence);
        this.density = density;
        this.isVenomous = isVenomous;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public boolean isVenomous() {
        return isVenomous;
    }

    public void setVenomous(boolean venomous) {
        isVenomous = venomous;
    }

    @Override
    public void consumeResources(int amount) {
        validatePresence("absorb resources");
        System.out.println("Plant is absorbing " + amount + " units of nutrients.");
    }

    @Override
    public LivingSpecies reproduce() {
        // Implementation for plant reproduction
        System.out.println("Plant is reproducing.");
        return new Plant(getHealth(), isFertility(), isPresence(), density, isVenomous);
    }

    @Override
    public void die() {
        // Implementation for plant death
        System.out.println("Plant has died.");
        setPresence(false);
    }

    @Override
    public void disappear() {
        // Implementation for plant disappearance
        System.out.println("Plant has disappeared.");
        setPresence(false);
    }

    public boolean canBeEaten() {
        if (isVenomous) {
            System.out.println("This plant is venomous and cannot be eaten.");
            return false;
        } else {
            System.out.println("This plant is safe to eat.");
            return true;
        }
    }

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