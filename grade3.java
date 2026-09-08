import java.util.*;

public class grade3 {
    static boolean isMatch(String s, String target) {
        if (s.length() != target.length()) return false;
        for (int i = 0; i < s.length();i++) {
            if (s.charAt(i) != '?' && s.charAt(i) != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    static void math(String s) {
        s = s.trim();

        char[] ops = {'+', '-', '*', '/'};

        for (int a = 10; a <= 99; a++) {
            for (int b = 10; b <= 99; b++) {
                for (char op : ops) {
                    int c = 0;
                    if (op == '+') c = a + b;
                    else if (op == '-') c = a - b;
                    else if (op == '*') c = a * b;
                    else if (op == '/') {
                        if (a % b != 0) continue;
                        c = a / b;
                    }

                    if (c >= 10 && c <= 99) {
                        String target = a + " " + op + " " + b + " = " + c;
                        
                        if (isMatch(s, target)) {
                            System.out.println(target);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println("WRONG PROBLEM!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();

            math(s);
        }
    }
}
