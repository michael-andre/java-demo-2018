package fr.cs.sio.paint.model;

import fr.cs.sio.paint.ui.Paintable;

/**
 * A base class for all shapes.
 */
// This class has to be declared abstract because it has at least one abstract method.
// As a consequence, this class cannot be instantiated (new Shape()), it can only be subclassed.
public abstract class Shape implements Paintable {

    // Here we declare properties common to all shapes.
    // Properties are strongly typed (declared with a type) and can optionally be given a default value.
    // Properties could be public to be accessible/visible from outside of the package (in App.main() for instance)...
    // ...but we choose to encapsulate them as private fields with public getters and setters.
    private Point origin;

    // A constructor for Shape that will initialize the origin fields with the provided values.
    // Since we have at least one constructor explicitly defined in Shape, the default implicit public no-arg one is not available.
    public Shape(int x, int y) {
        // When a local variable has the same name as an attribute, when use this.* to disambiguate.
        this.origin = new Point(x, y);
    }

    public Shape(Point origin) {
        this.origin = origin;
    }

    /**
     * Compute the area of the shape.
     *
     * @return The area.
     */
    // This method is abstract: is has only a declaration and no implementation (body).
    // The implementation must be provided by each subclass, they will have to @Override this method.
    public abstract double getArea();

    // A getter hides the implementation & storage from the outside (encapsulation).
    public int getX() {
        return origin.getX();
    }

    // A setter hides the implementation & storage from the outside (encapsulation).
    public void setX(int x) {
        origin.setX(x);
    }

    public int getY() {
        return origin.getY();
    }

    public void setY(int y) {
        origin.setY(y);
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    // This class already have a toString() method, inherited for the implicit parent class Object.
    // But we can redeclare it here to customize the output.
    @Override
    public String toString() {
        return origin.toString();
    }

}
