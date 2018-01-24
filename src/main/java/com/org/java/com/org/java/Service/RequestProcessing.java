package com.org.java.com.org.java.Service;

import com.org.java.com.org.java.models.PreSaleRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bhargav on 1/23/2018.
 */
public class RequestProcessing {

    public static List<PreSaleRequest> requestList = new ArrayList<>();

    public void getPreSaleRequests(String requests) throws NumberFormatException{

        PreSaleRequest preSaleRequest = null;

        String[] tempRequest = requests.split(System.lineSeparator());                                  //Splitting multiple requests and saving the pre-sale requests in an array

        for(String requestEntry: tempRequest){

            String[] requestArray = requestEntry.split(" ");                                    //Splitting the single request
            preSaleRequest=new PreSaleRequest();
            preSaleRequest.setName(requestArray[0]);                                                  //Saving the person's name

            try{
                preSaleRequest.setTickets(Integer.valueOf(requestArray[1]));                          //Saving the requested tickets

            }catch (NumberFormatException e){

                throw new NumberFormatException(requestArray[1]+" is invalid pre-sale request");
            }
            preSaleRequest.setFlag(false);

            requestList.add(preSaleRequest);

        }
            for(int i=0;i<requestList.size();i++){
                System.out.println(requestList.get(i).getName()+","+requestList.get(i).getTickets());
            }

        }




}
