import java.util.*;

public class fibo {
    public static long[] Fibo() {
        long[] Fi = new long[93];
        Fi[1] = 1;
        Fi[2] = 1;

        for (int i = 3; i <= 92; i++) {
            Fi[i] = Fi[i - 1] + Fi[i - 2];
        }

        return Fi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] Fi = Fibo();
        long t = sc.nextLong();
        while (--t >= 0) {
            int n = sc.nextInt();

            System.out.println(Fi[n]);
        }
    }
}
