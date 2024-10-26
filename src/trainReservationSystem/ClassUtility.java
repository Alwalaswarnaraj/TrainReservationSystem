package trainReservationSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassUtility {
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/trainreservation";
		String dbname = "root";
		String dbpass = "swarna@08";
		Connection con = DriverManager.getConnection(url, dbname, dbpass);
		return con;
	}
	
	public static void login()
}
