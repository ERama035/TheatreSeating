package com.bhargav.theatre.dao;

import com.bhargav.theatre.models.Section;

import java.util.List;

/**
 * DAO for theatre layout
 */
public class TheaterDAO {

    private int totalNumberOfSeats;

    private int availability;

    private static List<Section> sections;

    /**
     * Getters and setters
     */

    public int getTotalNumberOfSeats() {

        int totalSeats = 0;
        for ( Section section : sections) {
            totalSeats += section.getNumberOfSeats();
        }

        return totalSeats;
    }

    public int getAvailability() {

        int totalSeats = 0;
        for ( Section section : sections) {
            totalSeats += section.getUnoccupiedSeats();
        }

        return totalSeats;

    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

}
