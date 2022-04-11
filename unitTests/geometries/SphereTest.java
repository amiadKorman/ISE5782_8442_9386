package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    Sphere sphere = new Sphere(new Point (1, 0, 0), 1d);
    Point p1 = new Point(0.0651530771650466, 0.355051025721682, 0);
    Point p2 = new Point(1.53484692283495, 0.844948974278318, 0);

    /**
     * Test method for {@link geometries.Sphere#getNormal(primitives.Point)}.
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: tests for calculation of normal to the sphere//
        Sphere sphere = new Sphere(new Point(0, 0, 0), 5);

        assertEquals(new Vector(0, 0, 1), sphere.getNormal(new Point(0, 0, 5)),
                "ERROR: The calculation of normal to the Sphere is not calculated correctly");
    }

    @Test
    void allFindIntersectionality(){
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
        testFindIntersections11();
        testFindIntersections12();
        testFindIntersections13();
        testFindIntersections14();
        testFindIntersections15();
        testFindIntersections16();
    }

    /**
     * Test methods for {@link geometries.Sphere#findIntersections(primitives.Ray)}.
     */
    @Test
    public void testFindIntersections1() {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is outside the sphere (0 points)
        assertNull(
                sphere.findIntersections(
                        new Ray(
                                new Point(-1, 0, 0),
                                new Vector(1, 1, 0))),
                "Ray's line out of sphere");
    }

    @Test
    public void testFindIntersections2(){
        // TC02: Ray starts before and crosses the sphere (2 points)
        List<Point> result = sphere.findIntersections(new Ray(new Point(-1, 0, 0),
                new Vector(3, 1, 0)));
        assertEquals(2, result.size(),
                "Wrong number of points");
        if (result.get(0).getX() > result.get(1).getX())
            result = List.of(result.get(1), result.get(0));
        assertEquals(List.of(p1, p2), result,
                "Ray crosses sphere");
    }

    @Test
    void testFindIntersections3(){
        // TC03: Ray starts inside the sphere (1 point)
        assertEquals(
                List.of(p2),
                sphere.findIntersections(
                        new Ray(
                                new Point(0.5, 0.5, 0),
                                new Vector(3, 1, 0))),
                "Ray from inside sphere");
    }


    @Test
    void testFindIntersections4(){
        // TC04: Ray starts after the sphere (0 points)
        assertNull(
                sphere.findIntersections(
                        new Ray(
                                new Point(2, 1, 0),
                                new Vector(3, 1, 0))),
                "Sphere behind Ray");
    }

    // =============== Boundary Values Tests ==================//

    // **** Group: Ray's line crosses the sphere (but not the center)

    @Test
    void testFindIntersections5(){
        // TC11: Ray starts at sphere and goes inside (1 points)
        assertEquals(
                List.of(
                        new Point(2, 0, 0)),
                sphere.findIntersections(
                        new Ray(
                                new Point(1, -1, 0),
                                new Vector(1, 1, 0))),
                "Ray from sphere inside");
    }


    @Test
    void testFindIntersections6(){
        // TC12: Ray starts at sphere and goes outside (0 points)
        assertNull(
                sphere.findIntersections(
                        new Ray(
                                new Point(2, 0, 0),
                                new Vector(1, 1, 0))),
                "Ray from sphere outside");
    }

    // **** Group: Ray's line goes through the center
    @Test
    void testFindIntersections7(){
        // TC13: Ray starts before the sphere (2 points)
        List<Point> result = sphere.findIntersections(
                new Ray(
                        new Point(1, -2, 0),
                        new Vector(0, 1, 0)));
        assertEquals(
                2,
                result.size(),
                "Wrong number of points");
        if (result.get(0).getY() > result.get(1).getY())
            result = List.of(result.get(1), result.get(0));
        assertEquals(
                List.of(
                        new Point(1, -1, 0),
                        new Point(1, 1, 0)),
                result,
                "Line through O, ray crosses sphere");
    }

    @Test
    void testFindIntersections8() {
        // TC14: Ray starts at sphere and goes inside (1 points)
        assertEquals(
                List.of(
                        new Point(1, 1, 0)),
                sphere.findIntersections(
                        new Ray(
                                new Point(1, -1, 0),
                                new Vector(0, 1, 0))),
                "Line through O, ray from and crosses sphere");
    }

    @Test
    void testFindIntersections9() {
        // TC15: Ray starts inside (1 points)
        assertEquals(
                List.of(
                        new Point(1, 1, 0)),
                sphere.findIntersections(
                        new Ray(
                                new Point(1, 0.5, 0),
                                new Vector(0, 1, 0))),
                "Line through O, ray from inside sphere");
    }

    @Test
    void testFindIntersections10(){
        // TC16: Ray starts at the center (1 points)
        assertEquals(
                List.of(
                        new Point(1, 1, 0)),
                sphere.findIntersections(
                        new Ray(
                                new Point(1, 0, 0),
                                new Vector(0, 1, 0))),
                "Line through O, ray from O");
    }

    @Test
    void testFindIntersections11(){
        // TC17: Ray starts at sphere and goes outside (0 points)
        assertNull(
                sphere.findIntersections(
                        new Ray(
                                new Point(1, 1, 0),
                                new Vector(0, 1, 0))),
                "Line through O, ray from sphere outside");
    }

    @Test
    void testFindIntersections12(){
        // TC18: Ray starts after sphere (0 points)
        assertNull(
                sphere.findIntersections(
                        new Ray(
                                new Point(1, 2, 0),
                                new Vector(0, 1, 0))),
                "Line through O, ray outside sphere");

    }

    // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
    @Test
    void testFindIntersections13(){
        // TC19: Ray starts before the tangent point
        assertNull(
                sphere.findIntersections(
                        new Ray(
                                new Point(0, 1, 0),
                                new Vector(1, 0, 0))),
                "Tangent line, ray before sphere");
    }

    @Test
    void testFindIntersections14(){
        // TC20: Ray starts at the tangent point
        assertNull(
                sphere.findIntersections(
                        new Ray(
                                new Point(1, 1, 0),
                                new Vector(1, 0, 0))),
                "Tangent line, ray at sphere");
    }


    @Test
    void testFindIntersections15(){
        // TC21: Ray starts after the tangent point
        assertNull(
                sphere.findIntersections(
                        new Ray(
                                new Point(2, 1, 0),
                                new Vector(1, 0, 0))),
                "Tangent line, ray after sphere");
    }

    // **** Group: Special cases
    @Test
    void testFindIntersections16(){
        // TC22: Ray's line is outside, ray is orthogonal to ray start to sphere's center line
        assertNull(
                sphere.findIntersections(
                        new Ray(
                                new Point(-1, 0, 0),
                                new Vector(0, 0, 1))),
                "Ray orthogonal to ray head -> O line");
    }

}