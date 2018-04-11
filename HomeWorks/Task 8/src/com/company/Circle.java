package com.company;

/**
 * Created by nailya.shakirova on 11.04.2018.
 */
public class Circle {
    protected String figure;
    protected double r;

    public Circle (String figure, double r) {
        this.figure = figure;
        this.r = r;
    }

    public String getFigure() {
        return figure;
    }

    public double getR() {
        return r;
    }

    public double area() {
        return Math.PI * Math.pow(r, 2);
    }

}