public class Triangle extends Shape {

    private int base;

    public Triangle(int base, String name){
        this.base=base;
        this.name=name;
    }

    @Override
    public void draw() {
        for(int i = 0; i < base + 1; i++){
            for(int j = base; j > i; j--){
            System.out.print(" ");
            }
            for(int k = 0; k < (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
