import java.util.*;

public class b2t {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String date = sc.next();
        double lcb = sc.nextDouble();
        double r = sc.nextDouble();
        double p = sc.nextDouble();

        double f = lcb + r - p;

        System.out.println(name + " " + date + " " + String.format("%.1f", f));
    }
}
