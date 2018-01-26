package com.org.java.com.org.java.service;

import com.org.java.com.org.java.models.Layout;
import com.org.java.com.org.java.models.Section;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bhargav on 1/23/2018.
 *
 * Service class for theatre layout
 */
public class LayoutService {

    public static Layout theatreLayout = new Layout();

    /**
     *Method to store the theatre layout in list
     */

    public void getLayout(String tempLayout) throws NumberFormatException{

        Section sectionInRows = null;
        List<Section> sectionList = new ArrayList<Section>();
        int theatreCapacity = 0;
        int count = 0;

        /**
         *Storing the rows in array
         */
        String[] rows = tempLayout.split(System.lineSeparator());
        String[] sections = null;
        for(int i=0;i<rows.length;i++){
            /**
             *Spliting the rows into sections
             */
            sections = rows[i].split(" ");
            for(int j=0;j<sections.length;j++){
                try{
                    count = Integer.valueOf(sections[j]);

                }catch(NumberFormatException e){

                    throw new NumberFormatException(sections[j]+" is invalid section capacity");
                }

                /**
                 *Calculating the theatre capacity
                 */
                theatreCapacity = theatreCapacity + count;

                sectionInRows=new Section();

                /**
                 *Defining the current section values
                 */
                sectionInRows.setRowNumber(i+1);
                sectionInRows.setSectionNumber(j+1);
                sectionInRows.setNumberOfSeats(count);
                sectionInRows.setUnoccupiedSeats(count);

                /**
                 *Adding the current section to the sections list
                 */
                sectionList.add(sectionInRows);
            }

        }

        /**
         *Defining the Theatre layout values
         */
        theatreLayout.setTotalNumberOfSeats(theatreCapacity);
        theatreLayout.setAvailability(theatreCapacity);
        theatreLayout.setSections(sectionList);




    }


}
