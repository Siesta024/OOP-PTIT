import java.util.*;

public class lietketohop {
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n + 1];
        Try(1, a, 0, n, k);
        System.out.println();
        System.out.print("Tong cong co " + cnt + " to hop");
    }

    private static void Try(int i, int[] a, int start, int n, int k) {
        for (int j = start + 1; j <= n - k + i; j++) {
            a[i] = j;
            if (i == k) {
                for (int x = 1; x <= k; x++) {
                    System.out.print(a[x]);
                }
                System.out.print(" ");
                cnt++;
            }
            else{
                Try(i + 1, a, j, n, k);
            }
        }
    }
}
