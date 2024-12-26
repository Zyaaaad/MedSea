package com.example.medsea;

import java.util.Random;

public class Prey extends Animal implements Survivor {
    private String correspondingPredator;
    private boolean school;

    public Prey(int health, boolean fertility, boolean presence, String race,boolean status, String correspondingPredator, boolean school) {
        super(health, fertility, presence, race, status);
        this.correspondingPredator = correspondingPredator;
        this.school = school;
    }

    public String getCorrespondingPredator() {
        return correspondingPredator;
    }

    public void setCorrespondingPredator(String correspondingPredator) {
        this.correspondingPredator = correspondingPredator;
    }

    public boolean isSchool() {
        return school;
    }

    public void setSchool(boolean school) {
        this.school = school;
    }

    @Override
    public LivingSpecies reproduce() {
        if (isFertility() && isPresence()) {
            Prey prey = new Prey(getHealth() / 2, true, true,getRace(), isStatus(),getCorrespondingPredator(),isSchool());
            System.out.println("A new "+getRace()+" was born! With health " + prey.getHealth() + ".");
            return prey;
        } else {
            System.out.println("The "+getRace()+" cannot reproduce.");
            return null;
        }
    }

    public int flee() {
        Random random = new Random();
        int amount = random.nextInt(100) + 1; // entre 1 et 100 inclus
        System.out.println(amount +" of "+getRace()+"flees by hiding or blending in with the school.");
        return amount;
    }

    public void fight() {
        // Implementation for fighting
        System.out.println(getRace()+" is fighting.");
    }

    public void migrate(){
        System.out.println("Prey migrated.");
    }

}