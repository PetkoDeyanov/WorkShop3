package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;

public class TrainImpl extends VehicleImpl implements Train {

    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    private static final String INVALID_CARTS = "A train cannot have less than 1 cart or more than 15 carts.";

    private static final String INVALID_TRAIN_PASSENGER_CAPACITY = "A train cannot have less than 30 passengers or more than 150 passengers.";
    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.LAND);
        setCarts(carts);
    }



    @Override
    protected void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_TRAIN_PASSENGER_CAPACITY);
        }
        super.setPassengerCapacity(passengerCapacity);
    }

    private void setCarts(int carts) {
        if (carts < CARTS_MIN_VALUE || carts > CARTS_MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_CARTS);
        }
        this.carts = carts;
    }


    @Override
    public int getCarts() {
        return this.carts;
    }

    @Override
    public String getAsString() {
        String print = super.getAsString();
        print += String.format("Carts amount: %d", getCarts());
        print += System.lineSeparator();
        return print;
    }

}