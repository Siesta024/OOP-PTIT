import java.util.*;

public class daycontongk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int l = 0;
            boolean ok = false;
            long sum = a[0];

            for (int i = 1; i < n; i++) {
                sum += a[i];
                while (sum > k && l < i) {
                    sum -= a[l];
                    l++;
                }
                if (sum == k) {
                    ok = true;
                    break;
                }
            }
            if (ok)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
