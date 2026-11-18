public class MatHang {
    private static int sma = 10000;
    private int maHang;
    private String tenHang;
    private double donGia;

    public MatHang(String tenHang, double donGia) throws TrongException, SoAmException {
        if (tenHang.trim().isEmpty()) {
            throw new TrongException("Tên mặt hàng không được để trống!");
        }
        if (donGia <= 0) {
            throw new SoAmException("Đơn giá phải lớn hơn 0!");
        }
        this.maHang = sma++;
        this.tenHang = tenHang.trim();
        this.donGia = donGia;
    }

    public MatHang(int maHang, String tenHang, double donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
        if (maHang >= sma) {
            sma = maHang + 1;
        }
    }

    public int getMaHang() { return maHang; }
    public String getTenHang() { return tenHang; }
    public double getDonGia() { return donGia; }

    public Object[] toObject() {
        return new Object[]{maHang, tenHang, String.format("%,.0f", donGia)};
    }

    public String toFileString() {
        return maHang + ";" + tenHang + ";" + donGia;
    }

    @Override
    public String toString() {
        return maHang + " - " + tenHang;
    }
}