import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class showScoresForm extends JFrame {

	private JPanel contentPane;
	public static JTable jTable_AllScores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showScoresForm frame = new showScoresForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	score sc = new score();
	
	public showScoresForm() {
		setTitle("All Scores");
		setIconImage(Toolkit.getDefaultToolkit().getImage(showScoresForm.class.getResource("/images/stdmng.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 721);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setForeground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("All Scores");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblNewLabel.setBounds(265, 11, 218, 89);
		contentPane.add(lblNewLabel);
		
		jTable_AllScores = new JTable();
		jTable_AllScores.setRowHeight(34);
		jTable_AllScores.setFont(new Font("Monospaced", Font.BOLD, 18));
		jTable_AllScores.setModel(new DefaultTableModel(
			new Object[][] {
				{"Student ID", "First Name", "Last Name", "Course", "Score"},
			},
			new String[] {
				"Student ID", "First Name", "Last Name", "Course", "Score"
			}
		));
		jTable_AllScores.setBounds(24, 92, 649, 573);
		contentPane.add(jTable_AllScores);
		
		sc.showAllScores(jTable_AllScores);
		
		setLocationRelativeTo(null);
	}
}
