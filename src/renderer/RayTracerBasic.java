package renderer;

import lighting.LightSource;
import primitives.*;
import scene.Scene;

import java.util.List;

import geometries.Intersectable.GeoPoint;

import static primitives.Util.alignZero;

/**
 * This class used to trace rays for the rendering engine
 *
 * @author Amiad Korman & Omer Dayan
 */
public class RayTracerBasic extends RayTracerBase {

    /**
     * DELTA value to move the point away from original point
     */
    private static final double DELTA = 0.1;

    /**
     * Constructor for RayTracerBasic
     *
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
        if (intersections == null) {
            return scene.getBackground();
        }
        GeoPoint closestPoint = ray.findClosestGeoPoint(intersections);
        return calcColor(closestPoint, ray);
    }

    /**
     * Calculates the color of a given point on the scene
     *
     * @param gp The point on the geometry that we're calculating the color for.
     * @return The color of the point.
     */
    private Color calcColor(GeoPoint gp, Ray ray) {
        return scene.getAmbientLight().getIntensity()
                .add(calcLocalEffects(gp, ray));
    }

    /**
     * Calculates local effects of light sources on a certain point
     *
     * @param gp The intersection point
     * @param ray the ray that hit the geometry
     * @return The color of the point.
     */
    private Color calcLocalEffects(GeoPoint gp, Ray ray) {
        Color color = gp.geometry.getEmission();
        Vector v = ray.getDir();
        Vector n = gp.geometry.getNormal(gp.point);

        double nv = alignZero(n.dotProduct(v));

        // This is a check to see if the ray is hitting the geometry from the inside.
        if (nv == 0)
            return color;

        Material material = gp.geometry.getMaterial();

        // Calculates the color of a point on a surface,
        // by adding the emission of the surface to the sum of
        // the diffuse and specular colors of the surface
        for (LightSource lightSource : scene.getLights()) {
            Vector l = lightSource.getL(gp.point);
            double nl = alignZero(n.dotProduct(l));
            if (nl * nv > 0) { // sign(nl) == sing(nv)
                if(unshaded(gp, lightSource, l, n, nl)) {
                    Color iL = lightSource.getIntensity(gp.point);
                    color = color.add(iL.scale(calcDiffusive(material, nl)),
                            iL.scale(calcSpecular(material, n, l, nl, v)));
                }
            }
        }

        return color;
    }

    /**
     * Calculate the specular component of the light reflected from the surface of the object.
     *
     * @param material the material of the object
     * @param n        normal vector
     * @param l        direction from light to point
     * @param nl       dot-product of the normal vector and the light vector
     * @param v        view vector
     * @return The specular component factor.
     */
    private Double3 calcSpecular(Material material, Vector n, Vector l, double nl, Vector v) {
        Vector r = l.add(n.scale(-2 * nl)); // nl must be not zero!
        double minusVR = -alignZero(r.dotProduct(v));
        if (minusVR <= 0)
            return Double3.ZERO; // view from direction opposite to r vector
        return material.getKs().scale(Math.pow(minusVR, material.getShininess()));
    }

    /**
     * Calculates Diffusive component of light reflection
     *
     * @param material The material of the object that the ray hit.
     * @param nl       the dot-product of the normal and the light direction
     * @return The diffuse component factor.
     */
    private Double3 calcDiffusive(Material material, double nl) {
        nl = Math.abs(nl);
        return material.getKd().scale(nl);
    }


    /**
     * If the ray from the point to the light source intersects with any other geometry, then the point is shaded
     *
     * @param gp The point on the geometry that we're shading
     * @param lightSource The light source that we're checking if it's shaded or not.
     * @param l The vector from the point to the light source
     * @param n the normal vector of the point
     * @param nv the dot product of the normal vector and the vector from the camera to the point
     * @return true if the point is unshaded, and false if it is shaded.
     */
    private boolean unshaded(GeoPoint gp, LightSource lightSource, Vector l, Vector n, double nv){
        Vector lightDirection = l.scale(-1); // from point to light source
        double nl = n.dotProduct(lightDirection);

        // This is a vector that is used to move the point away from the surface of the geometry.
        Vector deltaVector = n.scale(nl > 0 ? DELTA : -DELTA);

        // This is a ray that is sent from the point to the light source.
        Ray lightRay = new Ray(gp.point.add(deltaVector),lightDirection);

        // Calculates the maximum distance from the ray to the surface
        double maxDistance = lightSource.getDistance(gp.point);

        // Get the intersections
        List<GeoPoint> intersections = scene.getGeometries().findGeoIntersections(lightRay, maxDistance);

        return intersections == null;
    }

}
