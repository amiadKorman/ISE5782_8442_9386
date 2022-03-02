package geometries;

import primitives.Point;
import primitives.Vector;

public class Plane implements Geometry {
    final Point _q0;
    final Vector _normal;

    // Initializing the plane with 3 points.
    public Plane(Point p1, Point p2, Point p3) {
        _q0 = p1;

        Vector U = p2.subtract(p1);
        Vector V = p3.subtract(p1);
        Vector N = U.crossProduct(V);

        _normal = N.normalize();
    }

    public Plane(Point _q0, Vector _normal) {
        this._q0 = _q0;
        this._normal = _normal;
    }


    @Override
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

    public Point get_q0() {
        return _q0;
    }

    public Vector get_normal() {
        return _normal;
    }

    @Override
    public Vector getNormal(Point point) {
        return getNormal();
    }

    public Vector getNormal() {
        return _normal;
    }
}
