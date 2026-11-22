import java.util.*;

public class quayphai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int k = 0;
            for (int i = 1; i < n; i++) {
                if (a[k] > a[i]) {
                    k = i;
                }
            }

            System.out.println(k);
        }
    }
}