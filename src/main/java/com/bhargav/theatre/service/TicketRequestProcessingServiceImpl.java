package com.bhargav.theatre.service;


import com.bhargav.theatre.models.TicketsAllocated;
import com.bhargav.theatre.errors.RequestProcessingException;

import java.util.ArrayList;
import java.util.List;

/**
 * This class processes the input of requests and stores them in a List
 */
public class TicketRequestProcessingServiceImpl implements TicketRequestProcessingService {


    public static List<TicketsAllocated> requestList = new ArrayList<>();


    @Override
    public void setPreSaleRequests(String requests) throws RequestProcessingException {

        TicketsAllocated ticketsAllocated = null;

        /**
         * Splitting multiple requests and saving the pre-sale requests in an array
         */
        String[] tempRequest = requests.split(System.lineSeparator());

        for (String requestEntry : tempRequest) {

            /**
             * Splitting the single request
             */
            String[] requestArray = requestEntry.split(" ");
            ticketsAllocated = new TicketsAllocated();

            /**
             * Saving the person's name
             */
            ticketsAllocated.setName(requestArray[0]);

            try {
                /**
                 * Saving the requested tickets
                 */

                ticketsAllocated.setTickets(Integer.valueOf(requestArray[1]));


            } catch (NumberFormatException e) {

                throw new NumberFormatException(requestArray[1] + " is invalid pre-sale request");
            }

            if (Integer.valueOf(requestArray[1]) < 0) {

                throw new RequestProcessingException("Entered negative value for request");

            }
            ticketsAllocated.setFlag(false);

            /**
             *Storing the request into a list
             */

            requestList.add(ticketsAllocated);

        }

    }


}
