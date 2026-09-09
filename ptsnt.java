import java.util.*;

public class ptsnt {
    public static List<Integer> sieve() {
        List<Integer> si = new ArrayList<>();
        boolean[] s = new boolean[100001];
        Arrays.fill(s, true);

        s[1] = s[0] = false;

        for (int i = 2; i * i <= 100000; i++) {
            if (s[i]) {
                si.add(i);

                for (int j = i * i; j <= 100000; j += i) {
                    s[j] = false;
                }
            }
        }

        return si;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> prime = sieve();

        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.print("Test " + i + ": ");

            int n = sc.nextInt();

            for (int j = 0; j < prime.size(); j++) {
                int x = prime.get(j);
                int cnt = 0;
                while (n % x == 0) {
                    cnt++;
                    n = n / x;
                }
                if (cnt != 0) System.out.printf("%d(%d) ", x, cnt);
            }

            if (n > 1) {
                System.out.printf("%d(%d)", n, 1);
            }

            System.out.println();
        }
    }
}
