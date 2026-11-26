import java.util.*;

public class chuanhoaxauhoten2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String[] ws = sc.nextLine().trim().split("\\s+");
            StringBuilder res = new StringBuilder();

            for (int i = 1; i < ws.length; i++) {
                String w = ws[i];

                res.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1).toLowerCase());
                if (i < ws.length - 1) {
                    res.append(" ");
                }
                else res.append(", ");
            }

            res.append(ws[0].toUpperCase());

            System.out.println(res);
        }
    }
}
