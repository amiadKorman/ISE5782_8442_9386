package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

public class PointLight extends Light implements LightSource{

    private final Point position;

    private double Kc = 1d;
    private double Kl = 0d;
    private double Kq = 0d;

    /**
     * Constructor for light class
     *
     * @param intensity
     */
    protected PointLight(Color intensity, Point position) {
        super(intensity);
        this.position = position;
    }

    public PointLight setKc(double kc) {
        this.Kc = kc;
        return this;
    }

    public PointLight setKl(double kl) {
        this.Kl = kl;
        return this;
    }

    public PointLight setKq(double kq) {
        this.Kq = kq;
        return this;
    }
    @Override
    public Color getIntensity(Point point) {
        double distance = point.distance(position);
        double distanceSquared = point.distanceSquared(position);

        /*if(distance <= 0)
            return getIntensity();*/

        double factor = (Kc + Kl*distance + Kq*distanceSquared);
        Color Ic = getIntensity();

        return Ic.reduce(factor);
    }

    @Override
    public Vector getL(Point point) {
        return point.subtract(this.position).normalize();
    }
}
