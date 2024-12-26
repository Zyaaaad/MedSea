package com.example.medsea;

public class Crustacean extends Animal implements Survivor {
    private boolean edible;

    public Crustacean(int health, boolean fertility, boolean presence, String race, boolean status, boolean edible) {
        super(health, fertility, presence, race, status);
        this.edible = edible;
    }

    public boolean isEdible() {
        return edible;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    @Override
    public void consumeResources(int amount) {
        validatePresence("consume resources");
        setHealth(getHealth() + amount);
        System.out.println(getRace()+" is filtering " + amount + " units of nutrients from the water.");
    }

    @Override
    public LivingSpecies reproduce() {
        validatePresence("reproduce");
        System.out.println("The "+getRace()+" reproduces.");
        return new Crustacean(getHealth(), isFertility(), isPresence(), this.getRace(), isStatus(),this.edible);
    }

}