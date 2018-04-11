package com.company;

/**
 * Created by nailya.shakirova on 11.04.2018.
 */
public class Square extends Circle {
    protected double side;  //сторона квадрата

    public Square (String figure, double side) {
        super(figure, Math.sqrt(2) * side/2);
        this.side = side;
    }

    public double getSide() {
        return side;
    }
//S = D^2/2
    public double area() {
        return Math.pow(r*2, 2)/2;
    }

}