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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class editDeleteScore extends JFrame {

	private JPanel contentPane;
	private JTextField jTextField_StudentId;
	public static JTable jTable_Score;
	private JTextField jTextField_Score;
	private JTextField jTextField_Desc;
	private JTextField jTextField_CourseId;
	private JButton jButtonEdit;
	private JButton jButton_Remove;
	private JButton jButton_AddScore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editDeleteScore frame = new editDeleteScore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	score sc = new score();
	
	public editDeleteScore() {
		setTitle("Edit / Delete Score");
		setIconImage(Toolkit.getDefaultToolkit().getImage(editDeleteScore.class.getResource("/images/stdmng.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(250, 235, 215));
		contentPane_1.setBounds(0, 0, 1037, 396);
		contentPane.add(contentPane_1);
		
		JLabel lblEditDelete = new JLabel("Edit / Delete Score");
		lblEditDelete.setFont(new Font("Monospaced", Font.BOLD, 23));
		lblEditDelete.setBounds(340, 0, 286, 49);
		contentPane_1.add(lblEditDelete);
		
		JLabel lblNewLabel_1 = new JLabel("Course ID :");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1.setBounds(34, 135, 116, 33);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Score :");
		lblNewLabel_1_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(72, 179, 116, 33);
		contentPane_1.add(lblNewLabel_1_1);
		
		jButtonEdit = new JButton("Edit");
		jButtonEdit.setIcon(new ImageIcon(editDeleteScore.class.getResource("/images/edit.png")));
		jButtonEdit.setForeground(new Color(0, 0, 255));
		jButtonEdit.setFont(new Font("Monospaced", Font.BOLD, 16));
		jButtonEdit.setBackground(Color.WHITE);
		jButtonEdit.setBounds(173, 292, 150, 33);
		contentPane_1.add(jButtonEdit);
		
		jButton_Remove = new JButton("Remove");
		jButton_Remove.setIcon(new ImageIcon(editDeleteScore.class.getResource("/images/close.png")));
		jButton_Remove.setForeground(new Color(255, 0, 0));
		jButton_Remove.setFont(new Font("Monospaced", Font.BOLD, 16));
		jButton_Remove.setBackground(Color.WHITE);
		jButton_Remove.setBounds(13, 292, 150, 33);
		contentPane_1.add(jButton_Remove);
		
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
				{"Student ID", "Course ID", "Score", "Description"},
			},
			new String[] {
				"Student ID", "Course ID", "Score", "Description"
			}
		));
		jTable_Score.setFont(new Font("Monospaced", Font.PLAIN, 13));
		jTable_Score.setBounds(493, 48, 497, 320);
		contentPane_1.add(jTable_Score);
		
		jTextField_Score = new JTextField();
		jTextField_Score.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_Score.setColumns(10);
		jTextField_Score.setBounds(160, 185, 269, 20);
		contentPane_1.add(jTextField_Score);
		
		jTextField_Desc = new JTextField();
		jTextField_Desc.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_Desc.setColumns(10);
		jTextField_Desc.setBounds(160, 229, 269, 20);
		contentPane_1.add(jTextField_Desc);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Description :");
		lblNewLabel_1_1_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(13, 223, 137, 33);
		contentPane_1.add(lblNewLabel_1_1_1);
		
		jTextField_CourseId = new JTextField();
		jTextField_CourseId.setEditable(false);
		jTextField_CourseId.setFont(new Font("Monospaced", Font.BOLD, 15));
		jTextField_CourseId.setColumns(10);
		jTextField_CourseId.setBounds(160, 143, 269, 20);
		contentPane_1.add(jTextField_CourseId);
		
		jButton_AddScore = new JButton("Add");
		jButton_AddScore.setIcon(new ImageIcon(editDeleteScore.class.getResource("/images/add.png")));
		jButton_AddScore.setForeground(new Color(0, 128, 0));
		jButton_AddScore.setFont(new Font("Monospaced", Font.BOLD, 16));
		jButton_AddScore.setBackground(Color.WHITE);
		jButton_AddScore.setBounds(333, 292, 150, 33);
		contentPane_1.add(jButton_AddScore);
		
		sc.fillScoreJtable(jTable_Score);
		setLocationRelativeTo(null);
		
		jButton_AddScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addScoreForm AddScf = new addScoreForm();
				AddScf.setVisible(true);
				AddScf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		
		jButton_Remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int sid = Integer.valueOf(jTextField_StudentId.getText());
				int cid = Integer.valueOf(jTextField_CourseId.getText());
				
				sc.insertUpdateDeleteStudent('d', sid, cid, null, null);
				
				jTable_Score.setModel(new DefaultTableModel(null, new Object [] {"Student ID","Course ID","Score","Description"}));
				sc.fillScoreJtable(jTable_Score);
			}
		});
		
		jButtonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int sid = Integer.valueOf(jTextField_StudentId.getText());
				int cid = Integer.valueOf(jTextField_CourseId.getText());
				double scr = Double.valueOf(jTextField_Score.getText());
				String ds = jTextField_Desc.getText();
				
				sc.insertUpdateDeleteStudent('u', sid, cid, scr, ds);
				jTable_Score.setModel(new DefaultTableModel(null, new Object[] {"Student ID","Course ID","Score","Description"}));
				sc.fillScoreJtable(jTable_Score);
				
			}
		});
		
		jTable_Score.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int rowIndex=jTable_Score.getSelectedRow();
				jTextField_StudentId.setText(jTable_Score.getValueAt(rowIndex, 0).toString());
				jTextField_CourseId.setText(jTable_Score.getValueAt(rowIndex, 1).toString());
				jTextField_Score.setText(jTable_Score.getValueAt(rowIndex, 2).toString());
				jTextField_Desc.setText(jTable_Score.getValueAt(rowIndex, 3).toString());
				
			}
		});
	}
}
