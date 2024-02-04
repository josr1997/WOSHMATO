package nl.scalda.woshmato.models;

import java.util.ArrayList;


public class Team implements Comparable<Team> {

    // Person t = new Person();
    public String name;
    public int id;
    ArrayList<Team> teams;
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Group> groups = new ArrayList<>();

    public boolean addTeacher(Teacher t) {
        teachers.add(t);
        return false;
    }

    public boolean addGroup(Group g) {
        groups.add(g);
        return false;
    }

    public Team(String name) {
        this.name = name;
    }
    
    public Team(int id) {
        this.id = id;
    }

    public Team() {

    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }
    

    @Override
    public int compareTo(Team o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        return "Team{" + "Id: " + getId() + ", Name: " + getName() + "}";
    }

}
