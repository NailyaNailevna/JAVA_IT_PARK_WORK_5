package com.company;
import java.util.Scanner;

public class Main {

    public static int sumAr(int a, int b) {
        int funkSum = 0;
        for (int i = a; i <= b; i++){
            funkSum = funkSum + i;
        }
        return funkSum;
    }

    public static int sumZifr(int a) {
        int funkSum = 0;
        while (a != 0) {
            funkSum = funkSum + a % 10;
            a = a/10;
        }
        return funkSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите 2 числа n и m:");

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int progSum;

        if (n <= m){
            progSum = sumAr(n,m);
        }
        else{
            progSum = sumAr(m,n);
        }

        System.out.println(progSum);
    }
}
