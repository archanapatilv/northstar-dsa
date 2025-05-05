package org.northstar.designpattern.creational.bridge;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class BridgeDemo {
    public static void main(String[] args) {
        //without inject
        RasterRender rasterRender = new RasterRender();
        VectorRender vectorRender = new VectorRender();
        Circle raster = new Circle(rasterRender, 10);
        raster.draw();
        raster.resize(5);
        raster.draw();
        Circle vector = new Circle(vectorRender, 20);

        //Binder pattern
        Injector injector = Guice.createInjector(new ShapeModule());
        Circle instance = injector.getInstance(Circle.class);
        instance.radius = 10;
        instance.draw();
        instance.resize(5);
        instance.draw();;

    }
}

class ShapeModule extends AbstractModule {
    @Override
    public void configure() {
        bind(Renderer.class).to(VectorRender.class);
    }
}

interface Renderer {
    public void renderCircle(float radius);
}

class VectorRender implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing with Vector " + radius);
    }
}

class RasterRender implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing with Raster " + radius);
    }
}

abstract class Shape {
    protected Renderer renderer;
    public Shape(Renderer renderer){
        this.renderer = renderer;
    }
    public abstract void draw();
    public abstract void resize(float factor);
}

class Circle extends Shape {

    protected float radius;

    @Inject
    public Circle(Renderer renderer) {
        super(renderer);
    }
    public Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }

    @Override
    public void resize(float factor) {
        radius = radius * factor;
    }
}