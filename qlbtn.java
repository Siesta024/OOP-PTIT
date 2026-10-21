import java.util.*;

public class qlbtn {
    static class SV {
        String msv, name, sdt;
        int grp;

        public SV(String m, String n, String s, int g) {
            msv = m;
            name = n;
            sdt = s;
            grp = g;
        }

        public String toString() {
            return msv + " " + name + " " + sdt;
        }
    }

    static class btl {
        String name;
        int grp;

        public btl(String n, int g) {
            name = n;
            grp = g;
        }

        public String getName() {
            return name;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<SV> svien = new ArrayList<>();
        ArrayList<btl> b = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            sc.nextLine();
            svien.add(new SV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt()));
        }
        sc.nextLine();
        for (int i = 1; i <= m; i++) {
            b.add(new btl(sc.nextLine(), i));
        }

        int q = sc.nextInt();
        for (int i = 1; i <= q; i++) {
            int x = sc.nextInt();

            System.out.printf("DANH SACH NHOM %d:\n", x);
            for (int j = 0; j < n; j++) {
                if (svien.get(j).grp == x) {
                    System.out.println(svien.get(j));
                }
            }
            System.out.printf("Bai tap dang ky: %s%n", b.get(x - 1).getName());
        }
    }
}
