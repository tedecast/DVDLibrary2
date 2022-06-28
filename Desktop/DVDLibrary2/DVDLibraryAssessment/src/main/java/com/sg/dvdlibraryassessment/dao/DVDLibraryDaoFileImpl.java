/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryassessment.dao;

import com.sg.dvdlibraryassessment.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
    
    
    public static final String LIBRARY_Fule = "library.txt";
    public static final String DELIMITER = "::";
    
    private DVD unmarshallDVD(String dvdAsText){
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String dvdID = dvdTokens[0];
        
        DVD dvdFromFile = new DVD(dvdID);
        
        dvdFromFile.setTitle(dvdTokens[1]);
        dvdFromFile.setReleaseDate(dvdTokens[2]);
        dvdFromFile.setMpaaRating(dvdTokens[3]);
        dvdFromFile.setDirectorsName(dvdTokens[4]);
        dvdFromFile.setStudioName(dvdTokens[5]);
        dvdFromFile.setUserRating(dvdTokens[5]);
        
        return dvdFromFile;
    }
    
//  private void loadLibrary() throws DVDLibraryDaoException {
//        Scanner scanner;
//        
//        try {
//            scanner = new Scanner(
//            new BufferedReader(
//                new FileReader(LIBRARY_FILE)));
//        } catch (FileNotFoundException e) {
//            throw new DVDLibraryDaoException(
//                "-_- Could not load library data into memory.", e);
//        }
//        String currentLine;
//        DVD currentDVD;
//        
//        while(scanner.hasNextLine()){
//            currentLine = scanner.nextLine();
//            currentDVD = unmarshallDVD(currentLine);
//            
//            dvds.put(currentDVD.getTitle(), currentDVD);
//        }
//        scanner.close();
//    }
//    
//    private String marshallDVD(DVD aDVD){
//        String dvdAsText = aDVD.getTitle() + DELIMITER;
//        
//        dvdAsText += aDVD.getReleaseDate() + DELIMITER;
//        dvdAsText += aDVD.getMpaaRating() + DELIMITER;
//        dvdAsText += aDVD.getDirectorsName() + DELIMITER;
//        dvdAsText += aDVD.getStudioName() + DELIMITER;
//        dvdAsText += aDVD.getUserRating() + DELIMITER;
//        
//        return dvdAsText;
//    }
//    
//    private void writeLibrary() throws DVDLibraryDaoException {
//        PrintWriter out;
//        
//        try {
//            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
//        } catch (IOException e){
//            throw new DVDLibraryDaoException(
//                "Could not save DVD data.", e);   
//        }
//        String dvdAsText;
//        List<DVD> dvdList = this.getAllDVDs();
//        for (DVD currentDVD : dvdList) {
//            dvdAsText = marshallDVD(currentDVD);
//            out.println(dvdAsText);
//            out.flush();
//        }
//        out.close();
//    }
}
