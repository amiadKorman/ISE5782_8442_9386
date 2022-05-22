package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * Interface for all light sources
 *
 * @author Amiad Korman & Omer Dayan
 */
public interface LightSource {

    /**
     * Given a point, return the intensity of the light at that point.
     *
     * @param p The origin of the light.
     * @return The intensity of the light.
     */
    public Color getIntensity(Point p);

    /**
     * Given a point, return the light direction vector
     *
     * @param p Starting point.
     * @return The direction of the light
     */
    public Vector getL(Point p);

    /**
     * Returns the distance from the light source to the given point.
     *
     * @param point The point to which the distance is to be calculated.
     * @return The distance between the point and the light source.
     */
    double getDistance(Point point);
}
