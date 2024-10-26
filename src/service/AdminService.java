package service;

import java.sql.SQLException;

import repo.AdminRepo;

public class AdminService {
	public static void login(String userName, String password) throws SQLException {
		boolean result = AdminRepo.login(userName, password);
		if(result) {
			System.out.println("Login Successful");
		}else {
			System.out.println("Login Failed");
		}
	}

}
