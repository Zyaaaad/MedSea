package com.example.medsea;

public abstract class LivingSpecies implements Reproducers {
    private int health;
    private boolean fertility;
    private boolean presence;

    public LivingSpecies(int health, boolean fertility, boolean presence) {
        this.health = health;
        this.fertility = fertility;
        this.presence = presence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isFertility() {
        return fertility;
    }

    public void setFertility(boolean fertility) {
        this.fertility = fertility;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    protected void validatePresence(String action) {
        if (!isPresence()) {
            throw new IllegalStateException(getClass().getSimpleName()+ " is not present and cannot " + action + ".");
        }
    }

    public abstract void die();

    public abstract void disappear();
}


