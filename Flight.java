

public class Flight {

	// Departure city of the flight
	String flightDeparCity;

	// Destination city of the flight
	String flightDestCity;

	// Time require to fly from source to destination
	int flightTime;

	// Flight cost to travel from source to destination
	int flightCost;

	// Constructor for Initialization and Instantiation of class variables
	public Flight(String departureCity, String destinationCity, int flightTime, int flightCost) {
		super();

		this.flightDeparCity = departureCity;
		this.flightDestCity = destinationCity;
		this.flightTime = flightTime;
		this.flightCost = flightCost;
	}

	// Getter and setter methods to access class variable from outside the class
	public String getFlightDeparCity() {
		return flightDeparCity;
	}

	public void setFlightDeparCity(String flightDeparCity) {
		this.flightDeparCity = flightDeparCity;
	}

	public String getFlightDestCity() {
		return flightDestCity;
	}

	public void setFlightDestCity(String flightDestCity) {
		this.flightDestCity = flightDestCity;
	}

	public int getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}

	public int getFlightCost() {
		return flightCost;
	}

	public void setFlightCost(int flightCost) {
		this.flightCost = flightCost;
	}

}
