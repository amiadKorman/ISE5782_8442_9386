package geometries;

import primitives.*;

/**
 * This interface will serve all geometric classes
 *
 * @author Amiad Korman & Omer Dayan
 */
public interface Geometry {
    /**
     * return the normal to the vector in specific point
     *
     * @param point
     * @return the normal to the vector in specific point
     */
    Vector getNormal(Point point);
}
