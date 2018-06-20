/**
 * Created by nailya.shakirova on 20.05.2018.
 */
public class threadsSum {
    static int tLength;

    public static int tailSum(int step) {
        int TailSum = 0;
        for (int i = step * tLength; i < (step+1) * tLength - 1; i++) {
            TailSum += mas[i];
        }
        return TailSum;
    }
}
