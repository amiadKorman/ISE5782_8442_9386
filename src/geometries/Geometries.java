package geometries;

import primitives.Point;
import primitives.Ray;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
 * Composite class for all geometries object {@link Intersectable}
 * @author Amiad Korman & Omer Dayan
 */

/**
 * A collection of intersectables
 */
public class Geometries implements Intersectable{

    // A private list of intersectables.
    private List<Intersectable> _intersectables;

    public Geometries() {
        _intersectables = new LinkedList<Intersectable>();
    }

    public Geometries(Intersectable... geometries) {
        _intersectables = new LinkedList<Intersectable>();
        Collections.addAll(_intersectables, geometries);
    }

    /**
     * It takes an array of Intersectables and adds them to the list of Intersectables
     */
    public void add( Intersectable...geometries){
        Collections.addAll(_intersectables, geometries);
    }

    @Override
    // Returning the result of the intersection of the current instance with the ray.
    public List<Point> findIntersections(Ray ray) {
        List<Point> result = null;
        for(var item: _intersectables){
            List<Point> itemList = item.findIntersections(ray);
            if(itemList!=null) {
                if(result==null)
                    result = new LinkedList<>();
                result.addAll(itemList);
            }
        }
        return result;
    }
}