package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    /**
     * Test method for {@link geometries.Polygon#getNormal(primitives.Point)}.
     */
    @Test
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: tests for calculation of normal to the triangle
        Triangle pl = new Triangle(
                new Point(0, 0, 1),
                new Point(1, 0, 0),
                new Point(0, 1, 0));
        double sqrt3 = Math.sqrt(1d / 3);

        assertEquals(new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point(0, 0, 1)),
                "ERROR: The calculation of normal to the triangle is not calculated correctly");
    }

    @Test
    void allFindIntersectionality(){
        testFindIntersections1();
        testFindIntersections2();
        testFindIntersections3();
        testFindIntersections4();
        testFindIntersections5();
        testFindIntersections6();
    }

    /**
     *tests for {@link geometries.Triangle#findIntersections(primitives.Ray)}.
     */
    // ============ Equivalence Partitions Tests ==============
    //TC01: Inside polygon/triangle(1 Point)
    @Test
    void testFindIntersections1() {
        Triangle triangle = new Triangle(
                new Point(2, 0, 0),
                new Point(0, 3, 0),
                new Point(0, 0, 0));

        Ray ray = new Ray(new Point(0, 0, -1), new Vector(1, 1, 1));
        List<Point> result = triangle.findIntersections(ray);
        Point p1 = new Point(1, 1, 0);
        assertEquals(List.of(p1), result, "Inside polygon/triangle(1 Point)");
    }

    //TC02: Outside against edge(0 Point)
    @Test
    void testFindIntersections2() {
        Triangle triangle = new Triangle(
                new Point(2, 0, 0),
                new Point(0, 3, 0),
                new Point(0, 0, 0));
        Ray ray = new Ray(new Point(0, 0, -1), new Vector(2, 1, 1));
        assertNull(triangle.findIntersections(ray), "Outside against edge");
    }

    //TC03: Outside against vertex(0 Point)
    @Test
    void testFindIntersections3() {
        Triangle triangle = new Triangle(
                new Point(2, 0, 0),
                new Point(0, 3, 0),
                new Point(0, 0, 0));
        Ray ray = new Ray(new Point(0, 0, -1), new Vector(3, -0.5, 1));
        assertNull(triangle.findIntersections(ray), "Outside against vertex");
    }

    // =============== Boundary Values Tests ==================
    //****Three cases (the ray begins "before" the plane)**

    //TC11: On edge(0 Point)
    @Test
    void testFindIntersections4() {
        Triangle triangle = new Triangle(
                new Point(2, 0, 0),
                new Point(0, 3, 0),
                new Point(0, 0, 0));
        Ray ray = new Ray(new Point(0, 0, -1),new Vector(0, 1, 1));
        assertNull(triangle.findIntersections(ray), "On edge");
    }

    //TC12: In vertex(0 Point)
    @Test
    void testFindIntersections5() {
        Triangle triangle = new Triangle(
                new Point(2, 0, 0),
                new Point(0, 3, 0),
                new Point(0, 0, 0));
        Ray ray = new Ray(new Point(0, 0, -1), new Vector(0, 3, 1));
        assertNull(triangle.findIntersections(ray), "In vertex");
    }

    //TC13: On edge's continuation(0 Point)
    @Test
    void testFindIntersections6() {
        Triangle triangle = new Triangle(
                new Point(2, 0, 0),
                new Point(0, 3, 0),
                new Point(0, 0, 0));
        Ray ray6 = new Ray(new Point(0, 0, -1), new Vector(0, 4, 1));
        assertNull(triangle.findIntersections(ray6), "On edge's continuation");
    }

}