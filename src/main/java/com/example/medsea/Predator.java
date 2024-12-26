package com.example.medsea;

import java.util.Random;

public class Predator extends Animal {
    private String correspondingPreys;

    public Predator(int health, boolean fertility, boolean presence, String race, boolean status, String correspondingPreys) {
        super(health, fertility, presence, race, status);
        this.correspondingPreys = correspondingPreys;
    }

    public String getCorrespondingPreys() {
        return correspondingPreys;
    }

    public void setCorrespondingPreys(String correspondingPreys) {
        this.correspondingPreys = correspondingPreys;
    }

    @Override
    public LivingSpecies reproduce() {
        if (isFertility() && isPresence()) {
            Predator predator = new Predator(getHealth() / 2, true, true,getRace(),isStatus(),getCorrespondingPreys());
            System.out.println("A new "+getRace()+" was born! With health " + predator.getHealth() + ".");
            return predator;
        } else {
            System.out.println("The "+getRace()+" cannot reproduce.");
            return null;
        }
    }

    public int hunt() {
        validatePresence("hunt");
        Random random = new Random();
        int amount = random.nextInt(20) + 1; // entre 1 et 20 inclus
        System.out.println("The "+getRace()+" has eaten " + amount + " units of "+ correspondingPreys+".");
        return amount;
    }

}

