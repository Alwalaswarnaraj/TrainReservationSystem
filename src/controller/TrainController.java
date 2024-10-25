package controller;

import java.sql.SQLException;

import model.Train;
import service.TrainService;

public class TrainController {
	Train train;
//	Train t1 = new Train(3022,"Hyderabad","Bangulore",true);
	public static void addTrain(Train t1) {
		try {
			TrainService.addTrain(t1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
