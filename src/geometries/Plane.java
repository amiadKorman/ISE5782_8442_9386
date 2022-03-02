/**
 * A plane is a flat surface that extends infinitely in all directions.
 */
package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * A plane is a flat surface that extends infinitely in all directions
 */
public class Plane implements Geometry {
    final Point _q0;
    final Vector _normal;

    // Initializing the plane with 3 points.

    // This is the constructor for the Plane class. It initializes the plane with 3 points.
    public Plane(Point p1, Point p2, Point p3) {
        _q0 = p1;

        Vector U = p2.subtract(p1);
        Vector V = p3.subtract(p1);
        Vector N = U.crossProduct(V);

        _normal = N.normalize();
    }

    // Initializing the plane with 3 points.
    public Plane(Point _q0, Vector _normal) {
        this._q0 = _q0;
        this._normal = _normal;
    }


    @Override
    // Overriding the toString method in the Object class.
    public String toString() {
        return "Plane{" +
                "_q0=" + _q0 +
                ", _normal=" + _normal +
                '}';
    }

    /**
     * Returns the normal vector of the plane
     *
     * @param "point" The point to get the normal at.
     * @return The normal vector of the plane.
     */

    // Returning the point that is the origin of the plane.
    public Point get_q0() {
        return _q0;
    }

    // Returning the normal vector of the plane.
    public Vector get_normal() {
        return _normal;
    }

    @Override
    // Overriding the `getNormal` method in the `Geometry` interface.
    public Vector getNormal(Point point) {
        return getNormal();
    }

    // Returning the normal vector of the plane.
    public Vector getNormal() {
        return _normal;
    }
}
