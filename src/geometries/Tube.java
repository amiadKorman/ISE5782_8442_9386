package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * This class creates a tube.
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Tube implements Geometry{
    final protected Ray _axisRay;
    final protected double _radius;

    /**
     * Constructor to initialize Tube based object with its
     *
     * @param axisRay of the Tube
     * @param radius of the Tube
     */
    public Tube(Ray axisRay, double radius) {
        _axisRay = axisRay;
        _radius = radius;
    }

    /**
     * Returns the axis ray
     *
     * @return A ray that is perpendicular to the axis of the cylinder.
     */
    public Ray getAxisRay() {
        return _axisRay;
    }

    /**
     * Returns the radius of the Tube
     *
     * @return The radius of the Tube.
     */
    public double getRadius() {
        return _radius;
    }

    /**
     * Overrides the toString method in the Object class
     *
     * @return string that describe the tube
     */
    @Override
    public String toString() {
        return "Tube{" +
                "_axisRay=" + _axisRay +
                ", _radius=" + _radius +
                '}';
    }

    /**
     * implementation of getNormal from Geometry
     *
     * @param point
     * @return normal vector to the tube in point
     */
    @Override
    public Vector getNormal(Point point) {
        return null;
    }
}
