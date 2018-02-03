package com.org.java.com.org.java.views;

import com.org.java.com.org.java.models.PreSaleRequest;

import static com.org.java.com.org.java.service.RequestProcessing.requestList;

/**
 * View class for Theatre seating
 */
public class TheatreSeatingView {

    /**
     * Method for printing the output
     */
    public void printRequests() {

        System.out.println("Seats Distribution :\n");
        for (PreSaleRequest preSaleRequest : requestList) {

            System.out.println(preSaleRequest.toString());
        }
    }


}
