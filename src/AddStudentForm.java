import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class AddStudentForm extends JFrame {

	private JPanel contentPane;
	private JTextField jTextField_FName;
	private JTextField jTextField_LName;
	private JTextField jTextField_Phone;
	private JTextField jTextField_Address;
	private JRadioButton jRadioButtonFemale;
	private JRadioButton jRadioButtonMale;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentForm frame = new AddStudentForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	Student std = new Student();
	
	public AddStudentForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddStudentForm.class.getResource("/images/stdmng.png")));
		setTitle("New Student");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 487);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New Student");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 23));
		lblNewLabel.setBounds(229, 11, 242, 49);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("First Name :");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1.setBounds(68, 104, 116, 33);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Last Name :");
		lblNewLabel_1_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(78, 148, 116, 33);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Sex :");
		lblNewLabel_1_2.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(130, 192, 116, 33);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Birthday :");
		lblNewLabel_1_3.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(88, 238, 116, 33);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Phone :");
		lblNewLabel_1_4.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(113, 282, 116, 33);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_4_1 = new JLabel("Address :");
		lblNewLabel_1_4_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_4_1.setBounds(98, 326, 116, 33);
		contentPane.add(lblNewLabel_1_4_1);

		jTextField_FName = new JTextField();
		jTextField_FName.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_FName.setBounds(194, 112, 309, 20);
		contentPane.add(jTextField_FName);
		jTextField_FName.setColumns(10);

		jTextField_LName = new JTextField();
		jTextField_LName.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_LName.setColumns(10);
		jTextField_LName.setBounds(194, 156, 309, 20);
		contentPane.add(jTextField_LName);

		jRadioButtonFemale = new JRadioButton("Female");
		jRadioButtonFemale.setFont(new Font("Monospaced", Font.BOLD, 14));
		jRadioButtonFemale.setBackground(new Color(224, 255, 255));
		jRadioButtonFemale.setBounds(194, 199, 80, 23);
		contentPane.add(jRadioButtonFemale);

		jRadioButtonMale = new JRadioButton("Male");
		jRadioButtonMale.setFont(new Font("Monospaced", Font.BOLD, 14));
		jRadioButtonMale.setBackground(new Color(224, 255, 255));
		jRadioButtonMale.setBounds(276, 199, 67, 23);
		contentPane.add(jRadioButtonMale);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(194, 248, 309, 23);
		contentPane.add(dateChooser);

		jTextField_Phone = new JTextField();
		jTextField_Phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}

			}
		});
		jTextField_Phone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		jTextField_Phone.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_Phone.setColumns(10);
		jTextField_Phone.setBounds(194, 290, 309, 20);
		contentPane.add(jTextField_Phone);

		jTextField_Address = new JTextField();
		jTextField_Address.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_Address.setColumns(10);
		jTextField_Address.setBounds(194, 334, 309, 20);
		contentPane.add(jTextField_Address);

		JButton jButtonAddStudent = new JButton("Add");
		jButtonAddStudent.setIcon(new ImageIcon(AddStudentForm.class.getResource("/images/add.png")));
		jButtonAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fname = jTextField_FName.getText();
				String lname = jTextField_LName.getText();
				String phone = jTextField_Phone.getText();
				String address = jTextField_Address.getText();
				String sex = "Male";
				if (jRadioButtonFemale.isSelected()) {
					sex = "Female";
				}

				if (verifyText()) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String bdate = dateFormat.format(dateChooser.getDate());

					Student std = new Student();
					std.insertUpdateDeleteStudent('i', null, fname, lname, sex, bdate, phone, address);
					MainForm.jLabel_StdCount.setText("Student Count = " + Integer.toString(MyFunction.countData("student")));
					
					try {
						manageStudentsForm.jTable.setModel(new DefaultTableModel (null,new Object [] {"ID","First Name","Last Name","Sex","Birthday","Phone","Address"}));
						std.fillStudentJtable(manageStudentsForm.jTable, "");
					} catch (Exception ex){
						System.out.println(ex.getMessage());
					}
					
				}
			}
		});

		jButtonAddStudent.setForeground(new Color(0, 128, 0));
		jButtonAddStudent.setBackground(Color.WHITE);
		jButtonAddStudent.setFont(new Font("Monospaced", Font.BOLD, 16));
		jButtonAddStudent.setBounds(364, 397, 138, 33);
		contentPane.add(jButtonAddStudent);

		JButton jButtonCancel = new JButton("Cancel");
		jButtonCancel.setIcon(new ImageIcon(AddStudentForm.class.getResource("/images/close.png")));
		jButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		jButtonCancel.setForeground(new Color(255, 0, 0));
		jButtonCancel.setFont(new Font("Monospaced", Font.BOLD, 16));
		jButtonCancel.setBackground(Color.WHITE);
		jButtonCancel.setBounds(194, 397, 149, 33);
		contentPane.add(jButtonCancel);

		ButtonGroup bg = new ButtonGroup();
		bg.add(jRadioButtonMale);
		bg.add(jRadioButtonFemale);
		jRadioButtonMale.setSelected(true);
		
		setLocationRelativeTo(null);

	}

	public boolean verifyText() {

		if (jTextField_FName.getText().equals("") || jTextField_LName.getText().equals("")
				|| jTextField_Phone.getText().equals("") || jTextField_Address.getText().equals("")
				|| dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "One or More Empty Field");
			return false;
			// data me e madhe se data e sotme
		} else if (dateChooser.getDate().compareTo(new Date()) > 0) {
			JOptionPane.showMessageDialog(null, "No Students From the Future Are Allowed");
			return false;
		} else {
			return true;
		}
	}
}
