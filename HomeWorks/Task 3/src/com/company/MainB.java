package com.company;
import java.util.Scanner;

/**
 * Created by nailya.shakirova on 02.04.2018.
 */
public class MainB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите 2 числа n и m для определения размерности массива:");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int matrixB[][] = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            if ((i + 1) % 2 == n % 2) {
                for (int j = m - 1; j >= 0; j--) {
                    matrixB[i][j] = (m * i + (j + 1));
                }
//                System.out.println(i+1);
            } else {
                for (int j = 0; j <= m - 1; j++) {
                    matrixB[i][j] = (m * i + (m - j));
                }
            }
        }

        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= m - 1; j++) {
                System.out.print(matrixB[i][j] + " ");
            }
            System.out.println();
        }

    }
}
