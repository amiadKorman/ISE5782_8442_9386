package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;

/**
 * This class implements the Geometry interface.
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Sphere implements Geometry{
    final private Point center;
    final private double radius;

    /**
     * Constructor to initialize Sphere based object with its center point and radius
     *
     * @param center
     * @param radius
     */
    public Sphere(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Overrides the toString method in the Object class
     *
     * @return string that describe the sphere
     */
    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + center +
                ", _radius=" + radius +
                '}';
    }

    /**
     * implementation of getNormal from Geometry
     *
     * @param point
     * @return normal vector to the sphere in point
     */
    @Override
    public Vector getNormal(Point point) {
        Vector v = point.subtract(center);
        return v.normalize();
    }

    /**
     * implementation of getNormal from Geometry
     *
     * @param ray {@link Ray}  pointing toward the object
     * @return List of intersection {@link Point}s
     */
    @Override
    public List<Point> findIntersections(Ray ray) {
        Point P0 = ray.getP0();
        Vector v = ray.getDir();

        if(P0.equals(center)){
            return List.of(center.add(v.scale(radius)));
            //throw new IllegalArgumentException("p of Ray is the center of the sphere");
        }

        Vector u = center.subtract(P0);

        double tm = alignZero(u.dotProduct(v));
        double d = alignZero(Math.sqrt(u.lengthSquared() - (tm * tm) ));

        // no intersections : the ray direction is above the sphere
        if(d >= radius){
            return null;
        }

        double th = alignZero(Math.sqrt( (radius * radius) - (d * d) ));

        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);

        if(t1 > 0 && t2 > 0){
            Point p1 = ray.getPoint(t1);
            Point p2 = ray.getPoint(t2);
            return List.of(p1, p2);
        }

        if(t1 > 0)
            return List.of(ray.getPoint(t1));

        if(t2 > 0)
            return List.of(ray.getPoint(t2));

        return null; // no intersections at all
    }
}
