package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * It extends the Tube class and implements the Geometry interface.
 */
public class Cylinder extends Tube implements Geometry{

    // Declaring a private variable named `height` of type `double`.
    private double height;

    // Creating a constructor for the Cylinder class.
    public Cylinder(Ray _axisRay, double _radius, double height) {
        super(_axisRay, _radius);
        this.height = height;
    }

    /**
     * Returns the height of the rectangle
     *
     * @return The height of the rectangle.
     */
    public double getHeight() {
        return height;
    }

    @Override
    // Overriding the getNormal method of the Geometry interface.
    public Vector getNormal(Point point) {
        return null;
    }
}
