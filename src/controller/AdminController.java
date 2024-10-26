package controller;

import java.sql.SQLException;
import java.util.Scanner;

import service.AdminService;
import trainReservationSystem.ClassUtility;

public class AdminController {
	static Scanner sc = new Scanner(System.in);
	public static void login() {
		System.out.print("Enter your User Name: ");
		String userName = sc.next();
		System.out.print("Enter your Password: ");
		String password = sc.next();
		System.out.println();
		try {
			AdminService.login(userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
