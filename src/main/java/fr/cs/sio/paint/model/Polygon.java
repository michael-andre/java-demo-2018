package fr.cs.sio.paint.model;

import java.awt.*;
import java.util.List;

public class Polygon extends Shape {

    private List<Point> points;

    public Polygon(List<Point> points) {
        super(points.get(0));
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public double getArea() {
        //TODO
        return 0;
    }

    @Override
    public void paint(Graphics g) {
        int[] xPoints = new int[getPoints().size()];
        int[] yPoints = new int[xPoints.length];
        for (int i = 0; i < getPoints().size(); i++) {
            Point p = getPoints().get(i);
            xPoints[i] = p.getX();
            yPoints[i] = p.getY();
        }
        g.drawPolygon(xPoints, yPoints, xPoints.length);
    }
}
