/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author Teresa
 */
public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {

    ClassRosterDao dao;
    
    public ClassRosterServiceLayerImpl(ClassRosterDao dao) {
        this.dao = dao;
    }
    
    @Override
    public void createStudent(Student student) throws 
            ClassRosterDuplicateIdException, 
            ClassRosterDataValidationException, 
            ClassRosterPersistenceException {
//        throw new UnsupportedOperationException("Not supported yet.");
        /* First check to see if there is already a student
           associated with the given student's id
           If so, we're all done here-
           throw a ClassRosterDuplicateIdException
        */
        if(dao.getStudent(student.getStudentId()) != null) {
            throw new ClassRosterDuplicateIdException(
                    "ERROR: Could not create student. Student Id "
                    + student.getStudentId()
                    + " already exists");
        }
        /* Now validate all the fields on the given Student object.
           This method will throw an
           exception if any of the validation rules are violated.
           validateStudentDate(student);
        */
        
        /* We passed all our business rules checks so go ahead
           and persist the Student object
        */
        dao.addStudent(student.getStudentId(), student);
    }

    @Override
    public List<Student> getAllStudents() throws 
            ClassRosterPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getStudent(String studentId) throws 
            ClassRosterPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student removeStudent(String studentID) 
            throws ClassRosterPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void validateStudentData(Student student) throws
            ClassRosterDataValidationException {
        if (student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0) {
            
            throw new ClassRosterDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }
}
