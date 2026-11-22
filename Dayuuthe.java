import java.util.*;

public class Dayuuthe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());
        while(t-- > 0) {
            List<Integer> a = new ArrayList<>();

            int odd = 0, even = 0;
            
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");

            for (String s : parts) {
                int x = Integer.parseInt(s);
                if (x % 2 == 0) even++;
                else odd++;
                a.add(x);
            }

            if (a.size() % 2 == 0 && even > odd) {
                System.out.println("YES");
            }            
            else if (a.size() %  2 == 1 && odd > even) {
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}
