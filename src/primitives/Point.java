package primitives;

import java.util.Objects;

/**
 * class representing a Point in 3D space
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Point {
    public static final Point ZERO = new Point(0, 0, 0);
    final protected Double3 xyz;

    /**
     * Constructor to initialize Point based object with Double3 value
     *
     * @param xyz {@link Double3} value
     */
    public Point(Double3 xyz) {
        this.xyz = xyz;
    }

    /**
     * primary Constructor to initialize Point based object with its three number values
     *
     * @param x first number value
     * @param y second number value
     * @param z third number value
     */
    public Point(double x, double y, double z) {
        xyz = new Double3(x, y, z);
    }

    /**
     * Given a point, return the distance squared between the point and this point
     *
     * @param point The point to which you are comparing this point.
     * @return The distance squared between the two points.
     */
    public double distanceSquared(Point point) {
        Double3 temp = xyz.subtract(point.xyz);
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
        return xyz.equals(point.xyz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xyz);
    }

    @Override
    public String toString() {
        return "Point " + xyz;
    }

    /**
     * Add a vector to a point
     *
     * @param vector The vector to add to the point.
     * @return A new Point object.
     */
    public Point add(Vector vector) {
        return new Point(xyz.add(vector.xyz));
    }

    /**
     * Given a point, return a vector that is the difference between the point and the current point
     *
     * @param point the point to subtract from this vector
     * @return A new {@link Vector} object.
     */
    public Vector subtract(Point point) {
        return new Vector(xyz.subtract(point.xyz));
    }

    /**
     * Returns the x coordinate of the point
     *
     * @return The value of the x coordinate.
     */
    public double getX(){
        return xyz.d1;
    }

    /**
     * Returns the y coordinate of the point
     *
     * @return The value of the y coordinate.
     */
    public double getY(){
        return xyz.d2;
    }

    /**
     * Returns the z coordinate of the point
     *
     * @return The value of the z coordinate.
     */
    public double getZ(){
        return xyz.d3;
    }
}
