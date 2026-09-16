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
            if (cnt == 1) {
                System.out.println("YES");
            }
            else if (cnt == 0 && a.length() % 2 != 0) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
