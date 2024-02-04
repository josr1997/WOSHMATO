package nl.scalda.woshmato.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import nl.scalda.woshmato.models.Person;
import nl.scalda.woshmato.models.Student;
import nl.scalda.woshmato.models.Teacher;
import nl.scalda.woshmato.models.Team;

/**
 * <p>
 * This class is used to send a packetData to the database.
 * </p>
 *
 * @author Jeroen van Loon
 */
public class DAOPerson extends DAOConnection {

    /**
     * This class (singleton pattern).
     */
    private static DAOPerson instance;

    /**
     * Arraylist met alle personeel uit de database
     */
    private ArrayList<Person> persons = new ArrayList<Person>();
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public DAOPerson() {

    }

    /**
     * Deze methode gooit alle personeel uit de database in een ArrayList.
     *
     * @author Jeroen van Loon
     * @return ArrayList<Person>
     */
    public ArrayList<Person> loadAllPersons() {
        Statement st;
        Person p;

        try {
            openConn();
            st = conn.createStatement();
            String sql = "SELECT * FROM `Person` WHERE archived='0'";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                p = new Person() {
                };
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setInsertion(rs.getString("insertion"));
                p.setLastname(rs.getString("lastname"));
                p.setEmail(rs.getString("email"));

                persons.add(p);

            }
            st.close();
            conn.close();
            for (Person person : persons) {
                System.out.println(person.getId());
                System.out.println(person.getName());
                if (person.getInsertion() == "") {
                } else {
                    System.out.println(person.getInsertion());
                }
                System.out.println(person.getLastname());
                System.out.println(person.getEmail());
                System.out.println("---------------------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public void createStudent(Student s) {

        /**
         * Initial query start
         */
        String query = "INSERT INTO `Person` (name,insertion,lastname,email) "
                + "VALUES ('" + s.getName() + "','" + s.getInsertion() + "','" + s.getLastname() + "','" + s.getEmail() + "');";

        String query2 = "INSERT INTO Student (person_id, group_id, ovnummer) VALUES (LAST_INSERT_ID(),'" + s.getGroupId() + "','" + s.getOVNummer() + "');";

        try {
            openConn();

            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            statement.executeUpdate(query2);

            statement.close();
            conn.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        System.out.println("Nieuw Persoon toegevoegd aan de database");

    }

    public void createTeacher(Teacher t) {
        t.getId();
        int isTeacher = 1;

//		String query = "INSERT INTO person (name,insertion,lastname,email,isDocent)" + "VALUES ('"+ t.getName() + t.getInsertion() + t.getLastname() + t.getEmail() + 1 +"'), 
        try {
            openConn();

            PreparedStatement statement = conn.prepareStatement("UPDATE person (name,insertion,lastname,email,isDocent) VALUES (?,?,?,?,?); UPDATE teacher (person_id,abbrevation,fte) VALUES (?,?,?);");
            statement.setString(1, t.getName());
            statement.setString(2, t.getInsertion());
            statement.setString(3, t.getLastname());
            statement.setString(4, t.getEmail());

            ResultSet resultSet = statement.executeQuery();

            statement.close();
            conn.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        System.out.println("Nieuw Docent toegevoegd aan de database");

    }

    public ArrayList<Teacher> loadTeachers() {
        Statement st;
        Teacher p;

        try {
            openConn();
            st = conn.createStatement();
            String sql = "SELECT Person.id,Person.name,Person.insertion,Person.lastname,Person.email,Teacher.abbreviation,Teacher.fte,Person.isDocent,Person.archived FROM Teacher INNER JOIN Person ON Person.id = Teacher.person_id";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                p = new Teacher();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setInsertion(rs.getString("insertion"));
                p.setLastname(rs.getString("lastname"));
                p.setEmail(rs.getString("email"));
                p.setAbbrevation(rs.getString("abbrevation"));
                p.setFTE(rs.getDouble("fte"));

                teachers.add(p);

            }
            st.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    /**
     * Deze methode wijzigt een bestaande person.
     */
    public void editPerson(Person p) {

        /**
         * Initial query start
         */
        String query = "UPDATE Person SET name='" + p.getName() + "', insertion='" + p.getInsertion() + "', lastname='" + p.getLastname() + "', email='" + p.getEmail() + "' WHERE id='" + p.getId() + "';";
        System.out.println(query);
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
     */
    public void archivePerson(Person p) {

        /**
         * Initial query start
         */
        String query = "UPDATE Person SET archived='1' WHERE id='" + p.getId() + "';";

        try {
            openConn();

            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        System.out.println("Person gearchiveerd");
    }

    public void deletePerson(int id) {

        /**
         * Initial query start
         */
        String query = "DELETE Person WHERE id='" + id + "';";

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

    public void deleteTeacher(int id) {//nog niet af moet ook de teacher in de teacher table verwijderen

        /**
         * Initial query start
         */
        String query = "DELETE Person WHERE id='" + id + "';";

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

    public void loadAllTeachers() {
        teachers.clear();
        Statement st;
        Teacher t;

        try {
            openConn();
            st = conn.createStatement();
            String sql = "SELECT Person.name, Person.insertion, Person.lastname, Teacher.person_id, Teacher.id FROM Teacher INNER JOIN Person ON Person.id=Teacher.person_id;";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                t = new Teacher();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setPersonId(rs.getInt("person_id"));
                t.setLastname(rs.getString("lastname"));
                t.setInsertion(rs.getString("insertion"));

                teachers.add(t);

            }
            st.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Student> getStudentsByTeam(Team t) {
        teachers.clear();
        Statement st;
        ArrayList<Student> students = new ArrayList<Student>();

        try {
            openConn();
            st = conn.createStatement();
            String sql = "SELECT * FROM student INNER JOIN Person ON person_id=Person.id where student.group_id IN (SELECT `group`.id FROM `group` where `group`.team_id = " + t.getId() + ");";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("Student.id"));
                s.setName(rs.getString("Person.name"));
 //               s.setPersonId(rs.getInt("person_id"));
                s.setLastname(rs.getString("Person.lastname"));
                s.setInsertion(rs.getString("Person.insertion"));
                s.setOVNummer(rs.getInt("Student.ovnummer"));
                s.setEmail("Person.email");

                students.add(s);

            }
            st.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static DAOPerson getInstance() {
        if (instance == null) {
            instance = new DAOPerson();
        }
        return instance;
    }

    public ArrayList<Person> getPersoneel() {
        return persons;
    }

    public void setPersoneel(ArrayList<Person> persons) {
        this.persons = persons;
    }

	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	}

}