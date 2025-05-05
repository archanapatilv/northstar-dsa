package org.northstar.designpattern.creational.decorator;

import java.util.function.Supplier;

// We already have circle and square class
// We want to support colored circle and colored square
// We don't want to modify base class ie. Circle and Square
// Option is to have another class and decorate it with color.
public class StaticDecoratorDemo {
    public static void main(String[] args) {
        Shape coloredCircle = new ColoredCircle(() -> new Circle(10), "blue");
        Shape transparentShape = new TransparentShape(() -> new Square(5), "green", 50);

        System.out.println(coloredCircle.info());
        System.out.println(transparentShape.info());
    }
}

class ColoredCircle<T extends Shape> implements Shape {
    Shape shape;
    String color;
    public ColoredCircle() {

    }
    public ColoredCircle(Supplier<? extends Shape> supplier, String color) {
        this.shape = supplier.get();
        this.color = color;
    }
    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}
class TransparentShape<T extends Shape> implements Shape {
    Shape shape;
    String color;
    int transparency;
    public TransparentShape() {

    }
    public TransparentShape(Supplier<? extends Shape> supplier, String color, int transparency) {
        this.shape = supplier.get();
        this.color = color;
        this.transparency = transparency;
    }
    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}



interface Shape {
    public String info();
}

class Circle implements Shape {
    float radius;

    public Circle() {
    }
    public Circle(float radius) {
        this.radius = radius;
    }
    void resize(float factor)
    {
        radius *= factor;
    }
    @Override
    public String info() {
        return "A circle of radius " + radius;
    }
}

class Square implements Shape {
    float side;

    public Square() {
    }
    public Square(float side) {
        this.side = side;
    }
    void resize(float factor)
    {
        side *= side;
    }
    @Override
    public String info() {
        return "A square with side " + side;
    }
}