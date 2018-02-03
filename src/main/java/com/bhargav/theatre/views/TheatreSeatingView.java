package com.bhargav.theatre.views;

import com.bhargav.theatre.models.TicketsAllocated;
import com.bhargav.theatre.service.TicketRequestProcessingServiceImpl;

/**
 * View class for Theatre seating
 */
public class TheatreSeatingView {

    /**
     * Method for printing the output
     */
    public void printRequests() {

        System.out.println("Seats Distribution :\n");
        for (TicketsAllocated ticketsAllocated : TicketRequestProcessingServiceImpl.requestList) {

            System.out.println(ticketsAllocated.toString());
        }
    }


}
