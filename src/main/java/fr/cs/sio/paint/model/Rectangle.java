package fr.cs.sio.paint.model;

import fr.cs.sio.paint.ui.Paintable;

import java.awt.*;
import java.io.Serializable;

/**
 * A rectangular {@link Shape}.
 */
// This class inherits from Shape (all properties and methods from Shape and its parent are available).
// It is NOT abstract, as a consequence it has to implement all abstract methods from Shape.
public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        // We explicitly call the constructor of Shape that takes x and y as parameters.
        // super() must be the first statement in a constructor
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point origin, int width, int height) {
        super(origin);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // The getArea() method is an declared in Shape as an abstract method.
    // We re-declare is here with the @Override annotation to provide the implementation for a Rectangle.
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "{ origin: " + super.toString() + ", width: " + width + ", height: " + height + " }";
    }

    @Override
    public void paint(Graphics g) {
        g.drawRect(getX(), getY(), getWidth(), getHeight());
    }
}
