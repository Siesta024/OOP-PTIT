import java.util.*;

public class matranxoan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        int[][] res = new int[n][n];
        int top = 0, bottom = n - 1;
        int l = 0, r = n - 1;
        int idx = 0;

        while (idx < n * n) {
            for (int i = l; i <= r && idx < n*n; i++) {
                res[top][i] = a[idx++];
            }
            top++;

            for (int i = top; i <= bottom && idx < n * n; i++) {
                res[i][r] = a[idx++];
            }
            r--;

            for (int i = r; i >= l && idx < n*n; i--) {
                res[bottom][i] = a[idx++];
            }
            bottom--;

            for (int i = bottom; i >= top && idx < n*n; i--) {
                res[i][l] = a[idx++];
            }
            l++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
