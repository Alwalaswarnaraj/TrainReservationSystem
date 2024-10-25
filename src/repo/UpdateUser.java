package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import trainReservationSystem.ClassUtility;

public class UpdateUser{
	
	public static void updateName(String name, String newName) throws SQLException {
		String query = "update user set userName = ? where userName = ?";
		Connection con = ClassUtility.getConnection();
		PreparedStatement pst;
		pst = con.prepareStatement(query);
		pst.setString(1, newName);
		pst.setString(2, name);
		pst.executeUpdate();
		con.close();
	}
	public static void updateEmail(String name,String newEmail) throws SQLException {
		String query = "update user set emailId = ? where userName= ?";
		Connection con = ClassUtility.getConnection();
		PreparedStatement pst;
		pst = con.prepareStatement(query);
		pst.setString(1, newEmail);
		pst.setString(2, name);
		pst.executeUpdate();
		con.close();
	}
	public static void updatePassword(String name,String newPassword) throws SQLException {
		String query = "update user set password = ? where userName= ?";
		Connection con = ClassUtility.getConnection();
		PreparedStatement pst;
		pst = con.prepareStatement(query);
		pst.setString(1, newPassword);
		pst.setString(2, name);
		pst.executeUpdate();
		con.close();
	}
}
