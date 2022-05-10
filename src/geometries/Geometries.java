package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
 * Composite class for all geometries object {@link Intersectable}
 *
 * @author Amiad Korman & Omer Dayan
 */

/**
 * A collection of intersectables
 */
public class Geometries extends Intersectable {

    // A private list of intersectable.
    private List<Intersectable> intersectables;

    /**
     * Geometries default constructor
     */
    public Geometries() {
        this.intersectables = new LinkedList<Intersectable>();
    }

    /**
     * Geometries constructor based on intersectables list
     *
     * @param intersectables
     */
    public Geometries(Intersectable... intersectables) {
        this();
        Collections.addAll(this.intersectables, intersectables);
    }

    /**
     * Takes an array of Intersectables and adds them to the list of Intersectables
     *
     * @param intersectables
     */
    public void add(Intersectable... intersectables) {
        Collections.addAll(this.intersectables, intersectables);
    }

    /**
     * implementation of findGeoIntersectionsHelper from Intersectable
     *
     * @param ray {@link Ray}  pointing toward the object
     * @return List of intersection {@link Point}s
     */
    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        List<GeoPoint> intersections = null;
        for (var item : this.intersectables) {
            //get intersections points of a particular item from intersectables
            var points = item.findGeoIntersections(ray);
            if (points != null) {
                //first time initialize result to new LinkedList
                if (intersections == null)
                    intersections = new LinkedList<>();
                //add all item points to the resulting list
                intersections.addAll(points);
            }
        }
        return intersections;
    }
}