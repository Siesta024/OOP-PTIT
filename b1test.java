import java.util.*;

public class b1test {
    static class nv implements Comparable<nv> {
        String mnv, name;
        double salary;

        public nv(String m, String n, double s, double d, double h) {
            mnv = m;
            name = n;
            salary = (s * d * h) / 22;
        }

        public String toString() {
            return mnv + " " + name + " " + String.format("%.2f", salary);
        }
        @Override
        public int compareTo(nv o) {
            if (this.salary != o.salary) {
                return Double.compare(o.salary, this.salary);
            }
            return this.mnv.compareTo(o.mnv);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<nv> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            s.add(new nv(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextInt(), sc.nextDouble()));
        }

        Collections.sort(s);

        int q = sc.nextInt();
        
        for (int i = 1; i <= q; i++) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            System.out.println(i);
            for (int j = 0; j < s.size(); j++) {
                if (s.get(j).salary >= a && s.get(j).salary <= b) {
                    System.out.println(s.get(j));
                }
            }
        }
    }
}
