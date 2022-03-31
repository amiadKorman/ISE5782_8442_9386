package geometries;

import primitives.*;

import java.util.List;

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

    /**
     * implementation of getNormal from Geometry
     *
     * @param ray {@link Ray}  pointing toward the object
     * @return List of intersection {@link Point}s
     */
    public List<Point> findIntersections(Ray ray) {
        return super.findIntersections(ray);
    }
}
