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
public class Sphere extends Geometry{
    /**
     * Center of Sphere.
     */
    final private Point center;
    /**
     * Radius od Sphere.
     */
    final private double radius;

    /**
     * Constructor to initialize Sphere based object with its center point and radius
     *
     * @param center Sphere's center.
     * @param radius Sphere's radius.
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
     * @param point The point on the sphere's surface.
     * @return normal vector to the sphere in point
     */
    @Override
    public Vector getNormal(Point point) {
        Vector v = point.subtract(center);
        return v.normalize();
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
        Point P0 = ray.getP0();
        Vector v = ray.getDir();

        if(P0.equals(center)){
            if(alignZero(this.radius - maxDistance) > 0)
                return null;
            return List.of(new GeoPoint(this, center.add(v.scale(radius))));
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

        if(t1 > 0 && t2 > 0 && alignZero(t1 - maxDistance) <= 0 && alignZero(t2 - maxDistance) <= 0){
            GeoPoint p1 = new GeoPoint(this,ray.getPoint(t1));
            GeoPoint p2 =  new GeoPoint(this,ray.getPoint(t2));
            return List.of(p1, p2);
        }

        if(t1 > 0 && alignZero(t1 - maxDistance) <= 0)
            return List.of(new GeoPoint(this, ray.getPoint(t1)));

        if(t2 > 0 && alignZero(t2 - maxDistance) <= 0)
            return List.of(new GeoPoint(this, ray.getPoint(t2)));

        return null; // no intersections at all
    }
}
