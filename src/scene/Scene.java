package scene;

import lighting.AmbientLight;
import geometries.Geometries;
import primitives.Color;

public class Scene {

    private final String name;
    private final Color background;
    private final AmbientLight ambientLight;
    private final Geometries geometries;

    public String getName() {
        return name;
    }

    public Color getBackground() {
        return background;
    }

    public AmbientLight getAmbientLight() {
        return ambientLight;
    }

    public Geometries getGeometries() {
        return geometries;
    }

    private Scene(SceneBuilder builder) {
        name = builder.name;
        background = builder.background;
        ambientLight = builder.ambientLight;
        geometries = builder.geometries;
    }

    public static class SceneBuilder {

        private final String name;
        private Color background;
        private AmbientLight ambientLight;
        private Geometries geometries;

        public SceneBuilder(String name) {
            this.name = name;
        }

        // chaining method

        public SceneBuilder setBackground(Color background) {
            this.background = background;
            return this;
        }

        public SceneBuilder setAmbientLight(AmbientLight ambientLight) {
            this.ambientLight = ambientLight;
            return this;
        }

        public SceneBuilder setGeometries(Geometries geometries) {
            this.geometries = geometries;
            return this;
        }

        public Scene build() {
            return new Scene(this);
        }
    }
}
