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
public class Geometries extends Intersectable {

    /**
     * A private list of intersectable.
     */
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
     * @param intersectables Linked list of the geometries we stored.
     */
    public Geometries(Intersectable... intersectables) {
        this();
        Collections.addAll(this.intersectables, intersectables);
    }

    /**
     * Takes an array of Intersectables and adds them to the list of Intersectables
     *
     * @param intersectables Linked list of the geometries we stored.
     */
    public void add(Intersectable... intersectables) {
        Collections.addAll(this.intersectables, intersectables);
    }

    /**
     * Finds the intersection points of the ray with the surface of the object
     *
     * @param ray The ray to intersect with the GeoPoint.
     * @param maxDistance The maximum distance from the source of the ray to intersect with.
     * @return A list of GeoPoints that are the intersections of the ray with the object.
     */
    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray, double maxDistance) {
        List<GeoPoint> intersections = null;
        for (var item : this.intersectables) {
            //get intersections points of a particular item from intersectables
            var points = item.findGeoIntersections(ray, maxDistance);
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