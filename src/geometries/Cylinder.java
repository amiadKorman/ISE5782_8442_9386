package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * This class extends the Tube class and implements the Geometry interface.
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Cylinder extends Tube implements Geometry{
    final private double _height;

    /**
     * Constructor to initialize Cylinder based object with its
     *
     * @param axisRay of the Cylinder
     * @param radius of the Cylinder
     * @param height of the Cylinder
     */
    public Cylinder(Ray axisRay, double radius, double height) {
        super(axisRay, radius);
       _height = height;
    }

    /**
     * Getter for the height of the rectangle
     *
     * @return The height of the rectangle.
     */
    public double getHeight() {
        return _height;
    }

    /**
     * Overrides the toString method in the Object class
     *
     * @return string that describe the cylinder
     */
    @Override
    public String toString() {
        return "Cylinder{" +
                "_height=" + _height +
                ", _axisRay=" + _axisRay +
                ", _radius=" + _radius +
                '}';
    }

    /**
     * implementation of getNormal from Geometry
     *
     * @param point
     * @return normal vector to the cylinder in point
     */
    @Override
    public Vector getNormal(Point point) {
        return null;
    }
}
