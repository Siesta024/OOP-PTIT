import java.util.*;

public class xephang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        Arrays.sort(a, (x, y) -> {
            if (x[0] == y[0]) return Integer.compare(x[1], y[1]);
            return Integer.compare(x[0], y[0]);
        });

        int time = 0;
        for (int i = 0; i < n; i++) {
            if (time < a[i][0]) {
                time = a[i][0];
            }
            time += a[i][1];
        }

        System.out.print(time);
    }
}
