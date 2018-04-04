package com.company;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите 2 числа m и n:");

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        RationalNumber rationalNumber;

        rationalNumber = new RationalNumber(m,n);

        rationalNumber.show();

        System.out.println(rationalNumber.toDouble());

        System.out.println(rationalNumber.nod(m,n));

        rationalNumber.optimize();
    }
}
