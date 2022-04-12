package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

/**
 * The `RayTracerBasic` class is a `RayTracerBase` class that does nothing
 *
 * @author Amiad Korman & Omer Dayan
 */
public class RayTracerBasic extends RayTracerBase {
    public RayTracerBasic(Scene scene) {
        super(scene);
    }

    @Override
    Color traceRay(Ray ray) {
        return null;
    }
}
