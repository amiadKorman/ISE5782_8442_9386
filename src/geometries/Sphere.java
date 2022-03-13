package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

/**
 * This class implements the Geometry interface.
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Sphere implements Geometry{
    final private Point _center;
    final private double _radius;

    /**
     * Constructor to initialize Sphere based object with its center point and radius
     *
     * @param center
     * @param radius
     */
    public Sphere(Point center, double radius) {
        this._center = center;
        this._radius = radius;
    }

    /**
     * Overrides the toString method in the Object class
     *
     * @return string that describe the sphere
     */
    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                ", _radius=" + _radius +
                '}';
    }

    /**
     * implementation of getNormal from Geometry
     *
     * @param point
     * @return normal vector to the sphere in point
     */
    @Override
    public Vector getNormal(Point point) {
        Vector v = point.subtract(_center);
        return v.normalize();
    }

    @Override
    public List<Point> findIntersections(Ray ray) {
        return null;
    }
}
