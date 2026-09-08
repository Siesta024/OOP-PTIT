import java.util.*;

public class chiatamgiac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (--t >= 0) {
            double n, h;
            n = sc.nextDouble();
            h = sc.nextDouble();
            double s = h / 2;
            double[] arr = new double[(int)n];

            double div = s / n;
            for (int i = 1; i <= n - 1; i++) {
                double h1 = h * Math.sqrt(i / n);
                arr[i] = h1;
            }

            for (int i = 1; i <= n - 1; i++) {
                System.out.printf("%.6f ", arr[i]);
            }
            System.out.println();
        }
    }
}
