

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class City {

	//Name of the city
	private String cityName;
	
	//Test required or not
	private boolean isTestRequired;
	
	//Time for test
	private int timeForTest;
	
	//Hotel price for one night stay
	private int hotelPricePerNight;

	// path length or distance form the source
	private int calculatedWeight;

	private Set<String> neighBourCities;

	// Store route for each city from the source with minimal cost
	private List<City> minimumCostRoute;

	//Store details of flight to travel from source to destination
	private Map<String, Flight> listOfFlightFromSrcToDest;
	
	//Store details of train to travel from source to destination
	private Map<String,Train>  listOfTrainFromSrcToDest;
	
	//Store mode of travel{Train,Fly}
	private String modeOfTravel;
 
	//Constructor for Initialization and Instantiation of class variables 
	public City(String cityName, boolean isTestRequired, int timeForTest, int hotelPricePerNight) {
		super();
		this.cityName = cityName;
		this.isTestRequired = isTestRequired;
		this.timeForTest = timeForTest;
		this.hotelPricePerNight = hotelPricePerNight;
		this.neighBourCities = new HashSet<String>();
		// Assign infinite cost to each cities initially
		this.calculatedWeight = Integer.MAX_VALUE;
		this.minimumCostRoute = new ArrayList<City>();
		this.listOfFlightFromSrcToDest = new HashMap<String, Flight>();
		this.listOfTrainFromSrcToDest = new HashMap<String, Train>();
		this.modeOfTravel=new String();
	}

	//Getter and setter methods to access class variable from outside the class
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public boolean isTestRequired() {
		return isTestRequired;
	}

	public void setTestRequired(boolean isTestRequired) {
		this.isTestRequired = isTestRequired;
	}

	public int getTimeForTest() {
		return timeForTest;
	}

	public void setTimeForTest(int timeForTest) {
		this.timeForTest = timeForTest;
	}

	public int getHotelPricePerNight() {
		return hotelPricePerNight;
	}

	public void setHotelPricePerNight(int hotelPricePerNight) {
		this.hotelPricePerNight = hotelPricePerNight;
	}

	public int getCalculatedWeight() {
		return calculatedWeight;
	}

	public void setCalculatedWeight(int calculatedWeight) {
		this.calculatedWeight = calculatedWeight;
	}

	public Set<String> getNeighBourCities() {
		return neighBourCities;
	}

	public void setNeighBourCities(Set<String> neighBourCities) {
		this.neighBourCities = neighBourCities;
	}

	public List<City> getMinimumCostRoute() {
		return minimumCostRoute;
	}

	public void setMinimumCostRoute(List<City> minimumCostRoute) {
		this.minimumCostRoute = minimumCostRoute;
	}

	public Map<String, Flight> getListOfFlightFromSrcToDest() {
		return listOfFlightFromSrcToDest;
	}

	public void setListOfFlightFromSrcToDest(Map<String, Flight> listOfFlightFromSrcToDest) {
		this.listOfFlightFromSrcToDest = listOfFlightFromSrcToDest;
	}

	public Map<String, Train> getListOfTrainFromSrcToDest() {
		return listOfTrainFromSrcToDest;
	}

	public void setListOfTrainFromSrcToDest(Map<String, Train> listOfTrainFromSrcToDest) {
		this.listOfTrainFromSrcToDest = listOfTrainFromSrcToDest;
	}

	public String getModeOfTravel() {
		return modeOfTravel;
	}

	public void setModeOfTravel(String modeOfTravel) {
		this.modeOfTravel = modeOfTravel;
	}
	
	

}