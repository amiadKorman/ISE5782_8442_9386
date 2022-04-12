package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.alignZero;

/**
 * This class is a polygon with three points
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Triangle extends Polygon implements Geometry {

    /**
     * Constructor to initialize Triangle based three points
     *
     * @param p1 first point
     * @param p2 second point
     * @param p3 third point
     */
    public Triangle(Point p1, Point p2, Point p3) {
        super(p1, p2, p3);
    }

    /**
     * implementation of findIntersections from Geometry
     *
     * @param ray {@link Ray}  pointing toward the object
     * @return List of intersection {@link Point}s
     */
    public List<Point> findIntersections(Ray ray) {
        // Gets all intersections with the plane
        List<Point> result = plane.findIntersections(ray);

        // if there is no intersections with the whole plane,
        // then is no intersections with the triangle
        if (result == null) {
            return null;
        }

        Point P0 = ray.getP0();
        Vector v = ray.getDir();

        Vector v1 = this.vertices.get(0).subtract(P0),
                v2 = this.vertices.get(1).subtract(P0),
                v3 = this.vertices.get(2).subtract(P0);

        Vector n1 = v1.crossProduct(v2).normalize(),
                n2 = v2.crossProduct(v3).normalize(),
                n3 = v3.crossProduct(v1).normalize();

        double a = alignZero(v.dotProduct(n1)),
                b = alignZero(v.dotProduct(n2)),
                c = alignZero(v.dotProduct(n3));

        // if all the points have the same sign(+/-),
        // all the points are inside the triangle
        if (a < 0 && b < 0 && c < 0 || a > 0 && b > 0 && c > 0)
            return result;

        return null;
    }
}
