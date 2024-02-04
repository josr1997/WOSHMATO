/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import nl.scalda.woshmato.datalayer.DAOGroup;
import nl.scalda.woshmato.datalayer.DAOPerson;
import nl.scalda.woshmato.datalayer.DAOTask;
import nl.scalda.woshmato.datalayer.DAOTeam;
import nl.scalda.woshmato.models.Category;
import nl.scalda.woshmato.models.CategoryList;
import nl.scalda.woshmato.models.Group;
import nl.scalda.woshmato.models.GroupList;
import nl.scalda.woshmato.models.Student;
import nl.scalda.woshmato.models.Task;
import nl.scalda.woshmato.models.TaskList;
import nl.scalda.woshmato.models.Team;
import nl.scalda.woshmato.controller.TeamController;

/**
 *
 * @author Jeroen
 */
public class Main {
    
    public static void main(String args[]){
//        //create Team
//          Group g = new Group();
//          g.setId(2);
//          Team t = new Team();
//          t.setName("AOtest");
//          DAOTeam.getInstance().createTeam(t,g);
//          //delete Team
//          Team t = new Team();
//          t.setId(3);
//          DAOTeam.getInstance().deleteTeam(t);
//            //archive team
//            Team t = new Team();
//            t.setId(2);
//            DAOTeam.getInstance().archiveTeam(t);

//System.out.println("test main");
//        Team t = new Team();
//        ArrayList<Team> teamsaa = t.getAllTeams();
//        teamsaa.toString();
//        System.out.println(teamsA);

    	
//    	DAOGroup.getInstance().loadAllGroups(true);
//    	Group g = DAOGroup.getInstance().getGroups().get(0);
//    	
//        Student s = new Student("Jos", "de", "Vries", 201746, g.getId(), "info@josdevries.nl");
//        DAOPerson.getInstance().createStudent(s);

//    	Task t = new Task(0, "GAAT FOUT", "KILL", 34, 0);
//    	TaskList.getInstance().createTask(t);
//        t.setDescription("kjhs");
//        TaskList.getInstance().editTask(t);
//        TaskList.getInstance().archiveTask(t);
//       /System.out.println(t.getArchived());
        
//        Category c = new Category(0, "testName");
//        CategoryList.getInstance().createCategory(c);
//        System.out.println(c.getName());
//        c.setName("hgbusef");
//        CategoryList.getInstance().editCategory(c);
//        System.out.println(c.getName());
//        CategoryList.getInstance().removeCategory(c);
//        c = null;
//        try{
//        System.out.println(c.getName());}catch(Exception e){
//            System.out.println("c deleted");
//        }
        

//            Group g = new Group(0, "testGroup", 19, 3, 0);
//            GroupList.getInstance().createGroup(g);
//            g.setName("niet meer testgroup");
//            GroupList.getInstance().editGroup(g);
//            System.out.println(DAOGroup.getInstance().findGroupById(g.getId()).getName());
//            GroupList.getInstance().archiveGroup(g);
//            System.out.println(g.getArchived());
//            GroupList.getInstance().removeGroup(g);
//            g = null;
//            try{
//                System.out.println(g.getName());
//            }catch(Exception e){
//                System.out.println("g removed");
//            }
    	DAOGroup.getInstance().loadAllGroups(true);

    }
    
    
    
}
