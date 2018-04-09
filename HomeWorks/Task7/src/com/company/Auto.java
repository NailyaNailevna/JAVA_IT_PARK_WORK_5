package com.company;

/**
 * Created by nailya.shakirova on 09.04.2018.
 */
public class Auto extends Transport {
    private int glassWashingConsumption;
//    private double glassWashingAmount;

    public Auto(String model, double fuelConsumption,
                int parameter,
                int glassWashingConsumption) {
        super(model, fuelConsumption,parameter);
        this.glassWashingConsumption = glassWashingConsumption;
    }

    public int getGlassWashingConsumption() {
        return glassWashingConsumption;
    }

    public void go(int km) {
        super.go(km);
        this.glassWashingConsumption = this.parameter - km * (this.glassWashingConsumption / 100);
    }
}
