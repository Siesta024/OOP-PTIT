import java.util.*;

public class pytago {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                a[i] *= a[i];
            }

            Arrays.sort(a);
            boolean ok = false;

            for (int i = n - 1; i >= 2; i--) {
                int l = 0;
                int r = i - 1;
                while (l < r) {
                    long s = a[l] + a[r];
                    if (s == a[i]) {
                        ok = true;
                        break;
                    }
                    if (s < a[i]) {
                        l++;
                    }
                    else r--;
                }
                if (ok) break;
            }

            if (ok) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
