package geometries;

import primitives.*;

// Defining a new type called `Geometry`.
public interface Geometry {
    Vector getNormal(Point point);
}
