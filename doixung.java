import java.util.*;

public class doixung {
    static  String check(String s) {
        int n = s.length();
        int diff = 0;

        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                diff++;
            }
        }

        if (diff == 1 || (diff == 0 && n % 2 != 0)) {
            return "YES";
        }
        return "NO";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();

            System.out.println(check(s));
        }
    }
}
