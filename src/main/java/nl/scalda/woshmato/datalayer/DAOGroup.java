package nl.scalda.woshmato.datalayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.scalda.woshmato.models.Group;
import nl.scalda.woshmato.models.Student;
import nl.scalda.woshmato.models.Teacher;
import nl.scalda.woshmato.models.Team;

/**
 * <p>
 * This class is used to send a group to the database.</p>
 *
 * @author Jos Rijborz
 */
public class DAOGroup extends DAOConnection {

	/**
	 * This class (singleton pattern).
	 */
	private static DAOGroup instance;

	/**
	 * Arraylist met alle taken uit de database
	 */
	private ArrayList<Group> groups = new ArrayList<Group>();

	public DAOGroup() {

	}

	/**
	 * Deze methode gooit alle taken uit de database in een ArrayList.
	 *
	 * @author Jos Rijborz
	 */
	public void loadAllGroups(boolean remove) {
		groups.clear();
		Statement st;
		Group g;

		try {
			openConn();
			st = conn.createStatement();

			String sql = "";

			if (remove) {
				sql = "SELECT * FROM `Group` WHERE NOT id=0";
			} else {
				sql = "SELECT * FROM `Group` WHERE archived='0' AND NOT id=0";
			}

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				g = new Group();

				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setArchived(rs.getInt("archived"));
				g.setTeacher(getTeacherByID(rs.getInt("teacher_id")));
				g.setTeam(getTeamByID(rs.getInt("team_id")));
				
				g.getTeacher().setName(getTeacherByID(rs.getInt("teacher_id")).getName());
				g.getTeacher().setLastname(getTeacherByID(rs.getInt("teacher_id")).getLastname());
				g.getTeacher().setInsertion(getTeacherByID(rs.getInt("teacher_id")).getInsertion());

//				DEZE METHODE IS TIJDELIJK UIT!
//				getStudentsToGroup(g); 
				
				
				groups.add(g);
				
//				System.out.println("Coach ID: " + g.getTeacher().getId());
//				System.out.println("Team ID: " + g.getTeam().getId());
//				System.out.println("Coach: " + g.getTeacher().getFullname());
//				System.out.println("Groep " + g.getName() + " heeft " + g.getStudents().size() + " studenten");
				
//				for (int i = 0; i < g.getStudents().size(); i++) {
//					System.out.println("Studenten: " + g.getStudents().get(i).getName() + " " + g.getStudents().get(i).getInsertion() + " " + g.getStudents().get(i).getLastname());
//				}
//				System.out.println("----------------------------------");
				
			}
			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getStudentsToGroup(Group g) 
	{
		Statement st;

		
		try {
			openConn();
			st = conn.createStatement();
			String sql = "SELECT Person.name, Person.insertion, Person.lastname, Student.id, Student.ovnummer FROM Student INNER JOIN Person on Person.id=Student.person_id WHERE group_id='" + g.getId() + "';";
	
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setOVNummer(rs.getInt("ovnummer"));
				s.setName(rs.getString("name"));
				s.setInsertion(rs.getString("insertion"));
				s.setLastname(rs.getString("lastname"));
				
				g.getStudents().add(s);
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deze methode maakt een nieuwe groep aan in de database.
	 *
	 * @author Jos Rijborz
	 */
	public void createGroup(Group g) {

		/**
		 * Initial query start
		 */
		String query = "INSERT INTO `Group` (name,team_id,teacher_id,archived) VALUES ('"
				+ g.getName() + "','"
				+ g.getTeam().getId() + "','"
				+ g.getTeacher().getId() + "','"
				+ g.getArchived() + "');";

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
	 * Deze methode wijzigt een bestaande groep.
	 *
	 * @author Jos Rijborz
	 */
	public void editGroup(Group g) {

		/**
		 * Initial query start
		 */
		String query = "UPDATE `Group` SET name='" + g.getName() + "', teacher_id='" + g.getTeacher().getId() + "', team_id='" + g.getTeam().getId() + "', archived='" + g.getArchived() + "'WHERE id='" + g.getId() + "';";

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
	 * Deze methode archiveert een groep.
	 *
	 * @author Jos Rijborz
	 */
	public void archiveGroup(Group p) {

		/**
		 * Initial query start
		 */
		String query = "UPDATE `Group` SET archived='1' WHERE id='" + p.getId() + "';";

		try {
			openConn();

			Statement statement = conn.createStatement();
			statement.executeUpdate(query);
			p.setArchived(1);
			statement.close();
			conn.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	/**
	 * Deze methode archiveert een groep.
	 *
	 * @author Jos Rijborz
	 */
	public void removeGroup(Group p) {

		/**
		 * Initial query start
		 */
		String query = "UPDATE student set student.group_id=0 WHERE student.group_id='" + p.getId() + "'";
		String query2 = "DELETE FROM `Group` WHERE id='" + p.getId() + "';";

		try {
			openConn();

			Statement statement = conn.createStatement();
			statement.executeUpdate(query);
			statement.executeUpdate(query2);
			p = null;
			statement.close();
			conn.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public ArrayList<Group> getgroupnameandid() {
		Statement st;
		Group g;
		try {
			openConn();
			st = conn.createStatement();
			String sql = "SELECT id,name FROM `Group` WHERE archived='0'";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				g = new Group();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				groups.add(g);
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groups;
	}

	public Group findGroupById(int id){
		Statement st;
		Group g = new Group();

		try {
			openConn();
			st = conn.createStatement();
			String sql = "SELECT * FROM `Group` WHERE id='" + id + "';";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Teacher t = getTeacherByID(rs.getInt("teacher_id"));
				
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setArchived(rs.getInt("archived"));
				g.setTeacher(t);
				g.setTeam(getTeamByID(rs.getInt("team_id")));
				
				g.getTeacher().setName(t.getName());
				g.getTeacher().setLastname(t.getLastname());
				g.getTeacher().setInsertion(t.getInsertion());
				g.getTeacher().setAbbrevation(t.getAbbrevation());
				
				getStudentsToGroup(g); 
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}
	
	public Teacher getTeacherByID(int teacherId) {
		Statement st;
		Teacher t = new Teacher();

		try {
			openConn();
			st = conn.createStatement();
			String sql = "SELECT Teacher.id, Person.name, Person.lastname, Person.insertion, Teacher.abbreviation FROM Teacher INNER JOIN Person ON Person.id=Teacher.person_id AND Teacher.id='" + teacherId + "';";

			//SELECT Person.name, Person.insertion, Person.lastname, Teacher.person_id, 
		//	Teacher.id FROM Teacher INNER JOIN Person ON Person.id=Teacher.person_id;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				t.setId(rs.getInt("id"));
				t.setName(rs.getString("name"));
				t.setInsertion(rs.getString("insertion"));
				t.setLastname(rs.getString("lastname"));
				t.setAbbrevation(rs.getString("abbreviation"));
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public Team getTeamByID(int teamId) {
		Statement st;
		Team t = null;
		try {
			openConn();
			st = conn.createStatement();
			String sql = "SELECT * FROM `Team` WHERE id='" + teamId + "';";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				t = new Team();
				t.setId(rs.getInt("id"));
				t.setName(rs.getString("name"));
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public ArrayList<Group> getGroupsByTeam(Team t) {
		groups.clear();
		Statement st;
		Group g;
		try {
			openConn();
			st = conn.createStatement();
			String sql = "SELECT * FROM `Group` WHERE team_id='" + t.getId() + "'";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				g = new Group();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				groups.add(g);
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groups;
	}
	
	public Team getTeamByGroupId(int id) {
		Statement st;
		Team t = null;
		try {
			openConn();
			st = conn.createStatement();
			String sql = "SELECT * FROM team WHERE id IN (SELECT `group`.team_id FROM `group` WHERE `group`.id = " + id + ");";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				t = new Team();
				t.setId(rs.getInt("id"));
				t.setName(rs.getString("name"));
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	public static DAOGroup getInstance() {
		if (instance == null) {
			instance = new DAOGroup();
		}
		return instance;
	}

	public ArrayList<Group> getGroups() {
		return groups;
	}

	public void setGroups(ArrayList<Group> groups) {
		this.groups = groups;
	}

}
