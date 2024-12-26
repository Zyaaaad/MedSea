package com.example.medsea;

public abstract class Animal extends LivingSpecies implements Reproducers,Movable,Survivor{
    private String race;
    private boolean status;

    public Animal(int health, boolean fertility, boolean presence, String race, boolean status) {
        super(health, fertility, presence);
        this.race = race;
        this.status = status;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void consumeResources(int foodAmount) {
        validatePresence("eat");
        setHealth(getHealth() + foodAmount);
        System.out.println("The " + getRace() + " eats " + foodAmount + " units of food.");
    }

    @Override
    public void die() {
        validatePresence("die");
        System.out.println("The " + race + " dies.");
        setPresence(false);
        setHealth(0);
        setStatus(false);
    }

    @Override
    public void disappear() {
        validatePresence("disappear");
        System.out.println("The " + race + " disappears.");
        setPresence(false);
        setStatus(false);
    }

    @Override
    public boolean move(){
        validatePresence("move to a new location");
        System.out.println("The "+getRace()+" moves to a new location.");
        return true;
    }
}