package com.org.java.com.org.java.models;

import java.util.List;

/**
 * Created by Bhargav on 1/22/2018.
 */
public class Layout {

    private int totalNumberOfSeats;

    @Override
    public String toString() {
        return "Layout{" +
                "totalNumberOfSeats=" + totalNumberOfSeats +
                ", Availability=" + Availability +
                ", sections=" + sections +
                '}';
    }

    private int Availability;

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    private List<Section> sections;


    public int getTotalNumberOfSeats() {
        return totalNumberOfSeats;

    }

    public void setTotalNumberOfSeats(int totalNumberOfSeats) {
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    public int getAvailability() {
        return Availability;
    }

    public void setAvailability(int availability) {
        Availability = availability;
    }

}
