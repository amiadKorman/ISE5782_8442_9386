package primitives;

import java.util.Objects;

/**
 * @author Amiad Korman & Omer Dayan
 */
public class Ray {
    private final Point p0;
    private final Vector dir;

    /**
     * Constructor to initialize Ray based object with its point value and vector value
     *
     * @param p0 point value
     * @param dir vector value
     */
    public Ray(Point p0, Vector dir) {
        this.p0 = p0;
        this.dir = dir.normalize();
    }

    /**
     * Returns the value of the p0 field
     *
     * @return The xyz coordinates of the point p0.
     */
    public Double3 getP0() {
        return p0._xyz;
    }

    /**
     * Returns the direction of the ray
     *
     * @return A Double3 object.
     */
    public Double3 getDir() {
        return dir._xyz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return Objects.equals(p0, ray.p0) && Objects.equals(dir, ray.dir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p0, dir);
    }

    @Override
    public String toString() {
        return "Ray{" + p0 + dir + '}';
    }
}
