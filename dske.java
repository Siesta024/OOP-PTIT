import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class dske {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public static void main(String[] args) throws IOException {
        String firstToken = next();
        if (firstToken == null) return;
        int n = Integer.parseInt(firstToken);

        // Khởi tạo danh sách kề cho các đỉnh từ 1 đến n
        List<List<Integer>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Đọc ma trận kề và chuyển sang danh sách kề
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                String token = next();
                if ("1".equals(token)) {
                    adj.get(i).add(j);
                }
            }
        }

        // Gom kết quả vào StringBuilder để in một lần
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append("List(" + i + ") = ");
            List<Integer> neighbors = adj.get(i);
            for (int k = 0; k < neighbors.size(); k++) {
                if (k > 0) sb.append(' ');
                sb.append(neighbors.get(k));
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}