package nl.scalda.woshmato.models;

import java.util.Set;

public abstract class Person {

    public int id;
    public String name;
    public String insertion;
    public String lastname;
    public String email;
    private Role role;
    private Set<Role> roles;

    public Person() {

    }

    public Person(int id, String name, String insertion, String lastname, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.insertion = insertion;
        this.email = email;
    }

    public Person(String name, String insertion, String lastname, String email) {
        this.name = name;
        this.lastname = lastname;
        this.insertion = insertion;
        this.email = email;
    }

    // -------------------------getters and setters-----------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInsertion() {
        return insertion;
    }

    public void setInsertion(String insertion) {
        this.insertion = insertion;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", insertion=" + insertion + ", lastname=" + lastname + ", email=" + email + '}';
    }

    public int compareTo(Person t) {
        return name.compareTo(t.name);

        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
