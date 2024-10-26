package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import model.Train;
import service.TrainService;

public class TrainController {
	Train train;
	static Scanner sc = new Scanner(System.in);
//	Train t1 = new Train(3022,"Hyderabad","Bangulore",true);
	public static void addTrain() {
		Train t = new Train();
		System.out.print("Enter Train Number");
		t.setTrainNumber(sc.nextInt());
		System.out.print("Enter source");
		t.setSource(sc.nextLine());
		System.out.print("Enter Destination");
		t.setDestination(sc.nextLine());
		System.out.println("is Seats Available");
		t.setIsSeatsAvailable(sc.nextBoolean());
		System.out.println("No of seatsAvailable");
		t.setNoOfseatedAvailable(sc.nextInt());
		System.out.println("schedule");
		t.setSchedule(LocalDate.now().plusDays(sc.nextInt()));
		System.out.println();
		try {
			TrainService.addTrain(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void getTrainDetails() {
		System.out.print("Enter the source: ");
		String source = sc.next();
		System.out.print("Enter the destination: ");
		String destination = sc.next();
		System.out.println();
		try {
			TrainService.getTrainDetails(source, destination);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void checkAvailability() {
		System.out.print("Enter the source: ");
		String source = sc.next();
		System.out.print("Enter the destination: ");
		String destination = sc.next();
		System.out.println();
		try {
			TrainService.checkAvailability(source, destination);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
