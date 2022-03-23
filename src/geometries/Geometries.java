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
 */


/**
 * this class is to manage a list of the intersectable
 *
 * @author Amiad Korman & Omer Dayan
 *
 */
public class Geometries implements Intersectable{

    private List<Intersectable> _intersectables;

    public Geometries() {
        _intersectables = new LinkedList<Intersectable>();
    }

    public Geometries(Intersectable... intersectables) {
        _intersectables = new LinkedList<Intersectable>();
        Collections.addAll(_intersectables, intersectables);
    }

    public void add( Intersectable...intersectables){
        Collections.addAll(_intersectables, intersectables);

    }

    @Override
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
