import java.util.*;

public class square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int c1 = sc.nextInt();
        int d1 = sc.nextInt();

        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        int c2 = sc.nextInt();
        int d2 = sc.nextInt();

        int a3 = Math.min(a1, a2);
        int b3 = Math.min(b1, b2);
        int c3 = Math.max(c1, c2);
        int d3 = Math.max(d1, d2);

        int res = Math.max(c3 - a3, d3 - b3);
        res = res * res;
        System.out.println(res);
    }
}
