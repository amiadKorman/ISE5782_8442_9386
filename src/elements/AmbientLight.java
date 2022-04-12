package elements;

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
        intensity = Color.BLACK;
    }

    /**
     * Constructor
     * @param Ia Light illumination
     * @param Ka Light factor
     */
    public AmbientLight(Color Ia, Double3 Ka) {
        intensity = Ia.scale(Ka);
    }

    /**
     * getter for intensity
     *
     * @return The intensity of the light.
     */
    public Color getIntensity() {
        return intensity;
    }
}
