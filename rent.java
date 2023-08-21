import java.util.*;
public class poojitha {

	public static void main(String[] args) {
		RideBookingSystem rideBookingSystem = new RideBookingSystem();

        // Adding drivers
        rideBookingSystem.addDriver(new Driver("A", "Sedan", 4.0, 500, ""));
        rideBookingSystem.addDriver(new Driver("B", "HatchBack", 4.3, 1000, ""));
        rideBookingSystem.addDriver(new Driver("C", "5 Seater", 4.8, 200, ""));
        rideBookingSystem.addDriver(new Driver("D", "Sedan", 4.1, 700, ""));
        rideBookingSystem.addDriver(new Driver("E", "HatchBack", 4.7, 430, ""));

       
        // Example 2
        int customerDistance2 = 20;
        String carRequested2 = "HatchBack";
        String destination2 = "";
        String result2 = rideBookingSystem.findNearestAvailableDriver(customerDistance2, carRequested2, destination2);
        System.out.println(result2);

        // Extension Example
        int customerDistance3 = 60;
        String carRequested3 = "5 Seater";
        String destination3 = "Delhi";
        String result3 = rideBookingSystem.findNearestAvailableDriver(customerDistance3, carRequested3, destination3);
        System.out.println(result3);

	}

}
public class Driver {
	 private String name;
	    private String carModel;
	    private double rating;
	    private int distanceFromCustomer;
	    private String preferredDestination;

	    public Driver(String name, String carModel, double rating, int distanceFromCustomer, String preferredDestination) {
	        this.name = name;
	        this.carModel = carModel;
	        this.rating = rating;
	        this.distanceFromCustomer = distanceFromCustomer;
	        this.preferredDestination = preferredDestination;
}
	    public String getName() {
	        return name;
	    }

	    public String getCarModel() {
	        return carModel;
	    }

	    public double getRating() {
	        return rating;
	    }

	    public int getDistanceFromCustomer() {
	        return distanceFromCustomer;
	    }

	    public String getPreferredDestination() {
	        return preferredDestination;
	    }
}

import java.util.*;
public class RideBookingSystem {
	private List<Driver> drivers;

    public RideBookingSystem() {
        drivers = new ArrayList<>();
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public String findNearestAvailableDriver(int customerDistance, String carRequested, String destination) {
        Driver nearestDriver = null;
        for (Driver driver : drivers) {
            if (driver.getRating() < 4 || !driver.getCarModel().equals(carRequested)) {
                continue;
            }
            if (nearestDriver == null || driver.getDistanceFromCustomer() < nearestDriver.getDistanceFromCustomer()) {
                nearestDriver = driver;
            }
        }
            if (nearestDriver.getPreferredDestination().equals(destination)) {
                return "Driver " + nearestDriver.getName() + " will take you to the destination.\n" +
                        "Your charge will be Rs " + (customerDistance * 8);
            }
        
        return "No available driver found.";
    }

}
