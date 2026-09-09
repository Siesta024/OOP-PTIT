import java.util.*;

public class tamphan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            boolean ok = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '0' && s.charAt(i) != '1' && s.charAt(i) != '2') {
                    System.out.println("NO");
                    ok = false;
                    break;
                }
            }
            if (ok)
                System.out.println("YES");
        }

    }
}