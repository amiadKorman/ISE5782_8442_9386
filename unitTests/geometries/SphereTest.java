package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    private Intersectable Sphere;
    Sphere sphere = new Sphere(new Point (1, 0, 0), 1d);

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
    }

    /**
     * Test methods for {@link geometries.Sphere#findIntersections(primitives.Ray)}.
     */
    @Test
    public void testFindIntersections1() {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is outside the sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point(-1, 0, 0), new Vector(1, 1, 0))),
                "Ray's line out of sphere");
    }

    @Test
    public void testFindIntersections2(){
        // TC02: Ray starts before and crosses the sphere (2 points)
        Point p1 = new Point(0.0651530771650466, 0.355051025721682, 0);
        Point p2 = new Point(1.53484692283495, 0.844948974278318, 0);
        List<Point> result = sphere.findIntersections(new Ray(new Point(-1, 0, 0),
                new Vector(3, 1, 0)));
        assertEquals(2, result.size(),
                "Wrong number of points");
        if (result.get(0).getX() > result.get(1).getX())
            result = List.of(result.get(1), result.get(0));
        assertEquals(List.of(p1, p2), result,
                "Ray crosses sphere");

        // =============== Boundary Values Tests ==================

        // **** Group: Ray's line crosses the sphere (but not the center)
        // TC11: Ray starts at sphere and goes inside (1 points)
        // TC12: Ray starts at sphere and goes outside (0 points)

        // **** Group: Ray's line goes through the center
        // TC13: Ray starts before the sphere (2 points)
        // TC14: Ray starts at sphere and goes inside (1 points)
        // TC15: Ray starts inside (1 points)
        // TC16: Ray starts at the center (1 points)
        // TC17: Ray starts at sphere and goes outside (0 points)
        // TC18: Ray starts after sphere (0 points)

        // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        // TC20: Ray starts at the tangent point
        // TC21: Ray starts after the tangent point

        // **** Group: Special cases
        // TC19: Ray's line is outside, ray is orthogonal to ray start to sphere's center line

    }

    @Test
    void findIntersections3(){
        // TC03: Ray starts inside the sphere (1 point)
        Ray ray = new Ray( new Point(0.5,0,0),new Vector(1.5,0,0));
        assertEquals(List.of(new Point(2,0,0)), Sphere.findIntersections(ray));
    }


    @Test
    void findIntersections4(){
        // TC04: Ray starts after the sphere (0 points)
        Ray ray = new Ray(new Point(3,0,0), new Vector(1,0,0));
        assertNull(Sphere.findIntersections(ray));
    }

    // =============== Boundary Values Tests ==================//

    // **** Group: Ray's line crosses the sphere (but not the center)

    @Test
    void findIntersections5(){
        // TC11: Ray starts at sphere and goes inside (1 points)
        Ray ray = new Ray(new Point(0,0,0), new Vector(2,2,0));
        assertEquals(List.of(new Point(1,1,0)) ,Sphere.findIntersections(ray));
    }


    @Test
    void findIntersections6(){
        // TC12: Ray starts at sphere and goes outside (0 points)
        Ray ray = new Ray(new Point(1,1,0), new Vector(2,2,0));
        assertNull(Sphere.findIntersections(ray));
    }

    // **** Group: Ray's line goes through the center
    @Test
    void findIntersections7(){
        // TC13: Ray starts before the sphere (2 points)
        Ray ray = new Ray(new Point(0,-2,0), new Vector(2,2,0));
        var result = Sphere.findIntersections(ray);
        assertEquals(2, result.size());
    }


    @Test
    void findIntersections8() {
        // TC14: Ray starts at sphere and goes inside (1 points)
        Ray ray = new Ray(new Point(2, 0, 0), new Vector(-1, 0, 0));
        assertEquals(List.of(new Point(0, 0, 0)), Sphere.findIntersections(ray));
    }

    @Test
    void findIntersections9() {
        // TC15: Ray starts inside (1 points)
        Ray ray = new Ray( new Point(0.59, 0, 0), new Vector(-0.59, 0, 0));
        assertEquals(List.of(new Point(0, 0, 0)), Sphere.findIntersections(ray));
    }

    @Test
    void findIntersections10(){
        // TC16: Ray starts at the center (1 points)
        Ray ray = new Ray(new Point(1,0,0), new Vector(2,2,0));
        assertThrows(IllegalArgumentException.class, ()-> Sphere.findIntersections(ray));
    }

    @Test
    void findIntersections11(){
        // TC17: Ray starts at sphere and goes outside (0 points)
        Ray ray = new Ray(new Point(2,0,0), new Vector(2,0,0));
        assertNull(Sphere.findIntersections(ray));
    }

    @Test
    void findIntersections12(){
        // TC18: Ray starts after sphere (0 points)
        Ray ray = new Ray (new Point(3,0,0), new Vector(1,0,0));
        assertNull(Sphere.findIntersections(ray));
    }

    // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
    @Test
    void findIntersections13(){
        // TC19: Ray starts before the tangent point
        Ray ray = new Ray( new Point(2,1,1), new Vector(-1,-1,0));
        assertNull(Sphere.findIntersections(ray));
    }

    @Test
    void findIntersections14(){
        // TC20: Ray starts at the tangent point
        Ray ray = new Ray(new Point(1,0,1), new Vector(1,1,0));
        assertNull(Sphere.findIntersections(ray));
    }


    @Test
    void findIntersections15(){
        // TC21: Ray starts after the tangent point
        Ray ray = new Ray(new Point(2,1,1), new Vector(4,4,0));
        assertNull(Sphere.findIntersections(ray));
    }

    // **** Group: Special cases
    @Test
    void findIntersections16(){
        // TC22: Ray's line is outside, ray is orthogonal to ray start to sphere's center line
        Ray ray = new Ray(new Point(3,0,0), new Vector(0,0,1));
        assertNull(Sphere.findIntersections(ray));
    }

}