package com.bhargav.theatre.models;

/**
 * Pojo class for Section class
 */
public class Section {

    private int rowNumber;
    private int sectionNumber;
    private int numberOfSeats;
    private int unoccupiedSeats;

    /**
     * Getters and Setters for Section class
     */

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getUnoccupiedSeats() {
        return unoccupiedSeats;
    }

    public void setUnoccupiedSeats(int unoccupiedSeats) {
        this.unoccupiedSeats = unoccupiedSeats;
    }

}
