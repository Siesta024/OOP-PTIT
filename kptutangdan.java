import java.util.*;

public class kptutangdan {
    static int n, k;
    static Integer[] a;
    static List<List<Integer>> res;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();

            a = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);
            res = new ArrayList<>();

            Try(0, new ArrayList<>());

            Collections.sort(res, new Comparator<List<Integer>>() {
                @Override 
                public int compare(List<Integer> l1, List<Integer> l2) {
                    int len = Math.min(l1.size(), l2.size());
                    for (int i = 0; i < len; i++) {
                        int cmp = l1.get(i).compareTo(l2.get(i));
                        if (cmp != 0) {
                            return cmp;
                        }
                    }
                    return Integer.compare(l1.size(), l2.size());
                }
            });

            for (List<Integer> sub : res) {
                for (int i : sub) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }

    private static void Try(int start, List<Integer> sub) {
        if (sub.size() == k) {
            res.add(new ArrayList<>(sub));
        }

        for (int i = start; i < n; i++) {
            sub.add(a[i]);
            Try(i + 1, sub);
            sub.remove(sub.size() - 1);
        }
    }
}
