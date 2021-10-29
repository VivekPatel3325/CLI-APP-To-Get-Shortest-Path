

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;




public class TravelAssistant implements TravelAssistantInterface {

	/*
	 * Maintain details of cities entered and consider each city as vertex of the
	 * graph
	 */
	private Map<String, City> listOfCities;

	/*
	 * Store mode of transport{Train or Flight} while travelling from one city to
	 * another
	 */
	private String minCostTraMode;

	// Default constructor for Initialization and Instantiation of class variables
	public TravelAssistant() {
		super();
		this.listOfCities = new HashMap<String, City>();
		this.minCostTraMode = new String("");
	}

	/**
	 * Method to add city in the graph as a vertex and return true,false and IllegalArgument
	 * exception based on the input parameters
	 * 
	 *  city             Name of city to be added
	 *  testRequired     Whether test is required in the city or not for entry
	 *  timeToTest       Time required to take covid test in the city
	 *  nightlyHotelCost Price of one night stay in a hotel
	 * return true if city is added with acceptable parameters . false if
	 *         information is exist for the city
	 * 
	 */
	public boolean addCity(String cityName, boolean testRequired, int timeToTest, int nightlyHotelCost)
			throws IllegalArgumentException {

		/*
		 * Check if city name is acceptable or not.If not then thow an
		 * illegalArgumentException
		 */
		if (cityName == null || cityName.trim().equals("")) {
			throw new IllegalArgumentException();
		}

		/*
		 * If hotel cost is negative or zero then throw exception
		 */
		if (nightlyHotelCost <= 0) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check that city is already added or not.If added then return false
		 */
		if (this.listOfCities.containsKey(cityName)) {
			return false;
		}

		/*
		 * Create new city and store into hashmap of listOfCities and return true
		 */
		City newCity = new City(cityName, testRequired, timeToTest, nightlyHotelCost);
		listOfCities.put(cityName, newCity);

		return true;
	}

	/**
	 * Method to add  flight detail between source and destination cities and return true,false
	 * and IllegalArgument exception based on the input parameters
	 * 
	 *  startCity       Name of departure city to be added
	 *  destinationCity Name of destination city to be added
	 *  flightTime      Flight time between source and destination cities
	 *  flightCost      Cost to travel in flight
	 * return true if flight is added with acceptable parameters . false if
	 *         information is exist for the flight
	 * 
	 */
	public boolean addFlight(String startCity, String destinationCity, int flightTime, int flightCost)
			throws IllegalArgumentException {

		/*
		 * Check if source city name is acceptable or not.If not then thow an
		 * IllegalArgumentException
		 */
		if (startCity == null || startCity.trim().equals("")) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if destination city name is acceptable or not.If not then thow an
		 * IllegalArgumentException
		 */
		if (destinationCity == null || destinationCity.trim().equals("")) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if source city is exist in the travel network or not.If not then thow
		 * an IllegalArgumentException
		 */
		if (!listOfCities.containsKey(startCity)) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if destination city is exist in the travel network or not.If not then
		 * thow an IllegalArgumentException
		 */
		if (!listOfCities.containsKey(destinationCity)) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if traveling time in flight is acceptable or not.Throw
		 * IllegalArgumentException if time is 0 or negative
		 */
		if (flightTime <= 0) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if flight cost is acceptable or not.Throw IllegalArgumentException if
		 * cost is 0 or negative
		 */
		if (flightCost <= 0) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if flight details already exist for the given source and destination or
		 * not return false if exist
		 */
		City originCity = null;
		originCity = listOfCities.get(startCity);
		if (originCity.getListOfFlightFromSrcToDest().get(destinationCity) != null) {
			return false;
		}

		Flight flight = new Flight(startCity, destinationCity, flightTime, flightCost);

		// Add flight details for the given source and destination cities and return
		// true
		originCity = listOfCities.get(startCity);
		originCity.getNeighBourCities().add(destinationCity);
		originCity.getListOfFlightFromSrcToDest().put(destinationCity, flight);

		return true;
	}

	/**
	 * Method to add train detail between source and destination cities and return true,false
	 * and IllegalArgument exception based on the input parameters
	 * 
	 *  startCity       Name of departure city to be added
	 *  destinationCity Name of destination city to be added
	 *  trainTime       Flight time between source and destination cities
	 *  trainCost       Cost to travel in flight
	 * return true if train is added with acceptable parameters . false if
	 *         information is exist for the flight
	 * 
	 */
	public boolean addTrain(String startCity, String destinationCity, int trainTime, int trainCost)
			throws IllegalArgumentException {

		/*
		 * Check if source city name is acceptable or not.If not then thow an
		 * IllegalArgumentException
		 */
		if (startCity == null || startCity.trim().equals("")) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if destination city name is acceptable or not.If not then thow an
		 * IllegalArgumentException
		 */
		if (destinationCity == null || destinationCity.trim().equals("")) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if source city is exist in the travel network or not.If not then thow
		 * an IllegalArgumentException
		 */
		if (!listOfCities.containsKey(startCity)) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if destination city is exist in the travel network or not.If not then
		 * throw an IllegalArgumentException
		 */
		if (!listOfCities.containsKey(destinationCity)) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if traveling time in train is acceptable or not.Throw
		 * IllegalArgumentException if time is 0 or negative
		 */
		if (trainTime <= 0) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if train cost is acceptable or not.Throw IllegalArgumentException if
		 * cost is 0 or negative
		 */
		if (trainCost <= 0) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if train details already exist for the given source and destination or
		 * not return false if exist
		 */
		City originCity = null;
		originCity = listOfCities.get(startCity);
		if (originCity.getListOfTrainFromSrcToDest().get(destinationCity) != null) {
			return false;
		}

		Train train = new Train(startCity, destinationCity, trainTime, trainCost);

		// Add city in neighbour city list of the source city
		originCity = listOfCities.get(startCity);
		originCity.getNeighBourCities().add(destinationCity);
		originCity.getListOfTrainFromSrcToDest().put(destinationCity, train);

		return true;
	}

