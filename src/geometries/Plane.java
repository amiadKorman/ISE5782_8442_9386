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

    /**
     * Returns the normal vector of the plane
     *
     * @param point The point to get the normal at.
     * @return The normal vector of the plane.
     */
    @Override
    public Vector getNormal(Point point) {
        return getNormal();
    }

    public Vector getNormal() {
        return _normal;
    }
}
