import java.util.*;;

public class b1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String date = sc.next();
        double p1 = sc.nextDouble();
        double p2 = sc.nextDouble();
        double p3 = sc.nextDouble();

        System.out.printf("%s %s %.1f", name, date, p1 + p2 + p3);
    }
}
