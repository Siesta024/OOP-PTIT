import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Management");
        frame.setSize(680, 520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel lblId = new JLabel("ID: ");
        lblId.setBounds(50, 20, 80, 25);
        frame.add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(140, 20, 140, 25);
        frame.add(txtId);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 55, 80, 25);
        frame.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(140, 55, 140, 25);
        frame.add(txtName);

        JLabel lblGen = new JLabel("Gender:");
        lblGen.setBounds(50, 90, 80, 25);
        frame.add(lblGen);

        JRadioButton rbMale = new JRadioButton("Male", true);
        rbMale.setBounds(140, 90, 65, 25);
        JRadioButton rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(210, 90, 80, 25);

        ButtonGroup bg

        frame.setVisible(true);
    }
}
