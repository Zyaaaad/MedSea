package com.example.medsea;

/**
 * Represents a crustacean, which is an animal and a survivor in the ecosystem.
 * Crustaceans have attributes for health, fertility, presence, race, status,
 * and whether they are edible.
 */
public class Crustacean extends Animal implements Survivor {
    /**
     * Indicates whether the crustacean is edible.
     */
    private boolean edible;

    /**
     * Constructs a Crustacean instance with the specified attributes.
     *
     * @param health   The health level of the crustacean.
     * @param fertility Indicates if the crustacean is fertile.
     * @param presence Indicates if the crustacean is present in the ecosystem.
     * @param race     The species or type of the crustacean.
     * @param status   The living status of the crustacean (alive or not).
     * @param edible   Indicates whether the crustacean is edible.
     */
    public Crustacean(int health, boolean fertility, boolean presence, String race, boolean status, boolean edible) {
        super(health, fertility, presence, race, status);
        this.edible = edible;
    }

    /**
     * Checks if the crustacean is edible.
     *
     * @return {@code true} if the crustacean is edible; {@code false} otherwise.
     */
    public boolean isEdible() {
        return edible;
    }

    /**
     * Sets whether the crustacean is edible.
     *
     * @param edible {@code true} to make the crustacean edible; {@code false} otherwise.
     */
    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    /**
     * Allows the crustacean to consume resources, increasing its health.
     * Simulates filtering nutrients from the water.
     *
     * @param amount The amount of nutrients to consume.
     */
    @Override
    public void consumeResources(int amount) {
        validatePresence("consume resources");
        setHealth(getHealth() + amount);
        System.out.println(getRace() + " is filtering " + amount + " units of nutrients from the water.");
    }

    /**
     * Allows the crustacean to reproduce, creating a new instance of itself.
     *
     * @return A new {@code Crustacean} instance with the same attributes as the parent.
     */
    @Override
    public LivingSpecies reproduce() {
        validatePresence("reproduce");
        System.out.println("The " + getRace() + " reproduces.");
        return new Crustacean(getHealth(), isFertility(), isPresence(), this.getRace(), isStatus(), this.edible);
    }
}
