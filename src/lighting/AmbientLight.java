package lighting;

import primitives.*;

/**
 * Ambient Light for all objects in 3D space
 *
 * @author Amiad Korman & Omer Dayan
 */
public class AmbientLight {
    private final Color intensity;  // intensity of ambient light

    /**
     * default constructor
     */
    public AmbientLight() {
        this.intensity = Color.BLACK;
    }

    /**
     * Constructor
     * @param Ia Light illumination
     * @param Ka Light factor
     */
    public AmbientLight(Color Ia, Double3 Ka) {
        this.intensity = Ia.scale(Ka);
    }

    /**
     * getter for intensity field
     *
     * @return The intensity of the light.
     */
    public Color getIntensity() {
        return this.intensity;
    }
}
