import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	    ShapeList ShapeList = new ShapeList();
	    ShapeList.addShape(new Square(5,"kwadrat 5x5"));
	    ShapeList.addShape(new Rectangle(15, 5, "prostokąt 15x5"));
        ShapeList.addShape(new Triangle(5,"trójkąt-podstawie 5"));
        ShapeList.addShape(new Circle(10,"koło-promien 10"));

        ShapeList.getList();
        ShapeList.editList();


	    /*
        LinkedList<Shape> ShapeList = new LinkedList<Shape>();
            ShapeList.add(new Rectangle());
            ShapeList.add(new Circle());
            ShapeList.add(new Triangle());

        for(Shape i: ShapeList){
            i.draw();
        }*/
    }
}
