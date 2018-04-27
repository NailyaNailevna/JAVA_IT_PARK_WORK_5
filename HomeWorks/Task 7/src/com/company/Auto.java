package com.company;

/**
 * Created by nailya.shakirova on 09.04.2018.
 */
public class Auto extends Transport {
    private double glassWashingConsumption;
//    private double glassWashingAmount;

    public Auto(String model, double fuelConsumption,
                int parameter,
                double glassWashingConsumption) {
        super(model, fuelConsumption,parameter);
        this.glassWashingConsumption = glassWashingConsumption;
    }

    public double getGlassWashingConsumption() {
        return glassWashingConsumption;
    }

    public void go(int km) {
        super.go(km);
        this.parameter = this.parameter - km * (this.glassWashingConsumption / 100);
    }
}
