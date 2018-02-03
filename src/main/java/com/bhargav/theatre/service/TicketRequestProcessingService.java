package com.bhargav.theatre.service;

import com.bhargav.theatre.errors.RequestProcessingException;

/**
 * Created by Bhargav on 2/3/2018.
 */
public interface TicketRequestProcessingService {
    void setPreSaleRequests(String requests) throws RequestProcessingException;
}
