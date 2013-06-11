/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irm.model;

import java.io.Serializable;

/**
 *
 * @author Petr
 */
public class PlaceBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Integer placeID;
    private Integer userID;
    private String placeName;
    private Integer rating;
    private String coordinateX;
    private String coordinateY;
    private String description;
    private String placeType;
    private int listPosition;
    
    public PlaceBean() {
        this.placeID = 0;
        this.userID = 0;
        this.placeName = null;
        this.rating = 0;
        this.coordinateX = null;
        this.coordinateY = null;
        this.description = null;
        this.placeType = null;
    }

    public PlaceBean(Integer placeID, Integer userID, String placeName, Integer rating, String coordinateX, String coordinateY, String description, String placeType, int listPosition) {
        this.placeID = placeID;
        this.userID = userID;
        this.placeName = placeName;
        this.rating = rating;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.description = description;
        this.placeType = placeType;
        this.listPosition = listPosition;
    }

    public int getListPosition() {
        return listPosition;
    }

    public void setListPosition(int listPosition) {
        this.listPosition = listPosition;
    }

    public Integer getPlaceID() {
        return placeID;
    }

    public void setPlaceID(Integer placeID) {
        this.placeID = placeID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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
    
    
    
}
