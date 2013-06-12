/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irm.control;

import irm.database.DatabaseConnector;
import irm.model.PlaceBean;
import irm.support.PlaceType;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Petr
 */
@ManagedBean(name = "listMapController")
@SessionScoped
public class ListMapController implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<PlaceBean> places;
    private PlaceBean currentPlace;
    private String currentPlaceType;
    @ManagedProperty(value = "#{userBean.id}")
    private Integer currentUserId;

    /**
     * Creates a new instance of ListMapController
     */
    public ListMapController() {
        currentPlaceType = PlaceType.ALL.toString();
        currentPlace = null;
        places = new ArrayList<PlaceBean>();
        loadPlaces();
        if (!places.isEmpty()) {
            currentPlace = places.get(0);
        }
    }

    public PlaceType[] getPlaceTypes() {
        return PlaceType.values();
    }

    public List<PlaceBean> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceBean> places) {
        this.places = places;
    }

    public PlaceBean getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(PlaceBean currentPlace) {
        this.currentPlace = currentPlace;
    }

    public String getCurrentPlaceType() {
        return currentPlaceType;
    }

    public void setCurrentPlaceType(String currentPlaceType) {
        this.currentPlaceType = currentPlaceType;
    }

    public boolean isMyPlace() {
        if (currentPlace == null) {
            return false;
        } else {
            return currentPlace.getUserID() == currentUserId;
        }
    }

    public void setCurrentUserId(Integer currentUserId) {
        this.currentUserId = currentUserId;
    }

    public Integer getCurrentUserId() {
        return currentUserId;
    }

    public void editPlace() {
        //zatim nic
    }

    public String addPlace() {
        return "editDetail";
    }

    public void updateCurrentPlace(int current) {
        currentPlace = places.get(current);
    }

    public String updatePlacesByType() {
        loadPlaces();
        return "listMap";
    }

    private void loadPlaces() {
        String sql = "SELECT * FROM `place`";
        if (!currentPlaceType.equals("ALL")) {
            sql = sql.concat(" WHERE `PlaceType` = '" + currentPlaceType + "'");
        }
        DatabaseConnector dc = new DatabaseConnector();
        ResultSet rs = dc.getDatabaseData(sql);
        places.clear();
        try {
            if (rs.isBeforeFirst()) {
                int counter = 0;
                while (rs.next()) {
                    places.add(new PlaceBean(rs.getInt("PlaceID"),
                            rs.getInt("UserID"),
                            rs.getString("PlaceName"),
                            rs.getInt("Rating"),
                            rs.getString("CoordinateX"),
                            rs.getString("CoordinateY"),
                            rs.getString("Description"),
                            rs.getString("PlaceType"),
                            counter));
                    counter++;
                }
            }
            dc.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
