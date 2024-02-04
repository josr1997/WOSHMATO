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
public class TeachingDay implements Comparable<TeachingDay> {

    private DayNames name;
    private TreeSet<TeachingHour> teachinghours;

    public TeachingDay(DayNames name) {
        this.name = name;
        teachinghours = new TreeSet<>();
    }

    public boolean addHour(TeachingHour m) {
        return teachinghours.add(m);
    }
    
    public boolean removeHour(TeachingHour m)
    {
        return teachinghours.remove(m);
    }
    

    public TreeSet getHours() {

        return teachinghours;
    }

    @Override
    public int compareTo(TeachingDay t) {

        return name.compareTo(t.name);
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return name.toString();
    }

    public DayNames getName() {
        return name;
    }

    public void setName(DayNames name) {
        this.name = name;
    }

    public int calculateHoursForTeacher(Teacher t) {
        int hours = 0;
        for (TeachingHour th : teachinghours) {
            if (th.getTeachers().contains(t)) {
                hours++;
            }
        }
        return hours;
    }

}
