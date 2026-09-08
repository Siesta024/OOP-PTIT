import java.util.*;

public class snt {
    public static boolean prime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (--t >= 0) {
            int n = sc.nextInt();
            if (prime(n)) {
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}
