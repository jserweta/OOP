public class Circle extends Shape {

    private int radius;

    public Circle(int radius, String name){
        this.radius=radius;
        this.name=name;
    }

    @Override
    public void draw() {
        for (int i = -radius; i <radius+1; i++) {
            for (int j = -radius; j < radius+1; j++) {
                if(i*i + j*j <= radius*radius){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
