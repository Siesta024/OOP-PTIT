import java.util.*;

public class sxchon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int cnt = 1;

        for (int i = 0; i < n - 1; i++) {
            int m = i;
            for (int j = i + 1; j < n; j++) {
                if (a[m] > a[j]) {
                    m = j;
                }
            }
            if (m != i) {
                int t = a[m];
                a[m] = a[i];
                a[i] = t;
            }
            System.out.printf("Buoc %d: ", cnt);
            for (int j = 0; j < n; j++) {
                System.out.print(a[j] + " ");
            }
            cnt++;
            System.out.println();
        }
    }
}
