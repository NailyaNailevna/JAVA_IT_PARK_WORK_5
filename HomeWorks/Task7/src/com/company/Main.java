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
        bike.go(50);
        System.out.println(bike.getModel() + ": пробег - " + bike.getMileage() + ", топлива - " + bike.getFuelAmount() + ", масло - " + bike.getOilAmount());

        Airplane plane = new Airplane("Tu",450,5,0.25);
        plane.addFuel(40000);
        //plane.setHeight(4500);
        plane.go(6000,4.5);
        System.out.println(plane.getModel() + ": пролетел - " + plane.getMileage() + ", на высоте - " + plane.getHeight() + ", осталось топлива - " + plane.getFuelAmount());

        Tank tank = new Tank("T",450,25);
        tank.addFuel(460);
        tank.setTarget(15);
        tank.go(50);
        System.out.println(tank.getModel() + ": проехал - " + tank.getMileage() + ", топлива - " + tank.getFuelAmount() + ", осталось боезапаса - " + tank.getParameter());
    }
}
