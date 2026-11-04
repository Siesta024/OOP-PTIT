import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class StudentManagement extends JFrame {

    private JTextField txtId, txtName, txtScore;
    private JRadioButton rbMale, rbFemale;
    private ButtonGroup genderGroup;
    private JCheckBox cbMath, cbPhysics, cbChemistry;
    private JButton btnAdd, btnUpdate, btnDelete, btnClear;
    private JTable table;
    private DefaultTableModel tableModel;

    public StudentManagement() {
        setTitle("Student Management");
        setSize(680, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Sử dụng Absolute Layout để bố cục giống hệt trong hình

        initComponents();
        addEvents();
    }

    private void initComponents() {
        // --- 1. Khu vực Form nhập liệu ---
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(50, 20, 80, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(140, 20, 140, 25);
        add(txtId);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 55, 80, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(140, 55, 140, 25);
        add(txtName);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(50, 90, 80, 25);
        add(lblGender);

        rbMale = new JRadioButton("Male", true);
        rbMale.setBounds(140, 90, 65, 25);
        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(210, 90, 80, 25);

        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        add(rbMale);
        add(rbFemale);

        JLabel lblSubjects = new JLabel("Subjects:");
        lblSubjects.setBounds(50, 125, 80, 25);
        add(lblSubjects);

        cbMath = new JCheckBox("Math");
        cbMath.setBounds(140, 125, 60, 25);
        cbPhysics = new JCheckBox("Physics");
        cbPhysics.setBounds(205, 125, 75, 25);
        cbChemistry = new JCheckBox("Chemistry");
        cbChemistry.setBounds(285, 125, 90, 25);

        add(cbMath);
        add(cbPhysics);
        add(cbChemistry);

        JLabel lblScore = new JLabel("Score:");
        lblScore.setBounds(50, 160, 80, 25);
        add(lblScore);

        txtScore = new JTextField();
        txtScore.setBounds(140, 160, 140, 25);
        add(txtScore);

        // --- 2. Khu vực các nút bấm (Buttons) ---
        btnAdd = new JButton("Add");
        btnAdd.setBounds(400, 20, 95, 28);
        add(btnAdd);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(400, 55, 95, 28);
        add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(400, 90, 95, 28);
        add(btnDelete);

        btnClear = new JButton("Clear");
        btnClear.setBounds(400, 125, 95, 28);
        add(btnClear);

        // --- 3. Khu vực Bảng hiển thị (Table) ---
        String[] columns = {"ID", "Name", "Gender", "Subjects", "Score"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho sửa trực tiếp trên bảng
            }
        };
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 210, 585, 240);
        add(scrollPane);
    }

    private void addEvents() {
        // Nút Add: Thêm sinh viên mới
        btnAdd.addActionListener(e -> {
            if (!validateInput()) return;

            String id = txtId.getText().trim();
            String name = txtName.getText().trim();
            String gender = rbMale.isSelected() ? "Male" : "Female";
            String subjects = getSelectedSubjects();
            double score = Double.parseDouble(txtScore.getText().trim());

            tableModel.addRow(new Object[]{id, name, gender, subjects, score});
            clearForm();
        });

        // Nút Update: Sửa dòng đang chọn
        btnUpdate.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng trong bảng để cập nhật!");
                return;
            }
            if (!validateInput()) return;

            tableModel.setValueAt(txtId.getText().trim(), selectedRow, 0);
            tableModel.setValueAt(txtName.getText().trim(), selectedRow, 1);
            tableModel.setValueAt(rbMale.isSelected() ? "Male" : "Female", selectedRow, 2);
            tableModel.setValueAt(getSelectedSubjects(), selectedRow, 3);
            tableModel.setValueAt(Double.parseDouble(txtScore.getText().trim()), selectedRow, 4);
        });

        // Nút Delete: Xóa dòng đang chọn
        btnDelete.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng trong bảng để xóa!");
                return;
            }
            tableModel.removeRow(selectedRow);
            clearForm();
        });

        // Nút Clear: Làm mới form
        btnClear.addActionListener(e -> clearForm());

        // Sự kiện click vào dòng trong bảng -> Đổ dữ liệu ngược lại vào form
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    txtId.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    txtName.setText(tableModel.getValueAt(selectedRow, 1).toString());

                    String gender = tableModel.getValueAt(selectedRow, 2).toString();
                    if (gender.equalsIgnoreCase("Male")) {
                        rbMale.setSelected(true);
                    } else {
                        rbFemale.setSelected(true);
                    }

                    String subjects = tableModel.getValueAt(selectedRow, 3).toString();
                    cbMath.setSelected(subjects.contains("Math"));
                    cbPhysics.setSelected(subjects.contains("Physics"));
                    cbChemistry.setSelected(subjects.contains("Chemistry"));

                    txtScore.setText(tableModel.getValueAt(selectedRow, 4).toString());
                }
            }
        });
    }

    // Hàm hỗ trợ lấy chuỗi các môn học được tích chọn
    private String getSelectedSubjects() {
        List<String> list = new ArrayList<>();
        if (cbMath.isSelected()) list.add("Math");
        if (cbPhysics.isSelected()) list.add("Physics");
        if (cbChemistry.isSelected()) list.add("Chemistry");
        return String.join(", ", list);
    }

    // Hàm kiểm tra dữ liệu đầu vào hợp lệ
    private boolean validateInput() {
        if (txtId.getText().trim().isEmpty() || txtName.getText().trim().isEmpty() || txtScore.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ ID, Name và Score!");
            return false;
        }
        try {
            Double.parseDouble(txtScore.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Score phải là một số hợp lệ!");
            return false;
        }
        return true;
    }

    // Hàm reset toàn bộ form về trạng thái ban đầu
    private void clearForm() {
        txtId.setText("");
        txtName.setText("");
        rbMale.setSelected(true);
        cbMath.setSelected(false);
        cbPhysics.setSelected(false);
        cbChemistry.setSelected(false);
        txtScore.setText("");
        table.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentManagement().setVisible(true);
        });
    }
}