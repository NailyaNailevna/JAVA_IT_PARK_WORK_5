//Вывести минимумы каждой строки произвольной матрицы.

package com.company;
import java.util.Scanner;

public class MainС {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите 2 числа n и m для определения размерности массива:");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int matrixC[][] = new int[n][m];

        for (int i = 0; i <= n - 1;i++) {
            System.out.println("Введите " + n + " чисел(ла) " + (int)(i+1) + " строки");
            for (int j = 0; j <= m - 1; j++){
                matrixC[i][j] = scanner.nextInt();
            }
        }

        int minValMatrix[] = new int[n];

//        int minVal = 0;

        for (int i = 0; i <= n - 1;i++) {
            for (int j = 0; j <= m - 1; j++) {
                if (matrixC[i][j] <= minValMatrix[i]){
                    minValMatrix[i] = matrixC[i][j];
                }
            }
            System.out.println("Минимальный элемент " + (int)(i+1) + " строки: " + minValMatrix[i]);
        }
    }
}
