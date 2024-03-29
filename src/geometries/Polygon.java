package geometries;

import java.util.List;

import primitives.*;
import static primitives.Util.*;

/**
 * Polygon class represents two-dimensional polygon in 3D Cartesian coordinate
 * system
 * 
 * @author Dan
 */
public class Polygon extends FlatGeometry {
	/**
	 * List of polygon's vertices
	 */
	protected final List<Point> vertices;
	/**
	 * Associated plane in which the polygon lays
	 */
	protected final Plane plane;

	/**
	 * Polygon constructor based on vertices list. The list must be ordered by edge
	 * path. The polygon must be convex.
	 * 
	 * @param vertices list of vertices according to their order by edge path
	 * @throws IllegalArgumentException in any case of illegal combination of
	 *                                  vertices:
	 *                                  <ul>
	 *                                  <li>Less than 3 vertices</li>
	 *                                  <li>Consequent vertices are in the same
	 *                                  point
	 *                                  <li>The vertices are not in the same
	 *                                  plane</li>
	 *                                  <li>The order of vertices is not according
	 *                                  to edge path</li>
	 *                                  <li>Three consequent vertices lay in the
	 *                                  same line (180&#176; angle between two
	 *                                  consequent edges)
	 *                                  <li>The polygon is concave (not convex)</li>
	 *                                  </ul>
	 */
	public Polygon(Point... vertices) {
		if (vertices.length < 3)
			throw new IllegalArgumentException("A polygon can't have less than 3 vertices");
		this.vertices = List.of(vertices);
		// Generate the plane according to the first three vertices and associate the
		// polygon with this plane.
		// The plane holds the invariant normal (orthogonal unit) vector to the polygon
		this.plane = new Plane(vertices[0], vertices[1], vertices[2]);
		this.normal = this.plane.getNormal();

		if (vertices.length == 3)
			return; // no need for more tests for a Triangle

		// Subtracting any subsequent points will throw an IllegalArgumentException
		// because of Zero Vector if they are in the same point
		Vector edge1 = vertices[vertices.length - 1].subtract(vertices[vertices.length - 2]);
		Vector edge2 = vertices[0].subtract(vertices[vertices.length - 1]);

		// Cross Product of any subsequent edges will throw an IllegalArgumentException
		// because of Zero Vector if they connect three vertices that lay in the same
		// line.
		// Generate the direction of the polygon according to the angle between last and
		// first edge being less than 180 deg. It is hold by the sign of its dot product
		// with
		// the normal. If all the rest consequent edges will generate the same sign -
		// the
		// polygon is convex ("kamur" in Hebrew).
		boolean positive = edge1.crossProduct(edge2).dotProduct(this.normal) > 0;
		for (var i = 1; i < vertices.length; ++i) {
			// Test that the point is in the same plane as calculated originally
			if (!isZero(vertices[i].subtract(vertices[0]).dotProduct(this.normal)))
				throw new IllegalArgumentException("All vertices of a polygon must lay in the same plane");
			// Test the consequent edges have
			edge1 = edge2;
			edge2 = vertices[i].subtract(vertices[i - 1]);
			if (positive != (edge1.crossProduct(edge2).dotProduct(this.normal) > 0))
				throw new IllegalArgumentException("All vertices must be ordered and the polygon must be convex");
		}
	}

	@Override
	public String toString() {
		return "Polygon{" +
				"vertices=" + this.vertices +
				", plane=" + this.plane +
				'}';
	}

	/**
	 * implementation of getNormal from Geometry
	 *
	 * @param point The point on the polygon's surface.
	 * @return normal vector to the sphere in point
	 */
	@Override
	public Vector getNormal(Point point) {
		return this.normal;
	}

	/**
	 * Finds the intersection points of the ray with the surface of the object
	 *
	 * @param ray The ray to intersect with the GeoPoint.
	 * @param maxDistance The maximum distance from the source of the ray to intersect with.
	 * @return A list of GeoPoints that are the intersections of the ray with the object.
	 */
	@Override
	protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray, double maxDistance) {
		List<GeoPoint> intersections = this.plane.findGeoIntersections(ray, maxDistance);

		// if there is no Intersections at all in the plane
		if (intersections == null)
			return null;

		int numOfVertices = vertices.size();
		Point p0 = ray.getP0();
		Vector dir = ray.getDir();

		Vector v1 = vertices.get(numOfVertices - 1).subtract(p0);
		Vector v2 = vertices.get(0).subtract(p0);

		Vector n = v1.crossProduct(v2).normalize();
		double vn = dir.dotProduct(n);
		boolean positive = vn > 0;

		if (isZero(vn))
			return null;

		for (int i = 1; i < numOfVertices; ++i) {
			v1 = v2;
			v2 = vertices.get(i).subtract(p0);
			n = v1.crossProduct(v2).normalize();
			vn = dir.dotProduct(n);

			//no intersection
			if (isZero(vn))
				return null;

			//not the same sign
			if (vn > 0 != positive)
				return null;
		}

		return List.of(new GeoPoint(this, intersections.get(0).point));
	}

}
