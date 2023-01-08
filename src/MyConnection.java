import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
public static Connection getConnection() {
	Connection con = null;
	final String url = "jdbc:postgresql://localhost/std_mng_db";

	final String user = "postgres";
	final String password = "admin";
	
   
    	try {
			con = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return con;
    }
}