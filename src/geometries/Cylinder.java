package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube implements Geometry{


    private double height;

    public Cylinder(Ray _axisRay, double _radius, double height) {
        super(_axisRay, _radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public Vector getNormal(Point point) {
        return null;
    }
}
