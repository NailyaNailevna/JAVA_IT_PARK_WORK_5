package com.company;

public class Main {

    public static void main(String[] args) {
        Auto auto = new Auto("Lada", 6.5, 2, 0.8);
        auto.addFuel(40);
        auto.go(50);
        System.out.println(auto.getModel() + ": пробег - " + auto.getMileage() + ", топлива - " + auto.getFuelAmount() + ", омывайка - " + auto.getParameter());

        Bike bike = new Bike("Ural",5,2,0.9);
        bike.addFuel(15);
        bike.addOil(5);
        auto.go(50);
        System.out.println(bike.getModel() + ": пробег - " + bike.getMileage() + ", топлива - " + bike.getFuelAmount() + ", масло - " + bike.getOilAmount());

        Airplane plane = new Airplane("Tu",1500,5000,0.25);
        plane.setHeight(4500);
        plane.go(9000);
        System.out.println(plane.getModel() + ": пролетел - " + plane.getMileage() + ", на высоте - " + plane.getHeight() + ", осталось топлива - " + plane.getFuelAmount());

        Tank tank = new Tank("T",250,25);
        tank.setTarget(15);
        tank.go(25);
        System.out.println(tank.getModel() + ": проехал - " + tank.getMileage() + ", топлива - " + tank.getFuelAmount() + ", поразил мишеней - " + tank.getParameter());
    }
}
