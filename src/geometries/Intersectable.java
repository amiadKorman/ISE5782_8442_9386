package geometries;

import primitives.*;

import java.util.List;

/**
 *  Interface for finding intersections points
 *
 *  @author Amiad Korman & Omer Dayan
 */
public interface Intersectable {
    /**
     * Returns all the intersections of ray with geometry shape
     *
     * @param ray {@link Ray} pointing toward the object
     * @return List of intersection {@link Point}s
     */
    List<Point> findIntersections(Ray ray);
}
