package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * A point light is a light source that has a position in space and a color
 *
 * @author Amiad Korman & Omer Dayan
 */
public class PointLight extends Light implements LightSource{
    /**
     * Light position in the scene.
     */
    private final Point position;
    /**
     * Constant attenuation factor.
     */
    private double Kc = 1d;
    /**
     * Light's attenuation factor.
     */
    private double Kl = 0d;
    /**
     * Quadratic attenuation factor.
     */
    private double Kq = 0d;

    /**
     * Constructor for PointLight class
     *
     * @param intensity The intensity of the PointLight
     */
    public PointLight(Color intensity, Point position) {
        super(intensity);
        this.position = position;
    }

    /**
     * Setter for the Kc field.
     *
     * @param kc Constant attenuation factor
     * @return The object itself.
     */
    public PointLight setKc(double kc) {
        this.Kc = kc;
        return this;
    }

    /**
     * Setter for the Kl field.
     *
     * @param kl Attenuation factor for the light source.
     * @return The object itself.
     */
    public PointLight setKl(double kl) {
        this.Kl = kl;
        return this;
    }

    /**
     * Setter for the Kq field.
     *
     * @param kq The attenuation factor.
     * @return The object itself.
     */
    public PointLight setKq(double kq) {
        this.Kq = kq;
        return this;
    }

    /**
     * Implementation of getIntensity from LightSource interface.
     *
     * @param point The origin of the light.
     * @return The intensity of the light.
     */
    @Override
    public Color getIntensity(Point point) {
        // Calculating the distance between the point
        // and the position of the light source.
        double distance = point.distance(position);
        double distanceSquared = point.distanceSquared(position);

        // Calculating the intensity of the light at a given point.
        double factor = (Kc + Kl*distance + Kq*distanceSquared);
        Color Ic = getIntensity();

        // Reducing the intensity of the light by the factor.
        return Ic.reduce(factor);
    }

    /**
     * Implementation og getL from LightSource interface.
     *
     * @param point Starting point.
     * @return The direction of the light
     */
    @Override
    public Vector getL(Point point) {
        return point.subtract(this.position).normalize();
    }

    /**
     * Returns the distance from the light source to the given point.
     *
     * @param point The point to which the distance is to be calculated.
     * @return The distance between the point and the light source.
     */
    @Override
    public double getDistance(Point point) {
        return this.position.distance(point);
    }
}
