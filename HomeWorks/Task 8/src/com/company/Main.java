package com.company;

public class Main {

    public static void main(String[] args) {
        Circle cirkle = new Circle("Круг", 2.5);
        System.out.println(cirkle.getFigure() +" радиус = " + cirkle.getR() + ", площадь = " + cirkle.area());

        Square square = new Square("Квадрат",5);
        System.out.println(square.getFigure() + " со стороной = " + square.side + ", радиус = " + square.getR() + ", площадь = " + square.area());

        Rectangle rectangle = new Rectangle("Прямоугольник", 3, 4);
        System.out.println(rectangle.getFigure() + " со сторонами: " + rectangle.side + ", " + rectangle.width + ", радиус = " + rectangle.getR() + ", площадь = " + rectangle.area());

        Ellipse ellipse = new Ellipse("Эллипс", 3, 4);
        System.out.println(ellipse.getFigure() + " с осями: " + ellipse.r + ", " + ellipse.width + ", площадь = " + ellipse.area());



    Circle figurs[] = {cirkle, square, rectangle, ellipse};

        for (Circle figur : figurs) {
            System.out.println(figur.area());
        }

    }
}