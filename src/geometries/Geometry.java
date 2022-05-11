package geometries;

import primitives.*;

/**
 * This interface will serve all geometric classes
 *
 * @author Amiad Korman & Omer Dayan
 */
public abstract class Geometry extends Intersectable{
    protected Color emission = Color.BLACK;
    private Material material = new Material();

    /**
     * Getter for the emission color of the Geometry
     *
     * @return The emission color of the Geometry.
     */
    public Color getEmission() {
        return emission;
    }

    /**
     * Setter for the emission color of the Geometry and return this object.
     *
     * @param emission The color of the light emitted by the object.
     * @return The object itself.
     */
    public Geometry setEmission(Color emission) {
        this.emission = emission;
        return this;
    }

    /**
     * Return the normal to the vector in specific point
     *
     * @param point
     * @return the normal to the vector in specific point
     */
    public abstract Vector getNormal(Point point);

    public Geometry setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public Material getMaterial() {
        return material;
    }
}
