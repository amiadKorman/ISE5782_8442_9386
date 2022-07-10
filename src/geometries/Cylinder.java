package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;

/**
 * Class representing a Cylinder
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Cylinder extends Tube {

    /**
     * Height of Cylinder.
     */
    private final double height;
    /**
     * Bottom base of Cylinder.
     */
    private final Plane bottomBase;
    /**
     * Upper base of Cylinder.
     */
    private final Plane upperBase;
    /**
     * Center Point of bottom base of Cylinder.
     */
    private final Point bottomCenter;
    /**
     * Center Point of upper base of Cylinder.
     */
    private final Point upperCenter;
    /**
     * Direction of Ray of Cylinder.
     */
    private final Vector va;

    /**
     * Cylinder constructor based on parameters.
     *
     * @param axisRay Central ray of Cylinder
     * @param radius Radius of Cylinder.
     * @param height Height of Cylinder.
     */
    public Cylinder(Ray axisRay, double radius, double height) {
        super(axisRay, radius);
        this.height = height;
        this.va = this.axisRay.getDir();
        this.bottomCenter = this.axisRay.getP0();
        this.upperCenter = this.axisRay.getPoint(this.height);
        this.bottomBase = new Plane(this.bottomCenter, this.va);
        this.upperBase = new Plane(this.upperCenter, this.va);
    }

    /**
     * Getter for the value of the height field.
     *
     * @return The height of the rectangle.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Implementation of getNormal from Geometry.
     *
     * @param point The point on the cylinder's surface.
     * @return The normal vector to the cylinder at the given point.
     */
    public Vector getNormal(Point point) {

        // define the center of cylinder's sides
        Vector cylinderCenterVector = axisRay.getDir();

        Point centerOfOneSide = axisRay.getP0();
        Point centerOfSecondSide = axisRay.getP0().add(axisRay.getDir().scale(height));

        //The normal at a base will be simply equal to central ray's
        //direction vector v or opposite to it (−v) so we check it
        if (point.equals(centerOfOneSide)) {
            return cylinderCenterVector.scale(-1);
        }
        else if (point.equals(centerOfSecondSide)){
            return cylinderCenterVector;
        }

        //If the point on one of the cylinder's bases, but it's not the center point
        double projection = cylinderCenterVector.dotProduct(point.subtract(centerOfOneSide));
        if (projection == 0) {
            Vector v1 = point.subtract(centerOfOneSide);
            return v1.normalize();
        }

        //If the point on the side of the cylinder.
        Point center = centerOfOneSide.add(cylinderCenterVector.scale(projection));
        Vector v = point.subtract(center);

        return v.normalize();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", _axisRay=" + axisRay +
                ", _radius=" + radius +
                '}';
    }

    /**
     * Helper function to check whether an intersection Point calculated for infinite cylinder
     * is between the bases of the Cylinder or outside it.
     *
     * @param p Intersection Point.
     * @return the GeoPoint for the cylinder with the p point if it is on the Cylinder, null otherwise.
     */
    private GeoPoint checkIntersection(Point p) {
        if (p == null) return null;
        return alignZero(this.va.dotProduct(p.subtract(this.bottomCenter))) > 0
                && alignZero(this.va.dotProduct(p.subtract(this.upperCenter))) < 0
                ? new GeoPoint(this, p) : null;
    }

    /**
     * Helper function to find an intersection Point with Cylinder's base
     *
     * @param base   Base of Cylinder.
     * @param ray    Ray to find intersection with.
     * @param center Center Point of Cylinder's base.
     * @return GeoPoint with the cylinder and the point on a base.
     */
    private GeoPoint baseIntersection(Plane base, Ray ray, Point center) {
        List<GeoPoint> lst = base.findGeoIntersections(ray); //intersection Points with Plane
        if (lst == null) return null;
        Point p = lst.get(0).point;
        return alignZero(p.distanceSquared(center) - this.sqrRadius) < 0 ? new GeoPoint(this, p) : null;
    }

    @Override
    public List<GeoPoint> findGeoIntersectionsHelper(Ray ray, double maxDistance) {
        //Step 1 - finding intersection Points with bases:
        GeoPoint gp1 = baseIntersection(this.bottomBase, ray, this.bottomCenter); //intersection Point with bottom base
        GeoPoint gp2 = baseIntersection(this.upperBase, ray, this.upperCenter); //intersection Point with upper base

        if (gp1 != null && gp2 != null) {
            double gp1D = gp1.point.distance(ray.getP0());
            double gp2D = gp2.point.distance(ray.getP0());

            return (gp1D <= maxDistance && gp2D <= maxDistance) ? twoPoints(ray, gp1, gp2) :
                    (gp1D <= maxDistance) ? List.of(gp1) : (gp2D <= maxDistance) ? List.of(gp2) : null;
        }

        GeoPoint basePoint = gp1 != null ? gp1 : gp2;

        //Step 2 - checking if intersection Points with Tube are on Cylinder itself:
        List<GeoPoint> lst = super.findGeoIntersectionsHelper(ray, maxDistance); //intersection Points with Tube
        if (lst == null) return basePoint == null ? null : List.of(basePoint);

        gp1 = checkIntersection(lst.get(0).point);
        gp2 = lst.size() < 2 ? null : checkIntersection(lst.get(1).point);
        if (basePoint != null)
            return gp1 != null ? twoPoints(ray, basePoint, gp1)
                    : gp2 != null ? twoPoints(ray, basePoint, gp2) : List.of(basePoint);
        if (gp1 == null) return gp2 != null ? List.of(gp2) : null;
        return gp2 != null ? twoPoints(ray, gp1, gp2) : List.of(gp1);
    }
}
