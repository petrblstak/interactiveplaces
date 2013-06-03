/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irm.database;

import irm.control.LoginController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Petr
 */
public class DatabaseConnector {

    //apparently doesnt work like this with tomcat 7
    //@Resource(name="jdbc/interrestmap") 
    private DataSource ds;
    private Connection con;

    /**
     * Constructor for creating DB connection.
     */
    public DatabaseConnector() {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/interrestmap");
            con = ds.getConnection();
        } catch (NamingException e) {
            System.out.println("SQL Exception: " + e.toString());
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Gets you data from database based on your SQL statement. Used only for viewing data.
     * 
     * @param sqlStatement {@link String} representing the SQL statement
     * @return {@link ResultSet} of a stated SQL query or <code>null</code> in case of error.
     */
    public ResultSet getDatabaseData(String sqlStatement){
        ResultSet rs = null;
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sqlStatement);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    /**
     * Updated data in database based on the SQL statement. Used for INSERT, UPDATE or DELETE.
     * 
     * @param sqlStatement {@link String} representing the SQL statement
     * @return 0 if nothing happened or positive number representing number of rows affected
     */
    public int updateDatabaseData(String sqlStatement){
        int result = 0;
        try {
            Statement stmt = con.createStatement();
            result = stmt.executeUpdate(sqlStatement);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     * Closes DB connection. Should be called after all DB work is done for the specific request.
     */
    public void CloseConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
