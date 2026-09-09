import java.util.Scanner;

public class Hcn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a <= 0 || b <= 0) {
            System.out.print(0);
        }

        else {
            int p = 2 * (a + b);
            int s = a * b;

            System.out.print(p + " " + s);
        }

        sc.close();
    }
}
