package renderer;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import scene.Scene;

import java.util.List;
import geometries.Intersectable.GeoPoint;

/**
 * This class used to trace rays for the rendering engine
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
        var intersections = scene.getGeometries().findGeoIntersections(ray);
        if (intersections == null) return scene.getBackground();
        GeoPoint closestPoint = ray.findClosestGeoPoint(intersections);
        return calcColor(closestPoint);
    }

    /**
     * It calculates the color of a given point on the scene
     *
     * @param gp The point on the geometry that we're calculating the color for.
     * @return The color of the point.
     */
    private Color calcColor(GeoPoint gp) {

        return scene.getAmbientLight().getIntensity()
                .add(gp.geometry.getEmission());
    }
}
