package primitives;

public class Vector extends Point{
    public Vector(double x, double y, double z) {
        super(x, y, z);
    }

    public Vector(Double3 xyz) {
        super(xyz);
        if(_xyz.equals(Double3.ZERO)){
            throw new IllegalArgumentException("Vector(0,0,0) is not valid");
        }
    }

    @Override
    public String toString() {
        return "Vector " + _xyz;
    }

    public double dotProduct(Vector v) {
        double u1 = _xyz.d1;
        double u2 = _xyz.d2;;
        double u3 = _xyz.d3;;

        double v1 = v._xyz.d1;
        double v2 = v._xyz.d2;;
        double v3 = v._xyz.d3;;

        return (u1*v1 + u2*v2 + u3*v3);
    }

    public Vector crossProduct(Vector v) {
        double u1 = _xyz.d1;
        double u2 = _xyz.d2;;
        double u3 = _xyz.d3;;

        double v1 = v._xyz.d1;
        double v2 = v._xyz.d2;;
        double v3 = v._xyz.d3;;

        return new Vector(u2 * v3 - u3 * v2, u3 * v1 - u1 * v3, u1 * v2 - u2 * v1);
    }

    public double lengthSquared() {
        double u1 = _xyz.d1;
        double u2 = _xyz.d2;;
        double u3 = _xyz.d3;;

        return u1 * u1 + u2 * u2 + u3 * u3;
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public Vector normalize() {
        double size = length();

        return new Vector(_xyz.reduce(size));
    }

//    @Override
//    public boolean equals(Object o) {
//        return super.equals(o);
//    }
//
//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
}
