package scene;

import lighting.AmbientLight;
import geometries.Geometries;
import lighting.Light;
import lighting.LightSource;
import primitives.Color;

import java.util.LinkedList;
import java.util.List;

/**
 * Scene class
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Scene {

    private final String name;
    private final Color background;
    private AmbientLight ambientLight;
    private final Geometries geometries;
    private final List<LightSource> lights;

    /**
     * @param builder
     * @param lights
     */
    private Scene(SceneBuilder builder, List<LightSource> lights) {
        this.name = builder.name;
        this.background = builder.background;
        this.ambientLight = builder.ambientLight;
        this.geometries = builder.geometries;
        this.lights = builder.lights;
    }

    /**
     * Getter for the name of the scene.
     *
     * @return The name of the scene.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the background of the scene.
     *
     * @return The background color of the scene.
     */
    public Color getBackground() {
        return this.background;
    }

    /**
     * Getter for the ambient light of the scene.
     *
     * @return The ambient light.
     */
    public AmbientLight getAmbientLight() {
        return this.ambientLight;
    }

    /**
     * Getter for the geometries structures in the scene.
     *
     * @return The geometries object.
     */
    public Geometries getGeometries() {
        return this.geometries;
    }

    /**
     * Getter for the lights in the scene.
     *
     * @return The lights.
     */
    public List<LightSource> getLights() {
        return this.lights;
    }

    public void setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
    }

    /**
     * inner class SceneBuilder builds Scene object using builder pattern
     */
    public static class SceneBuilder {

        private final String name;
        private List<LightSource> lights  = new LinkedList<>();
        private Color background = Color.BLACK;;
        private AmbientLight ambientLight = new AmbientLight();
        private Geometries geometries = new Geometries();

        /**
         * This is the builder
         *
         * @param name The name of the scene
         */
        public SceneBuilder(String name) {
            this.name = name;
        }

        // chaining method

        /**
         * This function sets the background color of the scene and returns the scene builder.
         *
         * @param background The background color of the scene.
         * @return The SceneBuilder object.
         */
        public SceneBuilder setBackground(Color background) {
            this.background = background;
            return this;
        }

        /**
         * > Sets the ambient light of the scene
         *
         * @param ambientLight The ambient light of the scene.
         * @return The SceneBuilder object.
         */
        public SceneBuilder setAmbientLight(AmbientLight ambientLight) {
            this.ambientLight = ambientLight;
            return this;
        }

        /**
         * This function sets the geometries of the scene
         *
         * @param geometries The geometries of the scene.
         * @return The SceneBuilder object.
         */
        public SceneBuilder setGeometries(Geometries geometries) {
            this.geometries = geometries;
            return this;
        }

        /**
         * This function sets the lights of the scene to the given list of lights and returns the scene builder.
         *
         * @param lights A list of light sources.
         * @return The SceneBuilder object.
         */
        public SceneBuilder setLights(List<LightSource> lights) {
            this.lights = lights;
            return this;
        }

        /**
         * This function returns the scene that we built.
         *
         * @return A new instance of the Scene class.
         */
        public Scene build() {
            return new Scene(this, lights);
        }
    }
}
