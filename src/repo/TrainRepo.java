package repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Train;
import trainReservationSystem.ClassUtility;

public class TrainRepo {

	public static boolean addTrain(Train t) throws SQLException {
		String query = "insert into train (trainNumber,source,destination, schedule,isSeatsAvailable ) values(?,?,?,?,?)";
		LocalDate sc = t.getSchedule();
		Connection con = ClassUtility.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, t.getTrainNumber());
		pst.setString(2, t.getSource());
		pst.setString(3, t.getDestination());
		pst.setDate(4, Date.valueOf(sc));
		pst.setBoolean(5, true);
		boolean result =pst.execute();
		System.out.println("added");
		con.close();
		return result;
	}
	
	public static List<Train> getTrainDetails(String source, String destination) throws SQLException {
		List<Train> trainDetails = new ArrayList<Train>();
		String query = "Select * from train where source = ? and destination = ?";
		Connection con = ClassUtility.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, source);
		pst.setString(2, destination);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Train a = new Train();
			a.setTrainNumber(rs.getInt("trainNumber"));
			a.setSource(rs.getString("source"));
			a.setDestination(rs.getString("destination"));
			a.setSchedule(rs.getDate("schedule").toLocalDate());
			a.setNoOfseatedAvailable(rs.getInt("noOfseatedAvailable"));
			trainDetails.add(a);
		}
		return trainDetails;
	}
	
	public static List<Train> checkAvailability(String source, String destination) throws SQLException{
		List<Train> train = new ArrayList<Train>();
		String query = "Select * from train where source = ? and destination = ?";
		Connection con = ClassUtility.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, source);
		pst.setString(2, destination);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Train a = new Train();
			if(rs.getBoolean("isSeatsAvailable")) {
				a.setTrainNumber(rs.getInt("trainNumber"));
				a.setSource(rs.getString("source"));
				a.setDestination(rs.getString("destination"));
				a.setSchedule(rs.getDate("schedule").toLocalDate());
				a.setNoOfseatedAvailable(rs.getInt("noOfseatedAvailable"));
				train.add(a);
			}
		}
		return train;
	}
}
