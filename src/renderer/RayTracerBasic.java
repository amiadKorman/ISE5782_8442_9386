package renderer;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import scene.Scene;

import java.util.List;

/**
 * The `RayTracerBasic` class is a `RayTracerBase` class
 *
 * @author Amiad Korman & Omer Dayan
 */
public class RayTracerBasic extends RayTracerBase {

    /**
     * Constructor for RayTracerBasic
     * @param scene
     */
    public RayTracerBasic(Scene scene) {
        super(scene);
    }

    /**
     * Given a ray, trace it through the scene and return the color of the pixel that it hits.
     *
     * @param ray The ray to trace.
     * @return A color object.
     */
    @Override
    Color traceRay(Ray ray) {
        List<Point> intersections = this.scene.getGeometries().findIntersections(ray);
        if (intersections != null) {
            Point closestPoint = ray.findClosestPoint(intersections);
            return calcColor(closestPoint);
        }
        else
            return this.scene.getBackground();
    }

    /**
     * Given a point, calculates and returns the color of this point
     *
     * @param point The point on the surface of the object that we're shading.
     * @return The ambient light intensity.
     */
    private Color calcColor(Point point) {
        return this.scene.getAmbientLight().getIntensity();
    }
}
