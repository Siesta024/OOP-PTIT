import java.util.*;

public class demsolanxuathien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int k = 1; k <= t; k++) {
            System.out.println("Test " + k + ": ");
            int n = sc.nextInt();

            Map<Integer, Integer> m = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                m.put(x, m.getOrDefault(x, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                System.out.printf("%d xuat hien %d lan \n", entry.getKey(), entry.getValue());
            }
        }
    }
}
