import java.util.*;

public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Integer> freq = new HashMap<>();
        for (int t = 0; t < n; t++) {
            String s = sc.nextLine().trim().toLowerCase();
            String[] arr = s.split("\\s+");
            int l = arr.length;
            String email = arr[l - 1];
            for (int i = 0; i < l - 1; i++) {
                email += arr[i].charAt(0);
            }
            int cnt = freq.getOrDefault(email, 0) + 1;
            freq.put(email, cnt);
            if (cnt > 1) {
                email += cnt;
            }
            email += "@ptit.edu.vn";
            System.out.println(email);
        }
    }
}
