import java.util.*;

public class thugondayso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (st.empty()) {
                st.push(sc.nextInt());
            }
            else {
                int x = sc.nextInt();
                int s = x + st.peek();
                if (s % 2 == 0) {
                    st.pop();
                }
                else st.push(x);
            }
        }

        System.out.println(st.size());
    }
}
