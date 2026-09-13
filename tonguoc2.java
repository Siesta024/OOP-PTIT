import java.util.*;

public class tonguoc2 {
    public static int[] sumDiv(int b) {
        int[] sum = new int[b + 1];

        for (int i = 0; i <= b; i++) {
            sum[i] = 1;
        }

        for (int i = 2; i * 2 <= b; i++) {
            for (int j = i * 2; j <= b; j+=i) {
                sum[j] += i;
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 0;
        int[] sum = sumDiv(b);

        for (int i = a; i <= b; i++) {
            if (sum[i] > i) {
                cnt++;        
            }
        }

        System.out.print(cnt);
    }
}
