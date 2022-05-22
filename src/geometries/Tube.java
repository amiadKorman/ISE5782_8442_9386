package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

/**
 * This class creates a tube.
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Tube extends Geometry{
    final protected Ray axisRay;
    final protected double radius;

    /**
     * Constructor to initialize Tube based object with its
     *
     * @param axisRay of the Tube
     * @param radius of the Tube
     */
    public Tube(Ray axisRay, double radius) {
        this.axisRay = axisRay;
        this.radius = radius;
    }

    /**
     * Getter for the axis ray
     *
     * @return A ray that is perpendicular to the axis of the cylinder.
     */
    public Ray getAxisRay() {
        return axisRay;
    }

    /**
     * Getter for the radius of the Tube
     *
     * @return The radius of the Tube.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Overrides the toString method in the Object class
     *
     * @return string that describe the tube
     */
    @Override
    public String toString() {
        return "Tube{" +
                "_axisRay=" + axisRay +
                ", _radius=" + radius +
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

        Vector tubeCenterVector = axisRay.getDir();
        Point p0 = axisRay.getP0();

        double projection = tubeCenterVector.dotProduct(point.subtract(p0));
        if (projection == 0) {
            throw new IllegalArgumentException("the projection must not be 0");
        }

        // Calculating O when O is a point on direction tube vector (o = p0 + proj * v)//
        Point tubeCenterPoint = p0.add(tubeCenterVector.scale(projection));

        //Calculate the normal
        Vector normalVector = point.subtract(tubeCenterPoint).normalize();

        return normalVector;
    }

    /**
     * Finds the intersection points of the ray with the surface of the object
     *
     * @param ray The ray to intersect with the GeoPoint.
     * @param maxDistance The maximum distance from the source of the ray to intersect with.
     * @return A list of GeoPoints that are the intersections of the ray with the object.
     */
    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray, double maxDistance) {
        return null;
    }
}
