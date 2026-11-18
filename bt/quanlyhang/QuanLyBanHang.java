import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.Collator;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

class TrongException extends Exception {
    public TrongException(String message) {
        super(message);
    }
}

class SoAmException extends Exception {
    public SoAmException(String message) {
        super(message);
    }
}

public class QuanLyBanHang extends JFrame {
    private static final String FILE_KH = "KH.TXT";
    private static final String FILE_MH = "MATHANG.TXT";
    private static final String FILE_HD = "HOADON.TXT";

    private List<KhachHang> listKH = new ArrayList<>();
    private List<MatHang> listMH = new ArrayList<>();
    private List<HoaDon> listHD = new ArrayList<>();

    private DefaultTableModel modelKH, modelMH, modelHD, modelThongKe;
    private JComboBox<KhachHang> cbKhachHang;
    private JComboBox<MatHang> cbMatHang;

    public QuanLyBanHang() {
        setTitle("Chương Trình Quản Lý Bán Hàng");
        setSize(950, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        docDuLieuTuFile();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("1. Quản lý Khách Hàng", taoPanelKhachHang());
        tabbedPane.addTab("2. Quản lý Mặt Hàng", taoPanelMatHang());
        tabbedPane.addTab("3 & 4. Hóa Đơn & Sắp Xếp", taoPanelHoaDon());
        tabbedPane.addTab("5. Bảng Kê Tổng Tiền", taoPanelThongKe());

        add(tabbedPane);
    }

    // Đọc ghi file
    private void docDuLieuTuFile() {
        //KH.TXT
        File fKH = new File(FILE_KH);
        if (fKH.exists()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fKH), StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty()) continue;
                    String[] p = line.split(";");
                    listKH.add(new KhachHang(Integer.parseInt(p[0]), p[1], p[2], p[3]));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //MATHANG.TXT
        File fMH = new File(FILE_MH);
        if (fMH.exists()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fMH), StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty()) continue;
                    String[] p = line.split(";");
                    listMH.add(new MatHang(Integer.parseInt(p[0]), p[1], Double.parseDouble(p[2])));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //HOADON.TXT
        File fHD = new File(FILE_HD);
        if (fHD.exists()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fHD), StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty()) continue;
                    String[] p = line.split(";");
                    int maKH = Integer.parseInt(p[0]);
                    int maMH = Integer.parseInt(p[1]);
                    int soLuong = Integer.parseInt(p[2]);

                    KhachHang kh = timKhachHang(maKH);
                    MatHang mh = timMatHang(maMH);
                    if (kh != null && mh != null) {
                        listHD.add(new HoaDon(kh, mh, soLuong));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private KhachHang timKhachHang(int maKH) {
        for (KhachHang kh : listKH) {
            if (kh.getMaKH() == maKH) return kh;
        }
        return null;
    }

    private MatHang timMatHang(int maMH) {
        for (MatHang mh : listMH) {
            if (mh.getMaHang() == maMH) return mh;
        }
        return null;
    }

    private void ghiFileKH() {
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(FILE_KH), StandardCharsets.UTF_8))) {
            for (KhachHang kh : listKH) pw.println(kh.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ghiFileMH() {
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(FILE_MH), StandardCharsets.UTF_8))) {
            for (MatHang mh : listMH) pw.println(mh.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ghiFileHD() {
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(FILE_HD), StandardCharsets.UTF_8))) {
            for (HoaDon hd : listHD) pw.println(hd.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // KHÁCH HÀNG
    private JPanel taoPanelKhachHang() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] cols = {"Mã KH", "Họ tên", "Địa chỉ", "Nhóm KH"};
        modelKH = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        for (KhachHang kh : listKH) modelKH.addRow(kh.toObject());
        JTable table = new JTable(modelKH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        form.setBorder(BorderFactory.createTitledBorder("Nhập thông tin Khách Hàng mới"));

        JTextField txtHoTen = new JTextField();
        JTextField txtDiaChi = new JTextField();
        JComboBox<String> cbNhomKH = new JComboBox<>(new String[]{"Mua lẻ", "Mua buôn", "Mua qua mạng"});
        JButton btnThem = new JButton("Thêm Khách Hàng & Lưu vào KH.TXT");

        form.add(new JLabel("Họ tên khách hàng:"));
        form.add(txtHoTen);
        form.add(new JLabel("Địa chỉ:"));
        form.add(txtDiaChi);
        form.add(new JLabel("Nhóm khách hàng (Hộp chọn):"));
        form.add(cbNhomKH);
        form.add(new JLabel(""));
        form.add(btnThem);

        btnThem.addActionListener(e -> {
            try {
                KhachHang kh = new KhachHang(txtHoTen.getText(), txtDiaChi.getText(),
                        cbNhomKH.getSelectedItem().toString());
                listKH.add(kh);
                ghiFileKH();
                modelKH.addRow(kh.toObject());
                capNhatComboBoxHoaDon();
                txtHoTen.setText("");
                txtDiaChi.setText("");
                JOptionPane.showMessageDialog(this, "Đã thêm khách hàng và lưu vào file KH.TXT!");
            } catch (TrongException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(form, BorderLayout.SOUTH);
        return panel;
    }

    // MẶT HÀNG 
    private JPanel taoPanelMatHang() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] cols = {"Mã hàng", "Tên mặt hàng", "Đơn giá"};
        modelMH = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        for (MatHang mh : listMH) modelMH.addRow(mh.toObject());
        JTable table = new JTable(modelMH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel form = new JPanel(new GridLayout(3, 2, 10, 10));
        form.setBorder(BorderFactory.createTitledBorder("Nhập thông tin Mặt Hàng mới"));

        JTextField txtTenHang = new JTextField();
        JTextField txtDonGia = new JTextField();
        JButton btnThem = new JButton("Thêm Mặt Hàng & Lưu vào MATHANG.TXT");

        form.add(new JLabel("Tên mặt hàng:"));
        form.add(txtTenHang);
        form.add(new JLabel("Đơn giá:"));
        form.add(txtDonGia);
        form.add(new JLabel(""));
        form.add(btnThem);

        btnThem.addActionListener(e -> {
            try {
                if (txtDonGia.getText().trim().isEmpty()) {
                    throw new TrongException("Đơn giá không được để trống!");
                }
                double gia = Double.parseDouble(txtDonGia.getText().trim());
                MatHang mh = new MatHang(txtTenHang.getText(), gia);
                listMH.add(mh);
                ghiFileMH();
                modelMH.addRow(mh.toObject());
                capNhatComboBoxHoaDon();
                txtTenHang.setText("");
                txtDonGia.setText("");
                JOptionPane.showMessageDialog(this, "Đã thêm mặt hàng và lưu vào file MATHANG.TXT!");
            } catch (TrongException | SoAmException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Đơn giá phải là số hợp lệ!", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(form, BorderLayout.SOUTH);
        return panel;
    }

    // HÓA ĐƠN & SẮP XẾP
    private JPanel taoPanelHoaDon() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] cols = {"Mã KH", "Họ tên KH", "Mã Hàng", "Tên Hàng", "Đơn Giá", "Số Lượng", "Thành Tiền"};
        modelHD = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        hienThiBangHoaDon();
        JTable table = new JTable(modelHD);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new GridLayout(1, 2, 15, 10));

        JPanel formNhap = new JPanel(new GridLayout(4, 2, 8, 8));
        formNhap.setBorder(BorderFactory.createTitledBorder("Chức năng 3: Nhập danh sách mua hàng"));

        cbKhachHang = new JComboBox<>();
        cbMatHang = new JComboBox<>();
        capNhatComboBoxHoaDon();

        JTextField txtSoLuong = new JTextField();
        JButton btnThemHD = new JButton("Thêm vào HOADON.TXT");

        formNhap.add(new JLabel("Chọn Khách Hàng:"));
        formNhap.add(cbKhachHang);
        formNhap.add(new JLabel("Chọn Mặt Hàng:"));
        formNhap.add(cbMatHang);
        formNhap.add(new JLabel("Số lượng mua:"));
        formNhap.add(txtSoLuong);
        formNhap.add(new JLabel(""));
        formNhap.add(btnThemHD);

        btnThemHD.addActionListener(e -> {
            try {
                KhachHang kh = (KhachHang) cbKhachHang.getSelectedItem();
                MatHang mh = (MatHang) cbMatHang.getSelectedItem();
                if (kh == null || mh == null) {
                    throw new TrongException("Vui lòng nhập Khách hàng và Mặt hàng trước khi lập hóa đơn!");
                }
                if (txtSoLuong.getText().trim().isEmpty()) {
                    throw new TrongException("Số lượng không được để trống!");
                }
                int sl = Integer.parseInt(txtSoLuong.getText().trim());
                if (sl <= 0) {
                    throw new SoAmException("Số lượng phải lớn hơn 0!");
                }

                boolean daTonTai = false;
                for (HoaDon hd : listHD) {
                    if (hd.getKhachHang().getMaKH() == kh.getMaKH() &&
                        hd.getMatHang().getMaHang() == mh.getMaHang()) {
                        hd.setSoLuong(hd.getSoLuong() + sl);
                        daTonTai = true;
                        break;
                    }
                }
                if (!daTonTai) {
                    listHD.add(new HoaDon(kh, mh, sl));
                }

                ghiFileHD();
                hienThiBangHoaDon();
                txtSoLuong.setText("");
                JOptionPane.showMessageDialog(this, "Đã lưu vào file HOADON.TXT!");
            } catch (TrongException | SoAmException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên!", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel formSapXep = new JPanel(new GridLayout(3, 1, 10, 10));
        formSapXep.setBorder(BorderFactory.createTitledBorder("Chức năng 4: Sắp xếp danh sách mua hàng"));

        JComboBox<String> cbSapXep = new JComboBox<>(new String[]{
            "-- Chọn tiêu chí sắp xếp --",
            "1. Theo Họ tên khách hàng (thứ tự từ điển)",
            "2. Theo Số lượng mặt hàng (giảm dần)"
        });
        JButton btnSapXep = new JButton("Thực hiện sắp xếp");

        btnSapXep.addActionListener(e -> {
            int chon = cbSapXep.getSelectedIndex();
            if (chon == 1) {
                Collator collator = Collator.getInstance(Locale.of("vi", "VN"));
                listHD.sort((o1, o2) -> collator.compare(
                        o1.getKhachHang().getHoTen().toLowerCase(),
                        o2.getKhachHang().getHoTen().toLowerCase()
                ));
                hienThiBangHoaDon();
            } else if (chon == 2) {
                listHD.sort((o1, o2) -> Integer.compare(o2.getSoLuong(), o1.getSoLuong()));
                hienThiBangHoaDon();
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 tiêu chí sắp xếp trong hộp chọn!");
            }
        });

        formSapXep.add(new JLabel("Lựa chọn kiểu sắp xếp (Hộp chọn):"));
        formSapXep.add(cbSapXep);
        formSapXep.add(btnSapXep);

        southPanel.add(formNhap);
        southPanel.add(formSapXep);
        panel.add(southPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void capNhatComboBoxHoaDon() {
        if (cbKhachHang != null && cbMatHang != null) {
            cbKhachHang.removeAllItems();
            for (KhachHang kh : listKH) cbKhachHang.addItem(kh);

            cbMatHang.removeAllItems();
            for (MatHang mh : listMH) cbMatHang.addItem(mh);
        }
    }

    private void hienThiBangHoaDon() {
        modelHD.setRowCount(0);
        for (HoaDon hd : listHD) {
            modelHD.addRow(hd.toObject());
        }
    }

    // BẢNG KÊ TỔNG TIỀN 
    private JPanel taoPanelThongKe() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] cols = {"Mã KH", "Họ tên khách hàng", "Nhóm KH", "Tổng số mặt hàng đã mua", "Tổng số tiền phải trả (VNĐ)"};
        modelThongKe = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        JTable table = new JTable(modelThongKe);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnTinhToan = new JButton("Lập Bảng Kê Tính Tổng Số Tiền Phải Trả Cho Mỗi Khách Hàng");
        btnTinhToan.setFont(new Font("Arial", Font.BOLD, 14));
        btnTinhToan.addActionListener(e -> {
            modelThongKe.setRowCount(0);
            Map<Integer, List<HoaDon>> mapTheoKH = listHD.stream()
                    .collect(Collectors.groupingBy(
                            hd -> hd.getKhachHang().getMaKH(),
                            LinkedHashMap::new,
                            Collectors.toList()
                    ));

            for (Map.Entry<Integer, List<HoaDon>> entry : mapTheoKH.entrySet()) {
                List<HoaDon> dsMua = entry.getValue();
                KhachHang kh = dsMua.get(0).getKhachHang();
                int tongSoLuong = dsMua.stream().mapToInt(HoaDon::getSoLuong).sum();
                double tongTien = dsMua.stream().mapToDouble(HoaDon::getThanhTien).sum();

                modelThongKe.addRow(new Object[]{
                    kh.getMaKH(),
                    kh.getHoTen(),
                    kh.getNhomKH(),
                    tongSoLuong,
                    String.format("%,.0f VNĐ", tongTien)
                });
            }
        });

        panel.add(btnTinhToan, BorderLayout.SOUTH);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuanLyBanHang().setVisible(true);
        });
    }
}