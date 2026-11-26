import java.util.*;

public class chuanhoaxauhoten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split("\\s+");
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                String w = words[i];
                res.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1).toLowerCase());
                if (i < words.length - 1) {
                    res.append(" ");
                }
            }

            System.out.println(res);
        } 
    }
}
