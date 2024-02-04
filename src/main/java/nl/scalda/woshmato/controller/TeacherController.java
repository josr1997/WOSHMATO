/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.woshmato.controller;

import java.util.ArrayList;
import nl.scalda.woshmato.datalayer.DAOPerson;
import nl.scalda.woshmato.models.Teacher;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Glenn
 */
public class TeacherController extends ActionSupport{
    private String name;
    private int id;
    private int person_id;//moet nog gedeclareerd worden
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
       

   public String execute() throws Exception {
      return "createTeacher";
   }
   
   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }
    
    
    public String addTeacherToDB(String teacherName, String insertion, String lastname, String email, String abbrevation, double FTE){
        try{
            Teacher t = new Teacher(id, teacherName, insertion, lastname, email, abbrevation, FTE,person_id);
            DAOPerson.getInstance().createTeacher(t);
            return "<h1>Teacher " + teacherName + " is toegevoegd aan de Database</h1>";
        }catch(Exception e){
        return "<h1>FAILED with message" + e.getMessage() + "</h1>"; 
        }
    }
    
    public void getAllTeachers(){
        teachers = DAOPerson.getInstance().loadTeachers();
    }
    
    public String deleteTeacher(){
        return "teacherdeleted";
    }
   
   
}
