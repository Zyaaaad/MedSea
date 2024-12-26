package com.example.medsea;
public class MediterraneanSea {
    private float waterHeight;
    private float totalPopulation;
    private float[] spatialLimits;

    // Constructor
    public MediterraneanSea(float waterHeight, float totalPopulation, float[] spatialLimits) {
        this.waterHeight = waterHeight;
        this.totalPopulation = totalPopulation;
        this.spatialLimits = spatialLimits;
    }

    // Getters and Setters
    public float getWaterHeight() {
        return waterHeight;
    }

    public void setWaterHeight(float waterHeight) {
        this.waterHeight = waterHeight;
    }

    public float getTotalPopulation() {
        return totalPopulation;
    }

    public void setTotalPopulation(float totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public float[] getSpatialLimits() {
        return spatialLimits;
    }

    public void setSpatialLimits(float[] spatialLimits) {
        this.spatialLimits = spatialLimits;
    }
}