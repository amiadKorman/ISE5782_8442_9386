package renderer;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.isZero;

public class Camera {

    private Vector _vRight;
    private Vector _vTo;
    private Vector _vUp;
    private Point _po;
    private double _distance;
    private int _width;
    private int _height;

    public Camera(Point p0, Vector vto, Vector vup) {
        if(!isZero(vto.dotProduct(vup))){
            throw new IllegalArgumentException("vup aren't orthogonal");
        }
        _po = p0;
        _vTo = vto.normalize();
        _vUp = vup.normalize();
        _vRight = _vTo.crossProduct(_vUp);
    }

    public Camera setVPDistance(double distance) {
        _distance = distance;
        return this;
    }

    public Camera setVPSize(int width, int height) {
        _width = width;
        _height = height;
        return this;
    }

    public Ray constructRay(int nX, int nY, int j, int i) {
        // Ratio (pixel width & height)
        double rY = (double) _height / nY;
        double rX = (double) _height / nX;

        // Image center
        Point Pc = _po.add(_vTo.scale(_distance));

        // Pixel[i,j ] center
        Point Pij = Pc;

        double yI = -(i -((nY - 1)/2d)) * rY;
        double xJ = (j -((nX - 1)/2d)) * rX;;

        if (xJ != 0 )
            Pij = Pij.add (_vRight.scale(xJ));
        if (yI != 0 )
            Pij = Pij.add(_vUp.scale(yI));

        return new Ray(_po, Pij.subtract(_po));
    }
}
