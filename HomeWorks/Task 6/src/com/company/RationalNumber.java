package com.company;

public class RationalNumber {
    private int dividend;
    private int divider;

    public RationalNumber() {
        this.dividend = 0;
        this.divider = 1;
    }

    public RationalNumber (int dividend, int divider) {
        this.dividend = dividend;
        if (divider == 0) {
            this.divider = 1;
        }
        else {
            this.divider = divider;
        }
    }

    public int getDivident() {
        return dividend;
    }

    public int getDivider() {
        return divider;
    }

    void show () {
        System.out.println(dividend + "/" + divider);
    }

    double toDouble() {
        double x = (double)(dividend/divider);
        return x;
    }

    int nod (int m, int n) {
        while (m != 0 && n != 0) {
            if (m > n) {
                m = m % n;
            }
            else {
                n = n % m;
            }
        }
        return m + n;
    }

    void optimize(){
        int d = nod(dividend,divider);
//        RationalNumber optimRationalNumber;
        RationalNumber optimRationalNumber = new RationalNumber (this.dividend / d, this.divider / d);
//        this.dividend = this.dividend / d;
//        this.divider = this.divider / d;
        System.out.println(optimRationalNumber.toDouble());
    }
}
