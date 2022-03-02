/**
 * A point is a point in 3D space
 */
package primitives;

import java.util.Objects;

/**
 * @author Amiad Korman & Omer Dayan
 */
public class Point {
    final protected Double3 _xyz;

    /**
     * Constructor to initialize Point based object with Double3 value
     *
     * @param xyz Double3 value
     */
    public Point(Double3 xyz) {
        _xyz = xyz;
    }

    /**
     * Constructor to initialize Point based object with its three number values
     *
     * @param x first number value
     * @param y second number value
     * @param z third number value
     */
    public Point(double x, double y, double z) {
        _xyz = new Double3(x, y, z);
    }

    /**
     * Given a point, return the distance squared between the point and this point
     *
     * @param point The point to which you are comparing this point.
     * @return The distance squared between the two points.
     */
    public double distanceSquared(Point point) {
        Double3 temp = _xyz.subtract(point._xyz);
        temp = temp.product(temp);

        return temp.d1 + temp.d2 + temp.d3;
    }

    /**
     * Given a point, return the distance between the point and this point
     *
     * @param point The point to measure the distance to.
     * @return The distance between the two points.
     */
    public double distance(Point point) {
        return Math.sqrt(distanceSquared(point));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return _xyz.equals(point._xyz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_xyz);
    }

    @Override
    public String toString() {
        return "Point " + _xyz;
    }

    /**
     * Add a vector to a point
     *
     * @param vector The vector to add to the point.
     * @return A new Point object.
     */
    public Point add(Vector vector) {
        return new Point(_xyz.add(vector._xyz));
    }

    /**
     * Given a point, return a vector that is the difference between the point and the current point
     *
     * @param point the point to subtract from this vector
     * @return A new Vector object.
     */
    public Vector subtract(Point point) {
        return new Vector(_xyz.subtract(point._xyz));
    }
}
