package trainReservationSystem;

import java.sql.Connection;
import java.sql.SQLException;

import controller.TrainController;
import controller.UserController;
import model.Train;
import model.User;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		Connection con = ClassUtility.getConnection();
		UserController uc = null;
		TrainController tc = null;
		User u = new User("sai", "psai.reddy@gmail.com", "sai12", "user");
		Train t1 = new Train(3022,"Hyderabad","Bangulore",true);
//		uc.register(u);
//		uc.updateUser("swarnaraj", "swarna.89");
		tc.addTrain(t1);
//		System.out.println(t1.getSchedule());
//		User.forgotPassword();
	}
}
