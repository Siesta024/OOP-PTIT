import java.util.*;

public class kcnhohonk {
    public static int binarysearch(int[] a, int l, int r, int target) {
        int res = r + 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] >= target) {
                res = m;
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            long cnt = 0;
            Arrays.sort(a);

            for (int i = 0; i < n; i++) {
                int x = binarysearch(a, i + 1, n - 1, a[i] + k);
                cnt += x - i - 1;
            }   

            System.out.println(cnt);
        }
    }
}
