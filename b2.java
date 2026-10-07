import java.util.Scanner;

class NhanVien{
   private String hoTen, ngaySinh;
   private double luongCoBan,tienThuong, tienPhat;
   
   public NhanVien(String hoTen, String ngaySinh, double luongCoBan, double tienThuong, double tienPhat){
       this.hoTen = hoTen;
       this.ngaySinh = ngaySinh;
       this.luongCoBan = luongCoBan;
       this.tienThuong = tienThuong;
       this.tienPhat = tienPhat;
   }
   
   public double tinhLuongThucLinh(){
       return luongCoBan + tienThuong - tienPhat;
   }
   
   public void hienThi(){
       System.out.printf("%s %s %.1f%n", hoTen, ngaySinh, tinhLuongThucLinh());
   }
}

public class b2{
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       String hoTen = sc.nextLine();
       String ngaySinh = sc.nextLine();
       double luongCoBan = sc.nextDouble();
       double tienThuong = sc.nextDouble();
       double tienPhat = sc.nextDouble();
       
       NhanVien nv = new NhanVien(
           hoTen,
           ngaySinh,
           luongCoBan,
           tienThuong,
           tienPhat
       );
       nv.hienThi();
       sc.close();
   }
}