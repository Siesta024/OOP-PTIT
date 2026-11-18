public class HoaDon {
    private KhachHang khachHang;
    private MatHang matHang;
    private int soLuong;

    public HoaDon(KhachHang khachHang, MatHang matHang, int soLuong) throws SoAmException {
        if (soLuong <= 0) {
            throw new SoAmException("Số lượng mua phải là số nguyên dương (> 0)!");
        }
        this.khachHang = khachHang;
        this.matHang = matHang;
        this.soLuong = soLuong;
    }

    public KhachHang getKhachHang() { return khachHang; }
    public MatHang getMatHang() { return matHang; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public double getThanhTien() {
        return soLuong * matHang.getDonGia();
    }

    public Object[] toObject() {
        return new Object[]{
            khachHang.getMaKH(),
            khachHang.getHoTen(),
            matHang.getMaHang(),
            matHang.getTenHang(),
            String.format("%,.0f", matHang.getDonGia()),
            soLuong,
            String.format("%,.0f", getThanhTien())
        };
    }

    // Lưu mã KH, mã Hàng và số lượng vào file HOADON.TXT
    public String toFileString() {
        return khachHang.getMaKH() + ";" + matHang.getMaHang() + ";" + soLuong;
    }
}