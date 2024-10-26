package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import trainReservationSystem.ClassUtility;

public class AdminRepo {
	public static boolean login(String userName, String password) throws SQLException {
		String query = "SELECT userName, password FROM user WHERE userName = ? AND password = ? AND role = 'admin'";
		Connection con = ClassUtility.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, userName);
		pst.setString(2, password);
		ResultSet result = pst.executeQuery();
		if(result.next()) {
			return true;
		}
		return false;
	}
}
