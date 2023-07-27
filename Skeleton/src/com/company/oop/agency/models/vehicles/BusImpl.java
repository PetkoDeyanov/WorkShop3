package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;

public class BusImpl extends VehicleImpl implements Bus {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;

    private static final String INVALID_PASSENGER_CAPACITY = "A train cannot have less than 30 passengers or more than 150 passengers.";

    private static final VehicleType type = VehicleType.LAND;

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, pricePerKilometer, type);
    }


    @Override
    protected void setPassengerCapacity(int passengerCapacity) {
        if(passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE){
            throw new IllegalArgumentException(INVALID_PASSENGER_CAPACITY);
        }

        super.setPassengerCapacity(passengerCapacity);
    }

    @Override
    public String getAsString() {
        return super.getAsString();
    }
}