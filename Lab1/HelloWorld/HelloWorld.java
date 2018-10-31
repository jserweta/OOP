import javaIn.*;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.print("Type your name: ");
            String name = JIn.getString();
        System.out.println("Hello World");
            System.out.println("And hello "+name);
    }
}
