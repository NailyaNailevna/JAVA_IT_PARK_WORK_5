package com.company;

public class RationalNumber {
    int a;
    int b;

    public RationalNumber() {
        a = 0;
        b = 1;
    }

    public RationalNumber (int aa, int bb) {
        a = aa;
        b = bb;
    }

    void show () {
        System.out.println(a + "/" + b);
    }

    double toDouble() {
        double x = (double)(a/b);
        return x;
    }
}
