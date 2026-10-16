import java.util.*;

public class dsdoituongnhanvien {
    static String stddate(String s) {
        StringBuilder sb = new StringBuilder(s);

        if (sb.charAt(1) == '/') sb.insert(0, '0');
        if (sb.charAt(4) == '/') sb.insert(3, '0');

        return sb.toString();
    }

    static class NhanVien {
        String mnv, name, se, birth, add, mst, date;
        int d, m, y;

        public NhanVien(int m, String n, String s, String b, String a, String mst, String date) {
            mnv = String.format("%05d", m);
            name = n;
            se = s;
            birth = stddate(b);
            add = a;
            this.mst = mst;
            this.date = stddate(date);

            String[] tmp = birth.split("/");
            d = Integer.parseInt(tmp[0]);
            m = Integer.parseInt(tmp[1]);
            y = Integer.parseInt(tmp[2]);
        }

        public String toString() {
            return mnv + " " + name + " " + se + " " + birth + " " + add + " " + mst + " " + date;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        NhanVien[] nv = new NhanVien[n];

        for (int i = 0; i < n; i++) {
            nv[i] = new NhanVien(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        }

        Arrays.sort(nv, Comparator.comparing((NhanVien x) -> x.y).thenComparing(x -> x.m).thenComparing(x -> x.d));

        for (int i = 0; i < n; i++) {
            System.out.println(nv[i]);
        }
    }
}
