package com.bhargav.theatre.service;

import com.bhargav.theatre.errors.LayoutServiceException;

/**
 * Create a layout that represents the rows and sections of seats available in a theater
 */
public interface LayoutService {

    void createLayout(String tempLayout) throws LayoutServiceException;
}
