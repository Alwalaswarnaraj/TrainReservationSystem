package model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Scanner;

public class Train {
	private int days;
	private int trainId;
	private int trainNumber;
	private String source;
	private String destination;
	private LocalDate schedule;
	private int noOfseatedAvailable;
	private boolean isSeatsAvailable;
	
	
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public LocalDate getSchedule() {
		return schedule;
	}
	public void setSchedule(LocalDate schedule) {
		this.schedule = schedule;
	}
	public boolean getIsSeatsAvailable() {
		return isSeatsAvailable;
	}
	public void setIsSeatsAvailable(boolean seatsAvailable) {
		this.isSeatsAvailable = seatsAvailable;
	}
	
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getNoOfseatedAvailable() {
		return noOfseatedAvailable;
	}
	public void setNoOfseatedAvailable(int noOfseatedAvailable) {
		this.noOfseatedAvailable = noOfseatedAvailable;
	}
	
	
	
	public Train(int trainNumber, String source, String destination, LocalDate schedule, int noOfseatedAvailable) {
		super();
		this.trainNumber = trainNumber;
		this.source = source;
		this.destination = destination;
		this.schedule = schedule;
		this.noOfseatedAvailable = noOfseatedAvailable;
	}
	
	public Train() {}
	public Train(int trainNumber, String source, String destination, boolean seatsAvailable) {
		super();
		this.trainNumber = trainNumber;
		this.source = source;
		this.destination = destination;
		this.schedule = LocalDate.now().plusDays(5);
		this.isSeatsAvailable = seatsAvailable;
	}
	@Override
	public String toString() {
		return "trainId=" + trainId + ", trainNumber=" + trainNumber + ", source=" + source + ", destination="
				+ destination + ", schedule=" + schedule + ", noOfseatedAvailable=" + noOfseatedAvailable;
	}
}
