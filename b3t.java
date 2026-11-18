import java.util.*;

public class b3t \u007B
    static class TuyenXeBuyt \u007B
        String ma, hoten;
        int soHieu, soLuot;

        public TuyenXeBuyt(int i, String name, int sohieu, int soluot) \u007B
            ma = String.format("HN%d%02d", sohieu, i);
            hoten = name;
            soHieu = sohieu;
            soLuot = soluot;
        \u007D

        public int getDoanhThu() \u007B
            return soLuot * 300000; 
        \u007D

        public String toString() \u007B
            return ma + " " + hoten + " " + soHieu + " " + soLuot + " " + this.getDoanhThu();
        \u007D
    \u007D
    public static void main(String[] args) \u007B
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        List<TuyenXeBuyt> l = new ArrayList<>();
        for (int i = 1; i <= t; i++) \u007B
            sc.nextLine();
            l.add(new TuyenXeBuyt(i, sc.nextLine(), sc.nextInt(), sc.nextInt()));
        \u007D

        for (int i = 0; i < l.size(); i++) \u007B
            System.out.println(l.get(i));
        \u007D
    \u007D
\u007D
