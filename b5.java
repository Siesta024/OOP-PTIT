import java.util.Scanner;

class GiangVien {
   private String ma;
   private String hoTen;
   private int tongGioDay;
   private double heSoLuong;
   private double luongLinh;
   private static int sMa = 1;

   public GiangVien() {
       this.ma = String.format("PM%04d", sMa++);
   }

   public double getLuongLinh() {
       return tongGioDay * 240 * heSoLuong;
   }

   public void input(Scanner in) {
       this.hoTen = in.nextLine().trim();
       this.tongGioDay = Integer.parseInt(in.nextLine().trim());
       this.heSoLuong = Double.parseDouble(in.nextLine().trim());
       this.luongLinh = getLuongLinh();
   }

   @Override
   public String toString() {
       return ma + " " + hoTen + " " + tongGioDay + " " + heSoLuong;
   }
}

public class b5 {
   public static void main(String args[]) { 
       Scanner sc = new Scanner(System.in);
       int n = 2;
       
       while (n-- > 0) {
           if (sc.hasNextLine()) {
               GiangVien gv = new GiangVien();
               gv.input(sc);
               System.out.println(gv.toString());
               
               double mucLuong = gv.getLuongLinh();
               System.out.println(mucLuong);
           }
       }
       sc.close();
   }
}
