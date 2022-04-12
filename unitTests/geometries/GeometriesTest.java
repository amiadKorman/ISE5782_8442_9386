package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.*;

class GeometriesTest {

    Sphere sph = new Sphere(new Point(1, 1, 1), 1);
    Plane plane = new Plane(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 2));
    Triangle tr = new Triangle(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));
    Geometries collection = new Geometries(sph, plane, tr);

    /**
     * Test methods for {@link geometries.Geometries#findIntersections(primitives.Ray)}.
     */
    @Test
    void allFindIntersectionality() {
        testFindIntersections1();
        testFindIntersections2();
        testFindIntersections3();
        testFindIntersections4();
        testFindIntersections5();
    }

    // ============ Equivalence Partitions Tests ==============

    // TC01: Some Geometries are intersected
    @Test
    void testFindIntersections1() {
        Ray ray = new Ray(
                new Point(-1, 0, 0),
                new Vector(1, 1, 1)
        );
        assertEquals(
                3,
                collection.findIntersections(ray).size()
                , "Wrong number of intersection points");
    }

    // =============== Boundary Values Tests ==================//

    // TC11: All Geometries are intersected
    @Test
    void testFindIntersections2() {
        Ray ray = new Ray(
                new Point(2, 2, 2.5),
                new Vector(-1, -1, -1)
        );
        assertEquals(
                4,
                collection.findIntersections(ray).size()
                , "Wrong number of intersection points");
    }

    // TC12: Only one Geometry are intersected
    @Test
    void testFindIntersections3() {
        Ray ray = new Ray(
                new Point(2, 0, 2),
                new Vector(-1, -1, -1)
        );
        assertEquals(1, collection.findIntersections(ray).size()
                , "Wrong number of intersection points");
    }

    // TC13: No Geometries are intersected
    @Test
    void testFindIntersections4() {
        Ray ray = new Ray(
                new Point(-1, 0, 0),
                new Vector(-1, -1, -1)
        );
        assertNull(
                collection.findIntersections(ray),
                "No intersection points");
    }

    // TC14: Empty Geometries collection
    @Test
    void testFindIntersections5() {
        collection = new Geometries();
        assertNull(
                collection.findIntersections(
                        new Ray(
                                new Point(-1, 0, 0),
                                new Vector(1, 1, 0)))
                , "No geometry shapes in the collection");
    }

}