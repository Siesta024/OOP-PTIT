import java.util.*;

public class luythua {
    static long mod = 1_000_000_007;

    static long pow(long x, long y) {
        if (y == 0) return 1;

        long a = pow(x, y / 2);
        a = (a * a) % mod;
        if (y % 2 == 1) return (a * x) % mod;
        return a;
    }
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(pow(a, b));
        }
    }
}