package nl.scalda.woshmato.controller;

import static com.opensymphony.xwork2.Action.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.Action;
import org.apache.struts2.interceptor.ServletRequestAware;
import nl.scalda.woshmato.datalayer.DAOGroup;
import nl.scalda.woshmato.models.Group;
import nl.scalda.woshmato.models.GroupList;
import nl.scalda.woshmato.models.Student;
import nl.scalda.woshmato.models.Task;
import nl.scalda.woshmato.models.Teacher;
import nl.scalda.woshmato.models.Team;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nl.scalda.woshmato.datalayer.DAOPerson;
import nl.scalda.woshmato.datalayer.DAOTask;
import nl.scalda.woshmato.datalayer.DAOTeam;

public class GroupController extends Action implements ServletRequestAware {

    HttpServletRequest request;
    ArrayList<Group> groups = DAOGroup.getInstance().getGroups();
    ArrayList<Teacher> teacherList = DAOPerson.getInstance().getTeachers();
    ArrayList<Team> teamList = DAOTeam.getInstance().getTeams();
    ArrayList<Student> studentList = new ArrayList<Student>();
    Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    Matcher m;

    public String addGroup() throws Exception {
        m = p.matcher(request.getParameter("groupName"));
        Boolean b = m.find();
        String groupName;
        if(!b){
        groupName = request.getParameter("groupName");            
        } else {
            return ERROR;
        }

        String teamString = request.getParameter("team");
        String splitStringTeam[] = teamString.split("(: )|(, )|(\\})");
        int newTeam = Integer.parseInt(splitStringTeam[1]);

        String teacherString = request.getParameter("teacher");
        String splitStringTeacher[] = teacherString.split("(: )|(, )|(\\})|(\\{)|(\\=)");
        int newTeacher = Integer.parseInt(splitStringTeacher[2]);

        Teacher teacher = new Teacher(newTeacher);
        Team team = new Team(newTeam);

        Group g = new Group(0, groupName, team, teacher, 0);

        GroupList.getInstance().createGroup(g);
        return SUCCESS;
    }

    public String editGroup() throws Exception {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        int groupArchived = 0;
        if ("".equals(request.getParameter("groupArchived"))) {
            for (Group gr : DAOGroup.getInstance().getGroups()) {
                if (gr.getId() == groupId) {
                    groupArchived = gr.getArchived();
                }
            }
        } else {
            groupArchived = Integer.parseInt(request.getParameter("groupArchived"));
        }
             String groupName = null;
        m = p.matcher(request.getParameter("groupName"));
        Boolean b = m.find();
        if(!b){
        if ("".equals(request.getParameter("groupName"))) {
            for (Group gr : DAOGroup.getInstance().getGroups()) {
                if (gr.getId() == groupId) {
                    groupName = gr.getName();
                }
            }
        } else {
            groupName = request.getParameter("groupName");
        }}
        else {
            return ERROR;
        }

        String teamString = request.getParameter("team");
        String splitStringTeam[] = teamString.split("(: )|(, )|(\\})");
        int newTeam = Integer.parseInt(splitStringTeam[1]);

        String teacherString = request.getParameter("teacher");
        String splitStringTeacher[] = teacherString.split("(: )|(, )|(\\})|(\\{)|(\\=)");
        int newTeacher = Integer.parseInt(splitStringTeacher[2]);

        Teacher teacher = new Teacher(newTeacher);
        Team team = new Team(newTeam);

        Group g = new Group(groupId, groupName, team, teacher, groupArchived);
        GroupList.getInstance().editGroup(g);
        return SUCCESS;
    }

    public String archiveGroup() throws Exception {
        int groupId = Integer.parseInt(request.getParameter("groupArchive"));
        Group g = new Group();
        g.setId(groupId);
        GroupList.getInstance().archiveGroup(g);
        return SUCCESS;
    }

    public String removeGroup() throws Exception {
        int groupId = Integer.parseInt(request.getParameter("groupRemove"));
        Group g = new Group();
        g.setId(groupId);
        GroupList.getInstance().removeGroup(g);
        return SUCCESS;
    }

    public String loadAllGroups() {
        DAOGroup.getInstance().loadAllGroups(true);
        groups = DAOGroup.getInstance().getGroups();
        return SUCCESS;
    }

    public String loadAllGroupsTeachersTeams() {
        DAOGroup.getInstance().loadAllGroups(true);
        groups = DAOGroup.getInstance().getGroups();
        DAOPerson.getInstance().loadAllTeachers();
        teacherList = DAOPerson.getInstance().getTeachers();
        DAOTeam.getInstance().loadTeams();
        teamList = DAOTeam.getInstance().getTeams();
        return SUCCESS;
    }

    public String loadGroup()
    {
    	loadAllGroupsTeachersTeams();
    	int id = Integer.parseInt(request.getParameter("id"));
    	Group p = DAOGroup.getInstance().findGroupById(id);
    	
        request.setAttribute("groupId", p.getId());
    	request.setAttribute("groupName", p.getName());
    	request.setAttribute("groupArchived", p.getArchived()); 
    	request.setAttribute("groupTeamId", p.getTeam().getId());
    	request.setAttribute("groupTeamName", p.getTeam().getName());
        request.setAttribute("groupTeam", p.getTeam().getId() + " " +p.getTeam().getName());
        request.setAttribute("groupTeacher", p.getTeacher().getId() + " " + p.getTeacher().getFullname());
    	
		return SUCCESS;
    }
    
    public String archiveGroupProcess()
    {
		int groupId = Integer.parseInt(request.getParameter("id"));
		Group g = new Group();
		g.setId(groupId);
		GroupList.getInstance().archiveGroup(g);
		return SUCCESS;
    }
    
    public String removeGroupProcess()
    {
		int groupId = Integer.parseInt(request.getParameter("id"));
		Group g = new Group();
		g.setId(groupId);
		GroupList.getInstance().removeGroup(g);
		return SUCCESS;
    }
    
    public String showStudents()
    {
		int groupId = Integer.parseInt(request.getParameter("id"));
		DAOGroup.getInstance().loadAllGroups(true);
		Group g = DAOGroup.getInstance().findGroupById(groupId);
		request.setAttribute("groupName", g.getName());
		request.setAttribute("groupTeam", g.getTeam().getName());
		request.setAttribute("groupTeacher", g.getTeacher().getAbbrevation() + " - " + g.getTeacher().getFullname());
		studentList = g.getStudents();
		return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    private HttpServletRequest getServletRequest() {
        return this.request;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(ArrayList<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public ArrayList<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(ArrayList<Team> teamList) {
        this.teamList = teamList;
    }

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
    
}
