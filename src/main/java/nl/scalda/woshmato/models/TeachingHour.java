/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.woshmato.models;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author jari
 */
public class TeachingHour implements Comparable<TeachingHour> {

    private int number;
    private String description;
    private TreeSet<Teacher> teachers = new TreeSet<>();

    public TeachingHour(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "TeachingHour{" + "number=" + number + ", description=" + description + "teachers=" + teachers +'}';
    }
  
    
    @Override
    public int compareTo(TeachingHour t) {
        return t.getNumber() - number;
    }
    
      public boolean addTeacher(Teacher t){
       return teachers.add(t);
    }
      
      public boolean removeTeacher(Teacher t)
      {
          return teachers.remove(t);
      }
    
    public TreeSet getTeachers(){
        
        return teachers;
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
