package com.bhargav.theatre.controllers;

import com.bhargav.theatre.service.*;

import java.util.Scanner;

/**
 * Controller class
 */
public class TheatreSeatingController {

    /**
     * Method which takes input from console
     */
    public void theatreSeatingController() {

        boolean layoutComplete = false;
        StringBuilder layoutEntry = new StringBuilder();
        StringBuilder preSaleRequests = new StringBuilder();

        System.out.println("Please enter theater layout followed by pre-sale requests and then enter 'end' ");

        Scanner inputs = new Scanner(System.in);

        String entry;

        while ((entry = inputs.nextLine()) != (null) && (!entry.equals("end"))) {

            if (entry.length() == 0) {

                layoutComplete = true;
                continue;
            }

            if (!layoutComplete) {

                layoutEntry.append(entry + System.lineSeparator());
            } else {


                preSaleRequests.append(entry + System.lineSeparator());
            }
        }


        inputs.close();

        LayoutServiceImpl layoutServiceImpl = new LayoutServiceImpl();
        TicketRequestProcessingService processing = new TicketRequestProcessingServiceImpl();
        TicketAllotService ticketAllotService = new TicketAllotServiceImpl();

        try {
            layoutServiceImpl.createLayout(layoutEntry.toString());

            processing.setPreSaleRequests(preSaleRequests.toString());

            ticketAllotService.allot();

        } catch (NumberFormatException e) {

            System.out.println(e.getMessage());
        } catch (Exception e) {

            e.printStackTrace();
        }
    }


}

