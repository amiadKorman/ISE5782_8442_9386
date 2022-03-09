package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    /**
     * Test method for {@link geometries.Plane#Plane(primitives.Point, primitives.Point, primitives.Point)}
     */
    @Test
    void testConstructor() {
        // =============== Boundary Values Tests ==================

        // TC01: First point = second point
        assertThrows(IllegalArgumentException.class, //
                () -> new Plane(
                        new Point(1, 0, 0),
                        new Point(1, 0, 0),
                        new Point(0, 1, 0)),
                "Constructed a plane with two points in the same place");

        // TC02: Points on the same vector
        assertThrows(IllegalArgumentException.class, //
                () -> new Plane(
                        new Point(1, 0, 0),
                        new Point(2, 0, 0),
                        new Point(3, 0, 0)),
                "Constructed a plane with all the points in the same vector");
    }

    /**
     * Test method for {@link geometries.Plane#getNormal(primitives.Point)}
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============//

        // TC01: tests for calculation of normal to the plane//
        Plane plane = new Plane(
                new Point(1, 0, 0),
                new Point(0, 1, 0),
                new Point(0, 0, 1));
        double sqrt3 = Math.sqrt(1d / 3); // the expected Normal

        //check the positive and negative direction of the normal//
        assertTrue(plane.getNormal().equals(new Vector(sqrt3, sqrt3, sqrt3)) ||
                plane.getNormal().scale(-1).equals(new Vector(sqrt3, sqrt3, sqrt3)),
                "ERROR: The calculation of normal to the plane is not calculated correctly");
    }
}