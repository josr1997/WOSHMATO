package nl.scalda.woshmato.datalayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import nl.scalda.woshmato.models.Category;

/**
 * <p>
 * This class is used to send a packetData to the database.
 * </p>
 *
 * @author Jos Rijborz
 */
public class DAOCategory extends DAOConnection {

    /**
     * This class (singleton pattern).
     */
    private static DAOCategory instance;

    /**
     * Arraylist met alle categorie�n uit de database
     */
    private ArrayList<Category> categories = new ArrayList<>();

    public DAOCategory() {
    }

    /**
     * Deze methode gooit alle categorie�n uit de database in een ArrayList.
     *
     * @author Jos Rijborz
     */
    public void loadAllCategorys() {
        categories.clear();
        Statement st;
        Category c;

        try {
            openConn();
            st = conn.createStatement();
            String sql = "SELECT * FROM Category WHERE NOT id=0";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));

                categories.add(c);
            }
            st.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deze methode maakt een nieuwe categorie aan in de database.
     *
     * @author Jos Rijborz
     */
    public void createCategory(Category c) {

        /**
         * Initial query start
         */
        String query = "INSERT INTO Category (name) VALUES ('" + c.getName() + "');";

        try {
            openConn();

            Statement statement = conn.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet returnedKeys = statement.getGeneratedKeys();
            while (returnedKeys.next()) {
                c.setId(returnedKeys.getInt(1));
                //System.out.println(returnedKeys.getInt(1));
                //System.out.println(c.getId());
            }
            statement.close();
            conn.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        //System.out.println("Nieuwe categorie toegevoegd aan de database");
    }

    /**
     * Deze methode wijzigt een bestaande categorie.
     *
     * @author Jos Rijborz
     */
    public void editCategory(Category c) {

        /**
         * Initial query start
         */
        String query = "UPDATE Category SET name='" + c.getName() + "' WHERE id='" + c.getId() + "';";

        try {
            openConn();

            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            //System.out.println("edited category");

            statement.close();
            conn.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    /**
     * Deze methode verwijderd een taak.
     *
     * @author Jos Rijborz
     */
    public void removeCategory(Category c) {

        /**
         * Initial query start
         */
        String query = "DELETE FROM category WHERE id='" + c.getId() + "';";
        String query1 = "UPDATE task SET categoryId='0' WHERE categoryId='" + c.getId() + "';";

        try {
            openConn();
            
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            statement.executeUpdate(query1);

            statement.close();
            conn.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        c = null;
        //System.out.println("Categorie verwijderd");
    }

    public Category findCategoryById(int id) {
        Statement st;
        Category c = new Category();

        try {
            openConn();
            st = conn.createStatement();
            String sql = "SELECT * FROM `Category` WHERE id='" + id + "';";

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

    public static DAOCategory getInstance() {
        if (instance == null) {
            instance = new DAOCategory();
        }
        return instance;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategorie(ArrayList<Category> categorys) {
        this.categories = categorys;
    }

}
