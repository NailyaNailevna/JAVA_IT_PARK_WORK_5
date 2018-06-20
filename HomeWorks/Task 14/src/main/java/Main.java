import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int tailSum(int step, int tLength, int mass[]) {
        int resSum = 0;
        for (int i = step * tLength; i < (step + 1) * tLength; i++) {
            resSum = resSum + mass[i];
        }
        return resSum;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 2 числа n и m для определения размерности массива и количества потоков:");
        int numbersCount = scanner.nextInt();
        int threadsCount = scanner.nextInt();

        int tLength = numbersCount / threadsCount;

        int mas[] = new int[numbersCount];

        Random random = new Random();
        for (int i = 0; i < numbersCount; i++) {
            mas[i] = random.nextInt(1000);
        }

        int forSumm = 0;
        for (int i = 0; i < threadsCount; i++) {
            forSumm += mas[i];
        }

        for (int i = 0; i < threadsCount; i++) {
            Thread thread [i] = new Thread();
            thread[i].start();
        }


//        System.out.print(tLength);

        for (int i = 0; i < numbersCount; i++) {
            System.out.print(mas[i] + " ");
        }


    }
}
