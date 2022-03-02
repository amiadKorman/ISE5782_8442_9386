package geometries;

import primitives.Point;
import primitives.Vector;

public class Sphere implements Geometry{
    private Point _center;
    private double _radius;

    public Sphere(Point _center, double _radius) {
        this._center = _center;
        this._radius = _radius;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                ", _radius=" + _radius +
                '}';
    }

    @Override
    public Vector getNormal(Point point) {
        return null;
    }
}
