import java.util.*;

public class sinhtohop {
    static int cnt = 0;
    static int[] a = new int[20];
    static int n, k;

    static void bt(int i) {
        for (int j = a[i - 1] + 1; j <= n - k + i; j++) {
            a[i] = j;
            if (i == k) {
                cnt++;
                for (int x = 1; x <= k; x++) {
                    System.out.print(a[x]);
                }
                System.out.print(" ");
            }
            else bt(i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        a[0] = 0;
        bt(1);
        System.out.printf("\nTong cong co %d to hop", cnt);
    }
}
