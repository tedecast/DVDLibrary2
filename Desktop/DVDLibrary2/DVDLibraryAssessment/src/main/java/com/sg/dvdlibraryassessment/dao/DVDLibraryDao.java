/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryassessment.dao;

import com.sg.dvdlibraryassessment.dto.DVD;
import java.util.List;

/**
 *
 * @author Teresa
 */
public interface DVDLibraryDao {
    
    List<DVD> getAllDVDs();

    DVD getDVD(String dvdID); // dvd info? -- refer to example on github
    
    DVD addDVD(String dvdID, DVD dvd);
    
    DVD removeDVD(String dvdID);
    
    DVD editDVD(String dvdID, DVD dvd, String prevDVDTitle);
    
    
}
// private String title;
//    private String releaseDate;
//    private String mpaaRating;
//    private String directorsName;
//    private String studioName;
//    private String userRating;
//    private String dvdID;
//
//io.print("Main Menu");
//            io.print("1. Display DVD List"); //Display All DVDs using ID
//            io.print("2. View DVD Information");
//            io.print("3. Find DVDs");
//            io.print("4. Add DVD");
//            io.print("5. Remove DVD");
//            io.print("6. Edit DVD");
//            io.print("7. Exit");