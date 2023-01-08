import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class course {

	public void insertUpdateDeleteStudent(char operation, Integer id, String label, Integer hours) {

		Connection con = MyConnection.getConnection();
		PreparedStatement ps;

		// i => for insert
		if (operation == 'i') {
			try {
				ps = con.prepareStatement("INSERT INTO course (label,hours_number) VALUES (?,?)");
				ps.setString(1, label);
				ps.setInt(2, hours);

				if (ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "New Course Added");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// u -> for update
		if (operation == 'u') {
			try {
				ps = con.prepareStatement("UPDATE course SET label = ?, hours_number = ? WHERE id = ?");
				ps.setString(1, label);
				ps.setInt(2, hours);
				ps.setInt(3, id);

				if (ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Course Data Updated");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// d => for delete
		if (operation == 'd') {
			
			int YesOrNo = JOptionPane.showConfirmDialog(null, "The Scores will be also Deleted", "Delete Course",
					JOptionPane.OK_CANCEL_OPTION, 0);

			if (YesOrNo == JOptionPane.OK_OPTION) {
				
				try {
					ps = con.prepareStatement("DELETE FROM course WHERE id=?");
					ps.setInt(1, id);

					if (ps.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "Course Deleted");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
	}

	
	public void fillCourseJtable(JTable table) {

		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			// ps = con.prepareStatement("SELECT * FROM student WHERE UPPER (first_name)
			// LIKE UPPER (?)");
			ps = con.prepareStatement("SELECT * FROM course");

			ResultSet rs = ps.executeQuery();

			DefaultTableModel model = (DefaultTableModel) table.getModel();

			Object[] row;
			while (rs.next()) {
				row = new Object[3];
				row[0] = rs.getInt(1);
				row[1] = rs.getString(2);
				row[2] = rs.getInt(3);

				model.addRow(row);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public boolean isCourseExist(String courseName) {

		boolean isExist = false;

		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		try {

			ps = con.prepareStatement("SELECT * FROM course WHERE label LIKE ?");

			ps.setString(1, courseName);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				isExist = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isExist;
	}
	
	public int getCourseId(String courseLabel) {
		
		int courseId = 0;
		
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		try {

			ps = con.prepareStatement("SELECT * FROM course WHERE label LIKE ?");

			ps.setString(1, courseLabel);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				courseId = rs.getInt("Id");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return courseId;
	}
	
	public void fillCourseCombo(JComboBox combo) {

		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			// ps = con.prepareStatement("SELECT * FROM student WHERE UPPER (first_name)
			// LIKE UPPER (?)");
			ps = con.prepareStatement("SELECT * FROM course");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				combo.addItem(rs.getString(2));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
