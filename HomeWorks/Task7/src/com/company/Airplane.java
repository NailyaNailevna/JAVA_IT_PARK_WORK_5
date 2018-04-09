package com.company;

/**
 * Created by nailya.shakirova on 09.04.2018.
 */
public class Airplane extends Transport {
    private int height;
    private double exitToHeight;

    public Airplane(String model, double fuelConsumption,
                    int parameter,
                    double exitToHeight) {
        super(model, fuelConsumption,parameter);
        this.exitToHeight = exitToHeight;
    }

    public int getHeight() {
        return height;
    }

    public double getExitToHeight() {
        return exitToHeight;
    }

    public void setHeight(int height) {
        if (this.parameter <= height) {
            this.height = height;
        }
        else {
            System.out.println("Самолет не может лететь на такой высоте, укажите другой параметр");
        }
    }

    public void go(int km) {
        super.go(km);
        this.fuelAmount = this.fuelAmount - this.height * this.exitToHeight* (this.fuelConsumption / 100);
    }
}
