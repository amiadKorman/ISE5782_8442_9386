package geometries;

import primitives.*;

import java.util.List;
import java.util.Objects;

/**
 *  Interface for finding intersections points
 *
 *  @author Amiad Korman & Omer Dayan
 */
public abstract class Intersectable {

    /**
     * This class represent geometric body and point in it.
     */
    public static class GeoPoint{

        public final Geometry geometry;
        public final Point point;

        /**
         * Constructor for GeoPoint
         *
         * @param geometry
         * @param point
         */
        public GeoPoint(Geometry geometry, Point point){
            this.geometry = geometry;
            this.point = point;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GeoPoint geoPoint = (GeoPoint) o;
            return geometry.equals(geoPoint.geometry) && point.equals(geoPoint.point);
        }

        @Override
        public int hashCode() {
            return Objects.hash(geometry, point);
        }

        @Override
        public String toString() {
            return "GeoPoint{" +
                    "geometry=" + geometry +
                    ", point=" + point +
                    '}';
        }
    }

    /**
     * Returns all the intersections of ray with geometry shape
     *
     * @param ray {@link Ray} pointing toward the object
     * @return List of intersection {@link Point}s
     */
    public final List<Point> findIntersections(Ray ray) {
        var geoList = findGeoIntersections(ray);
        return geoList == null ? null
                : geoList.stream()
                .map(gp -> gp.point)
                .toList();
    }

    /**
     * This function returns a list of all the intersections of the ray with the geometry of the scene
     *
     * @param ray The ray to find intersections with.
     * @return A list of GeoPoints.
     */
    public List<GeoPoint> findGeoIntersections(Ray ray){
        return findGeoIntersectionsHelper(ray);
    }

    /**
     * Finds the intersection points of the ray with the surface of the object
     *
     * @param ray The ray to intersect with the GeoPoint.
     * @return A list of GeoPoints that are the intersections of the ray with the object.
     */
    protected abstract List<GeoPoint> findGeoIntersectionsHelper(Ray ray);
}
