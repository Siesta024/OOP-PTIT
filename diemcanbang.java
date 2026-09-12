import java.util.*;

public class diemcanbang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] prefix = new int[n + 1];
            prefix[0] = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                prefix[i + 1] = prefix[i] + a[i];
            }

            int ans = -1;
            for (int i = 1; i < n; i++) {
                if (prefix[i] == prefix[n] - prefix[i + 1]) {
                    ans = i + 1;
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
