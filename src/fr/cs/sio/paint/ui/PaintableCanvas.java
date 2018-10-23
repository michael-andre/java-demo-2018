package fr.cs.sio.paint.ui;

import java.awt.*;
import java.util.List;

public class PaintableCanvas extends Canvas {

    private final List<Paintable> paintables;

    public PaintableCanvas(List<Paintable> paintables) {
        this.paintables = paintables;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Paintable element : paintables) {
            element.paint(g);
        }
    }

}
