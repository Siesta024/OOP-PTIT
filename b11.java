import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class GiangVien {
    private String ma;
    private String ten;
    private double tongGioChuan;

    public GiangVien(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
        this.tongGioChuan = 0.0;
    }

    public void themGioChuan(double gio) {
        this.tongGioChuan += gio;
    }

    public String getMa() {
        return ma;
    }

    @Override
    public String toString() {
        // Formats the total hours to exactly 2 decimal places as required
        return ten + " " + String.format("%.2f", tongGioChuan);
    }
}

public class b11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Read Subjects (Môn học)
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String maMon = sc.next();
            String tenMon = sc.nextLine().trim();
            // Subject data is consumed but not strictly needed for the output
        }

        // 2. Read Lecturers (Giảng viên)
        int m = sc.nextInt();
        List<GiangVien> danhSachGV = new ArrayList<>();
        Map<String, GiangVien> mapGV = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            String maGV = sc.next();
            String tenGV = sc.nextLine().trim();
            
            GiangVien gv = new GiangVien(maGV, tenGV);
            danhSachGV.add(gv);
            mapGV.put(maGV, gv);
        }

        // 3. Read Teaching Assignments (Lớp học phần) and accumulate hours
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            String maGV = sc.next();
            String maMon = sc.next();
            double gioChuan = sc.nextDouble();
            
            if (mapGV.containsKey(maGV)) {
                mapGV.get(maGV).themGioChuan(gioChuan);
            }
        }

        // 4. Output the results in the original input order
        for (GiangVien gv : danhSachGV) {
            System.out.println(gv);
        }

        sc.close();
    }
}