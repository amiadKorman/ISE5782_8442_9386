package primitives;

import java.util.Objects;

import static primitives.Util.isZero;

/**
 * Ray is a line that starts in specific point
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Ray {
    private final Point _p0;
    private final Vector _dir;

    /**
     * Constructor to initialize Ray based object with its point value and vector value
     *
     * @param p0 point value
     * @param dir vector value
     */
    public Ray(Point p0, Vector dir) {
        this._p0 = p0;
        this._dir = dir.normalize();
    }

    /**
     * Getter for the value of the p0 field
     *
     * @return The xyz coordinates of the point p0.
     */
    public Point getP0() {
        return _p0;
    }

    /**
     * Getter for the direction of the ray
     *
     * @return A Vector object.
     */
    public Vector getDir() {
        return _dir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return Objects.equals(_p0, ray._p0) && Objects.equals(_dir, ray._dir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_p0, _dir);
    }

    @Override
    public String toString() {
        return "Ray{" + _p0 + _dir + '}';
    }

    /**
     *
     * get Point at specific distance in the ray direction
     *
     * @param t distance for reaching new Point
     * @return new {@link Point}
     */
    public Point getPoint(double t) {
        if(isZero(t)){
            throw new IllegalArgumentException("t equal 0 cause illegal Vector ZERO");
        }
        return _p0.add(_dir.scale(t));
    }
}
