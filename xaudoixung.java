import java.util.*;

public class xaudoixung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();

            int l = 0;
            int r = a.length() - 1;
            int cnt = 0;

            while (l < r) {
                if (a.charAt(l) != a.charAt(r)) {
                    cnt += 1;
                }
                if (cnt >= 2) {
                    break;
                }
                l++;
                r--;
            }
            if (cnt >= 2) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
    }
}
