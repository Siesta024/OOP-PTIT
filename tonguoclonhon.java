import java.util.*;

public class tonguoclonhon {
    static  final int m = 1000007;
    static int[] sum = new int[m + 1];
    static int[] prefix = new int[m + 1];

    public static void sieve() {
        for (int i = 1; i < m / 2;i++) {
            for (int j = i * 2; j <= m; j+=i) {
                sum[j] += i;
            }
        }

        for (int i = 1; i <= m; i++) {
            prefix[i] = prefix[i - 1];
            if (sum[i] > i) {
                prefix[i]++;
            }
        }
    }

    public static void main(String[] args) {
        sieve();
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int res = prefix[b] - prefix[a - 1];
        System.out.println(res);
    }
}
