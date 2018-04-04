package com.company;
import java.util.Scanner;

public class Main {

    public static int parse(char input[]) {
        int strLen = input.length;
        int res = 0;
        for (int i = 0; i <= strLen - 1; i++){
            res = res + (((int)(input[i] - '0')) * (int)Math.pow(10,(strLen - 1 - i)));
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку цифр:");

        char str[] = scanner.nextLine().toCharArray();
        int Res = parse(str);

        System.out.println(Res);
    }
}
