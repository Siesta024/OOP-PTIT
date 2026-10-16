import java.util.*;

public class dsdoituongsv1 {
    public static StringBuilder dateformat(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.charAt(1) == '/') sb.insert(0, "0");
        if (sb.charAt(4) == '/') sb.insert(3, "0");

        return sb;
    }

    public static String stdname(String s) {
        String[] a = s.toLowerCase().trim().split("\\s+");
        String res = "";

        for (String x : a) {
            res += Character.toUpperCase(x.charAt(0)) + x.substring(1) + " ";
        }
        return res.trim();
    }

    static class sv {
        String msv, name, lop, birth;
        float gpa;

        sv(int m, String n, String l, String b, float g) {
            msv = String.format("B20DCCN%03d", m);
            name = stdname(n);
            lop = l;
            StringBuilder sb = dateformat(b);
            birth = sb.toString();
            gpa = g;
        }

        public String toString() {
            return msv + " " + name + " " + lop + " " + birth + " " + String.format("%.2f", gpa);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sv[] s = new sv[n];

        for (int i = 1; i <= n; i++) {
            sc.nextLine();
            s[i - 1] = new sv(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextFloat());
        }

        Arrays.sort(s, Comparator.comparingDouble((sv x) -> x.gpa).reversed());

        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
