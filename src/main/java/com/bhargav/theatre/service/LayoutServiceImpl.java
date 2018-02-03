package com.bhargav.theatre.service;

import com.bhargav.theatre.errors.LayoutServiceException;
import com.bhargav.theatre.models.Section;
import com.bhargav.theatre.dao.TheaterDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for theatre layout
 */
public class LayoutServiceImpl implements LayoutService {

    public TheaterDAO theatreTheaterDAO = new TheaterDAO();

    /**
     * Method to store the theatre layout in list
     */

    @Override
    public void createLayout(String tempLayout) throws LayoutServiceException {

        Section sectionInRows = null;
        List<Section> sectionList = new ArrayList<Section>();
        int theatreCapacity = 0;
        int count = 0;

        /**
         *Storing the rows in array
         */
        String[] rows = tempLayout.split(System.lineSeparator());
        String[] sections = null;
        for (int i = 0; i < rows.length; i++) {
            /**
             *Spliting the rows into sections
             */
            sections = rows[i].split(" ");
            for (int j = 0; j < sections.length; j++) {
                try {
                    count = Integer.valueOf(sections[j]);

                } catch (NumberFormatException e) {

                    throw new NumberFormatException(sections[j] + " is invalid section capacity");
                }

                if ((Integer.valueOf(sections[j])) < 0) {

                    throw new LayoutServiceException("Entered negative value for section");
                }

                /**
                 *Calculating the theatre capacity
                 */
                theatreCapacity = theatreCapacity + count;

                sectionInRows = new Section();

                /**
                 *Defining the current section values
                 */
                sectionInRows.setRowNumber(i + 1);
                sectionInRows.setSectionNumber(j + 1);
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
        theatreTheaterDAO.setSections(sectionList);


    }


}
