import java.util.*;

public class tonguocnt {
    static int maxn = 2000006;
    static int[] sie = new int[maxn + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long ans = 0;
        sieve();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            while (x > 1) {
                int p = sie[x];
                ans += p;
                x /= p;
            }
        }

        System.out.println(ans);
    }

    static void sieve() {
        for (int i = 2; i <= maxn; i++) {
            sie[i] = i;
        }

        for (int i = 2; i * i <= maxn; i++) {
            if (sie[i] == i) {
                for (int j = i * i; j <= maxn; j+=i) {
                    sie[j] = i;
                }
            }
        }
    }
}
