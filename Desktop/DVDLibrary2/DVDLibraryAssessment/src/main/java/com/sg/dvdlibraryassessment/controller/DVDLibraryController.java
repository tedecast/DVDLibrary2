/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryassessment.controller;

import com.sg.dvdlibraryassessment.dao.DVDLibraryDao;
import com.sg.dvdlibraryassessment.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibraryassessment.dto.DVD;
import com.sg.dvdlibraryassessment.ui.DVDLibraryView;
import com.sg.dvdlibraryassessment.ui.UserIO;
import com.sg.dvdlibraryassessment.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author Teresa
 */
public class DVDLibraryController {
    
    private DVDLibraryView view = new DVDLibraryView();
    private UserIO io = new UserIOConsoleImpl();
    private DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
    
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void listDVDs(){
        view.displayDVDListBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }
    
    private void viewDVDInfo(){
        view.displayDVDInfoBanner();
        String dvdID = view.getDVDIDChoice();
        DVD dvd = dao.getDVD(dvdID);
        view.displayDVDInfo(dvd);
    }
    private void addDVD() {
        view.displayAddDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getDVDID(), newDVD);
        view.displayDVDAddedSuccessBanner();
    }
    
   
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        while(keepGoing) {
            
            menuSelection = getMenuSelection();
            
            switch (menuSelection){
                case 1: 
                    listDVDs();
                    break;
                case 2: 
                    viewDVDInfo();
                    break;
                case 3:
                    io.print("FIND DVDS");
                    break;
                case 4:
                    addDVD();
                    break;
                case 5:
                    io.print("REMOVE DVDS");
                    break;
                case 6:
                    io.print("EDIT DVDS");
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");  
            }
        }
        io.print("GOOD BYE");
    }
    
  
    public void edit(){
        boolean keepEditing = true;
        int editMenuSelection = 0;
        while(keepEditing){
            
            editMenuSelection = getEditMenuSelection();
            
            switch(editMenuSelection){
                case 1: 
                    io.print("EDIT TITLE");
                    break;
                case 2:
                    io.print("EDIT RELEASE DATE");
                    break;
                case 3:
                    io.print("EDIT MPAA RATING");
                    break;
                case 4:
                    io.print("EDIT DIRECTOR");
                    break;
                case 5:
                    io.print("EDIT STUDIO");
                    break;
                case 6:
                    io.print("EDIT COMMENTS");
                    break;
                case 7:
                    io.print("EDIT ALL");
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
                            
            }
        }
        io.print("BACK TO MAIN MENU");
    }
    private int getEditMenuSelection(){
        return view.printEditMenuAndGetSelection();
    }
}
