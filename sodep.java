import java.util.*;

public class sodep {
    static boolean check1(String s) {
        int l = 0, r = s.length() - 1;

        while (l <= r) {
            if (s.charAt(l) != s.charAt(r) || (s.charAt(l) - '0') % 2 == 1) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    static boolean check2(String s) {
        if (s.charAt(0) != '8' || s.charAt(s.length() - 1) != '8') return false;

        int l = 0, r = s.length() - 1;
        int sum = 0;

        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            sum += s.charAt(l) + s.charAt(r) - 2 * '0';
            l++;
            r--;
        }

        if (sum % 10 != 0) return false;
        return true;
    }

    static boolean check3(String s) {
        int l = 0, r = s.length() - 1;

        while (l <= r) {
            if (s.charAt(l) != s.charAt(r) || "2357".indexOf(s.charAt(l)) == -1) {
                return false;
            }
            
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0) {
            String s = sc.next();

            if (check3(s)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
