package geometries;

import primitives.Vector;

/**
 * Marker interface for Flat geometry(polygon, plane, triangle)
 *
 * @author Amiad Korman & Omer Dayan
 */
public abstract class FlatGeometry extends Geometry {
    /**
     * Normal vector of the geometry
     */
    protected Vector normal;
}
