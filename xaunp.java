import java.util.*;

public class xaunp {
    static long[] fibo = new long[94];
    public static void fi() {
        fibo[0] = 0;
        fibo[1] = fibo[2] = 1;

        for (int i = 3; i <= 93; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
    }

    public static long daq(int n, long k) {
        if (n == 1) {
            return 0;
        }
        else if (n == 2) {
            return 1;
        }
        if (k <= fibo[n - 2]) {
            return daq(n - 2, k);
        }
        else {
            return daq(n - 1, k - fibo[n - 2]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fi();

        long t = sc.nextLong();
        while(t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();

            System.out.println(daq(n, k));
        }
    }
}
