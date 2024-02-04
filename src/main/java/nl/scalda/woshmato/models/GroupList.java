/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.woshmato.models;

import java.util.ArrayList;
import nl.scalda.woshmato.datalayer.DAOGroup;

/**
 *
 * @author kevin
 */
public class GroupList {
    private static GroupList instance;
    private ArrayList<Group> groups = DAOGroup.getInstance().getGroups();
    
    private GroupList(){
        
    }
    
    public GroupList(ArrayList<Group> groups){
        this.groups = groups;
    }
    
    public void createGroup(Group g){
        groups.add(g);
        DAOGroup.getInstance().createGroup(g);
    }
    
    public void editGroup(Group g){
        DAOGroup.getInstance().editGroup(g);
    }
    
    public void archiveGroup(Group g){
        DAOGroup.getInstance().archiveGroup(g);
    }
    
    public void removeGroup(Group g){
        DAOGroup.getInstance().removeGroup(g);
        g = null;
    }

    //Omdat er maar 1 groeplijst is
    //DEnk het niet
    public static GroupList getInstance() {
        if(instance == null){
            instance =  new GroupList();
        }
        return instance;
    }

    public static void setInstance(GroupList instance) {
        GroupList.instance = instance;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
    
    
    
}
