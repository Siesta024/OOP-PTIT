import java.util.*;

public class loaichan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            if (!st.isEmpty() && (st.peek() % 2 == cur % 2)) {
                st.pop();
            }
            else {
                st.push(cur);
            }
        }
        
        System.out.print(st.size());
    }
}