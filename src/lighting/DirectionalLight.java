package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;


/**
 * A directional light is a light that has a direction and an intensity
 *
 * @author Amiad Korman & Omer Dayan
 */
public class DirectionalLight extends Light implements LightSource{
    /**
     * Light direction.
     */
    private Vector direction;

    /**
     * Constructor for DirectionalLight class
     *
     * @param intensity The intensity of the color
     * @param direction The direction of DirectionalLight
     */
    public DirectionalLight(Color intensity, Vector direction) {
        super(intensity);
        this.direction = direction.normalize();
    }

    /**
     * Implementation of getIntensity from LightSource interface.
     *
     * @param point The origin of the light.
     * @return The intensity of the light.
     */
    @Override
    public Color getIntensity(Point point) {
        return getIntensity();
    }

    /**
     * Implementation og getL from LightSource interface.
     *
     * @param point Starting point.
     * @return The direction of the light
     */
    @Override
    public Vector getL(Point point) {
        return this.direction;
    }

    /**
     * Returns the distance from the light source to the given point.
     *
     * @param point The point to which the distance is to be calculated.
     * @return The distance between the point and the light source.
     */
    @Override
    public double getDistance(Point point) {
        return Double.POSITIVE_INFINITY;
    }
}
