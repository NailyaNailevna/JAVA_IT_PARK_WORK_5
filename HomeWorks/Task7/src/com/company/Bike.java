package com.company;

/**
 * Created by nailya.shakirova on 09.04.2018.
 */
public class Bike extends Transport {
    private double oilConsuption;
    private double oilAmount;

    public Bike(String model, double fuelConsumption,
                double parameter,
                double oilConsuption) {
        super(model, fuelConsumption,parameter);
        this.oilConsuption = oilConsuption;
    }

    public double getOilConsuption() {
        return oilConsuption;
    }

    public double getOilAmount() {
        return oilAmount;
    }

    public void addOil(double oilAmount) {
        if (this.parameter <= this.oilAmount + oilAmount) {
            this.oilAmount += oilAmount;
        }
        else {
            this.oilAmount = this.parameter;
            System.out.println("Полный бак масла");
        }
    }

    public void go(int km) {
        super.go(km);
        this.oilAmount = this.oilAmount - km * (this.oilConsuption / 100);
    }
}
