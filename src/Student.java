import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Student {

	public void insertUpdateDeleteStudent(char operation, Integer id, String fname, String lname, String sex,
			String bdate, String phone, String address) {

		Connection con = MyConnection.getConnection();
		PreparedStatement ps;

		// i => for insert
		if (operation == 'i') {
			try {
				ps = con.prepareStatement(
						"INSERT INTO student (first_name, last_name, sex, birthday, phone, address) VALUES (?,?,?,?,?,?)");
				ps.setString(1, fname);
				ps.setString(2, lname);
				ps.setString(3, sex);
				ps.setString(4, bdate);
				ps.setString(5, phone);
				ps.setString(6, address);

				if (ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "New Student Added");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// u -> for update
		if (operation == 'u') {
			try {
				ps = con.prepareStatement(
						"UPDATE student set first_name = ?, last_name = ?, sex = ?,birthday = ?,phone = ?, address = ? WHERE id=?");
				ps.setString(1, fname);
				ps.setString(2, lname);
				ps.setString(3, sex);
				ps.setString(4, bdate);
				ps.setString(5, phone);
				ps.setString(6, address);
				ps.setInt(7, id);

				if (ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Student Updated");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// d => for delete
		if (operation == 'd') {

			int YesOrNo = JOptionPane.showConfirmDialog(null, "The Scores will be also Deleted", "Delete Student",
					JOptionPane.OK_CANCEL_OPTION, 0);

			if (YesOrNo == JOptionPane.OK_OPTION) {

				try {
					ps = con.prepareStatement("DELETE FROM student WHERE id=?");
					ps.setInt(1, id);

					if (ps.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "Student Deleted");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void fillStudentJtable(JTable table, String valueToSearch) {

		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			// ps = con.prepareStatement("SELECT * FROM student WHERE UPPER (first_name)
			// LIKE UPPER (?)");
			ps = con.prepareStatement("SELECT * FROM student WHERE CONCAT (first_name,last_name,phone,address) LIKE ?");

			ps.setString(1, "%" + valueToSearch + "%");

			ResultSet rs = ps.executeQuery();

			DefaultTableModel model = (DefaultTableModel) table.getModel();

			Object[] row;
			while (rs.next()) {
				row = new Object[7];
				row[0] = rs.getInt(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				row[5] = rs.getString(6);
				row[6] = rs.getString(7);

				model.addRow(row);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
