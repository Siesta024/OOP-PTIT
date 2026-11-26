import java.util.*;

public class mtnhiphan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int o = 0, z = 0;
            for (int j = 0; j < 3; j++) {
                int x = sc.nextInt();
                if (x == 0) z++;
                else if (x== 1) o++;
            }

            if (o > z) ans++;
        }

        System.out.println(ans);
    }
}
