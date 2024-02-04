/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.woshmato.service;

import java.util.ArrayList;
import nl.scalda.woshmato.datalayer.DAOPerson;
import nl.scalda.woshmato.models.Person;
import nl.scalda.woshmato.models.Student;

/**
 *
 * @author jeroenvanloon
 */
public class PersonService {
        
    private static PersonService instance;
    
    private PersonService(){
        
    }
    
    public void deletePerson(int id){
        DAOPerson.getInstance().deletePerson(id);
    }
    
    public void createStudent(Student s){
        DAOPerson.getInstance().createStudent(s);
    }
    //create person methide maken
    
    public ArrayList<Person> loadPersons(){
        return DAOPerson.getInstance().loadAllPersons();
    }
    
    public static PersonService getInstance() {
        if (instance == null) {
            instance = new PersonService();
        }
        return instance;
    }
}
