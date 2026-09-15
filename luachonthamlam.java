import java.util.*;

public class luachonthamlam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        if (s > 9 * n || s == 0)
            System.out.println("-1 -1");
        else if (s == 9 * n) {
            String ln = "";
            for (int i = 0; i < n; i++) {
                ln += '9';
            }
            System.out.print(ln + " " + ln);
        } else {
            StringBuilder maxnum = new StringBuilder();
            int reS = s;
            for (int i = 0; i < n; i++) {
                int digit = Math.min(9, reS);
                maxnum.append(digit);
                reS -= digit;
            }

            char[] minnum = new char[n];
            reS = s - 1;
            
            for (int i = n - 1; i > 0; i--) {
                int digit = Math.min(9, reS);
                minnum[i] = (char) (digit + '0');
                reS -= digit;
            }
            minnum[0] = (char) ((reS + 1) + '0');

            String minN = new String(minnum);

            System.out.println(minN + " " + maxnum.toString());
        }
    }
}
