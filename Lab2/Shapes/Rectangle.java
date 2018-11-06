public class Rectangle extends Shape {
    protected int aLength;
    protected int bLength;


    public Rectangle(int aLength, int bLength, String name){
        this.aLength=aLength;
        this.bLength=bLength;
        this.name=name;
    }

    public Rectangle() {
        aLength=1;
        bLength=1;
        name="";
    }

    @Override
    public void draw() {

    }
}
