package com.org.java.com.org.java.Service;

import com.org.java.com.org.java.models.Layout;
import com.org.java.com.org.java.models.Section;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bhargav on 1/23/2018.
 */
public class LayoutService {

    public static Layout theatreLayout = new Layout();

    public void getLayout(String tempLayout) throws NumberFormatException{                     //Getting the user input of the models layout and saving it.

        Section sectionInRows = null;
        List<Section> sectionList = new ArrayList<Section>();
        int theatreCapacity = 0;
        int count = 0;

        String[] rows = tempLayout.split(System.lineSeparator());       //Storing the rows in array
        String[] sections = null;
        for(int i=0;i<rows.length;i++){
            sections = rows[i].split(" ");                       //Spliting the rows into sections
            for(int j=0;j<sections.length;j++){
                try{
                    count = Integer.valueOf(sections[j]);

                }catch(NumberFormatException e){

                    throw new NumberFormatException(sections[j]+" is invalid section capacity");
                }
                theatreCapacity = theatreCapacity + count;              //Calculating the models capacity

                sectionInRows=new Section();
                sectionInRows.setRowNumber(i+1);                        //Defining the current section values
                sectionInRows.setSectionNumber(j+1);
                sectionInRows.setNumberOfSeats(count);
                sectionInRows.setUnoccupiedSeats(count);

                sectionList.add(sectionInRows);                         //Adding the current section to the sections list
            }

        }

        theatreLayout.setTotalNumberOfSeats(theatreCapacity);           //Defining the Theatre layout values
        theatreLayout.setAvailability(theatreCapacity);
        theatreLayout.setSections(sectionList);

        System.out.println("layout" + theatreLayout);


    }


}
