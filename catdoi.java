import java.util.*;

public class catdoi {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-->0) {
            String s = sc.next();
            boolean ok = true;

            long a = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                
                if (c == '1') {
                    a = a * 10 + 1;
                }
                else if (c == '8' || c == '9' || c == '0') {
                    a = a * 10 + 0;
                }
                else {
                    ok = false;
                    break;
                }
            }

            if (a == 0) ok = false;

            if (ok) {
                System.out.println(a);
            }
            else {
                System.out.println("INVALID");
            }
        }
    }
}
