import java.util.*;

public class solk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-->0) {
            long n = sc.nextLong();

            long c = n % 10;
            n /= 10;
            boolean ok = true;
            while (n > 0) {
                long x = n % 10;
                if (x != c - 1 && x != c + 1) {
                    ok = false;
                    break;
                }
                c = x;
                n /= 10;
            }

            if (ok) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
