package primitives;

import java.util.List;
import java.util.Objects;

import static primitives.Util.isZero;
import geometries.Intersectable.GeoPoint;

/**
 * Ray is a line that starts in specific point
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Ray {
    private final Point p0;
    private final Vector dir;

    /**
     * Constructor to initialize Ray based object with its point value and vector value
     *
     * @param p0  point value
     * @param dir vector value
     */
    public Ray(Point p0, Vector dir) {
        this.p0 = p0;
        this.dir = dir.normalize();
    }

    /**
     * Getter for the value of the p0 field
     *
     * @return The xyz coordinates of the point p0.
     */
    public Point getP0() {
        return this.p0;
    }

    /**
     * Getter for the direction of the ray
     *
     * @return A Vector object.
     */
    public Vector getDir() {
        return this.dir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return this.p0.equals(ray.p0) && this.dir.equals(ray.dir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.p0, this.dir);
    }

    @Override
    public String toString() {
        return "Ray{" + this.p0 + this.dir + '}';
    }

    /**
     * Creating a {@link Point} at a specific distance in the ray direction
     *
     * @param delta distance for reaching new Point
     * @return new {@link Point}
     */
    public Point getPoint(double delta) {
        if (isZero(delta)) {
            throw new IllegalArgumentException("t should not be ZERO");
        }
        return this.p0.add(this.dir.scale(delta));
    }

    /**
     * Given a list of points, find the closest point to the origin
     *
     * @param points a list of points
     * @return the closest point to the origin
     */
    public Point findClosestPoint(List<Point> points) {
        return points == null || points.isEmpty() ? null
                : findClosestGeoPoint(points.stream().map(p -> new GeoPoint(null, p)).toList()).point;
    }


    /**
     * The function takes a list of GeoPoints and returns the closest GeoPoint to the origin
     *
     * @param points A list of GeoPoints to search through
     * @return The closest GeoPoint to the origin.
     */
    public GeoPoint findClosestGeoPoint(List<GeoPoint> points) {
        if (points == null)
            return null;

        GeoPoint result = null;
        double closest = Double.MAX_VALUE;
        double ptDistance;

        // A for loop that goes through all the points in the list and finds the closest point to the origin.
        for (var pt : points) {
            ptDistance = pt.point.distance(this.p0);
            if (ptDistance < closest) {
                closest = ptDistance;
                result = pt;
            }
        }

        return result;
    }
}
