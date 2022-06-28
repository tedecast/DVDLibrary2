/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryassessment;

import com.sg.dvdlibraryassessment.controller.DVDLibraryController;
import com.sg.dvdlibraryassessment.dao.DVDLibraryDao;
import com.sg.dvdlibraryassessment.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibraryassessment.ui.DVDLibraryView;
import com.sg.dvdlibraryassessment.ui.UserIO;
import com.sg.dvdlibraryassessment.ui.UserIOConsoleImpl;

/**
 *
 * @author Teresa
 */
public class App {
    
    public static void main(String[] args) {
        UserIO myIO = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIO);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        controller.run();
    }
}
