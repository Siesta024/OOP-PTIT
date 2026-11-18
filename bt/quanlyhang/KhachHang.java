public class KhachHang {
    private static int sma = 10000;
    private int maKH;
    private String hoTen;
    private String diaChi;
    private String nhomKH;

    public KhachHang(String hoTen, String diaChi, String nhomKH) throws TrongException {
        if (hoTen.trim().isEmpty() || diaChi.trim().isEmpty()) {
            throw new TrongException("Họ tên và Địa chỉ không được để trống!");
        }
        this.maKH = sma++;
        this.hoTen = hoTen.trim();
        this.diaChi = diaChi.trim();
        this.nhomKH = nhomKH;
    }

    public KhachHang(int maKH, String hoTen, String diaChi, String nhomKH) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.nhomKH = nhomKH;
        if (maKH >= sma) {
            sma = maKH + 1;
        }
    }

    public int getMaKH() { return maKH; }
    public String getHoTen() { return hoTen; }
    public String getDiaChi() { return diaChi; }
    public String getNhomKH() { return nhomKH; }

    public Object[] toObject() {
        return new Object[]{maKH, hoTen, diaChi, nhomKH};
    }

    public String toFileString() {
        return maKH + ";" + hoTen + ";" + diaChi + ";" + nhomKH;
    }

    @Override
    public String toString() {
        return maKH + " - " + hoTen;
    }
}