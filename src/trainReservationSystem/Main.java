package trainReservationSystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import controller.AdminController;
import controller.TrainController;
import controller.UserController;
import model.Train;
import model.User;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		Connection con = ClassUtility.getConnection();
		UserController uc = null;
		TrainController tc = null;
		Scanner sc = new Scanner(System.in);
		User u = new User("sai", "psai.reddy@gmail.com", "sai12", "user");
		Train t1 = new Train(3022,"Hyderabad","Bangulore",true);
//		uc.register(u);
//		uc.updateUser("swarnaraj", "swarna.89");
//		tc.addTrain(t1);
//		System.out.println(t1.getSchedule());
//		User.forgotPassword();
//		tc.getTrainDetails();
		tc.checkAvailability();
		
		System.out.println("Enter the how want to login");
		System.out.println("1. Login as user");
		System.out.println("2. Login as Admin");
		int n = sc.nextInt();
		switch (n) {
		case 1:
//			UserController.login();
			break;
		case 2:
			AdminController.login();
			break;
		default:
			break;
		}
	}
}
