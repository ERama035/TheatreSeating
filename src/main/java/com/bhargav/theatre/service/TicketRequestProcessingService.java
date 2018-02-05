package com.bhargav.theatre.service;

import com.bhargav.theatre.errors.RequestProcessingException;

/**
 * Service Used to set the presale requests received
 */
public interface TicketRequestProcessingService {

    void setPreSaleRequests(String requests) throws RequestProcessingException;
}
