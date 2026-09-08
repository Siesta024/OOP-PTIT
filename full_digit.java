import java.util.*;

public class full_digit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            long n = sc.nextLong();
            if (n == 0) {
                System.out.println("Impossible");
                continue;
            } 

            boolean[] visited = new boolean[10];
            long cnt = 0;
            long i = 1;

            while (true) {
                long k = n * i;
                long tmp = k;
                while (tmp > 0) {
                    int x = (int) (tmp % 10);
                    if (!visited[x]) {
                        visited[x] = true;
                        cnt++;
                    }
                    tmp /= 10;
                }

                if (cnt == 10) {
                    System.out.println(k);
                    break;
                }
                i++;
            }
        }
    }
}
