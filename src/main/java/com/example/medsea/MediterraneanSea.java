package com.example.medsea;

/**
 * Represents the Mediterranean Sea with attributes such as water height,
 * total population of species, and spatial limits.
 */
public class MediterraneanSea {

    /**
     * The height of the water level in the Mediterranean Sea.
     */
    private float waterHeight;

    /**
     * The total population of all species in the Mediterranean Sea.
     */
    private float totalPopulation;

    /**
     * The spatial limits of the Mediterranean Sea represented as an array of floats.
     * Typically, this could represent geographic coordinates or dimensions.
     */
    private float[] spatialLimits;

    /**
     * Constructs a new instance of the MediterraneanSea with specified attributes.
     *
     * @param waterHeight     The initial water height.
     * @param totalPopulation The total population of species.
     * @param spatialLimits   The spatial limits of the sea as an array of floats.
     */
    public MediterraneanSea(float waterHeight, float totalPopulation, float[] spatialLimits) {
        this.waterHeight = waterHeight;
        this.totalPopulation = totalPopulation;
        this.spatialLimits = spatialLimits;
    }

    /**
     * Gets the current water height of the Mediterranean Sea.
     *
     * @return The current water height.
     */
    public float getWaterHeight() {
        return waterHeight;
    }

    /**
     * Sets the water height of the Mediterranean Sea.
     *
     * @param waterHeight The new water height.
     */
    public void setWaterHeight(float waterHeight) {
        this.waterHeight = waterHeight;
    }

    /**
     * Gets the total population of species in the Mediterranean Sea.
     *
     * @return The total population.
     */
    public float getTotalPopulation() {
        return totalPopulation;
    }

    /**
     * Sets the total population of species in the Mediterranean Sea.
     *
     * @param totalPopulation The new total population.
     */
    public void setTotalPopulation(float totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    /**
     * Gets the spatial limits of the Mediterranean Sea.
     *
     * @return The spatial limits as an array of floats.
     */
    public float[] getSpatialLimits() {
        return spatialLimits;
    }

    /**
     * Sets the spatial limits of the Mediterranean Sea.
     *
     * @param spatialLimits The new spatial limits as an array of floats.
     */
    public void setSpatialLimits(float[] spatialLimits) {
        this.spatialLimits = spatialLimits;
    }
}
