package nl.scalda.woshmato.datalayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.scalda.woshmato.models.Group;
import nl.scalda.woshmato.models.Person;
import nl.scalda.woshmato.models.Teacher;
import nl.scalda.woshmato.models.Team;

public class DAOTeam extends DAOConnection {

    /**
     * This class (singleton pattern).
     */
    private static DAOTeam instance;
    private ArrayList<Team> teams = new ArrayList<Team>();
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    

    public ArrayList<Team> loadTeams() {
    	teams.clear();
        Statement st;
        Team t;

        try {
            openConn();
            st = conn.createStatement();
            String sql = "SELECT * FROM Team WHERE archived='0'";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                t = new Team();
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
  
                teams.add(t);
            }
            st.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }
    
    public ArrayList<Teacher> getTeachersByTeams(Team t){
    	teachers.clear();
        Statement st;

        try {
            openConn();
            st = conn.createStatement();
            String sql = "SELECT p1.*,t1.abbreviation,t1.fte FROM Teacher AS t1 INNER JOIN teacher_team AS tt ON t1.id = tt.teacher_id INNER JOIN Person AS p1 ON t1.person_id = p1.id WHERE tt.team_id = " + t.getId() + ";";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setName(rs.getString("name"));
                teacher.setInsertion(rs.getString("insertion"));
                teacher.setLastname(rs.getString("lastname"));
                teacher.setEmail(rs.getString("email"));
                teacher.setAbbrevation(rs.getString("abbreviation"));
                teacher.setFTE(rs.getDouble("fte"));
                teachers.add(teacher);
            }
            st.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    /**
     * Deze methode maakt een nieuwe person aan in de database.
     *
     * @author Jari Scholten
     */
    public void createTeam(Team t) {
        //Statement st;
        //Group g;
        String query = "INSERT INTO Team (name) " + "VALUES ('" + t.getName() + "');";

        /**
         * Initial query start
         */
        //String query2 = "INSERT INTO Team (name,group_id) VALUES ('" + t.getName() + "','" + group.get(1) + "');";
        try {
            openConn();

            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    /**
     * Deze methode wijzigt een bestaande person.
     *
     * @author Jari Scholten
     */
    public void editPerson(Person p) {

        /**
         * Initial query start
         */
        String query = "UPDATE Person SET naam='" + p.getName() + "', achternaam='" + p.getLastname() + "'"
                + "' WHERE id='" + p.getId() + "';";

        try {
            openConn();

            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        System.out.println("Person is gewijzigd");
    }

    /**
     * Deze methode archiveert een person.
     *
     * @author Jari Scholten
     */
    public void archiveTeam(Team t) {

        /**
         * Initial query start
         */
        String query = "UPDATE Team SET archived='1' WHERE id='" + t.getId() + "';";

        try {
            openConn();

            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        System.out.println("Team gearchiveerd");
    }

    public String deleteTeam(int id) {

        /**
         * Initial query start
         */
        String query = "DELETE FROM Team WHERE id='" + id + "';";

        try {
            openConn();

            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return "teamdeleted";
    }

    public static DAOTeam getInstance() {
        if (instance == null) {
            instance = new DAOTeam();
        }
        return instance;
    }

    public DAOTeam() {
        // TODO Auto-generated constructor stub
    }

	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	}
}
