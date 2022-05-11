package lighting;

import primitives.*;

/**
 * Ambient Light for all objects in 3D space
 *
 * @author Amiad Korman & Omer Dayan
 */
public class AmbientLight extends Light {

    /**
     * default constructor
     */
    public AmbientLight() {
        super(Color.BLACK);
    }

    /**
     * Constructor
     * @param Ia Light illumination
     * @param Ka Light factor
     */
    public AmbientLight(Color Ia, Double3 Ka) {
        super(Ia.scale(Ka));
    }

}
