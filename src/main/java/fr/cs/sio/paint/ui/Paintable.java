package fr.cs.sio.paint.ui;

import java.awt.*;

/**
 * An interface to be implemented by all objects that can be drawn by {@link PaintableCanvas}.
 */
public interface Paintable {

    // No need to add a visibility modifier on a method in an interface: only public makes sense.
    void paint(Graphics g);

}
