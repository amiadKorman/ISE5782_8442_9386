package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * It implements the Geometry interface.
 */
public class Sphere implements Geometry{
    private Point _center;
    private double _radius;

    // A constructor.
    public Sphere(Point _center, double _radius) {
        this._center = _center;
        this._radius = _radius;
    }

    @Override
    // Overriding the toString method of the Object class.
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                ", _radius=" + _radius +
                '}';
    }

    @Override
    // A method that returns a Vector.
    public Vector getNormal(Point point) {
        return null;
    }
}
