import java.util.*;

public class boinhonhat {
    public static boolean snt(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            long res = 1;

            for (int i = 2; i <= n; i++) {
                if (snt(i)) {
                    long pow = i;
                    while (pow * i <= n) {
                        pow *= i;
                    }
                    res *= pow;
                }
            }

            System.out.println(res);
        } 
    }
}
