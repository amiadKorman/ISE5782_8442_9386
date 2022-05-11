package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource{

    private Vector direction;

    /**
     * Constructor for DirectionalLight class
     *
     * @param intensity The intensity of the color
     */
    public DirectionalLight(Color intensity, Vector direction) {
        super(intensity);
        this.direction = direction.normalize();
    }

    /**
     * Given a point, return the intensity of the light at that point.
     *
     * @param p The origin of the light.
     * @return The intensity of the light.
     */
    @Override
    public Color getIntensity(Point p) {
        return getIntensity();
    }

    /**
     * Given a point, return the light direction vector
     *
     * @param p Starting point.
     * @return The direction of the light
     */
    @Override
    public Vector getL(Point p) {
        return this.direction;
    }
}
