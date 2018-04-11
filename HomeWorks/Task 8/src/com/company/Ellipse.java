package com.company;

/**
 * Created by nailya.shakirova on 11.04.2018.
 */
public class Ellipse extends Rectangle {

    public Ellipse (String figure, double side, double width) {
        super(figure, side, width);
        this.r = width;
        this.side = side;   // сторона-высота
        this.width = width; // сторона-ширина
    }
//S = πab
    public double area() {
        return Math.PI * side * width;
    }
}
