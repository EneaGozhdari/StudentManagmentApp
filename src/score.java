import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class score {

	public void insertUpdateDeleteStudent(char operation, Integer sid, Integer cid, Double scr, String descp) {

		Connection con = MyConnection.getConnection();
		PreparedStatement ps;

		// i => for insert
		if (operation == 'i') {
			try {
				ps = con.prepareStatement(
						"INSERT INTO score (student_id ,course_id ,student_score, description) VALUES (?,?,?,?)");
				ps.setInt(1, sid);
				ps.setInt(2, cid);
				ps.setDouble(3, scr);
				ps.setString(4, descp);

				if (ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Score Added");
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
						"UPDATE score SET student_score = ?, description = ? WHERE student_id = ? AND course_id =?");
				ps.setDouble(1, scr);
				ps.setString(2, descp);
				ps.setInt(3, sid);
				ps.setInt(4, cid);

				if (ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Score Updated");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// d => for delete
		if (operation == 'd') {
			try {
				ps = con.prepareStatement("DELETE FROM score WHERE student_id=? AND course_id=?");
				ps.setInt(1, sid);
				ps.setInt(2, cid);

				if (ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Score Deleted");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void fillScoreJtable(JTable table) {

		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM score");

			ResultSet rs = ps.executeQuery();

			DefaultTableModel model = (DefaultTableModel) table.getModel();

			Object[] row;
			while (rs.next()) {
				row = new Object[4];
				row[0] = rs.getInt(1);
				row[1] = rs.getInt(2);
				row[2] = rs.getDouble(3);
				row[3] = rs.getString(4);

				model.addRow(row);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	
	public void showAllScores(JTable table) {

		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT student_id,first_name,last_name,label,student_score\r\n"
					+ "FROM score\r\n"
					+ "INNER JOIN student AS stab ON stab.id=student_id\r\n"
					+ "INNER JOIN course AS ctab ON ctab.id=course_id;");

			ResultSet rs = ps.executeQuery();

			DefaultTableModel model = (DefaultTableModel) table.getModel();

			Object[] row;
			while (rs.next()) {
				row = new Object[5];
				row[0] = rs.getInt(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getDouble(5);

				model.addRow(row);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
