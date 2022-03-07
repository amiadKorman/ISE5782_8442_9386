package primitives;

/**
 * Vector is a line with direction and size
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Vector extends Point {
    /**
     * Constructor to initialize Vector based object with its three number values
     *
     * @param x first number value
     * @param y second number value
     * @param z third number value
     */
    public Vector(double x, double y, double z) {
        super(x, y, z);
        if (_xyz.equals(Double3.ZERO)) {
            throw new IllegalArgumentException("Vector(0,0,0) is not valid");
        }
    }

    /**
     * Constructor to initialize Vector based object with Double3 value
     *
     * @param xyz Double3 value
     */
    public Vector(Double3 xyz) {
        super(xyz);
        if (_xyz.equals(Double3.ZERO)) {
            throw new IllegalArgumentException("Vector(0,0,0) is not valid");
        }
    }

    /**
     * Add the vector to this vector and return the result
     *
     * @param vector The vector to add to this vector.
     * @return A new Vector object.
     */
    public Vector add(Vector vector) {
        return new Vector(_xyz.add(vector._xyz));
    }

    /**
     * This function takes a double and returns a new Vector with the xyz coordinates scaled by the double
     *
     * @param num The number to multiply the vector by.
     * @return A new Vector object.
     */
    public Vector scale(double num) {
        return new Vector(_xyz.scale(num));
    }

    /**
     * Given two vectors, return the dot product of the two vectors
     *
     * @param v the vector to be dotted with this vector.
     * @return The dot product of the two vectors.
     */
    public double dotProduct(Vector v) {
        double u1 = _xyz._d1;
        double u2 = _xyz._d2;

        double u3 = _xyz._d3;


        double v1 = v._xyz._d1;
        double v2 = v._xyz._d2;

        double v3 = v._xyz._d3;


        return (u1 * v1 + u2 * v2 + u3 * v3);
    }

    /**
     * Given two vectors, return the vector that is perpendicular to both
     *
     * @param v The vector to be crossed with this vector.
     * @return A new Vector object.
     */
    public Vector crossProduct(Vector v) {
        double u1 = _xyz._d1;
        double u2 = _xyz._d2;
        double u3 = _xyz._d3;

        double v1 = v._xyz._d1;
        double v2 = v._xyz._d2;
        double v3 = v._xyz._d3;

        return new Vector(u2 * v3 - u3 * v2, u3 * v1 - u1 * v3, u1 * v2 - u2 * v1);
    }

    /**
     * Returns the square of the length of the vector
     *
     * @return The length of the vector.
     */
    public double lengthSquared() {
        double u1 = _xyz._d1;
        double u2 = _xyz._d2;
        double u3 = _xyz._d3;

        return u1 * u1 + u2 * u2 + u3 * u3;
    }

    /**
     * Returns the length of the vector
     *
     * @return The length of the vector.
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * Given a vector, return a new vector with the same direction but with a length of 1
     *
     * @return The vector with the same direction but with a length of 1.
     */
    public Vector normalize() {
        double size = length();

        return new Vector(_xyz.reduce(size));
    }

    @Override
    public String toString() {
        return "Vector " + _xyz;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
