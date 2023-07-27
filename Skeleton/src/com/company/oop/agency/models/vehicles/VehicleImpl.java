package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.contracts.Identifiable;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public abstract class VehicleImpl implements Vehicle {


    public static final double PRICE_MIN_VALUE = 0.1d;
    public static final double PRICE_MAX_VALUE = 2.5d;

    private static final int PASSENGER_MAX = 800;

    private static final int PASSENGER_MIN = 1;

    private static final String INVALID_CAPACITY = "A vehicle with less than 1 passenger or more than 800 passengers cannot exist!";
    private static final String INVALID_PRICE = "A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist!";
    private int Id;
    private int passengerCapacity;
    private double pricePerKilometer;
    private VehicleType vehicleType;

    //TODO to look at vehicle type in the ctor
    public VehicleImpl(int Id, int passengerCapacity, double pricePerKilometer, VehicleType type) {
        setId(Id);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        setVehicleType(type);
    }

    private void setId(int id) {
        this.Id = id;
    }

    public int getId() {
        return this.Id;
    }

    protected void setPassengerCapacity(int passengerCapacity) {
        ValidationHelper.validateValueInRange(passengerCapacity, PASSENGER_MIN, PASSENGER_MAX, INVALID_CAPACITY);

        this.passengerCapacity = passengerCapacity;
    }

    private void setPricePerKilometer(double price) {
        ValidationHelper.validateValueInRange(price, PRICE_MIN_VALUE, PRICE_MAX_VALUE, INVALID_PRICE);
        this.pricePerKilometer = price;
    }

    private void setVehicleType(VehicleType type) {
        this.vehicleType = type;
    }


    @Override
    public VehicleType getType() {
        return vehicleType;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    /*
    Train ----
    Passenger capacity: {capacity}
    Price per kilometer: {pricePerKilometer}
    Vehicle type: {vehicleType}
    Carts amount: {carts}
     */
    //TODO check the line separator
    private String getVehicleName() {
        String name = this.getClass().getSimpleName();
        name = name.substring(0, name.length() - 4);
        return name;
    }

    @Override
    public String getAsString() {
        String print = String.format("%s ----\n", getVehicleName()) +
                String.format("Passenger capacity: %d\n", getPassengerCapacity()) +
                String.format("Price per kilometer: %.2f\n", getPricePerKilometer()) +
                String.format("Vehicle type: %s\n", getType());
        return print;

    }
}
