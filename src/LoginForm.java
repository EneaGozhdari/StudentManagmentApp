import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField jTextField_Username;
	private JPasswordField jPasswordField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/images/stdmng.png")));

		setFont(new Font("Monospaced", Font.BOLD, 15));
		setTitle("Student Management App");
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 477);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("LOGIN FORM");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 27));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(139, 0, 170, 57);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 17));
		lblNewLabel_1.setBounds(62, 276, 108, 32);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setFont(new Font("Monospaced", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(62, 319, 108, 32);
		contentPane.add(lblNewLabel_1_1);

		jTextField_Username = new JTextField();
		jTextField_Username.setFont(new Font("Monospaced", Font.PLAIN, 17));
		jTextField_Username.setBounds(157, 278, 205, 28);
		contentPane.add(jTextField_Username);
		jTextField_Username.setColumns(10);

		jPasswordField1 = new JPasswordField();
		jPasswordField1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		jPasswordField1.setBounds(157, 321, 205, 28);
		contentPane.add(jPasswordField1);

		JButton jButton_Login = new JButton("LOGIN");
		jButton_Login.setIcon(new ImageIcon(LoginForm.class.getResource("/images/login.png")));
		jButton_Login.setForeground(new Color(34, 139, 34));

		jButton_Login.setBackground(Color.WHITE);
		jButton_Login.setFont(new Font("Monospaced", Font.BOLD, 17));
		jButton_Login.setBounds(265, 379, 146, 40);
		contentPane.add(jButton_Login);

		JButton jButton_cancel = new JButton("CANCEL");
		jButton_cancel.setForeground(Color.RED);
		jButton_cancel.setBackground(Color.WHITE);
		jButton_cancel.setIcon(new ImageIcon(LoginForm.class.getResource("/images/close.png")));
		jButton_cancel.setFont(new Font("Monospaced", Font.BOLD, 17));
		jButton_cancel.setBounds(72, 379, 168, 40);
		contentPane.add(jButton_cancel);

		JLabel lbl_U = new JLabel("*");
		lbl_U.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_U.setForeground(Color.RED);
		lbl_U.setBounds(363, 284, 48, 14);
		contentPane.add(lbl_U);

		JLabel lbl_p = new JLabel("*");
		lbl_p.setForeground(Color.RED);
		lbl_p.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_p.setBounds(363, 327, 48, 14);
		contentPane.add(lbl_p);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(LoginForm.class.getResource("/images/admin.png")));
		lblNewLabel_2.setBounds(104, 54, 250, 244);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(LoginForm.class.getResource("/images/loginform.jpg")));
		lblNewLabel_3.setBounds(0, 0, 474, 442);
		contentPane.add(lblNewLabel_3);

		lbl_U.setVisible(false);
		lbl_p.setVisible(false);
		setLocationRelativeTo(null);

		jButton_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});

		jButton_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lbl_U.setVisible(false);
				lbl_p.setVisible(false);

				if (jTextField_Username.getText().equals("")) {
					lbl_U.setVisible(true);
				}
				if (String.valueOf(jPasswordField1.getPassword()).equals("")) {
					lbl_p.setVisible(true);
				} else {
					Connection con = MyConnection.getConnection();
					PreparedStatement ps;

					try {
						ps = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
						ps.setString(1, jTextField_Username.getText());
						ps.setString(2, String.valueOf(jPasswordField1.getPassword()));

						ResultSet rs = ps.executeQuery();

						if (rs.next()) {
							MainForm mf = new MainForm();
							mf.setVisible(true);
							// mf.pack();
							// mf.setLocationRelativeTo(null);
							MainForm.jLabel_Username.setText("Welcome <" + jTextField_Username.getText() + ">");
							MainForm.jLabel_StdCount
									.setText("Student Count = " + Integer.toString(MyFunction.countData("student")));
							dispose();
							// do ndryshohet me tabelen kurset
							MainForm.jLabel_CrsCount
									.setText("Course Count = " + Integer.toString(MyFunction.countData("course")));
							dispose();

						} else {
							JOptionPane.showMessageDialog(null, "Wrong Password or Username");
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});

	}
}
