import java.util.*;

public class hoadonquanao {
    static class Product {
        String id, name;
        int price1, price2;

        public Product(String i, String n, int p1, int p2) {
            id = i;
            name = n;
            price1 = p1;
            price2 = p2;
        }

        public int getPrice(String s) {
            if (s.charAt(2) == '1') {
                return price1;
            }
            return price2;
        }
    }

    static class bill {
        String stt;
        int discount, total;
        String name;

        public bill(int s, String c, String n,int p, int a) {
            stt = c + String.format("-%03d", s);
            name = n;
            total = p * a;
            if (a >= 150) discount = total / 2;
            else if (a >= 100) discount = total * 30 / 100;
            else if (a >= 50) discount = total * 15 / 100;
            total -= discount;  
        }

        public String toString() {
            return stt + " " + name + " " + discount + " " + total;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Product> p = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            sc.nextLine();
            p.add(new Product(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }

        int m = sc.nextInt();
        List<bill> b = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            String code = sc.next();
            int amount = sc.nextInt();

            for (int j = 0; j < p.size(); j++) {
                if (code.startsWith(p.get(j).id)) {
                    int price = p.get(j).getPrice(code);
                    b.add(new bill(i, code, p.get(j).name, price, amount));
                }
            }
        }

        b.forEach(e -> {
            System.out.println(e);
        });
    }
}