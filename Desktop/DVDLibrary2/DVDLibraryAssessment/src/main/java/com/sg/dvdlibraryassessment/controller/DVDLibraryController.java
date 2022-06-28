/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryassessment.controller;

import com.sg.dvdlibraryassessment.ui.DVDLibraryView;
import com.sg.dvdlibraryassessment.ui.UserIO;
import com.sg.dvdlibraryassessment.ui.UserIOConsoleImpl;

/**
 *
 * @author Teresa
 */
public class DVDLibraryController {
    
    private DVDLibraryView view = new DVDLibraryView();
    private UserIO io = new UserIOConsoleImpl();
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        while(keepGoing) {
            
            menuSelection = getMenuSelection();
            
            switch (menuSelection){
                case 1: 
                    io.print("DISPLAY DVD LIST");
                    break;
                case 2: 
                    io.print("VIEW DVD INFORMATION");
                    break;
                case 3:
                    io.print("FIND DVDS");
                    break;
                case 4:
                    io.print("ADD DVDS");
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
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
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
