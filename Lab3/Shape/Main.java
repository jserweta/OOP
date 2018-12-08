import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	 
        LinkedList<Shape> ShapeList = new LinkedList<Shape>();
        ShapeList.add(new Rectangle());
        ShapeList.add(new Square());
        ShapeList.add(new Circle());
        ShapeList.add(new Triangle());

        for(Shape i: ShapeList){
            i.draw();
        }
    }
}
