
package nl.scalda.woshmato.service;

import java.util.ArrayList;
import nl.scalda.woshmato.datalayer.DAOTeam;
import nl.scalda.woshmato.models.Teacher;
import nl.scalda.woshmato.models.Team;

public class TeamService {
    
    private static TeamService instance;
    
    private TeamService(){
        
    }
    
    public String deleteTeam(int id){
        return DAOTeam.getInstance().deleteTeam(id);
    }
    
    public void createTeam(Team t){
        DAOTeam.getInstance().createTeam(t);
    }
    public ArrayList<Team> loadTeams(){
        return DAOTeam.getInstance().loadTeams();
    }
    public ArrayList<Teacher> getTeam(Team t){
        return DAOTeam.getInstance().getTeachersByTeams(t);
    }
    
    public static TeamService getInstance() {
        if (instance == null) {
            instance = new TeamService();
        }
        return instance;
    }
    
}
