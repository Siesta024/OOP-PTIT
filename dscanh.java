import java.util.*;

public class dscanh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int x = sc.nextInt();

                if (j > i && x == 1) {
                    sb.append('(').append(i).append(',').append(j).append(")\n");
                }
            }
        }

        System.out.print(sb);
    }
}
