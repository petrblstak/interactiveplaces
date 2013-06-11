/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irm.support;

/**
 *
 * @author Petr
 */
public enum PlaceType {
    ALL("All"), 
    CLUB("Club"), 
    PUB("Pub"), 
    RESTAURANT("Restaurant"), 
    PARK("Park"), 
    OUTDOOR("Outdoor"), 
    OTHER("Other");

    private String label;

    private PlaceType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
