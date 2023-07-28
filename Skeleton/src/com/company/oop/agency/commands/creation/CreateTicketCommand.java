package com.company.oop.agency.commands.creation;

import com.company.oop.agency.commands.CommandsConstants;
import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.models.TicketImpl;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;
import com.company.oop.agency.utils.ParsingHelpers;
import com.company.oop.agency.utils.ValidationHelper;

import java.util.List;

public class CreateTicketCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;

    private final AgencyRepository agencyRepository;

    private int journeyId;
    private Journey journey;
    private double administrativeCost;

    public CreateTicketCommand(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, 2);
        parseParameters(parameters);

        Ticket createdTicket = agencyRepository.createTicket(journey, administrativeCost);

        return String.format(CommandsConstants.TICKET_CREATED_MESSAGE, createdTicket.getId());
    }

    private void parseParameters(List<String> parameters) {
        this.journeyId = ParsingHelpers.tryParseInteger(parameters.get(0), "journey id");

        this.administrativeCost = ParsingHelpers.tryParseDouble(parameters.get(1), "cost");
        this.journey = agencyRepository.findElementById(agencyRepository.getJourneys(), journeyId);
    }
}