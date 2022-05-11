package primitives;

public class Material {
    private Double3 Kd = Double3.ZERO;
    private Double3 Ks = Double3.ZERO;
    private int nShininess = 0;

    public Double3 getKs() {
        return Ks;
    }


    public Material setKd(double Kd) {
        this.Kd = new Double3(Kd);
        return this;
    }

    public Material setKs(double Ks) {
        this.Ks = new Double3(Ks);
        return this;
    }

    public Material setKd(Double3 Kd) {
        this.Kd = Kd;
        return this;
    }

    public Material setKs(Double3 Ks) {
        this.Ks = Ks;
        return this;
    }


    public Double3 getKd() {
        return Kd;
    }

    public Material setShininess(int nShininess) {
        this.nShininess = nShininess;
        return this;
    }

    public int getShininess() {
        return nShininess;
    }
}
