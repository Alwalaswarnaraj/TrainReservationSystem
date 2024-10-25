package trainReservationSystem;

import java.sql.Connection;
import java.sql.SQLException;

import userService.User;

public class Main {
	public static void main(String[] args) throws SQLException {
		Connection con = ClassUtility.getConnection();
		User u = new User("sai", "psai.reddy@gmail.com", "sai12", "user");
		User.register(u);
		User.updateUser("swarnaraj", "swarna.89");
//		User.forgotPassword();
	}
}
