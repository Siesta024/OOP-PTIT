import java.util.*;;

public class daycontongprime {
    static int n;
    static Integer[] a;
    static List<List<Integer>> res;

    public static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2;i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void Try(int start, List<Integer> cur, int sum) {
        if (!cur.isEmpty() && isPrime(sum)) {
            res.add(new ArrayList<>(cur));
        }

        for (int i = start; i < n; i++) {
            cur.add(a[i]);
            Try(i + 1, cur, sum + a[i]);
            cur.remove(cur.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            n = sc.nextInt();

            a = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a, Collections.reverseOrder());

            res = new ArrayList<>();
            Try(0, new ArrayList<>(), 0);

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
}
