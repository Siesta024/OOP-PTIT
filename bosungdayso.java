import java.util.*;

public class bosungdayso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[201];
        int n = sc.nextInt();
        int m = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            a[x] = 1;
            if (m < x) {
                m = x;
            }
        }
        boolean ok = true;
        for (int i = 1; i <= m; i++) {
            if (a[i] != 1) {
                ok = false;
                System.out.println(i);
            }
        }
        if (ok) System.out.println("Excellent!");
    }
}
