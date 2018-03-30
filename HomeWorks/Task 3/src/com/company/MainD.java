//Вывести сумму элементов побочной диагонали квадратной матрицы

package com.company;
import java.util.Scanner;

public class MainD {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размерность массива:");
        int n = scanner.nextInt();

        int matrixA[][] = new int[n][n];

        for (int i = 0; i <= n - 1;i++) {
            System.out.println("Введите " + n + " чисел(ла) " + (int)(i+1) + " строки");
            for (int j = 0; j <= n - 1; j++){
                matrixA[i][j] = scanner.nextInt();
            }
        }

        int maxSum = 0;

        for (int i = 0; i <= n - 1; i++) {
                maxSum = maxSum + matrixA[n - 1 - i][i];
            }

        System.out.println(maxSum);

        for (int row[] : matrixA) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
