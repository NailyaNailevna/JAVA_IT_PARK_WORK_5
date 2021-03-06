package com.company;
import java.util.Scanner;

/**
 * Created by nailya.shakirova on 02.04.2018.
 */
public class MainC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите 2 числа n и m для определения размерности массива:");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int matrixC[][] = new int[n][m];

        for (int i = 0; i <= n - 1;i++) {
            System.out.println("Введите " + m + " чисел(ла) " + (int)(i+1) + " строки");
            for (int j = 0; j <= m - 1; j++){
                matrixC[i][j] = scanner.nextInt();
            }
        }

        int minValMatrix[] = new int[n];

        for (int i = 0; i <= n - 1;i++) {
            minValMatrix[i] = matrixC[i][0];
        }

        for (int i = 0; i <= n - 1;i++) {
            for (int j = 0; j <= m - 1; j++) {
                if (matrixC[i][j] <= minValMatrix[i]){
                    minValMatrix[i] = matrixC[i][j];
                }
            }
            System.out.println("Минимальный элемент " + (int)(i+1) + "-ой строки: " + minValMatrix[i]);
        }
    }
}
