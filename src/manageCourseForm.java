import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class manageCourseForm extends JFrame {

	private JPanel contentPane;
	private JTextField jTextField_CourseLabel;
	public static JTable jTable;
	private JTextField jTextField_CourseId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageCourseForm frame = new manageCourseForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	course c = new course();

	public manageCourseForm() {
		setTitle("Manage Course");
		setIconImage(Toolkit.getDefaultToolkit().getImage(manageCourseForm.class.getResource("/images/stdmng.png")));
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(255, 255, 224));
		contentPane_1.setBounds(0, 0, 885, 350);
		contentPane.add(contentPane_1);
		
		JLabel lblManageCourse = new JLabel("Manage Course");
		lblManageCourse.setFont(new Font("Monospaced", Font.BOLD, 23));
		lblManageCourse.setBounds(343, 11, 242, 49);
		contentPane_1.add(lblManageCourse);
		
		JLabel lblNewLabel_1 = new JLabel("Course :");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1.setBounds(44, 155, 116, 33);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hours :");
		lblNewLabel_1_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(55, 228, 116, 33);
		contentPane_1.add(lblNewLabel_1_1);
		
		jTextField_CourseLabel = new JTextField();
		jTextField_CourseLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_CourseLabel.setColumns(10);
		jTextField_CourseLabel.setBounds(160, 161, 269, 20);
		contentPane_1.add(jTextField_CourseLabel);
		
		JSpinner jSpinner = new JSpinner();
		jSpinner.setFont(new Font("Monospaced", Font.BOLD, 18));
		jSpinner.setBounds(160, 231, 116, 25);
		contentPane_1.add(jSpinner);
		
		JButton jButtonAddCourse = new JButton("Add");
		jButtonAddCourse.setIcon(new ImageIcon(manageCourseForm.class.getResource("/images/add.png")));
		jButtonAddCourse.setForeground(new Color(0, 100, 0));
		jButtonAddCourse.setFont(new Font("Monospaced", Font.BOLD, 16));
		jButtonAddCourse.setBackground(Color.WHITE);
		jButtonAddCourse.setBounds(302, 292, 127, 33);
		contentPane_1.add(jButtonAddCourse);
		
		JButton jButtonRemove = new JButton("Remove");
		jButtonRemove.setIcon(new ImageIcon(manageCourseForm.class.getResource("/images/close.png")));
		jButtonRemove.setForeground(new Color(255, 0, 0));
		jButtonRemove.setFont(new Font("Monospaced", Font.BOLD, 16));
		jButtonRemove.setBackground(Color.WHITE);
		jButtonRemove.setBounds(10, 292, 150, 33);
		contentPane_1.add(jButtonRemove);
		
		jTable = new JTable();
		jTable.setForeground(Color.BLACK);
		jTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Label", "Hours"},
			},
			new String[] {
				"ID", "Label", "Hours"
			}
		));
		jTable.setFont(new Font("Monospaced", Font.BOLD, 13));
		jTable.setBounds(450, 76, 407, 260);
		contentPane_1.add(jTable);
		
		JLabel lblNewLabel_1_2 = new JLabel("ID :");
		lblNewLabel_1_2.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(79, 91, 48, 33);
		contentPane_1.add(lblNewLabel_1_2);
		
		jTextField_CourseId = new JTextField();
		jTextField_CourseId.setEditable(false);
		jTextField_CourseId.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_CourseId.setColumns(10);
		jTextField_CourseId.setBounds(160, 97, 116, 20);
		contentPane_1.add(jTextField_CourseId);
		
		JButton jButtonEditCourse = new JButton("Update");
		jButtonEditCourse.setIcon(new ImageIcon(manageCourseForm.class.getResource("/images/edit.png")));
		jButtonEditCourse.setForeground(new Color(0, 0, 205));
		jButtonEditCourse.setFont(new Font("Monospaced", Font.BOLD, 16));
		jButtonEditCourse.setBackground(Color.WHITE);
		jButtonEditCourse.setBounds(170, 292, 122, 33);
		contentPane_1.add(jButtonEditCourse);
		
		setLocationRelativeTo(null);
		
		jButtonAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addCourseForm Addcf = new addCourseForm();
				Addcf.setVisible(true);
				Addcf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		
		jTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int index = jTable.getSelectedRow();
				jTextField_CourseId.setText(jTable.getValueAt(index, 0).toString());
				jTextField_CourseLabel.setText(jTable.getValueAt(index, 1).toString());
				jSpinner.setValue(Integer.valueOf(jTable.getValueAt(index, 2).toString()));
				
			}
		});
		
		jButtonEditCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					int id = Integer.valueOf(jTextField_CourseId.getText());
					String label = jTextField_CourseLabel.getText();
					int hours = Integer.valueOf(jSpinner.getValue().toString());
					c.insertUpdateDeleteStudent('u', id, label, hours);

					manageCourseForm.jTable.setModel(new DefaultTableModel(null, new Object[] { "ID", "Label", "Hours" }));
					c.fillCourseJtable(manageCourseForm.jTable);
					//JOptionPane.showMessageDialog(null, "Course Edited");
				
			}
		});
		
		jButtonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/**
				 * When delete course you also delete the scores for that course
				 * 
				    alter table score 
					add constraint fk_score_course
					foreign key (course_id)
					references course (id)
					on delete cascade;
				 */
				
				if (!jTextField_CourseId.getText().equals("")) {
				int id = Integer.valueOf(jTextField_CourseId.getText());
				c.insertUpdateDeleteStudent('d', id, null, null);
				manageCourseForm.jTable.setModel(new DefaultTableModel(null,new Object [] {"ID","Label","Hours"}));
				c.fillCourseJtable(manageCourseForm.jTable);
				jTextField_CourseId.setText("");
				jTextField_CourseLabel.setText("");
				jSpinner.setValue(5);
				}
			}
		});
		
		c.fillCourseJtable(jTable);
	}
}
