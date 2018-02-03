package com.org.java.com.org.java.controllers;

import com.org.java.com.org.java.service.AllotService;
import com.org.java.com.org.java.service.LayoutService;
import com.org.java.com.org.java.service.RequestProcessing;

import java.util.Scanner;

/**
 * Controller class
 */
public class ModelViewController {

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

        LayoutService layoutService = new LayoutService();
        RequestProcessing processing = new RequestProcessing();
        AllotService allotService = new AllotService();

        try {
            layoutService.getLayout(layoutEntry.toString());

            processing.getPreSaleRequests(preSaleRequests.toString());

            allotService.allot();

        } catch (NumberFormatException e) {

            System.out.println(e.getMessage());
        } catch (Exception e) {

            e.printStackTrace();
        }
    }


}

