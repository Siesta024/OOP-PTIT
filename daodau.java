import java.util.*;

public class daodau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        long k = sc.nextLong();

        Long[] a = new Long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        Arrays.sort(a);

        for (int i = 0; i < n && k > 0; i++) {
            if (a[i] < 0) {
                a[i] = -a[i];
                k--;
            }
        }
        
        Arrays.sort(a);

        if (k > 0 && k % 2 == 1) {
            a[0] = -a[0];
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        System.out.print(sum);
    }
}