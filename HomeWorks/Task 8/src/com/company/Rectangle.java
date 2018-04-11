package com.company;

/**
 * Created by nailya.shakirova on 11.04.2018.
 */
public class Rectangle extends Square{
    protected double width; // сторона-ширина

    public Rectangle (String figure, double side, double width) {
        super(figure, Math.sqrt(Math.pow(side, 2) + Math.pow(width, 2)) / Math.sqrt(2));
        this.side = side;   // сторона-высота
        this.width = width; // сторона-ширина
    }

    public double getWidth() {
        return width;
    }
//      S = a√(Do2 - a2) = b√(Do2 - b2)
    public double area() {
        return side * Math.sqrt((Math.pow(side, 2) + Math.pow(width, 2)) - Math.pow(side,2));
    }
}