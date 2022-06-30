/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.dto.Student;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author Teresa
 */
public class ClassRosterController {
    
    private ClassRosterView view; //= new ClassRosterView();
    private ClassRosterDao dao; //= new ClassRosterDaoFileImpl();
    private UserIO io = new UserIOConsoleImpl();
   
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view){
        this.dao = dao;
        this.view = view;
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createStudent()throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }
    
     private void listStudents()throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }
     
    private void viewStudent()throws ClassRosterPersistenceException{
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }
    
    private void removeStudent()throws ClassRosterPersistenceException{
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = dao.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }
    
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        // modified, adding try-catch
        try {
            while (keepGoing) {
            
            menuSelection = getMenuSelection();
            
            // Commented out because we made a method through ClassRosterView
//            io.print("Main Menu");
//            io.print("1. List Student IDs");
//            io.print("2. Create New Student");
//            io.print("3. View a Student");
//            io.print("4. Remove a Student");
//            io.print("5. Exit");
            
//            menuSelection = io.readInt("Please select from the" + " above choices.", 1, 5);
            
            switch(menuSelection){
                case 1: 
//                    io.print("LIST STUDENTS");
                    listStudents();
                    break;
                case 2:
//                    io.print("CREATE STUDENT");
                    createStudent();
                    break;
                case 3:
//                    io.print("VIEW STUDENT");
                    viewStudent();
                    break;
                case 4:
//                    io.print("REMOVE STUDENT");
                    removeStudent();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
//                    io.print("UNKNOWN COMMAND");    
                    unknownCommand();
            }
        }
//      io.print("GOOD BYE");
        exitMessage();
    } catch (ClassRosterPersistenceException e) {
        view.displayErrorMessage(e.getMessage());
    }
   
    }
}