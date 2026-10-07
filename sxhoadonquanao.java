import java.util.*;

public class sxhoadonquanao {
    static class product {
        String id, name;
        int p1, p2;

        public product(String id, String name, int p1, int p2) {
            this.id = id;
            this.name = name;
            this.p1 = p1;
            this.p2 = p2;
        }

        public boolean isP(String s) {
            return s.startsWith(id);
        }

        public int getPrice(String s) {
            if (s.charAt(2) == '1') return p1;
            return p2;
        }
    }

    static class bill {
        String code, name;
        int dis, total;

        public bill(int stt, String id, String name, int amount, int price) {
            code = id + String.format("-%03d", stt);
            this.name = name;
            
            total = price * amount;
            if (amount >= 150) dis = total / 2;
            else if (amount >= 100) dis = total * 30 / 100;
            else if (amount >= 50) dis = total * 15 / 100;
            total -= dis;
        }

        public String toString() {
            return code + " " + name + " " + dis + " " + total;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        product[] p = new product[n];

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            p[i] = new product(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextInt());
        }

        int m = sc.nextInt();
        bill[] b = new bill[m];
        for (int i = 1; i <= m; i++) {
            String code = sc.next();
            int amount = sc.nextInt();
            for (int j = 0; j < n; j++) {
                if (p[j].isP(code)) {
                    b[i - 1] = new bill(i, code, p[j].name, amount, p[j].getPrice(code));
                }
            }
        }

        Arrays.sort(b, Comparator.comparingInt((bill x) -> x.total).reversed());

        for(int i = 0; i < m; i++) {
            System.out.println(b[i]);
        }
    }
}
