import java.util.*;

public class sxchen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int cnt = 1;
        res.add(a[0]);
        System.out.print("Buoc 0: ");
        for (int j = 0; j < res.size(); j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();

        for (int i = 1; i < n; i++) {
            int m = 0;
            while (m < res.size() && a[i] > res.get(m)) {
                m++;
            }
            res.add(m, a[i]);

            System.out.printf("Buoc %d: ", cnt);
            for (int j = 0; j < res.size(); j++) {
                System.out.print(res.get(j) + " ");
            }
            cnt++;
            System.out.println();
        }
    }
}
