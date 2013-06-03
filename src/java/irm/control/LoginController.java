/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irm.control;

import irm.database.DatabaseConnector;
import irm.model.UserBean;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Petr
 */
@ManagedBean(name = "loginController")
@RequestScoped
public class LoginController implements Serializable {

    private static final long serialVersionUID = 1L;

    private String login;
    
    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public String logUser() {
        if (isValidUser()) {
            return "listMap";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Username " + login + " is not valid!"));
            return null;
        }
    }

    public boolean isValidUser() {
        String sql = "SELECT * FROM `user` WHERE `userName` = '" + login + "'";
        DatabaseConnector dc = new DatabaseConnector();
        ResultSet rs = dc.getDatabaseData(sql);
        try {
            if (rs.isBeforeFirst()) {
                rs.next();
                userBean.setId(rs.getInt("UserID"));
                userBean.setName(rs.getString("UserName"));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
