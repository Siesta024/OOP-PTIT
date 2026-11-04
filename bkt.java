import java.util.*;

public class bkt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        
        int a = 0, b = 0;

        for (int i = 0; i < s.length(); i++) {
            char  c = s.charAt(i);
            int t1 = (c == 'A') ? 0 : 1;
            int t2 = (c == 'B') ? 0 : 1;

            int r1 = Math.min(a + t1, t2 + b + 1);
            int r2 = Math.min(b + t2, a + t1 + 1);

            a = r1;
            b = r2;
        }

        System.out.println(a);
    }
}
