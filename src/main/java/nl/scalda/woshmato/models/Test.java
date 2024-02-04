/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.woshmato.models;

import java.util.Iterator;
import java.util.TreeSet;


/**
 *
 * @author jari
 */
public class Test {

    public static void main(String[] args) {
          String NewLine = System.getProperty("line.separator");
        //new Schedule + Teachingdays
        Schedule mySchedule = new Schedule();
        TeachingDay m = new TeachingDay(DayNames.MONDAY);
        TeachingDay t = new TeachingDay(DayNames.THUESDAY);
        TeachingDay w = new TeachingDay(DayNames.WEDNESDAY);
        TeachingDay th = new TeachingDay(DayNames.THURSDAY);
        TeachingDay f = new TeachingDay(DayNames.FRIDAY);

        //Creating Teachinghours per day
        //Monday
        TeachingHour firstm = new TeachingHour(1);
        TeachingHour secondm = new TeachingHour(2);
        TeachingHour thirdm = new TeachingHour(3);
        TeachingHour fourthm = new TeachingHour(4);
        TeachingHour fifthm = new TeachingHour(5);
        TeachingHour sixthm = new TeachingHour(6);
        TeachingHour seventhm = new TeachingHour(7);
        TeachingHour eightm = new TeachingHour(8);
        
        //Tuesday
        TeachingHour firstt = new TeachingHour(1);
        TeachingHour secondt = new TeachingHour(2);
        TeachingHour thirdt = new TeachingHour(3);
        TeachingHour fourtht = new TeachingHour(4);
        TeachingHour fiftht = new TeachingHour(5);
        TeachingHour sixtht = new TeachingHour(6);
        TeachingHour seventht = new TeachingHour(7);
        TeachingHour eightt = new TeachingHour(8);
        //Wednesday
        TeachingHour firstw = new TeachingHour(1);
        TeachingHour secondw = new TeachingHour(2);
        TeachingHour thirdw = new TeachingHour(3);
        TeachingHour fourthw = new TeachingHour(4);
        TeachingHour fifthw = new TeachingHour(5);
        TeachingHour sixthw = new TeachingHour(6);
        TeachingHour seventhw = new TeachingHour(7);
        TeachingHour eightw = new TeachingHour(8);
        //Thursday
        TeachingHour firstth = new TeachingHour(1);
        TeachingHour secondth = new TeachingHour(2);
        TeachingHour thirdth = new TeachingHour(3);
        TeachingHour fourthth = new TeachingHour(4);
        TeachingHour fifthth = new TeachingHour(5);
        TeachingHour sixthth = new TeachingHour(6);
        TeachingHour seventhth = new TeachingHour(7);
        TeachingHour eightth = new TeachingHour(8);
        //Friday
        TeachingHour firstf = new TeachingHour(1);
        TeachingHour secondf = new TeachingHour(2);
        TeachingHour thirdf = new TeachingHour(3);
        TeachingHour fourthf = new TeachingHour(4);
        TeachingHour fifthf = new TeachingHour(5);
        TeachingHour sixthf = new TeachingHour(6);
        TeachingHour seventhf = new TeachingHour(7);
        TeachingHour eightf = new TeachingHour(8);
        
        //Creating new teachers
        Teacher t1 = new Teacher("Jari", "Badr", "Scholten", "jari.scholten@gmail.com", "J.S", 10);
        Teacher t2 = new Teacher("Jeffrey", "Chubby", "vdWelle", "jeffrey.pussydestroyer@hotmail.com", "jvdw", 69);
        Teacher t3 = new Teacher("wouter", "de maten naaier", "naaier", "wouter.kodde@iknaaiallesaanelkaar.naaieritus", "W.K", 10);
        Teacher t4 = new Teacher("Smeagle", "the smeagle", "Smeagle", "smeagle@smeagle.smeagle", "smeagle", 69);
        Teacher t5 = new Teacher("Gino", "Tittyfucker", "Palo", "gino@pornhub.com", "J.S", 10);
        Teacher t6 = new Teacher("Brammetje", "Het Vliegtuig", "van Hueule", "bram@klm.com", "B.V.H", 69);
        
        //Adding days to schedule
        mySchedule.addDay(m);
        mySchedule.addDay(t);
        mySchedule.addDay(w);
        mySchedule.addDay(th);
        mySchedule.addDay(f);
        
        //Adding teachinghours per day
        m.addHour(secondm);
        m.addHour(firstm);
        m.addHour(thirdm);
        m.addHour(fourthm);
        m.addHour(fifthm);
        m.addHour(sixthm);
        m.addHour(seventhm);
        m.addHour(eightm);

        t.addHour(fiftht);
        t.addHour(sixtht);
        t.addHour(seventht);
        t.addHour(eightt);

        w.addHour(firstw);
        w.addHour(sixthw);
        w.addHour(seventhw);
        w.addHour(eightw);

        th.addHour(secondth);
        th.addHour(sixthth);
        th.addHour(seventhth);
        th.addHour(eightth);

        f.addHour(thirdf);
        f.addHour(sixthf);
        f.addHour(seventhf);
        f.addHour(eightf);
              
        //Adding a teacher to each hour
        firstm.addTeacher(t2);
        secondm.addTeacher(t1);
        thirdm.addTeacher(t6);
        fourthm.addTeacher(t5);
        fifthm.addTeacher(t1);
        sixthm.addTeacher(t1);
        seventhm.addTeacher(t1);
        eightm.addTeacher(t2);
        
        fiftht.addTeacher(t2);
        sixtht.addTeacher(t3);
        seventht.addTeacher(t3);
        eightt.addTeacher(t3);
        
        firstw.addTeacher(t4);
        sixthw.addTeacher(t4);
        seventhw.addTeacher(t4);
        eightw.addTeacher(t4);
        
        secondth.addTeacher(t4);
        sixthth.addTeacher(t4);
        seventhth.addTeacher(t4);
        eightth.addTeacher(t1);
        
        thirdf.addTeacher(t2);
        sixthf.addTeacher(t6);
        seventhf.addTeacher(t6);
        eightf.addTeacher(t6);
        
        //Calculating how many hours a teacher teaches per day
        System.out.println("Aantal uur dat Jari les geeft op maandag: " + m.calculateHoursForTeacher(t1));
        System.out.println("Aantal uur dat Jari les geeft op dinsdag: " + t.calculateHoursForTeacher(t1));
        System.out.println("Aantal uur dat Jari les geeft op woensdag: " + w.calculateHoursForTeacher(t1));
        System.out.println("Aantal uur dat Jari les geeft op donderdag: " + th.calculateHoursForTeacher(t1));
        System.out.println("Aantal uur dat Jari les geeft op vrijdag: " + f.calculateHoursForTeacher(t1));
        System.out.println();
        
        System.out.println("Aantal uur dat Jeffrey les geeft op maandag: " + m.calculateHoursForTeacher(t2));
        System.out.println("Aantal uur dat Jeffrey les geeft op dinsdag: " + t.calculateHoursForTeacher(t2));
        System.out.println("Aantal uur dat Jeffrey les geeft op woensdag: " + w.calculateHoursForTeacher(t2));
        System.out.println("Aantal uur dat Jeffrey les geeft op donderdag: " + th.calculateHoursForTeacher(t2));
        System.out.println("Aantal uur dat Jeffrey les geeft op vrijdag: " + f.calculateHoursForTeacher(t2));
        System.out.println();
        
        System.out.println("Aantal uur dat Wouter les geeft op maandag: " + m.calculateHoursForTeacher(t3));
        System.out.println("Aantal uur dat Wouter les geeft op dinsdag: " + t.calculateHoursForTeacher(t3));
        System.out.println("Aantal uur dat Wouter les geeft op woensdag: " + w.calculateHoursForTeacher(t3));
        System.out.println("Aantal uur dat Wouter les geeft op donderdag: " + th.calculateHoursForTeacher(t3));
        System.out.println("Aantal uur dat Wouter les geeft op vrijdag: " + f.calculateHoursForTeacher(t3));
        System.out.println();
        
        System.out.println("Aantal uur dat Smeagle les geeft op maandag: " + m.calculateHoursForTeacher(t4));
        System.out.println("Aantal uur dat Smeagle les geeft op dinsdag: " + t.calculateHoursForTeacher(t4));
        System.out.println("Aantal uur dat Smeagle les geeft op woensdag: " + w.calculateHoursForTeacher(t4));
        System.out.println("Aantal uur dat Smeagle les geeft op donderdag: " + th.calculateHoursForTeacher(t4));
        System.out.println("Aantal uur dat Smeagle les geeft op vrijdag: " + f.calculateHoursForTeacher(t4));
        System.out.println();
        
        System.out.println("Aantal uur dat Gino les geeft op maandag: " + m.calculateHoursForTeacher(t5));
        System.out.println("Aantal uur dat Gino les geeft op dinsdag: " + t.calculateHoursForTeacher(t5));
        System.out.println("Aantal uur dat Gino les geeft op woensdag: " + w.calculateHoursForTeacher(t5));
        System.out.println("Aantal uur dat Gino les geeft op donderdag: " + th.calculateHoursForTeacher(t5));
        System.out.println("Aantal uur dat Gino les geeft op vrijdag: " + f.calculateHoursForTeacher(t5));
        System.out.println();
        
        System.out.println("Aantal uur dat Bram les geeft op maandag: " + m.calculateHoursForTeacher(t6));
        System.out.println("Aantal uur dat Bram les geeft op dinsdag: " + t.calculateHoursForTeacher(t6));
        System.out.println("Aantal uur dat Bram les geeft op woensdag: " + w.calculateHoursForTeacher(t6));
        System.out.println("Aantal uur dat Bram les geeft op donderdag: " + th.calculateHoursForTeacher(t6));
        System.out.println("Aantal uur dat Bram les geeft op vrijdag: " + f.calculateHoursForTeacher(t6));
        System.out.println();
        
        //Calculates how many hours a teacher teaches per week
        System.out.println("Jari geeft : " + mySchedule.calculateTeacherHours(m, t, w, th, f, t1) + " uur les");
        System.out.println("Jeffrey geeft : " + mySchedule.calculateTeacherHours(m, t, w, th, f, t2) + " uur les");
        System.out.println("Wouter geeft : " + mySchedule.calculateTeacherHours(m, t, w, th, f, t3) + " uur les");
        System.out.println("Smeagle geeft : " + mySchedule.calculateTeacherHours(m, t, w, th, f, t4) + " uur les");
        System.out.println("Gino geeft : " + mySchedule.calculateTeacherHours(m, t, w, th, f, t5) + " uur les");
        System.out.println("Bram geeft : " + mySchedule.calculateTeacherHours(m, t, w, th, f, t6) + " uur les");
        System.out.println();
        
        //Looping through treeset and printing all the days
        TreeSet<TeachingDay> teachingDays = mySchedule.getDays();
        Iterator iterator;
        iterator = teachingDays.iterator();

        // displaying the Tree set data
        System.out.print("Alle dagen in de week: "  + NewLine);
        while (iterator.hasNext()) {
            System.out.print(iterator.next().toString() + " " + NewLine);
        }

        TreeSet<TeachingHour> teachinghoursm = m.getHours();
        TreeSet<TeachingHour> teachinghoursd = t.getHours();
        TreeSet<TeachingHour> teachinghoursw = w.getHours();
        TreeSet<TeachingHour> teachinghoursdo = th.getHours();
        TreeSet<TeachingHour> teachinghoursv = f.getHours();
        
        //looping through the hours per day
        Iterator iterator1;
        iterator1 = teachinghoursm.iterator();
        // displaying the Tree set data
        System.out.print("Maandag: " + NewLine);
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next().toString() + " " + NewLine);
        }

        Iterator iterator2;
        iterator2 = teachinghoursd.iterator();
        // displaying the Tree set data
        System.out.print("Dinsdag: " + NewLine);
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next().toString() + " " + NewLine);
        }

        Iterator iterator3;
        iterator3 = teachinghoursw.iterator();
        // displaying the Tree set data
        System.out.print("Woensdag: " + NewLine);
        while (iterator3.hasNext()) {
            System.out.print(iterator3.next().toString() + " " + NewLine);
        }

        Iterator iterator4;
        iterator4 = teachinghoursdo.iterator();
        // displaying the Tree set data
        System.out.print("Donderdag: " + NewLine);
        while (iterator4.hasNext()) {
            System.out.print(iterator4.next().toString() + " " + NewLine);
        }

        Iterator iterator5;
        iterator5 = teachinghoursv.iterator();
        // displaying the Tree set data
        System.out.print("Vrijdag: " + NewLine);
        while (iterator5.hasNext()) {
            System.out.print(iterator5.next().toString() + " " + NewLine);
        }
        
        
    }
}
