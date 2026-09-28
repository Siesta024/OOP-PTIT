import java.lang.reflect.Array;
import java.util.*;

class sp {
    String code, name;
    int l1, l2;

    public sp(String m, String n, int x, int y) {
        code = m;
        name = n;
        l1 = x;
        l2 = y;
    }

    public boolean isSp(String c) {
        return c.startsWith(code);
    }

    public int getPrice(String s) {
        if (s.charAt(2) == '1') {
            return l1;
        }
        return l2;
    }
}

class bill {
    String code, name;
    int cnt, off, sum, fin;

    public bill(int i, String c, String name, int count, int price) {
        code = c + '-' + String.format("%03d", i);
        this.name = name;
        cnt = count;
        sum = price * cnt;
        if (cnt >= 150) {
            off = sum / 2;
        }
        else if (cnt >= 100) {
            off = sum * 3 / 10;
        }
        else if (cnt >= 50) {
            off = sum * 15 / 100;
        }

        fin = sum - off;
    }

    @Override 
    public String toString() {
        return code + ' ' + name + ' ' + off + ' ' + fin;
    }
}

public class hoadonquanao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<sp> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            a.add(new sp(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }

        int m = sc.nextInt();
        ArrayList<bill> b = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            String code = sc.next();
            int cnt = sc.nextInt();
            sp x = a.get(0);
            for (int j = 0; j < n; j++) {
                if (a.get(j).isSp(code)) {
                    x = a.get(j);
                    break;
                }
            }

            b.add(new bill(i, code, x.name, cnt, x.getPrice(code)));
        }

        b.sort((x, y) -> Integer.compare(y.fin, x.fin));

        b.forEach(e -> {
            System.out.println(e);
        });
    }
}
