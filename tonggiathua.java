import java.util.*;

public class tonggiathua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long s = 0;
        long c = 1;
        for (int i = 1; i <= n; i++) {
            c *= i;
            s += c;
        }
        System.out.print(s);
    }
}
