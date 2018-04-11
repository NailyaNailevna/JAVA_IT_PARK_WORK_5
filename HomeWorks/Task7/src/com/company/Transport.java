package com.company;

/**
 * Created by nailya.shakirova on 09.04.2018.
 */
public class Transport {
    private String model;
    protected int mileage;
    protected double fuelConsumption;
    protected double fuelAmount;
    protected double parameter;

    public Transport(String model, double fuelConsumption, double parameter) {
        this.model = model;
        this.mileage = 0;
        this.fuelConsumption = fuelConsumption;
        this.fuelAmount = 0;
        this.parameter = parameter;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getParameter() {
        return parameter;
    }

    public void addFuel(double fuel) {
        this.fuelAmount += fuel;
    }

    public void go(int km) {
        this.mileage = mileage + km;
        this.fuelAmount = this.fuelAmount - km * (this.fuelConsumption / 100);
    }
}