	/**
	 * Method to find optimal path between source and destination using Dijkstra algorithm  and return path
	 * Throw IllegalArgument exception if input parameters are unacceptable
	 * 
	 *  startCity       Name of departure city to be added
	 *  destinationCity Name of destination city to be added
	 *  isVaccinated    Whether visitor is vaccinated or not
	 *  costImportance  Cost priority for the travel plan
	 *  travelTimeImportance  Travel time priority for the travel plan
	 *  travelHopImportance   Priority for number of stops between source and destination cities
	 * return Optimal travel path if path exist between source and destination cities else null
	 * Throw an IllegalArgumentException if input parameters are unacceptable        
	 */
	public List<String> planTrip(String startCity, String destinationCity, boolean isVaccinated, int costImportance,
			int travelTimeImportance, int travelHopImportance) throws IllegalArgumentException {

		/*
		 * Check if start city name is acceptable or not.If not then thow an
		 * IllegalArgumentException
		 */
		if (startCity == null || startCity.trim().equals("")) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if destination city name is acceptable or not.If not then thow an
		 * IllegalArgumentException
		 */
		if (destinationCity == null || destinationCity.trim().equals("")) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if source city is exist in the travel network or not.If not then thow
		 * an IllegalArgumentException
		 */
		if (!listOfCities.containsKey(startCity)) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if destination city is exist in the travel network or not.If not then
		 * thow an IllegalArgumentException
		 */
		if (!listOfCities.containsKey(destinationCity)) {
			throw new IllegalArgumentException();
		}

		/*
		 * Check if the cost travel time and travel hop priorities are non negative.If
		 * not then thow an IllegalArgumentException
		 */
		if (costImportance < 0 || travelTimeImportance < 0 || travelHopImportance < 0) {
			throw new IllegalArgumentException();
		}

		City sourceCity = listOfCities.get(startCity);
		

		List<String> visitedCities = new ArrayList<String>();
		
		List<String> unvisitedCities = new ArrayList<String>();
		unvisitedCities.add(startCity);
		
		// Initial distance travel from source set to 0
		sourceCity.setCalculatedWeight(0);
		boolean iterate = unvisitedCities.size() != 0;

		//Iterate until list of unvisited cities is not empty
		while (iterate) {

			//Get the city with minimal cost and make it current city
			String recentVisitedCity = getMinRouteCity(unvisitedCities);
			
			//Remove recently visited city from the list of unvisited cities  
			unvisitedCities.remove(recentVisitedCity);

			// Get the detail of currently visited city
			City recVisitedCityDetail = listOfCities.get(recentVisitedCity);

			// Iterate adjacent cities of current city for finding minimal cost and mode of
			// transportation{Flight,Train}
			for (String neighbourCity : recVisitedCityDetail.getNeighBourCities()) {

				City adjacentCity = listOfCities.get(neighbourCity);
				
				// Calculate cost of traveling form one city to another through flight or train and return minimal cost
				int totalWeight = calculateWeight(recVisitedCityDetail, adjacentCity, costImportance,
						travelTimeImportance, travelHopImportance);
				
				
				if (!visitedCities.contains(adjacentCity.getCityName())) {
					//Update the existing cost of adjacent city if the current cost is higher  than new
					calMinCostFromSource(recVisitedCityDetail, adjacentCity, totalWeight);
					unvisitedCities.add(adjacentCity.getCityName());
				}
			}

			if (unvisitedCities.size() == 0) {
				iterate = false;
			}
			visitedCities.add(recentVisitedCity);

		}

		return getOptimalPath(startCity,destinationCity);
	}

