package geometries;

import primitives.Point;

/**
 * This class is a polygon with three points
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Triangle extends Polygon implements Geometry{

    /**
     * Constructor to initialize Triangle based object with its three points
     *
     * @param p1 first point
     * @param p2 second point
     * @param p3 third point
     */
    public Triangle(Point p1, Point p2,Point p3) {
        super(p1, p2, p3);
    }

}
