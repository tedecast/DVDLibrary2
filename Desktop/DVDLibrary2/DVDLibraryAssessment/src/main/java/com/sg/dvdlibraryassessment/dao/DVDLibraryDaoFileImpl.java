/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryassessment.dao;

import com.sg.dvdlibraryassessment.dto.DVD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Teresa
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    
    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public List<DVD> getAllDVDs() {
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String dvdID) {
        return dvds.get(dvdID);
    }

    @Override
    public DVD addDVD(String dvdID, DVD dvd) {
        DVD prevDVD = dvds.put(dvdID, dvd);
        return prevDVD;
    }

    @Override
    public DVD removeDVD(String dvdID) {
        DVD removedDVD = dvds.remove(dvdID);
        return removedDVD;
    }

    @Override
    public DVD editDVD(String dvdID, DVD dvd, String prevDVDTitle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public DVD changeTitle(String dvdID, String title) {
        //loadLibrary();
        DVD dvdToEdit = dvds.get(dvdID);
        dvdToEdit.setTitle(title);
        //writeLibrary();
        return dvdToEdit;
    }
    
    @Override
    public DVD changeReleaseDate(String dvdID, String releaseDate) {
        //loadLibrary();
        DVD dvdToEdit = dvds.get(dvdID);
        dvdToEdit.setReleaseDate(releaseDate);
        //writeLibrary();
        return dvdToEdit;
    }

    @Override
    public DVD changeMpaaRating(String dvdID, String mpaaRating) {
       // loadLibrary();
        DVD dvdToEdit = dvds.get(dvdID);
        dvdToEdit.setMpaaRating(mpaaRating);
       // writeLibrary();
        return dvdToEdit;
    }

    @Override
    public DVD changeDirectorName(String dvdID, String directorName) {
        //loadLibrary();
        DVD dvdToEdit = dvds.get(dvdID);
        dvdToEdit.setDirectorsName(directorName);
        //writeLibrary();
        return dvdToEdit;
    }

    @Override
    public DVD changeUserRating(String dvdID, String userRating) {
       //loadLibrary();
        DVD dvdToEdit = dvds.get(dvdID);
        dvdToEdit.setUserRating(userRating);
        //writeLibrary();
        return dvdToEdit;
    }

    @Override
    public DVD changeStudioName(String dvdID, String studioName)  {
        //loadLibrary();
        DVD dvdToEdit = dvds.get(dvdID);
        dvdToEdit.setStudioName(studioName);
        //writeLibrary();
        return dvdToEdit;
    }
    
}
