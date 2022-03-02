package geometries;

import primitives.Point;

/**
 * A triangle is a polygon with three points
 */
public class Triangle extends Polygon implements Geometry{

    // Calling the constructor of the superclass Polygon.
    public Triangle(Point p1, Point p2,Point p3) {super(p1, p2, p3);
    }

}
