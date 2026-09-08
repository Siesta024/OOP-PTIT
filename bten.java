import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class bten {
    static int n;
    static Integer[] a;
    static ArrayList<String> res;
    static ArrayList<Integer> current;

    // Kiểm tra số nguyên tố
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Thuật toán quay lui sinh dãy con
    public static void Try(int i, int sum) {
        // Nếu tổng hiện tại là số nguyên tố, lưu dãy con dưới dạng chuỗi
        if (isPrime(sum) && !current.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < current.size(); j++) {
                sb.append(current.get(j)).append(" ");
            }
            res.add(sb.toString().trim());
        }

        // Duyệt các phần tử tiếp theo để tạo tổ hợp
        for (int j = i; j < n; j++) {
            current.add(a[j]);
            Try(j + 1, sum + a[j]);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                n = sc.nextInt();
                a = new Integer[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                }
                
                // Sắp xếp mảng giảm dần để định hình đúng thứ tự giá trị trong từng dãy con
                Arrays.sort(a, Collections.reverseOrder());
                
                res = new ArrayList<>();
                current = new ArrayList<>();
                
                // Gọi hàm quay lui bắt đầu từ chỉ số 0, tổng = 0
                Try(0, 0);
                
                // Sắp xếp danh sách các chuỗi kết quả theo thứ tự từ điển tăng dần
                Collections.sort(res);
                
                // In kết quả
                for (String s : res) {
                    System.out.println(s);
                }
            }
        }
        sc.close();
    }
}