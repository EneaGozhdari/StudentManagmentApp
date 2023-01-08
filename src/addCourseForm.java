import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class addCourseForm extends JFrame {

	private JPanel contentPane;
	private JTextField jTextField_CourseLabel;
	public static JSpinner jSpinner;
	public static JButton jButtonAddCourse;
	public static JButton jButtonCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addCourseForm frame = new addCourseForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	course c = new course();

	public addCourseForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(addCourseForm.class.getResource("/images/stdmng.png")));
		setTitle("Add Course");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddCourse = new JLabel("Add Course");
		lblAddCourse.setFont(new Font("Monospaced", Font.BOLD, 23));
		lblAddCourse.setBounds(183, 11, 242, 49);
		contentPane.add(lblAddCourse);

		JLabel lblNewLabel_1 = new JLabel("Course :");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1.setBounds(45, 86, 116, 33);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Hours :");
		lblNewLabel_1_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(55, 130, 116, 33);
		contentPane.add(lblNewLabel_1_1);

		jTextField_CourseLabel = new JTextField();
		jTextField_CourseLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_CourseLabel.setColumns(10);
		jTextField_CourseLabel.setBounds(171, 94, 269, 20);
		contentPane.add(jTextField_CourseLabel);

		jSpinner = new JSpinner();
		jSpinner.setModel(new SpinnerNumberModel(5, 5, 300, 1));
		jSpinner.setFont(new Font("Monospaced", Font.BOLD, 18));
		jSpinner.setBounds(171, 138, 116, 25);
		contentPane.add(jSpinner);

		jButtonAddCourse = new JButton("Add");
		jButtonAddCourse.setIcon(new ImageIcon(addCourseForm.class.getResource("/images/add.png")));
		jButtonAddCourse.setForeground(new Color(0, 128, 0));
		jButtonAddCourse.setFont(new Font("Monospaced", Font.BOLD, 16));
		jButtonAddCourse.setBackground(new Color(255, 255, 255));
		jButtonAddCourse.setBounds(266, 246, 168, 33);
		contentPane.add(jButtonAddCourse);

		jButtonCancel = new JButton("Cancel");
		jButtonCancel.setIcon(new ImageIcon(addCourseForm.class.getResource("/images/close.png")));
		jButtonCancel.setForeground(new Color(255, 0, 0));
		jButtonCancel.setFont(new Font("Monospaced", Font.BOLD, 16));
		jButtonCancel.setBackground(Color.WHITE);
		jButtonCancel.setBounds(55, 246, 182, 33);
		contentPane.add(jButtonCancel);

		setLocationRelativeTo(null);
		
		// BUTONI ADD
		jButtonAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!c.isCourseExist(jTextField_CourseLabel.getText())) {
					
					String label = jTextField_CourseLabel.getText();
					int hours = Integer.valueOf(jSpinner.getValue().toString());
					c.insertUpdateDeleteStudent('i', null, label, hours);
					MainForm.jLabel_CrsCount.setText("Course Count = "+Integer.toString(MyFunction.countData("Course")));
				
				try {
					
					manageCourseForm.jTable.setModel(new DefaultTableModel(null, new Object [] {"ID","Label","Hours"}));
					c.fillCourseJtable(manageCourseForm.jTable);
					
				} catch (Exception ex) {
					
					System.out.println(ex.getMessage());
				}
				} else {
					JOptionPane.showMessageDialog(null, "Course Already Exist");	
				}		
			}
		});

		// BUTONI CANCEL
		jButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}
}
