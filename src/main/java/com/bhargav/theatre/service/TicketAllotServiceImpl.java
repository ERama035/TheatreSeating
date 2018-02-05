package com.bhargav.theatre.service;

import com.bhargav.theatre.dao.TheaterDAO;
import com.bhargav.theatre.models.TicketsAllocated;
import com.bhargav.theatre.models.Section;
import com.bhargav.theatre.views.TheatreSeatingView;


import static com.bhargav.theatre.service.TicketRequestProcessingServiceImpl.requestList;

/**
 * Service class for alloting the seats
 */
public class TicketAllotServiceImpl implements TicketAllotService {

    TheaterDAO theaterDAO = new TheaterDAO();
    
    /**
     * Method for allocating the seats
     */
    public void allot() {

       
        for (TicketsAllocated ticketsAllocated : requestList) {
            if (ticketsAllocated.isFlag()) continue;

            
            /**
             * Checking if the request can be handled or not
             */
            
            if (ticketsAllocated.getTickets() > theaterDAO.getTotalNumberOfSeats()) {
                ticketsAllocated.setMessage("Sorry, we can't handle your party");
                ticketsAllocated.setFlag(true);
            }
            /**
             * Alloting seats if the requested seats is equal to the number of seats available in a section
             */
            for (int i = 0; i < theaterDAO.getSections().size(); i++) {
                Section section = theaterDAO.getSections().get(i);
                if (section.getUnoccupiedSeats() == ticketsAllocated.getTickets()) {
                    allotSeats(ticketsAllocated, section);
                    break;


                } else if (section.getUnoccupiedSeats() > ticketsAllocated.getTickets()) {
                    int requestNo = findComplementRequest(section.getUnoccupiedSeats() - ticketsAllocated.getTickets(), i);
                    if (requestNo != -1) {
                        allotSeats(ticketsAllocated, section);
                        allotSeats(requestList.get(requestNo), section);
                        break;

                    } else {
                        int sectionNo = findSection(ticketsAllocated.getTickets());
                        if (sectionNo >= 0) {
                            allotSeats(ticketsAllocated, theaterDAO.getSections().get(sectionNo));
                            break;

                        } else {
                            allotSeats(ticketsAllocated, section);

                            break;
                        }

                    }
                }

            }


            if (!ticketsAllocated.isFlag()) {

                ticketsAllocated.setMessage("Call to split party.");
                ticketsAllocated.setFlag(true);

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
        for (int i = 0; i < theaterDAO.getSections().size(); i++) {
            Section section = theaterDAO.getSections().get(i);
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

            TicketsAllocated request = requestList.get(i);

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
     * @param ticketsAllocated object
     * @param section        object
     */
    private void allotSeats(TicketsAllocated ticketsAllocated, Section section) {

        int unoccupied = section.getUnoccupiedSeats();

        unoccupied -= ticketsAllocated.getTickets();

//        int totalSeats = theaterDAO.getAvailability();
//
//        totalSeats -= ticketsAllocated.getTickets();

        section.setUnoccupiedSeats(unoccupied);
        ticketsAllocated.setFlag(true);
        ticketsAllocated.setRowSelected(section.getRowNumber());
        ticketsAllocated.setSectionSelected(section.getSectionNumber());



    }

}



