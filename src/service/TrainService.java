package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Train;
import trainReservationSystem.ClassUtility;

public class TrainService {
	public static void addTrain(Train t) throws SQLException {
		String query = "insert into train (trainNumber,source,destination, schedule,isSeatsAvailable ) values(?,?,?,?,?)";
		LocalDate sc = t.getSchedule();
		Connection con = ClassUtility.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, t.getTrainNumber());
		pst.setString(2, t.getSource());
		pst.setString(3, t.getDestination());
		pst.setDate(4, Date.valueOf(sc));
		pst.setBoolean(5, true);
		pst.execute();
		System.out.println("added");
		con.close();
	}
}