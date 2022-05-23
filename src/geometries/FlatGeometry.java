package geometries;

import primitives.Vector;

/**
 * marker interface for Flat geometry(polygon, plane, triangle)
 */
public abstract class FlatGeometry extends Geometry {
    protected Vector normal;
}
