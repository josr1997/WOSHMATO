/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.woshmato.service;

import java.util.ArrayList;
import nl.scalda.woshmato.datalayer.DAOPerson;
import nl.scalda.woshmato.models.Teacher;

/**
 *
 * @author jeroenvanloon
 */
public class TeachersService {
    private static TeachersService instance;
    
    private TeachersService(){
        
    }
//    
//    public String deleteTeacher(int id){
//       return DAOPerson.getInstance().deleteTeacher(id);
//    }
    
    public void createTeacher(Teacher t){
        DAOPerson.getInstance().createTeacher(t);
    }
    public ArrayList<Teacher> loadTeacher(){
        return DAOPerson.getInstance().loadTeachers();
    }
    
    public static TeachersService getInstance() {
        if (instance == null) {
            instance = new TeachersService();
        }
        return instance;
    }
}
