/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryassessment.ui;

/**
 *
 * @author Teresa
 */
public class DVDLibraryView {
    
    private UserIO io = new UserIOConsoleImpl();
    
    public int printMenuAndGetSelection() {
            io.print("Main Menu");
            io.print("1. Display DVD List"); //Display All DVDs using ID
            io.print("2. View DVD Information");
            io.print("3. Find DVDs");
            io.print("4. Add DVD");
            io.print("5. Remove DVD");
            io.print("6. Edit DVD");
            io.print("7. Exit");
            
            return io.readInt("Please select from the above choices.", 1, 7);
    }
    
    public int printEditMenuAndGetSelection() {
        io.print("=== Edit DVD ===");
        io.print("1. Title");
        io.print("2. Release Date");
        io.print("3. MPAA rating");
        io.print("4. Director's name");
        io.print("5. Studio");
        io.print("6. Comments");
        io.print("7. Edit All");
        io.print("8. Exit");
            
        return io.readInt("Please select from the above choices.", 1, 8);
    }
}
