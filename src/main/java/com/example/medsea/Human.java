package com.example.medsea;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Human extends LivingSpecies implements Survivor,Polluters{
    private String job;

    public Human(int health, boolean fertility, boolean presence, String job) {
        super(health, fertility, presence);
        this.job = job;
    }

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public void consumeResources(int amount) {
        validatePresence("eat");
        setHealth(getHealth() + amount);
        System.out.println(job + " has eaten "+ amount +" units of food.Health is now "+getHealth()+".");
    }

    @Override
    public LivingSpecies reproduce() {
        if (isFertility() && isPresence()) {
            Human human = new Human(getHealth() / 2, true, true, getJob());
            System.out.println("A new "+ human.job +" has been created with health " + human.getHealth() + ".");
            return human;
        } else {
            System.out.println(job + " cannot reproduce.");
            return null;
        }
    }

    @Override
    public void die() {
        setPresence(false);
        setHealth(0);
        System.out.println(job + " has died.");
    }

    @Override
    public void disappear() {
        setPresence(false);
        System.out.println(job + " has disappeared.");
    }

    public int fishing(String fishType) {
        validatePresence("fish");
        int amountFished = new Random().nextInt(10) + 1;

        System.out.println(job + " has caught " + amountFished + " " + fishType + (amountFished > 1 ? "s" : "") + "!");
        return amountFished;

    }

    @Override
    public void pollute(Climate climate, double amount) {
        validatePresence("pollute");
        climate.incrementPollution(amount);
        System.out.println(job + " has polluted the environment by " + amount + " units.");
    }


    public String regulate(Climate climate) {
        validatePresence("regulate");

        Season currentSeason = climate.getCurrentSeason();
        System.out.println(job + " is regulating fishing based on the current climate: " + currentSeason);

        String targetFish = switch (currentSeason) {
            case SPRING -> "Tuna";
            case SUMMER -> "Octopus";
            case AUTUMN -> "Shark";
            case WINTER -> "Sardine";
        };
            System.out.println("Targeting fish for the season: " + targetFish);
            return targetFish;
    }


}
