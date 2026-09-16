import java.util.*;

public class soxacach {
    static int n;
    static int[] a = new int[11];
    static boolean[] visited = new boolean[11];

    public static void Try(int i) {
        if (i == n + 1) {
            for (int x = 1; x <= n; x++) {
                System.out.print(a[x]);
            }
            System.out.println();
            return;
        }

        for (int j = 1; j <= n; j++) {
           if (!visited[j]) {
                if (i == 1 || Math.abs(a[i - 1] - j) != 1) {
                    visited[j] = true;
                    a[i] = j;
                    Try(i + 1);
                    visited[j] = false;
                }
           }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            Arrays.fill(visited, false);
            Try(1);
            System.out.println();
        }
    }
}
