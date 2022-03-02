package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * It creates a tube.
 */
public class Tube implements Geometry{
    protected Ray _axisRay;
    protected double _radius;

    // Creating a constructor for the class.
    public Tube(Ray _axisRay, double _radius) {
        this._axisRay = _axisRay;
        this._radius = _radius;
    }

    @Override
    // Overriding the toString method of the superclass.
    public String toString() {
        return "Tube{" +
                "_axisRay=" + _axisRay +
                ", _radius=" + _radius +
                '}';
    }

    @Override
    // Returning a null vector.
    public Vector getNormal(Point point) {
        return null;
    }
}
