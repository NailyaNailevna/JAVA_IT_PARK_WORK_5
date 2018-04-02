package com.company;

public class Main {

    public static void main(String[] args) {
        RationalNumber rationalNumber;

        rationalNumber = new RationalNumber(4,5);

        rationalNumber.show();

        System.out.println(rationalNumber.toDouble());
    }
}
