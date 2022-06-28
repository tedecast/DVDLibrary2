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
    
    private DVDLibraryView view;
    private UserIO io = new UserIOConsoleImpl();
    private DVDLibraryDao dao;
    
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view){
        this.dao = dao;
        this.view = view;
    }
    
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
    
    private void removeDVD() {
       view.displayRemoveDVDBanner();
       String dvdID = view.getDVDIDChoice();
       DVD removedDVD = dao.removeDVD(dvdID);
       view.displayRemoveResult(removedDVD);
    }
   
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
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
                    removeDVD();
                    break;
                case 6:
                    editDVD();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }
    
    private void editTitle(String dvdID){
        String newTitle = view.getTitle();
        dao.changeTitle(dvdID, newTitle);
//        view.displayEditResult();
   }
    
    private void editReleaseDate(String dvdID){
        String newReleaseDate = view.getReleaseDate();
        dao.changeReleaseDate(dvdID, newReleaseDate);
//        view.displayKeepEditingBanner();
    }
    private void editMpaaRating(String dvdID) {
        String newMpaaRating = view.getMpaaRating();
        dao.changeMpaaRating(dvdID, newMpaaRating);
//        view.displayKeepEditingBanner();
    }
    private void editDirectorsName(String dvdID) {
        String newDirectorName = view.getDirectorName();
        dao.changeDirectorName(dvdID, newDirectorName);
//        view.displayKeepEditingBanner();
    }
    private void editUserRating(String dvdID) {
        String newUserRating = view.getUserRating();
        dao.changeUserRating(dvdID, newUserRating);
//        view.displayKeepEditingBanner();
    }
    private void editStudioName(String dvdID) {
        String newStudioName = view.getStudioName();
        dao.changeStudioName(dvdID, newStudioName);
//        view.displayKeepEditingBanner();
    }
    
  
    public void editDVD(){
        String dvdID = view.getDVDIDChoice();
        DVD dvdEdit = dao.getDVD(dvdID);
        boolean keepEditing = true;
        int editMenuSelection = 0;
        while(keepEditing){
            
            editMenuSelection = getEditMenuSelection();
            if(dvdEdit != null){
                view.getDoesNotExist();
                }else{   
                switch(editMenuSelection){
                    case 1: 
                        editTitle(dvdID);
                        break;
                    case 2:
                        editReleaseDate(dvdID);
                        break;
                    case 3:
                        editMpaaRating(dvdID);
                        break;
                    case 4:
                        editDirectorsName(dvdID);
                        break;
                    case 5:
                        editStudioName(dvdID);
                        break;
                    case 6:
                        editUserRating(dvdID);
                        break;
                    case 7:
                        editTitle(dvdID);
                        editReleaseDate(dvdID);
                        editMpaaRating(dvdID);
                        editDirectorsName(dvdID);
                        editStudioName(dvdID);
                        editUserRating(dvdID);
                        break;
                    default:
                        unknownCommand();
                }
            }
            io.print("BACK TO MAIN MENU");
        }
    }
    private int getEditMenuSelection(){
        return view.printEditMenuAndGetSelection();
    }
}
