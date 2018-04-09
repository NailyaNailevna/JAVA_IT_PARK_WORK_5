package com.company;

/**
 * Created by nailya.shakirova on 09.04.2018.
 */
public class Tank extends Transport {
    //private int ammunition;
    private int target;

    public Tank (String model, double fuelConsumption,
                 int parameter) {
        super(model, fuelConsumption,parameter);
        //this.ammunition = ammunition;
    }

//    public int getAmmunition() {
//        return ammunition;
//    }

    public double getTarget() {
        return target;
    }

    public void addAmmunition(int parameter) {
        this.parameter += parameter;
    }

    public void setTarget (int target) {
        this.target = target;
    }

    public void go(int km) {
        super.go(km);
        this.parameter = this.parameter - this.target;
    }
}
