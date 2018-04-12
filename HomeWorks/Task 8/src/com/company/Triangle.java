package com.company;

/**
 * Created by nailya.shakirova on 11.04.2018.
 */
public class Triangle extends Ellipse{

    public Triangle (String figure, double side, double width) {
        super(figure,side,width);
        //this.side = side  //сторона-основание
        //this.width = width; // высота к стороне-основанию
    }

/* S = (a · b · с) / 4R*/
// S = 1/2 * a * h
    public double area() {
        return (side * width) / 2;
    }
}
