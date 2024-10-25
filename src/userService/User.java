package userService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import trainReservationSystem.ClassUtility;

public class User {
	private int userId;
	private String userName;
	private String email;
	private String password;
	private String role;
	private Timestamp createdAt;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public User(String userName, String email, String password, String role) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdAt = new Timestamp(System.currentTimeMillis());
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", role=" + role + ", createdAt=" + createdAt + "]";
	}
	
	public static void register(User u) throws SQLException {
		String query = "INSERT INTO user (userName, emailId, password, role, createed_at) VALUES (?, ?, ?, ?, ?)";
		String query1 = "insert into password (?,?)";
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
			String var = UserUtility.userVerification(username, password);
//			System.out.println(var); just checking the what method is return;
			if(username.equals(var)) {
				UserUtility.updateUser(username,password);
			}else {
				System.out.println("user not found");
			}
		}
	public static void forgotPassword() {
		
	}
}












