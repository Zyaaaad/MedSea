package com.example.medsea;

import java.util.Random;

/**
 * Represents a human in the ecosystem. Humans are a type of living species that consume resources,
 * reproduce, fish, pollute, and regulate environmental activities based on their job and the climate.
 */
public class Human extends LivingSpecies implements Survivor, Polluters {

    /**
     * The profession or role of the human.
     */
    private String job;

    /**
     * Constructs a Human object with specified attributes.
     *
     * @param health    The health of the human.
     * @param fertility The fertility status of the human.
     * @param presence  The presence status of the human.
     * @param job       The job or profession of the human.
     */
    public Human(int health, boolean fertility, boolean presence, String job) {
        super(health, fertility, presence);
        this.job = job;
    }

    /**
     * Gets the job or profession of the human.
     *
     * @return The job of the human.
     */
    public String getJob() {
        return job;
    }

    /**
     * Sets the job or profession of the human.
     *
     * @param job The new job of the human.
     */
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public void consumeResources(int amount) {
        validatePresence("eat");
        setHealth(getHealth() + amount);
        System.out.println(job + " has eaten " + amount + " units of food. Health is now " + getHealth() + ".");
    }


    public LivingSpecies reproduce() {
        if (isFertility() && isPresence()) {
            Human human = new Human(getHealth() / 2, true, true, getJob());
            System.out.println("A new " + human.job + " has been created with health " + human.getHealth() + ".");
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

    /**
     * Allows the human to fish and catch a random amount of a specified type of fish.
     *
     * @param fishType The type of fish to catch.
     * @return The number of fish caught.
     */
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

    /**
     * Regulates fishing activities based on the current climate and season.
     *
     * @param climate The current climate of the ecosystem.
     * @return The type of fish targeted for the current season.
     */
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