	private List<String> getOptimalPath(String startCity, String destinationCity) {

		List<String> listOfRoute = new ArrayList<String>();

		City finalStop = listOfCities.get(destinationCity);
		City sourceCity = listOfCities.get(startCity);

		if (sourceCity.getCityName().equals(finalStop.getCityName())) {
			listOfRoute.add("start " + finalStop.getCityName());
			return listOfRoute;
		}

		if (finalStop.getMinimumCostRoute().size() == 0) {
			return null;
		}

		int counter = 0;
		for (City city : finalStop.getMinimumCostRoute()) {
			if (counter == 0) {
				listOfRoute.add("start " + city.getCityName());
			}

			if (counter <= finalStop.getMinimumCostRoute().size() - 2) {
				listOfRoute.add(
						city.getModeOfTravel() + " " + finalStop.getMinimumCostRoute().get(counter + 1).getCityName());
			} else {
				listOfRoute.add(city.getModeOfTravel() + " " + finalStop.getCityName());
			}
			counter++;
		}

		return listOfRoute;
	}

	
	/*Method to update the cost of adjacentCity if it's current cost is higher than the new calculated cost 
	 * sourceCity     source city
	 * connectedCity  destination or connected city
	 * weight         updated calculated cost 
	 *return minimal cost of travel from source to connected or destination  cities
	 * */
	private void calMinCostFromSource(City recVisitedCityDetail, City adjacentCity, int weight) {
		
		//Get the cost of current city
		int minWeighFromSource = recVisitedCityDetail.getCalculatedWeight();

		List<City> minCostCities = new LinkedList<City>();

		for (City city : recVisitedCityDetail.getMinimumCostRoute()) {
			minCostCities.add(city);
		}

		int totalWeight = 0;

		totalWeight = minWeighFromSource + weight;
		
		//Update the cost of adjacent city if it's current cost is higher than new cost
		if (adjacentCity.getCalculatedWeight() > totalWeight) {
			adjacentCity.setCalculatedWeight(totalWeight);
			City connectedCity = new City(recVisitedCityDetail.getCityName(), recVisitedCityDetail.isTestRequired(),
					recVisitedCityDetail.getTimeForTest(), recVisitedCityDetail.getHotelPricePerNight());
			connectedCity.setModeOfTravel(minCostTraMode);
			minCostCities.add(connectedCity);
			// City city = minCostCities.get(minCostCities.size() - 1);
			// recVisitedCityDetail.setModeOfTravel(this.minCostTraMode);
			adjacentCity.setMinimumCostRoute(minCostCities);
		}
	}

	/*Method to calculate  cost  of traveling between source and destination through 
	 * various mode of transportation{Train,Flight} and return optimal cost as well as 
	 * decide mode of transportation
	 * sourceCity     source city
	 * connectedCity  destination or connected city
	 *return minimal cost of travel from source to connected or destination  cities
	 * */
	private int calculateWeight(City sourceCity, City connectedCity, int costImp, int travelTimeImp, int travelHopImp) {

		//Initialize all  cost to 0
		int minWeight = 0;

		int flightTotalWeight = 0;

		int trainTotalWeight = 0;

		//Get the detail of flight to travel from source to connected or destination cities
		Flight flight = sourceCity.getListOfFlightFromSrcToDest().get(connectedCity.getCityName());

		//Get the detail of train to travel from source to connected or destination cities 
		Train train = sourceCity.getListOfTrainFromSrcToDest().get(connectedCity.getCityName());

		// If no flight exist between source and destination then return 0.
		if (flight == null && train == null) {
			this.minCostTraMode = "";
			return minWeight;
		}
		
		//Calculate cost of traveling through flight if flight is available to travel from source to connected or destination cities
		if (flight != null) {
			flightTotalWeight = flight.getFlightCost() * costImp + flight.getFlightTime() * travelTimeImp
					+ 1 * travelHopImp;
		}

		//Calculate cost of traveling through train if flight is available to travel from source to connected or destination cities
		if (train != null) {
			trainTotalWeight = train.getTrainCost() * costImp + train.getTrainTime() * travelTimeImp + 1 * travelHopImp;
		}

		//Find minimal cost and mode of transportation If both flight and train are available to travel from source to connected or destination cities
		if (flight != null && train != null) {
			if (flightTotalWeight < trainTotalWeight) {
				minWeight = flightTotalWeight;
				this.minCostTraMode = "fly";
			} else {
				minWeight = trainTotalWeight;
				this.minCostTraMode = "train";
			}
		}

		//Select mode of transportation if flight or train either of them are not available
		if (flight == null) {
			this.minCostTraMode = "train";
			return trainTotalWeight;
		} else if (train == null) {
			this.minCostTraMode = "fly";
			return flightTotalWeight;
		}

		return minWeight;
	}

	/*Method to decide optimal route between the list of cities based on the 
	 * optimal cost(weight)
	 *unvisitedCities  List of cities whose weight has been calculated 
	 *return Name of the cities whose optimal path is selected  
	 * */
	private String getMinRouteCity(List<String> unvisitedCities) {

		String minDisCity = null;
		// Assign default value to infinity
		int lowerWeight = Integer.MAX_VALUE;

		/*
		 * Iterate through list of cities and compare the calculated cost(weight) of the
		 * cities in each iteration and find cities with minimal cost
		 */
		for (int index = 0; index < unvisitedCities.size(); index++) {

			City city = listOfCities.get(unvisitedCities.get(index));
			int cityWeight = city.getCalculatedWeight();
			if (lowerWeight > cityWeight) {
				lowerWeight = cityWeight;
				minDisCity = city.getCityName();
			}
		}

		return minDisCity;
	}





}
