package nl.scalda.woshmato.models;

import java.util.ArrayList;
import nl.scalda.woshmato.datalayer.DAOGroup;

public class Group {

	private int id;
	private String name;
	private Teacher teacher;
	private Team team;
	private int archived;
	private ArrayList<Student> students = new ArrayList<>();

	public Group(int id, String name, int archived) {
		this.id = id;
		this.name = name;
		this.archived = archived;
	}
	
	public Group(int id, String name, Team team, Teacher teacher, int archived) {
		this.id = id;
		this.name = name;
		this.team = team;
		this.teacher = teacher;
		this.archived = archived;
	}

	public Group() {}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArchived() {
		return archived;
	}

	public void setArchived(int archived) {
		this.archived = archived;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
//toString maken
}
