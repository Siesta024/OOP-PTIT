import java.util.*;

public class uocsnt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            long n = sc.nextLong();
            long maxprime = 2;

            while (n % 2 == 0) {
                n /= 2;
            }
            for (long i = 3; i * i <= n; i+=2) {
                while (n % i == 0) {
                    n /= i;
                    maxprime = i;
                }
            }

            if (n > 1) maxprime = n;

            System.out.println(maxprime);
        }
    }
}
