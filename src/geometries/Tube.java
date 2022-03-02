package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Tube implements Geometry{
    protected Ray _axisRay;
    protected double _radius;

    public Tube(Ray _axisRay, double _radius) {
        this._axisRay = _axisRay;
        this._radius = _radius;
    }

    @Override
    public String toString() {
        return "Tube{" +
                "_axisRay=" + _axisRay +
                ", _radius=" + _radius +
                '}';
    }

    @Override
    public Vector getNormal(Point point) {
        return null;
    }
}
