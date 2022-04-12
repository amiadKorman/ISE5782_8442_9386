/**
 * A plane is a flat surface that extends infinitely in all directions.
 */
package geometries;

import java.util.List;

import primitives.*;

import static primitives.Util.*;

/**
 * This class is a flat surface that extends infinitely in all directions
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Plane implements Geometry {
    final private Point q0;
    final private Vector normal;

    /**
     * Constructor to initialize Plane based object with its three points
     *
     * @param p1 first point
     * @param p2 second point
     * @param p3 third point
     */
    public Plane(Point p1, Point p2, Point p3) {
        q0 = p1;

        Vector U = p2.subtract(p1);
        Vector V = p3.subtract(p1);

        Vector N = U.crossProduct(V);

        normal = N.normalize();
    }

    /**
     * Constructor to initialize Plane based object with point and normal vector
     *
     * @param q0     point on the plane
     * @param normal vector to the plane
     */
    public Plane(Point q0, Vector normal) {
        this.q0 = q0;
        this.normal = normal.normalize();
    }


    /**
     * Overrides the toString method in the Object class
     *
     * @return string that describe the plane
     */
    @Override
    public String toString() {
        return "Plane{" +
                "_q0=" + q0 +
                ", _normal=" + normal +
                '}';
    }

    /**
     * Getter for _q0 field
     *
     * @return point in the plane
     */
    public Point getQ0() {
        return q0;
    }

    /**
     * Getter for _normal field
     *
     * @return the normal vector of the plane.
     */
    public Vector getNormal() {
        return normal;
    }

    /**
     * implementation of getNormal from Geometry
     *
     * @param point
     * @return normal vector to the plane in point
     */
    @Override
    public Vector getNormal(Point point) {
        return getNormal();
    }

    /**
     * implementation of findIntersections from Geometry
     *
     * @param ray {@link Ray}  pointing toward the object
     * @return List of intersection {@link Point}s
     */
    @Override
    public List<Point> findIntersections(Ray ray) {
        Point P0 = ray.getP0();
        Vector v = ray.getDir();
        Vector n = normal;

        // ray begins at q0 of the plane
        if (q0.equals(P0)) {
            return null;
        }

        // ray is laying in the plane axis
        double nv = n.dotProduct(v);

        //ray direction cannot be parallel to plane orientation
        if (isZero(nv)) {
            return null;
        }

        Vector P0_Q0 = q0.subtract(P0);

        // numerator
        double nQMinusP0 = alignZero(n.dotProduct(P0_Q0));

        // t should be > 0
        if (isZero(nQMinusP0)) {
            return null;
        }

        double t = alignZero(nQMinusP0 / nv);

        // t should be > 0
        if (t <= 0) {
            return null;
        }

        // return immutable List
        return List.of(ray.getPoint(t));
    }
}
