package primitives;

import java.util.Objects;

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
     * @param p0 point value
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
        return p0;
    }

    /**
     * Getter for the direction of the ray
     *
     * @return A Vector object.
     */
    public Vector getDir() {
        return dir;
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
