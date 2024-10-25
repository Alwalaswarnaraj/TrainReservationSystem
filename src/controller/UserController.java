package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;
import service.UserService;
import trainReservationSystem.ClassUtility;

public class UserController {

	public static void register(User u) throws SQLException {
		String query = "INSERT INTO user (userName, emailId, password, role, createed_at) VALUES (?, ?, ?, ?, ?)";
		Connection con = ClassUtility.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, u.getUserName());
		pst.setString(2, u.getEmail());
		pst.setString(3, u.getPassword());
		pst.setString(4,u.getRole());
		pst.setTimestamp(5,u.getCreatedAt());
		int count = pst.executeUpdate();
		
		pst.close();
		if(count > 0) {
			System.out.println("Registered Successfully");
		}else {
			System.out.println("Failed to Register");
		}
	}
	
	public static void updateUser(String username,String password) throws SQLException {
		String var = UserService.userVerification(username, password);
//			System.out.println(var); just checking the what method is return;
		if(username.equals(var)) {
			UserService.updateUser(username,password);
		}else {
			System.out.println("user not found");
		}
	}
	public static void forgotPassword() {
		
	}
}
