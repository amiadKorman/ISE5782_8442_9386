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
public class Geometries implements Intersectable {

    // A private list of intersectable.
    private List<Intersectable> intersectables;

    /**
     * Geometries default constructor
     */
    public Geometries() {
        this.intersectables = new LinkedList<Intersectable>();
    }

    /**
     * Geometries constructor
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
     * implementation of findIntersections from Geometry
     *
     * @param ray {@link Ray}  pointing toward the object
     * @return List of intersection {@link Point}s
     */
    @Override
    public List<Point> findIntersections(Ray ray) {
        List<Point> result = null;
        for (var item : this.intersectables) {
            //get intersections points of a particular item from intersectables
            List<Point> itemList = item.findIntersections(ray);
            if (itemList != null) {
                //first time initialize result to new LinkedList
                if (result == null)
                    result = new LinkedList<>();
                //add all item points to the resulting list
                result.addAll(itemList);
            }
        }
        return result;
    }
}