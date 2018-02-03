package com.bhargav.theatre.errors;

/**
 * Custom exception class for TicketRequestProcessingServiceImpl.
 */
public class RequestProcessingException extends Exception {

    public RequestProcessingException(String message) {

        super(message);
    }


}
