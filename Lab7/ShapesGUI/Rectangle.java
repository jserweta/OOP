import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Shape{

    private double sideA;
    private double sideB;

    private int xCord;
    private int yCord;

    private Rectangle2D rectangle2D;

    public Rectangle(double sideA, double sideB, int xCord, int yCord) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.xCord = xCord;
        this.yCord = yCord;
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
    }

    @Override
    public double area() {
        return sideA * sideB;
    }

    @Override
    public void draw(Graphics graphics) {
        Graphics2D graphics2D = ( Graphics2D ) graphics;
        rectangle2D = new Rectangle2D.Double(xCord - (sideB/2), yCord - (sideA/2), sideA, sideB);
        graphics.setColor(Color.darkGray);
        ((Graphics2D) graphics).fill(rectangle2D);
        graphics2D.draw(rectangle2D);
    }

    @Override
    public void resetCords(int dx, int dy) {
        xCord += dx;
        yCord += dy;
    }

    @Override
    public boolean areCordsInside(int x, int y) {
        return rectangle2D.getBounds2D().contains(x,y);
    }
}