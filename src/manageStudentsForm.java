import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class manageStudentsForm extends JFrame {

	private JPanel contentPane;
	private JTextField jTextField_FName;
	private JTextField jTextField_LName;
	private JTextField jTextField_Phone;
	private JTextField jTextField_Address;
	private JTextField jTextField_STD_ID;
	public static JTable jTable;

	
	Student std = new Student();
	public static JTextField jTextField_Search;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageStudentsForm frame = new manageStudentsForm();
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
	public manageStudentsForm() {
		
		setTitle("Manage Student");
		setIconImage(Toolkit.getDefaultToolkit().getImage(manageStudentsForm.class.getResource("/images/stdmng.png")));
		setFont(new Font("Monospaced", Font.BOLD, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1245, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(null);
		contentPane_1.setBackground(new Color(224, 255, 255));
		contentPane_1.setBounds(0, 0, 1312, 452);
		contentPane.add(contentPane_1);
		
		JLabel lblManageStudents = new JLabel("Manage Students");
		lblManageStudents.setFont(new Font("Monospaced", Font.BOLD, 23));
		lblManageStudents.setBounds(546, 11, 242, 49);
		contentPane_1.add(lblManageStudents);
		
		JLabel lblNewLabel_1 = new JLabel("First Name :");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1.setBounds(68, 104, 116, 33);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name :");
		lblNewLabel_1_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(78, 148, 116, 33);
		contentPane_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Sex :");
		lblNewLabel_1_2.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(130, 192, 116, 33);
		contentPane_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Birthday :");
		lblNewLabel_1_3.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(88, 238, 116, 33);
		contentPane_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Phone :");
		lblNewLabel_1_4.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(113, 282, 116, 33);
		contentPane_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Address :");
		lblNewLabel_1_4_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_4_1.setBounds(98, 326, 116, 33);
		contentPane_1.add(lblNewLabel_1_4_1);
		
		jTextField_FName = new JTextField();
		jTextField_FName.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_FName.setColumns(10);
		jTextField_FName.setBounds(194, 112, 309, 20);
		contentPane_1.add(jTextField_FName);
		
		jTextField_LName = new JTextField();
		jTextField_LName.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_LName.setColumns(10);
		jTextField_LName.setBounds(194, 156, 309, 20);
		contentPane_1.add(jTextField_LName);
		
		JRadioButton jRadioButtonFemale = new JRadioButton("Female");
		jRadioButtonFemale.setFont(new Font("Monospaced", Font.BOLD, 14));
		jRadioButtonFemale.setBackground(new Color(224, 255, 255));
		jRadioButtonFemale.setBounds(194, 199, 80, 23);
		contentPane_1.add(jRadioButtonFemale);
		
		JRadioButton jRadioButtonMale = new JRadioButton("Male");
		jRadioButtonMale.setSelected(true);
		jRadioButtonMale.setFont(new Font("Monospaced", Font.BOLD, 14));
		jRadioButtonMale.setBackground(new Color(224, 255, 255));
		jRadioButtonMale.setBounds(276, 199, 67, 23);
		contentPane_1.add(jRadioButtonMale);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(194, 248, 309, 23);
		contentPane_1.add(dateChooser);
		
		jTextField_Phone = new JTextField();
		jTextField_Phone.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_Phone.setColumns(10);
		jTextField_Phone.setBounds(194, 290, 309, 20);
		contentPane_1.add(jTextField_Phone);
		
		jTextField_Address = new JTextField();
		jTextField_Address.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_Address.setColumns(10);
		jTextField_Address.setBounds(194, 334, 309, 20);
		contentPane_1.add(jTextField_Address);
		
		JButton jButtonAddStudent = new JButton("Add");
		jButtonAddStudent.setIcon(new ImageIcon(manageStudentsForm.class.getResource("/images/add.png")));
		jButtonAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddStudentForm Addsf = new AddStudentForm();
				Addsf.setVisible(true);
				Addsf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		jButtonAddStudent.setForeground(new Color(0, 128, 0));
		jButtonAddStudent.setFont(new Font("Monospaced", Font.BOLD, 16));
		jButtonAddStudent.setBackground(Color.WHITE);
		jButtonAddStudent.setBounds(364, 397, 138, 33);
		contentPane_1.add(jButtonAddStudent);
		
		JButton jButtonRemoveStudent = new JButton("Delete");
		jButtonRemoveStudent.setIcon(new ImageIcon(manageStudentsForm.class.getResource("/images/close.png")));
		jButtonRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				if (jTextField_STD_ID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No Student Selected");
				} else  {
					int id = Integer.valueOf(jTextField_STD_ID.getText());
					std.insertUpdateDeleteStudent('d', id , null, null, null, null, null, null);
					std.fillStudentJtable(jTable, "");
					jTable.setModel(new DefaultTableModel (null,new Object [] {"ID","First Name","Last Name","Sex","Birthday","Phone","Address"}));
					std.fillStudentJtable(jTable, jTextField_Search.getText());
					MainForm.jLabel_StdCount.setText("Student Count = "+Integer.toString(MyFunction.countData("Student")));
					
					jTextField_STD_ID.setText("");
					jTextField_Address.setText("");
					jTextField_FName.setText("");
					jTextField_LName.setText("");
					jTextField_Phone.setText("");
					jRadioButtonMale.setSelected(false);
					jRadioButtonFemale.setSelected(false);
					dateChooser.setDate(null);	
				}	
			}
		});
		jButtonRemoveStudent.setForeground(new Color(255, 0, 0));
		jButtonRemoveStudent.setFont(new Font("Monospaced", Font.BOLD, 16));
		jButtonRemoveStudent.setBackground(Color.WHITE);
		jButtonRemoveStudent.setBounds(36, 397, 149, 33);
		contentPane_1.add(jButtonRemoveStudent);
		
		JLabel lblNewLabel_1_5 = new JLabel("ID :");
		lblNewLabel_1_5.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(135, 60, 49, 33);
		contentPane_1.add(lblNewLabel_1_5);
		
		jTextField_STD_ID = new JTextField();
		jTextField_STD_ID.setEditable(false);
		jTextField_STD_ID.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_STD_ID.setColumns(10);
		jTextField_STD_ID.setBounds(194, 68, 309, 20);
		contentPane_1.add(jTextField_STD_ID);
		
		JButton jButtonEditStudent = new JButton("Edit");
		jButtonEditStudent.setIcon(new ImageIcon(manageStudentsForm.class.getResource("/images/edit.png")));
		jButtonEditStudent.addActionListener(new ActionListener() {
			
			public boolean verifyText() {

				if (jTextField_FName.getText().equals("") || jTextField_LName.getText().equals("")
						|| jTextField_Phone.getText().equals("") || jTextField_Address.getText().equals("")
			            || jTextField_STD_ID.getText().equals("")
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
			
			public void actionPerformed(ActionEvent e) {
				String fname = jTextField_FName.getText();
				String lname = jTextField_LName.getText();
				String phone = jTextField_Phone.getText();
				String address = jTextField_Address.getText();
				int id = Integer.valueOf(jTextField_STD_ID.getText());
				String sex = "Male";
				if (jRadioButtonFemale.isSelected()) {
					sex = "Female";
				} 
//				else if (jRadioButtonMale.isSelected()) {
//					sex = "Male";
//				}

				if (verifyText()) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String bdate = dateFormat.format(dateChooser.getDate());

					Student std = new Student();
					std.insertUpdateDeleteStudent('u', id , fname, lname, sex, bdate, phone, address);
					//MainForm.jLabel_StdCount.setText("Student Count = " + Integer.toString(MyFunction.countData("student")));
					
					manageStudentsForm.jTable.setModel(new DefaultTableModel (null,new Object [] {"ID","First Name","Last Name","Sex","Birthday","Phone","Address"}));
					std.fillStudentJtable(manageStudentsForm.jTable, "");
			}
			}
		});
		jButtonEditStudent.setForeground(new Color(0, 0, 255));
		jButtonEditStudent.setFont(new Font("Monospaced", Font.BOLD, 16));
		jButtonEditStudent.setBackground(Color.WHITE);
		jButtonEditStudent.setBounds(205, 397, 149, 33);
		contentPane_1.add(jButtonEditStudent);
		
		
		
		jTable = new JTable();
		
		
		jTable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				
			}
		});
		jTable.addMouseListener(new MouseAdapter() {
			int rowIndex;
			@Override
			
			public void mouseClicked(MouseEvent e) {
				
				//model=(DefaultTableModel)jTable.getModel();
				
				rowIndex = jTable.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) jTable.getModel();
				
				jRadioButtonFemale.setSelected(false);
				jRadioButtonMale.setSelected(false);
								
				if (model.getValueAt(rowIndex, 3).toString().equals("Male")) {
					jRadioButtonMale.setSelected(true);
					
				} else {
					jRadioButtonFemale.setSelected(true);
					
				}
				
				jTextField_STD_ID.setText(model.getValueAt(rowIndex, 0).toString());
				jTextField_FName.setText(model.getValueAt(rowIndex, 1).toString());
				jTextField_LName.setText(model.getValueAt(rowIndex, 2).toString());
				jTextField_Phone.setText(model.getValueAt(rowIndex, 5).toString());
				jTextField_Address.setText(model.getValueAt(rowIndex, 6).toString());
				
				Date bdate;	
				try {
					bdate = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rowIndex, 4).toString());
					dateChooser.setDate(bdate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		jTable.setFont(new Font("Monospaced", Font.PLAIN, 13));
		jTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "First Name", "Last Name", "Sex", "Birthday", "Phone", "Address"},
			},
			new String[] {
				"ID", "First Name", "Last Name", "Sex", "Birthday", "Phone", "Address"
			}
		));
		jTable.setBounds(535, 107, 681, 323);
		contentPane_1.add(jTable);
		
		std.fillStudentJtable(jTable, "");
		ButtonGroup bg = new ButtonGroup();
		bg.add(jRadioButtonMale);
		bg.add(jRadioButtonFemale);
		
		jTextField_Search = new JTextField();
		jTextField_Search.addKeyListener(new KeyAdapter() {
			
			@Override
			public void  keyTyped(KeyEvent e) {
			}	
			@Override
			public void keyPressed(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			    jTable.setModel(new DefaultTableModel (null,new Object [] {"ID","First Name","Last Name","Sex","Birthday","Phone","Address"}));
				std.fillStudentJtable(jTable, jTextField_Search.getText());
			}
		});
		jTextField_Search.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_Search.setColumns(10);
		jTextField_Search.setBounds(846, 68, 370, 20);
		contentPane_1.add(jTextField_Search);
		
		JLabel lblNewLabel_1_6 = new JLabel("Search by pattern :");
		lblNewLabel_1_6.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(589, 60, 236, 33);
		contentPane_1.add(lblNewLabel_1_6);
		
	}

	
}
