import java.util.*;

public class b6 {
    static String toD(String s) {
        String[] d = s.split("/");
        for (int i = 0; i <= 1; i++) {
            while (d[i].length() < 2)
                d[i] = "0" + d[i];
        }
        return d[0] + "/" + d[1] + "/" + d[2];
    }

    static String msv(int i) {
        String s = Integer.toString(i);
        while (s.length() < 3)
            s = "0" + s;
        return "B20DCCN" + s;
    }
    
    static String stdName(String s) {
        String[] n = s.toLowerCase().trim().split("\\s+");
        String r = "";
        for (int i = 0; i < n.length; i++) {
            r = r + Character.toString(n[i].charAt(0)).toUpperCase() + n[i].substring(1) + " ";
        }
        return r;
    } 

    static class svien {
        String msv, name, lop, date;
        double gpa;

        public svien(String m, String n, String l, String d, double g) {
            msv = m;
            name = n;
            lop = l;
            date = d;
            gpa = g;
        }

        public String toString() {
            String g = String.format("%.2f", this.gpa);
            return msv + ' ' + name + ' ' + lop + ' ' + date + ' ' + g;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        List<svien> s = new ArrayList<>();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            sc.nextLine();
            s.add(new svien(msv(i), stdName(sc.nextLine()), sc.nextLine(), toD(sc.next()), sc.nextFloat()));
        }

        s.sort((x, y) -> Double.compare(y.gpa, x.gpa));

        s.forEach(e -> {
            System.out.println(e);
        });
    }
}