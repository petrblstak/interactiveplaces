/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irm.control;

import irm.database.DatabaseConnector;
import irm.support.PlaceType;
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
@ManagedBean(name = "detailController")
@RequestScoped
public class DetailController implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManagedProperty(value = "#{userBean.id}")
    private Integer currentUserId;
    private String placeName;
    private Integer rating;
    private String coordinateX;
    private String coordinateY;
    private String description;
    private String placeType;

    public PlaceType[] getPlaceTypes() {
        return PlaceType.values();
    }

    public void setCurrentUserId(Integer currentUserId) {
        this.currentUserId = currentUserId;
    }

    public Integer getCurrentUserId() {
        return currentUserId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(String coordinateX) {
        this.coordinateX = coordinateX;
    }

    public String getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(String coordinateY) {
        this.coordinateY = coordinateY;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public void savePlace() {
        String sql = "INSERT INTO `place`(UserID, PlaceName, Rating, CoordinateX, CoordinateY, Description, PlaceType) "
                + "VALUES(" + currentUserId + ",'" + placeName + "'," + rating + ",'" + coordinateX + "','" + coordinateY + "','" + description + "','" + placeType + "')";
        DatabaseConnector dc = new DatabaseConnector();
        int result = dc.updateDatabaseData(sql);
        FacesContext context = FacesContext.getCurrentInstance();
        if (result == 0) {
            context.addMessage(null, new FacesMessage("Error! Unable to save this place"));
        } else {
            context.addMessage(null, new FacesMessage("Successfully saved " + result + " new place"));
        }
        dc.CloseConnection();
    }
    
    public String goBack(){
        return "listMap";
    }
}
