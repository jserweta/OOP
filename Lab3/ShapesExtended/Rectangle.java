public class Rectangle extends Shape {

    protected int aLength;
    protected int bLength;


    public Rectangle() {
        this.aLength=1;
        this.bLength=1;
        this.name="";
    }

    public Rectangle(int aLength, int bLength, String name){
        this.aLength=aLength;
        this.bLength=bLength;
        this.name=name;
    }

    @Override
    public void draw() {
        for (int i = 1; i<bLength+1; i++){
            for (int j = 1; j<aLength; j++){
                System.out.print("* ");
          }
        System.out.println("*");
       }
    }
}
