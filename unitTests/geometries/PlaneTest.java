package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {
    Plane pl = new Plane(new Point(0, 0, 1), new Vector(1, 1, 1));

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

    /**
     * Test methods for {@link geometries.Plane#findIntersections(primitives.Ray)}
     */
    @Test
    void allFindIntersectionality() {
        testFindIntersections1();
        testFindIntersections2();
        testFindIntersections3();
        testFindIntersections4();
        testFindIntersections5();
        testFindIntersections6();
        testFindIntersections7();
        testFindIntersections8();
        testFindIntersections9();
        testFindIntersections10();
    }

    // ============ Equivalence Partitions Tests ==============

    // TC01: Ray into plane
    @Test
    void testFindIntersections1() {
        assertEquals(
                List.of(
                        new Point(1, 0, 0)),
                pl.findIntersections(
                        new Ray(
                                new Point(0.51, 0, 0),
                                new Vector(1, 0, 0))),
                "Bad plane intersection");
    }

    // TC02: Ray out of plane
    @Test
    void testFindIntersections2() {
        assertNull(
                pl.findIntersections(
                        new Ray(
                                new Point(2, 0, 0),
                                new Vector(1, 0, 0))),
                "Must not be plane intersection");
    }

    // =============== Boundary Values Tests ==================

    // TC11: Ray parallel to plane
    @Test
    void testFindIntersections3() {
        assertNull(
                pl.findIntersections(
                        new Ray(
                                new Point(1, 1, 1),
                                new Vector(0, 1, -1))),
                "Must not be plane intersection");
    }

    // TC12: Ray in plane
    @Test
    void testFindIntersections4() {
        assertNull(
                pl.findIntersections(
                        new Ray(
                                new Point(0, 0.5, .5),
                                new Vector(0, 1, -1))),
                "Must not be plane intersection");
    }

    // TC13: Orthogonal ray into plane
    @Test
    void testFindIntersections5() {
        assertEquals(
                List.of(
                        new Point(1d / 3, 1d / 3, 1d / 3)),
                pl.findIntersections(
                        new Ray(
                                new Point(1, 1, 1),
                                new Vector(-1, -1, -1))),
                "Bad plane intersection");
    }

    // TC14: Orthogonal ray out of plane
    @Test
    void testFindIntersections6() {
        assertNull(
                pl.findIntersections(
                        new Ray(
                                new Point(1, 1, 1),
                                new Vector(1, 1, 1))),
                "Must not be plane intersection");
    }

    // TC15: Orthogonal ray out of plane
    @Test
    void testFindIntersections7() {
        assertNull(
                pl.findIntersections(
                        new Ray(
                                new Point(1, 1, 1),
                                new Vector(1, 1, 1))),
                "Must not be plane intersection");
    }

    // TC16: Orthogonal ray from plane
    @Test
    void testFindIntersections8() {
        assertNull(
                pl.findIntersections(
                        new Ray(
                                new Point(0, 0.5, 0.5),
                                new Vector(1, 1, 1))),
                "Must not be plane intersection");
    }

    // TC17: Ray from plane
    @Test
    void testFindIntersections9() {
        assertNull(
                pl.findIntersections(
                        new Ray(
                                new Point(0, 0.5, 0.5),
                                new Vector(1, 1, 0))),
                "Must not be plane intersection");
    }

    // TC18: Ray from plane's Q point
    @Test
    void testFindIntersections10() {
        assertNull(
                pl.findIntersections(
                        new Ray(
                                new Point(0, 0, 1),
                                new Vector(1, 1, 0))),
                "Must not be plane intersection");
    }

}