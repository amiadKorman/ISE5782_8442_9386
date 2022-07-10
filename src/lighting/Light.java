package lighting;

import primitives.Color;

/**
 * Light is an abstract class.
 *
 * @author Amiad Korman & Omer Dayan
 */
public abstract class Light {
    /**
     * Light color intensity.
     */
    private Color intensity;

    /**
     * Constructor for light class
     *
     * @param intensity
     */
    protected Light(Color intensity){
        this.intensity = intensity;
    }

    /**
     * Getter for the light intensity.
     *
     * @return The intensity of the light.
     */
    public Color getIntensity() {
        return intensity;
    }
}
