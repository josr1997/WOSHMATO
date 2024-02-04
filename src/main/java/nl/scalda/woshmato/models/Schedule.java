/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.woshmato.models;


import java.util.TreeSet; 

/**
 *
 * @author jari
 */
public class Schedule {
    
    private TreeSet<TeachingDay> teachingDays;
    private int hourDurationInMinutes;
    
    public Schedule()
    {
        teachingDays = new TreeSet<>();
    }
    
    public void addDay(TeachingDay m){
        boolean add = teachingDays.add(m);
    }
    
    public TreeSet getDays(){
        
        return teachingDays;
    }
    
    public TreeSet<TeachingDay> getTeachingDays() {
        return teachingDays;
    }

    public void setTeachingDays(TreeSet<TeachingDay> teachingDays) {
        this.teachingDays = teachingDays;
    }
  
     public int calculateTeacherHours(TeachingDay t1, TeachingDay t2, TeachingDay t3, TeachingDay t4, TeachingDay t5, Teacher p) {
     int total = t1.calculateHoursForTeacher(p) + t2.calculateHoursForTeacher( p) + t3.calculateHoursForTeacher(p) + t4.calculateHoursForTeacher(p) + t5.calculateHoursForTeacher(p);
     
     return total;
       }
   
}
