package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Train;
import repo.TrainRepo;
import trainReservationSystem.ClassUtility;

public class TrainService {
	public static void addTrain(Train t) throws SQLException {
		boolean result = TrainRepo.addTrain(t);
		if(result) {
			System.out.println("Successfully added the TrainInformation");
		}else {
			System.out.println("Failed to add");
		}
	}
	public static void getTrainDetails(String source, String destination) throws SQLException {
		List<Train> train =  TrainRepo.getTrainDetails(source, destination);
		if(!train.isEmpty()) {
			Iterator<Train> list = train.iterator();
			while(list.hasNext()) {
				System.out.println(list.next());
			}
		}else {
			System.out.println("train not avilable");
		}
 	}
	
	public static void checkAvailability(String source, String destination) throws SQLException {
		List<Train> train = TrainRepo.checkAvailability(source, destination);
		if(!train.isEmpty()) {
			Iterator<Train> list = train.iterator();
			while(list.hasNext()) {
				System.out.println(list.next());
			}
		}else {
			System.out.println("train not avilable");
		}
	}
}