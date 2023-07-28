package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;

public class AirplaneImpl extends VehicleImpl implements Airplane {

    private boolean hasFreeFood;
    private static final VehicleType type = VehicleType.AIR;


    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id, passengerCapacity, pricePerKilometer, type);
        this.hasFreeFood = hasFreeFood;
    }


    public boolean hasFreeFood(){
        return hasFreeFood;
    }

    @Override
    public String getAsString() {
        String print =  super.getAsString();
        print += String.format("Has free food: %b\n", hasFreeFood());
        return print;
    }
}