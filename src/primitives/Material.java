package primitives;

/**
 * Material class, the material of the geometries
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Material {
    /**
     * Diffuse factor
     */
    private Double3 Kd = Double3.ZERO;
    /**
     * Specular factor
     */
    private Double3 Ks = Double3.ZERO;
    /**
     * Transparency factor
     */
    private Double3 Kt = Double3.ZERO;
    /**
     * Reflection factor
     */
    private Double3 Kr = Double3.ZERO;
    /**
     * Shininess factor
     */
    private int nShininess = 0;

    /**
     * Getter for Ks field.
     *
     * @return The value of the specular reflectivity.
     */
    public Double3 getKs() {
        return Ks;
    }

    /**
     * Getter for Kd field.
     *
     * @return The value of diffuse reflectivity.
     */
    public Double3 getKd() {
        return Kd;
    }

    /**
     * Getter for Kt field.
     *
     * @return The value of transparency coefficient.
     */
    public Double3 getKt() {
        return Kt;
    }

    /**
     * Getter for Kr field.
     *
     * @return The value of reflection coefficient.
     */
    public Double3 getKr() {
        return Kr;
    }

    /**
     * Getter for nShininess field.
     *
     * @return The shininess of the material.
     */
    public int getShininess() {
        return nShininess;
    }

    /**
     * Setter for the Kd field.
     *
     * @param Kd Diffuse reflectivity.
     * @return The material itself.
     */
    public Material setKd(double Kd) {
        this.Kd = new Double3(Kd);
        return this;
    }

    /**
     * Setter for the Kd field.
     *
     * @param Kd Diffuse reflectivity.
     * @return The material itself.
     */
    public Material setKd(Double3 Kd) {
        this.Kd = Kd;
        return this;
    }

    /**
     * Setter for the Ks field.
     *
     * @param Ks specular reflectivity
     * @return The material itself.
     */
    public Material setKs(double Ks) {
        this.Ks = new Double3(Ks);
        return this;
    }

    /**
     * Setter for the Ks field.
     *
     * @param Ks specular reflectivity
     * @return The material itself.
     */
    public Material setKs(Double3 Ks) {
        this.Ks = Ks;
        return this;
    }

    /**
     * Setter for the transparency coefficient field
     *
     * @param Kt The transparency coefficient of the material.
     * @return The material itself.
     */
    public Material setKt(Double3 Kt) {
        this.Kt = Kt;
        return this;
    }

    /**
     * Setter for the transparency coefficient field
     *
     * @param Kt The transparency coefficient of the material.
     * @return The material itself.
     */
    public Material setKt(double Kt) {
        this.Kt = new Double3(Kt);
        return this;
    }

    /**
     * Setter for the reflection coefficient field.
     *
     * @param Kr The reflection coefficient of the material.
     * @return The material itself.
     */
    public Material setKr(Double3 Kr) {
        this.Kr = Kr;
        return this;
    }

    /**
     * Setter for the reflection coefficient field.
     *
     * @param Kr The reflection coefficient of the material.
     * @return The material itself.
     */
    public Material setKr(double Kr) {
        this.Kr = new Double3(Kr);
        return this;
    }

    /**
     * Setter for the nShininess field.
     *
     * @param nShininess The shininess of the material.
     * @return The material object itself.
     */
    public Material setShininess(int nShininess) {
        this.nShininess = nShininess;
        return this;
    }


}
