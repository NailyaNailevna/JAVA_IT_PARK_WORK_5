package com.company;

public class Main {

    public static void main(String[] args) {
        Auto auto = new Auto("Lada", 6.5, 2, 0.8);
        auto.addFuel(40);
        auto.go(50);

        Bike bike = new Bike("Ural",5,2,0.9);
        bike.addFuel(15);
        bike.addOil(5);
        auto.go(50);

        Airplane plane = new Airplane("Tu",1500,5000,0.25);
        plane.setHeight(4500);
        plane.go(9000);

        Tank tank = new Tank("T",250,25);
        tank.setTarget(15);
        tank.go(25);
    }
}
