package projects;

import org.junit.jupiter.api.Test;

import static java.awt.Color.*;

import renderer.ImageWriter;
import lighting.*;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;

public class sceneTests {
    private final Scene scene1 = new Scene.SceneBuilder("Test scene").build();

    /**
     * Cameras
     */
    private final Camera camera1 = new Camera(new Point(-1000, 1000, 8000), new Vector(0.13, -0.13, -1),
            new Vector(0, 1, -0.13))
            .setVPSize(150, 150).setVPDistance(1000)
            .setRayTracer(new RayTracerBasic(scene1));

    /**
     * set all geometries for test
     *
     * @return
     */
    private Scene setGeo() {
        // shiny plane
        scene1.getGeometries().add(
        new Plane(
                new Point(0, -350, 0), new Vector(0,-350,0))
                .setMaterial(new Material().setKd(0.5).setKs(0.5).setKr(0.2).setShininess(60))
                .setEmission(new Color(GRAY)));
        // 3 spheres of the base snowman
        scene1.getGeometries().add(new Sphere(new Point(0, -200, -50), 150d).setEmission(new Color(WHITE).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        scene1.getGeometries().add(new Sphere(new Point(0, 0, -50), 100d).setEmission(new Color(WHITE).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        scene1.getGeometries().add(new Sphere(new Point(0, 125, -50), 50d).setEmission(new Color(WHITE).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        // two spheres for eyes
        scene1.getGeometries().add(new Sphere(new Point(20, 150, -10), 10d).setEmission(new Color(BLACK).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        scene1.getGeometries().add(new Sphere(new Point(-20, 150, -10), 10d).setEmission(new Color(BLACK).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        // two spheres for buttons
        scene1.getGeometries().add(new Sphere(new Point(0, -25, 50), 10d).setEmission(new Color(255, 215, 0).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        scene1.getGeometries().add(new Sphere(new Point(0, 25, 50), 10d).setEmission(new Color(255, 215, 0).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        // cylinder for nose
        scene1.getGeometries().add(new Cylinder(new Ray(new Point(0, 125, 0),
                new Vector(0, 0, 1)), 5d, 50d).setEmission(new Color(ORANGE).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        // right-hand
        // cylinder for arm
        scene1.getGeometries().add(new Cylinder(new Ray(new Point(75, 0, -50), new Vector(1, 1, 0)), 5d, 150d)
                .setEmission(new Color(66, 40, 11).reduce(2)).setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        // sphere for hand
        scene1.getGeometries().add(new Sphere(new Point(175, 100, -50), 20d).setEmission(new Color(BLUE).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        // cylinders for fingers
        scene1.getGeometries().add(new Cylinder(new Ray(new Point(175, 100, -50),
                new Vector(1, 1, 0)), 5d, 40d).setEmission(new Color(BLUE).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        scene1.getGeometries().add(new Cylinder(new Ray(new Point(175, 100, -50),
                new Vector(0, 1, 0)), 5d, 40d).setEmission(new Color(BLUE).
                reduce(2)).setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        scene1.getGeometries().add(new Cylinder(new Ray(new Point(175, 100, -50),
                new Vector(-1, 1, 0)), 5d, 40d).setEmission(new Color(BLUE).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        // left-hand
        // cylinder for arm
        scene1.getGeometries().add(new Cylinder(new Ray(new Point(-75, 0, -50),
                new Vector(-1, 1, 0)), 5d, 150d).setEmission(new Color(66, 40, 11).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        // sphere for hand
        scene1.getGeometries().add(new Sphere(new Point(-175, 100, -50), 20d).
                setEmission(new Color(BLUE).reduce(2)).setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        // cylinders for fingers
        scene1.getGeometries().add(new Cylinder(new Ray(new Point(-175, 100, -50),
                new Vector(-1, 1, 0)), 5d, 40d).setEmission(new Color(BLUE).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        scene1.getGeometries().add(new Cylinder(new Ray(new Point(-175, 100, -50),
                new Vector(0, 1, 0)), 5d, 40d).setEmission(new Color(BLUE).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        scene1.getGeometries().add(new Cylinder(new Ray(new Point(-175, 100, -50),
                new Vector(1, 1, 0)), 5d, 40d).setEmission(new Color(BLUE).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        // cylinders for pillars
        scene1.getGeometries().add(new Cylinder(new Ray(new Point(400, -350, 300),
                new Vector(0, 1, 0)), 40, 650d).setEmission(new Color(RED).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        scene1.getGeometries().add(new Cylinder(new Ray(new Point(400, -350, -300),
                new Vector(0, 1, 0)), 40, 650d).setEmission(new Color(RED).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        scene1.getGeometries().add(new Cylinder(new Ray(new Point(-400, -350, 300),
                new Vector(0, 1, 0)), 40, 650d).setEmission(new Color(RED).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        scene1.getGeometries().add(new Cylinder(new Ray(new Point(-400, -350, -300),
                new Vector(0, 1, 0)), 40, 650d).setEmission(new Color(RED).reduce(2)).
                setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300)));
        // triangles and polygons for the shed
        scene1.getGeometries().add(new Triangle(new Point(-400, 301, 300), new Point(400, 301, 300),
                new Point(0, 500, 300)).setEmission(new Color(ORANGE)).setMaterial((new Material().setKd(0.5).setKs(0.5).setShininess(300).setKt(0.8))));
        scene1.getGeometries().add(new Triangle(new Point(-400, 301, -300), new Point(400, 301, -300),
                new Point(0, 500, -300)).setEmission(new Color(ORANGE)).setMaterial((new Material().setKd(0.5).setKs(0.5).setShininess(300).setKt(0.8))));
        scene1.getGeometries().add(new Polygon(new Point(0, 500, 300), new Point(-400, 301, 300),
                new Point(-400, 301, -300), new Point(0, 500, -300)).setEmission(new Color(ORANGE)));
        scene1.getGeometries().add(new Polygon(new Point(0, 500, 300), new Point(400, 301, 300),
                new Point(400, 301, -300), new Point(0, 500, -300)).setEmission(new Color(ORANGE)));

        return scene1;
    }

    @Test
    public void bonus10Geo() {
        setGeo().getLights().add(new PointLight(new Color(150, 150, 150), new Point(500, 500, 6000)));

        camera1.setImageWriter(new ImageWriter("bonus10Geo", 500, 500))
                .setRayTracer(new RayTracerBasic(scene1))
                .renderImage();
        camera1.writeToImage();

    }


}
