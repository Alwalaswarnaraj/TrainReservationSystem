package userService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import trainReservationSystem.ClassUtility;

public class UserUtility {
	public static String userVerification(String name,String password) throws SQLException {
//		String query = "select u.userName,u.password from user u inner join passwords p on u.password = p.password";     old query 
		String query = "select u.userName from user u inner join passwords p on u.password = p.password where p.password= ?"; // new query updated version
		Connection con = ClassUtility.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,password);
		ResultSet rs = pst.executeQuery();
		String uname = null;
		while(rs.next()) {
			uname = rs.getString("userName");
			if(uname.equals(name)) {
				return uname;
			}
		}
//		System.out.println(u+" "+p); just print to check the fetched usename and password
		return null;
	}
	
	public static void updateUser(String username, String password) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select the option");
		System.out.println("1. Update UserName");
		System.out.println("2. Update Password");
		System.out.println("3. Update Email");
		int n = sc.nextInt();
		switch (n) {
		case 1:System.out.println("Enter the name");
				String newName = sc.nextLine();
				UpdateUser.updateName(userVerification(username, password), newName);
			break;
		case 2: System.out.println("Enter the password: ");
				String newPassword = sc.next();
				UpdateUser.updatePassword(userVerification(username,password), newPassword);
			break;
		case 3: System.out.println("Enter the email");
				String newEmail = sc.nextLine();
				UpdateUser.updateEmail(userVerification(username,password), newEmail);
		default:
			break;
		}
	}
}
