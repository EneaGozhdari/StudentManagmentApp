import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainForm extends JFrame {

	private JPanel contentPane;
	public static JLabel jLabel_Username;
	public static JLabel jLabel_StdCount;
	public static JLabel jLabel_CrsCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
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
	public MainForm() {
		setTitle("Main Form");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainForm.class.getResource("/images/stdmng.png")));
		
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 449);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlLtHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 79, 25);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_2 = new JMenu("Student");
		mnNewMenu_2.setFont(new Font("Monospaced", Font.BOLD, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add");
		mntmNewMenuItem.setBackground(new Color(255, 255, 255));
		mntmNewMenuItem.setIcon(new ImageIcon(MainForm.class.getResource("/images/add.png")));
		mntmNewMenuItem.setFont(new Font("Monospaced", Font.BOLD, 15));
		
		mnNewMenu_2.add(mntmNewMenuItem);
		
		JMenuItem mntmManage = new JMenuItem("Manage Student");
		mntmManage.setBackground(new Color(255, 255, 255));
		mntmManage.setIcon(new ImageIcon(MainForm.class.getResource("/images/manage_student.png")));
		mntmManage.setFont(new Font("Monospaced", Font.BOLD, 15));
		mnNewMenu_2.add(mntmManage);
		
		
		jLabel_Username = new JLabel("Welcome <###> ");
		jLabel_Username.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
		jLabel_Username.setBounds(52, 36, 199, 41);
		contentPane.add(jLabel_Username);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(7, 136, 230, 68);
		
		panel.setLayout(null);
		
		jLabel_StdCount = new JLabel("Student Count = ");
		jLabel_StdCount.setBounds(10, 11, 220, 44);
		jLabel_StdCount.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		panel.add(jLabel_StdCount);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 255, 240));
		panel_1.setBounds(7, 222, 230, 68);
		contentPane.add(panel_1);
		
		jLabel_CrsCount = new JLabel("Courses Count = ");
		jLabel_CrsCount.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		jLabel_CrsCount.setBounds(10, 11, 220, 44);
		panel_1.add(jLabel_CrsCount);
		
		contentPane.add(panel);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setFont(new Font("Monospaced", Font.BOLD, 12));
		menuBar_1.setToolTipText("");
		menuBar_1.setBounds(79, 0, 79, 25);
		contentPane.add(menuBar_1);
		
		JMenu mnNewMenu = new JMenu("Course");
		mnNewMenu.setFont(new Font("Monospaced", Font.BOLD, 15));
		menuBar_1.add(mnNewMenu);
		
		JMenuItem jMenuItemAddCourse = new JMenuItem("Add");
		jMenuItemAddCourse.setBackground(new Color(255, 255, 255));
		jMenuItemAddCourse.setIcon(new ImageIcon(MainForm.class.getResource("/images/add.png")));
		jMenuItemAddCourse.setFont(new Font("Monospaced", Font.BOLD, 15));
		mnNewMenu.add(jMenuItemAddCourse);
		
		JMenuItem manageCourseMenuItem = new JMenuItem("Manage Course");
		manageCourseMenuItem.setBackground(new Color(255, 255, 255));
		manageCourseMenuItem.setIcon(new ImageIcon(MainForm.class.getResource("/images/course.png")));
		manageCourseMenuItem.setFont(new Font("Monospaced", Font.BOLD, 15));
		mnNewMenu.add(manageCourseMenuItem);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setFont(new Font("Monospaced", Font.BOLD, 12));
		menuBar_2.setBounds(158, 0, 79, 25);
		contentPane.add(menuBar_2);
		
		JMenu mnNewMenu_1 = new JMenu("Score");
		mnNewMenu_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		menuBar_2.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Score");
		mntmNewMenuItem_1.setBackground(new Color(255, 255, 255));
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainForm.class.getResource("/images/add.png")));
		mntmNewMenuItem_1.setFont(new Font("Monospaced", Font.BOLD, 15));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Edit / Remove");
		mntmNewMenuItem_2.setBackground(new Color(255, 255, 255));
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainForm.class.getResource("/images/score.png")));
		mntmNewMenuItem_2.setFont(new Font("Monospaced", Font.BOLD, 15));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem menuItemShowScores = new JMenuItem("Show Scores");
		menuItemShowScores.setBackground(new Color(255, 255, 255));
		menuItemShowScores.setIcon(new ImageIcon(MainForm.class.getResource("/images/table.png")));
		menuItemShowScores.setFont(new Font("Monospaced", Font.BOLD, 15));
		mnNewMenu_1.add(menuItemShowScores);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(MainForm.class.getResource("/images/mainform.jpg")));
		lblNewLabel_1.setBounds(0, 0, 535, 417);
		contentPane.add(lblNewLabel_1);
		
		setLocationRelativeTo(null);
		
		jMenuItemAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//adding courses
				addCourseForm Addcf = new addCourseForm();
				Addcf.setVisible(true);
				Addcf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		
		mntmManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				manageStudentsForm Mngsf = new manageStudentsForm();
				Mngsf.setVisible(true);
				Mngsf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddStudentForm Addsf = new AddStudentForm();
				Addsf.setVisible(true);
				Addsf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		
		manageCourseMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				manageCourseForm Mngcf = new manageCourseForm();
				Mngcf.setVisible(true);
				Mngcf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addScoreForm addscf = new addScoreForm();
				addscf.setVisible(true);
				addscf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editDeleteScore eddscf = new editDeleteScore();
				eddscf.setVisible(true);
				eddscf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		
		menuItemShowScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showScoresForm showSf = new showScoresForm();
				showSf.setVisible(true);
				showSf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		
	}
}
