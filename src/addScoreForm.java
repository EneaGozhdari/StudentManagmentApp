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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class addScoreForm extends JFrame {

	private JPanel contentPane;
	private JTextField jTextField_StudentId;
	public static JTable jTable_Score;
	private JTextField jTextField_Score;
	private JButton jButtonAddScore;
	private JButton jButton_Cancel ;
	public static JComboBox jComboBox_CourseId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addScoreForm frame = new addScoreForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	course c = new course();
	Student std = new Student ();
	score sc = new score();
	DefaultTableModel model;
	private JTextField jTextField_Descp;
	
	public addScoreForm() {
		setTitle("Add Score");
		setIconImage(Toolkit.getDefaultToolkit().getImage(addScoreForm.class.getResource("/images/stdmng.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(250, 235, 215));
		contentPane_1.setBounds(0, 0, 885, 350);
		contentPane.add(contentPane_1);
		
		JLabel lblAddScore = new JLabel("Add Score");
		lblAddScore.setFont(new Font("Monospaced", Font.BOLD, 23));
		lblAddScore.setBounds(343, 11, 242, 49);
		contentPane_1.add(lblAddScore);
		
		JLabel lblNewLabel_1 = new JLabel("Course ID :");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1.setBounds(34, 135, 116, 33);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Score :");
		lblNewLabel_1_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(72, 179, 116, 33);
		contentPane_1.add(lblNewLabel_1_1);
		
		jButtonAddScore = new JButton("Add");
		jButtonAddScore.setIcon(new ImageIcon(addScoreForm.class.getResource("/images/add.png")));
		jButtonAddScore.setForeground(new Color(0, 128, 0));
		jButtonAddScore.setFont(new Font("Monospaced", Font.BOLD, 16));
		jButtonAddScore.setBackground(Color.WHITE);
		jButtonAddScore.setBounds(261, 292, 150, 33);
		contentPane_1.add(jButtonAddScore);
		
		jButton_Cancel = new JButton("Cancel");
		jButton_Cancel.setIcon(new ImageIcon(addScoreForm.class.getResource("/images/close.png")));
		jButton_Cancel.setForeground(new Color(255, 0, 0));
		jButton_Cancel.setFont(new Font("Monospaced", Font.BOLD, 16));
		jButton_Cancel.setBackground(Color.WHITE);
		jButton_Cancel.setBounds(61, 292, 150, 33);
		contentPane_1.add(jButton_Cancel);
		
		JLabel lblNewLabel_1_2 = new JLabel("Student ID :");
		lblNewLabel_1_2.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(24, 91, 157, 33);
		contentPane_1.add(lblNewLabel_1_2);
		
		jTextField_StudentId = new JTextField();
		jTextField_StudentId.setEditable(false);
		jTextField_StudentId.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_StudentId.setColumns(10);
		jTextField_StudentId.setBounds(160, 97, 269, 20);
		contentPane_1.add(jTextField_StudentId);

		jTable_Score = new JTable();
		jTable_Score.setModel(new DefaultTableModel(
			new Object[][] {
				{"Student ID", "Name", null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		jTable_Score.setFont(new Font("Monospaced", Font.PLAIN, 13));
		jTable_Score.setBounds(464, 65, 392, 274);
		contentPane_1.add(jTable_Score);
		
		jTextField_Score = new JTextField();
		jTextField_Score.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_Score.setColumns(10);
		jTextField_Score.setBounds(160, 185, 269, 20);
		contentPane_1.add(jTextField_Score);
		
		jComboBox_CourseId = new JComboBox();
		jComboBox_CourseId.setEditable(true);
		jComboBox_CourseId.setBounds(160, 143, 269, 22);
		contentPane_1.add(jComboBox_CourseId);
		
		c.fillCourseCombo(jComboBox_CourseId);
		std.fillStudentJtable(jTable_Score, "");
		
		jTextField_Descp = new JTextField();
		jTextField_Descp.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_Descp.setColumns(10);
		jTextField_Descp.setBounds(160, 229, 269, 20);
		contentPane_1.add(jTextField_Descp);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Description :");
		lblNewLabel_1_1_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(13, 223, 137, 33);
		contentPane_1.add(lblNewLabel_1_1_1);
		
		setLocationRelativeTo(null);
		
		jTable_Score.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int rowIndex = jTable_Score.getSelectedRow();
				jTextField_StudentId.setText(jTable_Score.getValueAt(rowIndex, 0).toString());
				
			}
		});
		
		jButtonAddScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int stdId = Integer.valueOf(jTextField_StudentId.getText());
				int crsId = c.getCourseId(jComboBox_CourseId.getSelectedItem().toString());
				double scr = Double.valueOf(jTextField_Score.getText());
				sc.insertUpdateDeleteStudent('i', stdId, crsId, scr ,jTextField_Descp.getText());
				
				try {
				editDeleteScore.jTable_Score.setModel(new DefaultTableModel(null,new Object [] {"Student Id","Course ID","Score","Description"}));
				sc.fillScoreJtable(editDeleteScore.jTable_Score);
				} catch (Exception ex){
					System.out.println(ex.getMessage());
				}
			}
		});
		
		jButton_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		
		hideColumn(6);
		hideColumn(5);
		hideColumn(4);
		hideColumn(3);
	}
	
	private void hideColumn(int colIndex) {
		
		TableColumn col = jTable_Score.getColumnModel().getColumn(colIndex);
		col.setMaxWidth(0);
		col.setMinWidth(0);
		col.setPreferredWidth(0);
	}
}
