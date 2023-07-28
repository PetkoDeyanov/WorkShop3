package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public class JourneyImpl implements Journey {

    public static final int START_LOCATION_MIN_LENGTH = 5;
    public static final int START_LOCATION_MAX_LENGTH = 25;
    public static final int DESTINATION_MIN_LENGTH = 5;
    public static final int DESTINATION_MAX_LENGTH = 25;
    public static final int DISTANCE_MIN_VALUE = 5;
    public static final int DISTANCE_MAX_VALUE = 5000;

    private static final String INVALID_START_LOCATION = "The StartingLocation's length cannot be less than 5 or more than 25 symbols long.";
    private static final String INVALID_DESTINATION = "The Destination's length cannot be less than 5 or more than 25 symbols long.";
    private static final String INVALID_DISTANCE = "The Distance cannot be less than 5 or more than 5000 kilometers.";

    private String startLocation;
    private String destination;

    private int distance;
    private Vehicle vehicle;
    private int Id;
    public JourneyImpl(int id, String startLocation, String destination, int distance, Vehicle vehicle) {
        setId(id);
        setStartLocation(startLocation);
        setDestination(destination);
        setDistance(distance);
        setVehicle(vehicle);
    }

    private void setId(int id) {
        this.Id = id;
    }

    private void setStartLocation(String startLocation) {
        ValidationHelper.validateStringLength(startLocation, START_LOCATION_MIN_LENGTH, START_LOCATION_MAX_LENGTH, INVALID_START_LOCATION);
        this.startLocation = startLocation;
    }

    private void setDestination(String destination) {
        ValidationHelper.validateStringLength(destination, DESTINATION_MIN_LENGTH, DESTINATION_MAX_LENGTH, INVALID_DESTINATION);
        this.destination = destination;
    }

    private void setDistance(int distance) {
        ValidationHelper.validateValueInRange(distance, DISTANCE_MIN_VALUE, DISTANCE_MAX_VALUE, INVALID_DISTANCE);
        this.distance = distance;
    }

    private void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    @Override
    public Vehicle getVehicle() {
        return this.vehicle;
    }

    @Override
    public String getStartLocation() {
        return this.startLocation;
    }

    @Override
    public String getDestination() {
        return this.destination;
    }

    @Override
    public double calculateTravelCosts() {
       double cost;
       cost = this.vehicle.getPricePerKilometer() * getDistance();
        return cost;
    }

    @Override
    public int getId() {
        return this.Id;
    }

    @Override
    public String getAsString() {
       String print = "Journey ----\n" +
               "Start location: %s\n"+
               "Destination: %s\n"+
               "Distance: %d\n" +
                "Vehicle type: %s\n" +
                "Travel costs: %.2f\n";
    return String.format(print, getStartLocation(), getDestination(), getDistance(), getVehicle().getType(), calculateTravelCosts());
    }
    /*
    Journey ----
Start location: {startLocation}
Destination: {destination}
Distance: {distance}
Vehicle type: {vehicleType}
Travel costs: {costs}
     */
}