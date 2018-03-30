package com.company;
import java.util.Scanner;

public class MainA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите 2 числа n и m для определения размерности массива:");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int matrixA[][] = new int[n][m];

        for (int i = 0; i <= n - 1;i++) {
            System.out.println("Введите " + n + " чисел(ла) " + (int)(i+1) + " строки");
            for (int j = 0; j <= m - 1; j++){
                matrixA[i][j] = scanner.nextInt();
            }
        }



        for (int row[] : matrixA) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
