package com.org.java.com.org.java.service;

import com.org.java.com.org.java.models.PreSaleRequest;
import com.org.java.com.org.java.models.Section;
import static com.org.java.com.org.java.service.LayoutService.theatreLayout;
import static com.org.java.com.org.java.service.RequestProcessing.requestList;

/**
 * Created by Bhargav on 1/23/2018.
 */
public class AllotService {

    /** Method for allocating the seats**/
    public void allot() {

        for(PreSaleRequest preSaleRequest: requestList){
            for(Section section:theatreLayout.getSections()) {
                int unoccupied=section.getUnoccupiedSeats();
                if(unoccupied>=preSaleRequest.getTickets()){
                    allotSeats(preSaleRequest,section);
                }
            }
            if(!preSaleRequest.isFlag()){
                if(preSaleRequest.getTickets()>theatreLayout.getAvailability()) {
                    preSaleRequest.setFlag(true);
                    preSaleRequest.setMessage("can't handle request");
                }
                else
                    if(isReAssign(preSaleRequest)){
                        preSaleRequest.setFlag(true);
                        preSaleRequest.setMessage("Split Party");
                    }


            }
        }
    }

    private void allotSeats(PreSaleRequest preSaleRequest, Section section) {
        int unoccupied=section.getUnoccupiedSeats();
        //deduct available seats in a section
        unoccupied-=preSaleRequest.getTickets();
        //deduct total available seats
        int totalSeats=theatreLayout.getAvailability();
        totalSeats-=preSaleRequest.getTickets();
        section.setUnoccupiedSeats(unoccupied);
        preSaleRequest.setFlag(true);
        preSaleRequest.setRowSelected(section.getRowNumber());
        preSaleRequest.setSectionSelected(section.getSectionNumber());
    }

    /** Method for re-assigning seats**/
    private boolean isReAssign(PreSaleRequest preSaleRequest) {

        boolean result;
        for(int i=0;i<theatreLayout.getSections().size();i++){
            int s=theatreLayout.getSections().get(i).getNumberOfSeats();
            int a=theatreLayout.getSections().get(i).getUnoccupiedSeats();
            if(s>=preSaleRequest.getTickets()) {
                for (int j = 0; j < theatreLayout.getSections().size(); j++) {
                    if (theatreLayout.getSections().get(j).getUnoccupiedSeats()>=(s-a)){
                      //  List<PreSaleRequest> requestsAlloted=getRequestsAllotedToSection(theatreLayout.getSections().get(i));
                        boolean flag=true;
//                        for(PreSaleRequest request:requestsAlloted) {
//                            removeAllots(request,theatreLayout.getSections().get(i));
//                            allotSeats(request,theatreLayout.getSections().get(j));
//                            allotSeats(preSaleRequest,theatreLayout.getSections().get(i));
                        }

                    }

                }
            }
        return false;
        }

    }




