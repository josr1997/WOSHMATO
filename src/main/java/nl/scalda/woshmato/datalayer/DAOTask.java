package nl.scalda.woshmato.datalayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import nl.scalda.woshmato.models.Category;
import nl.scalda.woshmato.models.CategoryList;
import nl.scalda.woshmato.models.Task;
import nl.scalda.woshmato.models.TaskList;

/**
 * <p>
 * This class is used to send a packetData to the database.</p>
 *
 * @author Jos Rijborz
 */
public class DAOTask extends DAOConnection {

    /**
     * This class (singleton pattern).
     */
    private static DAOTask instance;

    /**
     * Arraylist met alle taken uit de database
     */

    private ArrayList<Task> tasks = TaskList.getInstance().getTasks();
    private ArrayList<Category> categories = DAOCategory.getInstance().getCategories();

    public DAOTask() {

    }

    /**
     * Deze methode gooit alle taken uit de database in een ArrayList.
     *
     * @author Jos Rijborz
     */
    public void loadAllTasks(boolean remove) {
        tasks.clear();
        Statement st;

        Task t;

        try {
            openConn();
            st = conn.createStatement();

            String sql = "";

            if (remove) {
                sql = "SELECT * FROM Task";
            } else {
                sql = "SELECT * FROM Task WHERE archived='0'";
            }

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                t = new Task();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setDescription(rs.getString("description"));
                t.setLessonhour(rs.getDouble("lessonhour"));
                t.setClockhour(rs.getDouble("clockhour"));
                t.setCategory(getCategoryById(rs.getInt("categoryId")));
                t.setArchived(rs.getInt("archived"));

                tasks.add(t);
            }
            st.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } try {
            DAOCategory.getInstance().loadAllCategorys();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Category getCategoryById(int category) {
        Statement st;
        Category c = new Category();

        try {
            openConn();
            st = conn.createStatement();
            String sql = "SELECT * FROM `Category` WHERE id='" + category + "';";

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
            }
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
	}

	/**
     * Deze methode maakt een nieuwe taak aan in de database.
     *
     * @author Jos Rijborz
     * @param t
     */
    public void createTask(Task t) {

        /**
         * Initial query start
         */
        String query = "INSERT INTO Task (name,description,lessonhour,categoryId,clockhour) VALUES ('"
                + t.getName() + "','"
                + t.getDescription() + "','"
                + t.getLessonhour() + "','"
                + t.getCategory().getId() + "','"
                + t.getClockhour() + "');";

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
     * Deze methode wijzigt een bestaande taak.
     *
     * @author Jos Rijborz
     */
    public void editTask(Task t) {

        /**
         * Initial query start
         */
        String query = "UPDATE Task SET name='" + t.getName() + "', description='" + t.getDescription() + "'"
                + ", lessonhour='" + t.getLessonhour() + "', clockhour='" + t.getClockhour() + "'"
                + ", archived='" + t.getArchived() + "', categoryId='" + t.getCategory().getId() + "' WHERE id='" + t.getId() + "';";

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
     * Deze methode archiveert een taak.
     *
     * @author Jos Rijborz
     */
    public void archiveTask(Task t) {

        /**
         * Initial query start
         */
        String query = "UPDATE Task SET archived='1' WHERE id='" + t.getId() + "';";
        String query1 = "UPDATE Task SET archived='0' WHERE id='" + t.getId() + "';";
        String query2 = "SELECT archived FROM task WHERE id='" + t.getId() + "';";

        try {
            openConn();
            
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query2);
            while(rs.next()){
            	if(rs.getInt("archived") == 0){
            		statement.executeUpdate(query);
            	} else {
            		statement.executeUpdate(query1);
            	}
            }
            

            statement.close();
            conn.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public Task findTaskById(int id) {
        Statement st;
        Task t = new Task();

        try {
            openConn();
            st = conn.createStatement();
            String sql = "SELECT * FROM `Task` WHERE id='" + id + "';";

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setDescription(rs.getString("description"));
                t.setLessonhour(rs.getDouble("lessonhour"));
                t.setClockhour(rs.getDouble("clockhour"));
                t.setArchived(rs.getInt("archived"));
                t.setCategory(getCategoryById(rs.getInt("categoryId")));
            }
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static DAOTask getInstance() {
        if (instance == null) {
            instance = new DAOTask();
        }
        return instance;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

}
