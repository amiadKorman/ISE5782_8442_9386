package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

public class SpotLight extends PointLight{
    private final Vector direction;
    private double narrowBeam = 0d;

    public SpotLight(Color intensity, Point position, Vector direction) {
        super(intensity, position);
        this.direction = direction;
    }

    public SpotLight setNarrowBeam(double narrowBeam) {
        this.narrowBeam = narrowBeam;
        return this;
    }

    public double getNarrowBeam(){
        return this.narrowBeam;
    }

    @Override
    public Color getIntensity(Point point) {
        Color Ic = super.getIntensity(point);
        double lv = getL(point).dotProduct(direction);
        double factor = Math.max(0, lv);

        return Ic.scale(factor);
    }
}