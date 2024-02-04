package nl.scalda.woshmato.models;

import nl.scalda.woshmato.datalayer.DAOPerson;

public class Student extends Person {

    private int OVNummer;
    private int personId;
    private int groupId;

    public Student(int id,String name, String insertion, String lastname, String email, int OVNummer, int personId) {
        super(id, name, insertion, lastname, email);
        this.OVNummer = OVNummer;
        this.personId = personId;
    }

    public Student() {

    }

    public int getOVNummer() {
        return OVNummer;
    }

    public void setOVNummer(int oVNummer) {
        this.OVNummer = oVNummer;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", insertion=" + insertion + ", lastname=" + lastname + ", email=" + email + ", OVNummer=" + OVNummer + '}';
    }

}
