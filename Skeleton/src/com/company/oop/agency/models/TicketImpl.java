package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;
import com.company.oop.agency.utils.ValidationHelper;

public class TicketImpl implements Ticket {

    private int Id;
    private Journey journey;
    private double administrativeCost;


    public TicketImpl(int id, Journey journey, double costs) {
        setId(id);
        setJourney(journey);
        setCost(costs);
    }

    private void setId(int id) {
        this.Id = id;
    }
    private void setJourney(Journey journey){
        this.journey = journey;
    }

    private void setCost(double cost){
        if(cost < 0)
            throw new InvalidUserInputException(String.format("Value of '%s' must be a positive number. Actual value: %.2f.", "costs", cost));
        this.administrativeCost = cost;

    }


    @Override
    public int getId() {
        return this.Id;
    }

    @Override //TODO return as readonly or new
    public Journey getJourney() {
        return this.journey;

    }

    @Override
    public double calculatePrice() {
       return this.journey.calculateTravelCosts() * administrativeCost;
    }

    @Override
    public double getAdministrativeCosts() {
        return administrativeCost;
    }

    @Override
    public String getAsString() {
        String result = """
                Ticket ----
                Destination: %s
                Price: %.2f
                """;
        return String.format(result, this.journey.getDestination(), calculatePrice());
    }
}
