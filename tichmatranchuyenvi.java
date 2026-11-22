import java.util.*;

public class tichmatranchuyenvi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        
        for (int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            long[][] a = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m;j++) {
                    a[i][j] = sc.nextLong();
                }
            }

            long[][] res = new long[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    long s = 0;
                    for (int k = 0; k < m; k++) {
                        s += a[i][k] * a[j][k];
                    }

                    res[i][j] = s;
                    res[j][i] = s;
                }
            }

            System.out.println("Test " + t + ":");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(res[i][j] + (j == n - 1 ? "" : " "));
                }
                System.out.println();
            }
        }
    }
}
