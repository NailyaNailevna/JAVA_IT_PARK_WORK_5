package com.company;

/**
 * Created by nailya.shakirova on 04.04.2018.
 */
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
        int d = nod(a,b);
        a = a / d;
        b = b / d;
        System.out.println(toDouble());
    }
}
