package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * A spotLight is a point light with a direction and a narrow beam
 *
 * @author Amiad Korman & Omer Dayan
 */
public class SpotLight extends PointLight{
    /**
     * Light direction.
     */
    private final Vector direction;
    /**
     * Narrow beam factor.
     */
    private double narrowBeam = 1d;

    /**
     * Constructor
     *
     * @param intensity The intensity of the SpotLight
     * @param position The position of the SpotLight
     * @param direction The direction of the SpotLight
     */
    public SpotLight(Color intensity, Point position, Vector direction) {
        super(intensity, position);
        this.direction = direction.normalize();
    }

    /**
     * Setter for the narrowBeam field.
     *
     * @param narrowBeam The angle of the narrow beam in degrees.
     * @return The object itself.
     */
    public SpotLight setNarrowBeam(double narrowBeam) {
        this.narrowBeam = narrowBeam;
        return this;
    }

    /**
     * Getter for the narrowBeam field.
     *
     * @return The narrowBeam variable is being returned.
     */
    public double getNarrowBeam(){
        return this.narrowBeam;
    }

    /**
     * Implementation of getIntensity from LightSource interface.
     *
     * @param point The origin of the light.
     * @return The intensity of the light.
     */
    @Override
    public Color getIntensity(Point point) {
        // Calculating the intensity of the light source.
        Color Ic = super.getIntensity(point);
        double projection = getL(point).dotProduct(direction);

        double factor = Math.max(0, projection);

        // A way to make the light more focused.
        factor = Math.pow(factor, narrowBeam);

        // Scaling the intensity of the light source by the factor.
        return Ic.scale(factor);
    }

}
