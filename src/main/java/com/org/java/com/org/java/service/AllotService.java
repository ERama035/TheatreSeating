package com.org.java.com.org.java.service;

import com.org.java.com.org.java.models.PreSaleRequest;
import com.org.java.com.org.java.models.Section;
import static com.org.java.com.org.java.service.LayoutService.theatreLayout;
import static com.org.java.com.org.java.service.RequestProcessing.requestList;

/**
 * Created by Bhargav on 1/23/2018.
 */
public class AllotService {

    // Method for allocating the seats
    public void allot() {

        for (PreSaleRequest preSaleRequest : requestList) {
            if(preSaleRequest.isFlag())continue;
            if(preSaleRequest.getTickets()>theatreLayout.getTotalNumberOfSeats()){
                preSaleRequest.setMessage("can't handle request");
                preSaleRequest.setFlag(true);
            }
            for (int i = 0; i < theatreLayout.getSections().size(); i++) {
                Section section=theatreLayout.getSections().get(i);
                if(section.getUnoccupiedSeats()==preSaleRequest.getTickets()){
                    allotSeats(preSaleRequest,section);
                    break;

                }
                else if(section.getUnoccupiedSeats()>preSaleRequest.getTickets()){
                    int requestNo = findComplementRequest(section.getUnoccupiedSeats() - preSaleRequest.getTickets(), i);
                    if(requestNo != -1){
                        allotSeats(preSaleRequest,section);
                        allotSeats(requestList.get(requestNo),section);
                        break;
                    }else{
                        int sectionNo = findSection(preSaleRequest.getTickets());
                        if(sectionNo>=0){
                            allotSeats(preSaleRequest,theatreLayout.getSections().get(sectionNo));
                            break;
                        }else{
                            allotSeats(preSaleRequest,section);
                            break;
                        }

                    }
                }

            }
            if(!preSaleRequest.isFlag()){

                preSaleRequest.setMessage("Split party");
                preSaleRequest.setFlag(true);

            }

        }
        printRequests();
    }

    private int findSection(int tickets) {
        for(int i=0;i<theatreLayout.getSections().size();i++){
            Section section=theatreLayout.getSections().get(i);
            if(section.getUnoccupiedSeats()==tickets) {
                return i;
            }
        }
        return -1;
    }

    private int findComplementRequest(int quantity, int currentIndex) {
        int requestNo = -1;

        for(int i=currentIndex+1 ; i<requestList.size() ; i++){

            PreSaleRequest request = requestList.get(i);

            if(!request.isFlag() && request.getTickets() == quantity){

                requestNo = i;
                break;

            }

        }

        return requestNo;
    }

    private void printRequests() {

        System.out.println("Seats Distribution");
            for(PreSaleRequest preSaleRequest: requestList){
            System.out.println(preSaleRequest.output());
        }
    }

    private void allotSeats(PreSaleRequest preSaleRequest, Section section) {
        int unoccupied = section.getUnoccupiedSeats();
        //deduct available seats in a section
        unoccupied -= preSaleRequest.getTickets();
        //deduct total available seats
        int totalSeats = theatreLayout.getAvailability();
        totalSeats -= preSaleRequest.getTickets();
        theatreLayout.setAvailability(totalSeats);
        section.setUnoccupiedSeats(unoccupied);
        preSaleRequest.setFlag(true);
        preSaleRequest.setRowSelected(section.getRowNumber());
        preSaleRequest.setSectionSelected(section.getSectionNumber());
    }

}



