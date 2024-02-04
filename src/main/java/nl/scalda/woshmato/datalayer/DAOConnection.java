package nl.scalda.woshmato.datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p>
 * A Data access object for the connection to the database</p>
 * This class should always be extended to other data access object classes to
 * call its inherited methods.
 *
 * @author Jos Rijborz
 */
public class DAOConnection {

    /**
     * The host connecting to.
     */
    protected String url;

    /**
     * The user name using to connect to the host.
     */
    protected String user;

    /**
     * The password using to connect to the host.
     */
    protected String password;

    /**
     * The connection bridge to connect to the host.
     */
    protected Connection conn;

    /**
     * Sets the path, user and password depending on the properties file mode.
     *
     * @author Jos Rijborz
     */
    public DAOConnection() {    
        this.url = "jdbc:mysql://172.16.17.102/woshmato";
        this.user = "root";
        this.password = "Qwerty123";
    }

    
    /**
     * Opens a connection to the MySQL database using the credentials set in
     * {@link #DAOConnection()}.
     *
     * @author Jos Rijborz
     */
    public void openConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            setConn((Connection) DriverManager.getConnection(url, user, password));
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the connection to the MySQL database.
     *
     * @author Jos Rijborz
     */
    public void closeconn() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the connection to the MySQL database.
     *
     * @author Jos Rijborz
     * @return The connection to the MySQL database.
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * Sets the connection to the MySQL database.
     *
     * @author Jos Rijborz
     * @param conn A Connection with the credentials and host.
     */
    private void setConn(Connection conn) {
        this.conn = conn;
    }
}
