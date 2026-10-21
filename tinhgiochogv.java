import java.util.*;

public class tinhgiochogv {
    static class GiangVien {
        String idGV, tenGV;
        double total;

        public GiangVien(String id, String name) {
            idGV = id;
            tenGV = name;
        }

        public double getTotal() {
            return this.total;
        }

        public void setTotal(double s) {
            this.total = s;
        }
        
        public String toString() {
            return tenGV;
        }
    }

    static class monhoc {
        String idmon, idgv;
        double time;

        public monhoc(String id, String name, double time) {
            idmon = id;
            idgv = name;
            this.time = time;
        }

        public String getGV() {
            return idgv;
        }
        public String getId() {
            return idmon;
        }
        public double getTime() {
            return time;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, String> MH = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.nextLine().trim();
            MH.put(id, name);
        }
        int t = Integer.parseInt(sc.nextLine());
        Map<String, GiangVien> GV = new HashMap<>();
        for (int j = 0; j < t; j++) {
            String id = sc.next();
            String name = sc.nextLine().trim();
            GV.put(id, new GiangVien(id, name));
        }
        int q = Integer.parseInt(sc.nextLine());
        List<monhoc> a = new ArrayList<>(); 
        for (int i = 0; i < q; i++) {
            String[] line = sc.nextLine().split("\\s+");
            String idgv = line[0];
            String idmh = line[1];
            double time = Double.parseDouble(line[2]);

            a.add(new monhoc(idmh, idgv, time));
        }

        String gv = sc.next();
        System.out.print("Giang vien: ");
        System.out.println(GV.get(gv));
        GiangVien gvien = GV.get(gv);
        for (monhoc l : a) {
            if (l.getGV().equals(gv)) {
                System.out.println(MH.get(l.getId()) + " " + l.getTime());
                gvien.setTotal(gvien.getTotal() + l.getTime());
            }
        }
        System.out.printf("Tong: %.2f", gvien.getTotal());
    }
}
