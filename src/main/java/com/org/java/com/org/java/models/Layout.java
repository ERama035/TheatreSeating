package com.org.java.com.org.java.models;

import java.util.List;

/**
 * Created by Bhargav on 1/22/2018.
 *
 * Pojo class for theatre layout
 */
public class Layout {

    private int totalNumberOfSeats;

    private int Availability;

    private List<Section> sections;

    /**
     * Getters and setters
     * @return
     */

    public int getTotalNumberOfSeats() { return totalNumberOfSeats; }

    public void setTotalNumberOfSeats(int totalNumberOfSeats) {
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    public int getAvailability() {
        return Availability;
    }

    public void setAvailability(int availability) {
        Availability = availability;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

}
