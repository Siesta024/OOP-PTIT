import java.util.*;
import java.util.Scanner;

class TuyenXeBuyt{
   private String ma, hoten;
   private int soHieu, soLuot;
   private static int sMa = 1;
   
   public TuyenXeBuyt(String hoten, int soHieu, int soLuot){
       this.hoten = hoten;
       this.soHieu = soHieu;
       this.soLuot = soLuot;
       
       this.ma = String.format("HN%d%02d", soHieu, sMa++);
   }
   public int getDoanhthu(){
       return soLuot*300000;
   }
   
   @Override
   public String toString(){
           return ma + " " +  hoten + " " +  soHieu + " " + soLuot + " " + getDoanhthu();
   }
}

public class b3{
   public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       if(sc.hasNextLine()){
           int n = Integer.parseInt(sc.nextLine().trim());
           while(n-- > 0){
               String hoten = sc.nextLine();
               int soHieu = Integer.parseInt(sc.nextLine());
               int soLuot = Integer.parseInt(sc.nextLine());
           
               TuyenXeBuyt xe = new TuyenXeBuyt(hoten, soHieu, soLuot);
               System.out.println(xe);
           }
       }
       sc.close();
   }
}

