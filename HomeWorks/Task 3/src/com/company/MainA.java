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
            System.out.println("Введите " + m + " чисел(ла) " + (int)(i+1) + " строки");
            for (int j = 0; j <= m - 1; j++){
                matrixA[i][j] = scanner.nextInt();
            }
        }

        int elem = 0;

        for (int i = 0; i <= n - 1;i++) {
            for (int j = 0; j <= m - 1; j++){
                elem = matrixA[i][j];
                boolean flag = false;
                if (j < m - 1){
                    for (int k = j+1; k <= m-1; k++) {
                        if (matrixA[i][k] == elem) {
                            matrixA[i][k] = 0;
                            flag = true;
                        }
                    }
                }
                if (i < n-1) {
                    for (int h = i + 1; h <= n - 1; h++) {
                        for (int l = 0; l <= m - 1; l++) {
                            if (matrixA[h][l] == elem) {
                                matrixA[h][l] = 0;
                                flag = true;
                            }

                        }
                    }
                }

                if (flag == true) {
                    matrixA[i][j] = 0;
                }
            }
        }

        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= m - 1; j++) {
                System.out.print(matrixA[i][j] + " ");
            }
            System.out.println();
        }

    }
}
