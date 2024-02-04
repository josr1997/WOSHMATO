package nl.scalda.woshmato.models;

/**
 * @author Jeroen
 *
 */
import nl.scalda.woshmato.datalayer.DAOPerson;

public class Teacher extends Person {
    /**
     * @param abbrevation
     * @param FTE
     * @param teacherRole
     * @param PersonId;
     **/
    //public ArrayList<Group> group = new ArrayList<Group>();
    public String abbrevation;
    public double FTE;
    private Role teacherRole;
    private int PersonId;

    /**
     * @param id
     * @param abbrevation
     * @param FTE
     * @param name
     * @param insertion
     * @param lastname
     * @param email
     * @param role
     */
    public Teacher(int id, String name, String insertion, String lastname, String email, String abbrevation, double FTE, int personId) {
        super(id,name, insertion, lastname, email);
        this.abbrevation = abbrevation;
        this.FTE = FTE;
    }
    
        public Teacher(String name, String insertion, String lastname, String email, String abbrevation, double FTE) {
        super(name, insertion, lastname, email);
        this.abbrevation = abbrevation;
        this.FTE = FTE;
    }

    public Teacher() {
        this.setRole(Role.TEACHER);
    }
    
    public Teacher(int id){
        this.id = id;
    }

    public void createTeacher() {
        DAOPerson.getInstance().createTeacher(this);
    }

    public double getFTE() {
        return FTE;
    }

    public void setFTE(double fTE) {
        FTE = fTE;
    }

    public String getAbbrevation() {
        return abbrevation;
    }

    public void setAbbrevation(String abbrevation) {
        this.abbrevation = abbrevation;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int PersonId) {
        this.PersonId = PersonId;
    }

    public Role getTeacherRole() {
        return teacherRole;
    }

    public void setTeacherRole(Role teacherRole) {
        this.teacherRole = teacherRole;
    }
    
    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", name=" + name + ", insertion=" + insertion + ", lastname=" + lastname + ", email=" + email + ", abbrevation=" + abbrevation + ", FTE=" + FTE + ", teacherRole=" + teacherRole + '}';
    }

    public String getFullname() {
        if (insertion.equals("")) {
            return name + " " + lastname;
        } else {
            return name + " " + insertion + " " + lastname;
        }

    }
//   @Override
//   public int compareTo(Person t) {
//       return super.compareTo(t); //To change body of generated methods, choose Tools | Templates.
//   }
//   

    @Override
    public int compareTo(Person t) {
        return super.compareTo(t); //To change body of generated methods, choose Tools | Templates.
    }
}
