package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

/**
 *
 * @author Amiad Korman & Omer Dayan
 */
public abstract class RayTracerBase {
    protected Scene scene;

    protected RayTracerBase(Scene scene){
        this.scene = scene;
    }

    abstract Color traceRay(Ray ray);
}
