/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.woshmato.controller;

import nl.scalda.woshmato.models.Team;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import static com.opensymphony.xwork2.Action.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.Action;
import org.apache.struts2.interceptor.ServletRequestAware;

import nl.scalda.woshmato.datalayer.DAOGroup;
import nl.scalda.woshmato.datalayer.DAOPerson;
import nl.scalda.woshmato.datalayer.DAOTeam;
import nl.scalda.woshmato.models.Group;
import nl.scalda.woshmato.models.Student;
import nl.scalda.woshmato.models.Teacher;
import nl.scalda.woshmato.service.TeamService;

/**
 *
 * @author Jeroen
 */
public class TeamController extends Action implements ServletRequestAware {

    private String name;
    private String teamName;
    private int id;
    List<Team> teams;
    List<Teacher> teachers;
    List<Group> groups;
    List<Student> students;
    HttpServletRequest request;

//    @Override
//    public String execute() throws Exception {
//        addTeamToDB();
//        return "createTeam";
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams() {
        return TeamService.getInstance().loadTeams();
//        return teams;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String addTeamToDB() {
        try {
            Team t = new Team(teamName);

            TeamService.getInstance().createTeam(t);
            return "<h1>Team " + teamName + " is toegevoegd aan de Database</h1>";
        } catch (Exception e) {
            return "<h1>FAILED with message" + e.getMessage() + "</h1>";
        }
    }

    public String getAllTeams() {
        return "getallteams";
    }
    
    public String deleteTeam(){
        return TeamService.getInstance().deleteTeam(id);
    }
    
    public String getTeachersByTeam(Team t){
        teachers = TeamService.getInstance().getTeam(t);
        return "";
    }
    
    public String showTeamDetails()
    {
        int id = Integer.parseInt(request.getParameter("id")); //ID of the Group
    	Team t = DAOGroup.getInstance().getTeamByGroupId(id);
    	teachers = DAOTeam.getInstance().getTeachersByTeams(t);
    	groups = DAOGroup.getInstance().getGroupsByTeam(t);
    	students = DAOPerson.getInstance().getStudentsByTeam(t);
    	
    	request.setAttribute("teamName", t.getName() );
    	System.out.println(t.getName() + " <<<");
    	System.out.println(t.getId() + " <<<");
    	System.out.println(id + " id uit de request ofzo");
    	return SUCCESS;
    }

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
	}
	
    private HttpServletRequest getServletRequest() {
        return this.request;
    }

}
