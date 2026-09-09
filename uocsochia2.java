import java.util.*;

public class uocsochia2 {
    static int ptsnt(int n) {
        if (n % 2 != 0) return 0;

        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if  (i % 2 == 0) {
                    cnt++;
                }

                if (i * i != n && (n / i) % 2 == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int ans = ptsnt(n);
            System.out.println(ans);
        }
    }
}
