/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irm.model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Petr
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String name;

    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
        this.id = 0;
        this.name = "none";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
