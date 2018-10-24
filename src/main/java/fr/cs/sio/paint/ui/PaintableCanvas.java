package fr.cs.sio.paint.ui;

import java.awt.*;
import java.util.List;

/**
 * A custom swing {@link Component} to display {@link Paintable} objects.
 */
public class PaintableCanvas extends Canvas {

    // Hold a list of objects to display;
    // The variable is final, its reference cannot be changed after the constructor is called.
    // But the CONTENT of the list itself can be changed (add, remove...).
    private final List<? extends Paintable> paintables;

    public PaintableCanvas(List<? extends Paintable> paintables) {
        // final attributes need to be given a value in the constructor.
        this.paintables = paintables;
    }

    @Override
    public void paint(Graphics g) {
        // Call super implementation (draws the background).
        super.paint(g);
        // Then delegate the drawing to each Paintable.
        for (Paintable element : paintables) {
            element.paint(g);
        }
    }

}
