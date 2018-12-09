import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener {

    int xCursor;
    int yCursor;

    ArrayList<Shape> ShapeList;

    public MyPanel() {
        addMouseListener(this);
        addMouseMotionListener(this);
        ShapeList = new ArrayList<>();
        ShapeList.add(new Circle(50,200,200));
        ShapeList.add(new Square(25, 200, 180));
        ShapeList.add(new Rectangle(80,100,60,180));
        ShapeList.add(new Triangle(new int[]{10,60,80}, new int[]{80, 120, 180}));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(Shape shape : ShapeList){
            shape.draw(g);
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
        xCursor = e.getX();
        yCursor = e.getY();
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int dx = e.getX() - xCursor;
        int dy = e.getY() - yCursor;

        for( Shape myShape : ShapeList ){
            if (myShape.areCordsInside(xCursor, yCursor)) {
                myShape.resetCords(dx, dy);
            }
        }

        repaint();

        xCursor += dx;
        yCursor += dy;
    }



    @Override
    public void mouseMoved(MouseEvent e) {

    }
}