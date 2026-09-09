import java.util.*;

public class ktrafibo {
    public static long[] Fibo() {
        long[] fi = new long[93];
        fi[1] = fi[2] = 1;
        
        for (int i = 3; i <= 92; i++) {
            fi[i] = fi[i-1] + fi[i-2];
        }

        return fi;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] fi = Fibo();
        int t = sc.nextInt();
        while (--t >= 0) {
            long n = sc.nextLong();
            if (Arrays.binarySearch(fi, n) >= 0) {
                
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
