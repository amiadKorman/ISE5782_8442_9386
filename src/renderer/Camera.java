package renderer;


import primitives.Color;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.isZero;

/**
 * This class represented a camera
 *
 * @author Amiad Korman & Omer Dayan
 */
public class Camera {

    private Vector vRight;
    private Vector vTo;
    private Vector vUp;
    private Point p0;

    private double distance;
    private int width;
    private int height;

    private ImageWriter imageWriter;
    private RayTracerBasic rayTracer;

    /**
     * This is the constructor of the camera class. It takes 3 vectors as parameters and checks if they are orthogonal.
     * If they are not, it throws an exception.
     *
     * @param p0 The point that the camera spot in
     * @param vTo The direction of the camera
     * @param vUp The direction of the camera
     */
    public Camera(Point p0, Vector vTo, Vector vUp) {
        if(!isZero(vTo.dotProduct(vUp))){
            throw new IllegalArgumentException("vUp and vTo aren't orthogonal");
        }
        this.p0 = p0;
        this.vTo = vTo.normalize();
        this.vUp = vUp.normalize();
        this.vRight = this.vTo.crossProduct(this.vUp);
    }

    /**
     * Getter for the distance field of Camera
     *
     * @return The distance between the camera and the viewPlane.
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Getter for the width field of Camera.
     *
     * @return The width of the camera.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter for the height field of Camera.
     *
     * @return The height of the camera.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the distance between the camera and the viewPlane.
     *
     * @param distance The distance from the camera to the view plane.
     * @return The camera object itself.
     */
    public Camera setVPDistance(double distance) {
        this.distance = distance;
        return this;
    }

    /**
     * Set the viewPlane size to the given width and height.
     *
     * @param width The width of the viewPlane.
     * @param height The height of the viewPlane.
     * @return The camera object itself.
     */
    public Camera setVPSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    /**
     * Construct a ray through the pixel [i,j] on the view plane,
     * when the view plane is divided into nX by nY rectangular cells
     *
     * @param nX number of pixels in the columns
     * @param nY number of pixels in the rows
     * @param j column index of the pixel
     * @param i the row index of the pixel
     * @return A ray from the camera to the pixel.
     */
    public Ray constructRay(int nX, int nY, int j, int i) {
        // Ratio (pixel width & height)
        double rY = (double) this.height / nY;
        double rX = (double) this.height / nX;

        // Image center
        Point Pc = this.p0.add(this.vTo.scale(this.distance));

        // Pixel[i,j] center
        Point Pij = Pc;

        double yI = -(i -((nY - 1)/2d)) * rY;
        double xJ = (j -((nX - 1)/2d)) * rX;;

        // move to middle of pixel i,j
        if (!isZero(xJ))
            Pij = Pij.add (this.vRight.scale(xJ));
        if (!isZero(yI))
            Pij = Pij.add(this.vUp.scale(yI));

        // return ray from camera to viewPlane coordinate (i, j)
        return new Ray(this.p0, Pij.subtract(this.p0));
    }

    public Camera setImageWriter(ImageWriter imageWriter) {
        this.imageWriter = imageWriter;
        return this;
    }

    public Camera setRayTracer(RayTracerBasic rayTracer) {
        this.rayTracer = rayTracer;
        return this;
    }

    public void renderImage() {
        //TO DO
    }

    public void writeToImage() {
        this.imageWriter.writeToImage();;
    }

    public void printGrid(int interval, Color color) {
        for (int i = 0; i < this.imageWriter.getNx(); i++) {
            for (int j = 0; j < this.imageWriter.getNy(); j++) {
                if (i % 50 == 0 || j % 50 == 0)
                    this.imageWriter.writePixel(i, j, color);
            }
        }
    }
}
