package com.org.java.com.org.java.service;

import com.org.java.com.org.java.models.PreSaleRequest;
import com.org.java.com.org.java.models.Section;
import com.org.java.com.org.java.views.TheatreSeatingView;

import static com.org.java.com.org.java.service.LayoutService.theatreLayout;
import static com.org.java.com.org.java.service.RequestProcessing.requestList;

/**
 * Service class for alloting the seats
 */
public class AllotService {

    /**
     * Method for allocating the seats
     */
    public void allot() {

        for (PreSaleRequest preSaleRequest : requestList) {
            if (preSaleRequest.isFlag()) continue;

            /**
             * Checking if the request can be handled or not
             */
            if (preSaleRequest.getTickets() > theatreLayout.getTotalNumberOfSeats()) {
                preSaleRequest.setMessage("Sorry, we can't handle your party");
                preSaleRequest.setFlag(true);
            }
            /**
             * Alloting seats if the requested seats is equal to the number of seats available in a section
             */
            for (int i = 0; i < theatreLayout.getSections().size(); i++) {
                Section section = theatreLayout.getSections().get(i);
                if (section.getUnoccupiedSeats() == preSaleRequest.getTickets()) {
                    allotSeats(preSaleRequest, section);
                    break;


                } else if (section.getUnoccupiedSeats() > preSaleRequest.getTickets()) {
                    int requestNo = findComplementRequest(section.getUnoccupiedSeats() - preSaleRequest.getTickets(), i);
                    if (requestNo != -1) {
                        allotSeats(preSaleRequest, section);
                        allotSeats(requestList.get(requestNo), section);
                        break;

                    } else {
                        int sectionNo = findSection(preSaleRequest.getTickets());
                        if (sectionNo >= 0) {
                            allotSeats(preSaleRequest, theatreLayout.getSections().get(sectionNo));
                            break;

                        } else {
                            allotSeats(preSaleRequest, section);

                            break;
                        }

                    }
                }

            }


            if (!preSaleRequest.isFlag()) {

                preSaleRequest.setMessage("Call to split party.");
                preSaleRequest.setFlag(true);

            }

        }
        TheatreSeatingView theatreSeatingView = new TheatreSeatingView();
        theatreSeatingView.printRequests();

    }

    /**
     * Finds sections by availability
     *
     * @param tickets requested
     * @return section number
     */
    private int findSection(int tickets) {
        for (int i = 0; i < theatreLayout.getSections().size(); i++) {
            Section section = theatreLayout.getSections().get(i);
            if (section.getUnoccupiedSeats() == tickets) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Finds the request which can be allocated in the section which is partially filled and be fully occupied
     *
     * @param quantity     tickets required by complement request
     * @param currentIndex current request number
     * @return the request number
     */
    private int findComplementRequest(int quantity, int currentIndex) {
        int requestNo = -1;

        for (int i = currentIndex + 1; i < requestList.size(); i++) {

            PreSaleRequest request = requestList.get(i);

            if (!request.isFlag() && request.getTickets() == quantity) {

                requestNo = i;
                break;

            }

        }

        return requestNo;
    }


    /**
     * Method for allot seats for a request to a specific section
     *
     * @param preSaleRequest object
     * @param section        object
     */
    private void allotSeats(PreSaleRequest preSaleRequest, Section section) {

        int unoccupied = section.getUnoccupiedSeats();

        /**
         *deduct available seats in a section
         */
        unoccupied -= preSaleRequest.getTickets();

        /**
         *deduct total available seats
         */
        int totalSeats = theatreLayout.getAvailability();

        totalSeats -= preSaleRequest.getTickets();
        theatreLayout.setAvailability(totalSeats);
        section.setUnoccupiedSeats(unoccupied);
        preSaleRequest.setFlag(true);
        preSaleRequest.setRowSelected(section.getRowNumber());
        preSaleRequest.setSectionSelected(section.getSectionNumber());

    }

}



