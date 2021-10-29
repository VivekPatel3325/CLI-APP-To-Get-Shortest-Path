

import java.util.UUID;

public class Train {

	// Departure city of the flight
	String trainDeparCity;
	// Destination city of the flight
	String trainDestCity;

	// Train Time require to travel from source to destination in
	int trainTime;
	// Train cost to travel from source to destination
	int trainCost;

	// Constructor for Initialization and Instantiation of class variables
	public Train(String trainDeparCity, String trainDestCity, int trainTime, int trainCost) {
		super();

		this.trainDeparCity = trainDeparCity;
		this.trainDestCity = trainDestCity;
		this.trainTime = trainTime;
		this.trainCost = trainCost;
	}

	// Getter and setter methods to access class variable from outside the class
	public String getTrainDeparCity() {
		return trainDeparCity;
	}

	public void setTrainDeparCity(String trainDeparCity) {
		this.trainDeparCity = trainDeparCity;
	}

	public String getTrainDestCity() {
		return trainDestCity;
	}

	public void setTrainDestCity(String trainDestCity) {
		this.trainDestCity = trainDestCity;
	}

	public int getTrainTime() {
		return trainTime;
	}

	public void setTrainTime(int trainTime) {
		this.trainTime = trainTime;
	}

	public int getTrainCost() {
		return trainCost;
	}

	public void setTrainCost(int trainCost) {
		this.trainCost = trainCost;
	}

}
