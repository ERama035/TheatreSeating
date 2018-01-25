package com.org.java.com.org.java.models;

/**
 * Created by Bhargav on 1/22/2018.
 *
 * Pojo class for pre sale requests
 */
public class PreSaleRequest {

    private String name;
    private int sectionSelected;
    private int rowSelected;
    private boolean flag;
    private int tickets;
    private String message;

    /**
     * Getters and Setters
     * @return
     */
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSectionSelected() {
        return sectionSelected;
    }

    public void setSectionSelected(int sectionSelected) {
        this.sectionSelected = sectionSelected;
    }

    public int getRowSelected() {
        return rowSelected;
    }

    public void setRowSelected(int rowSelected) {
        this.rowSelected = rowSelected;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String output(){

        String output = null;

        if(message==null){

            output = name+" "+"Row"+rowSelected+" "+"Section"+ sectionSelected;

        }
        else{

            output = name+" "+message;
        }



        return output;
    }

}
