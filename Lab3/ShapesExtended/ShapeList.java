import java.util.LinkedList;
import java.util.Scanner;

public class ShapeList {
    private LinkedList<Shape> ShapeList = new LinkedList<Shape>();


    public void addShape(Shape shape){
        ShapeList.add(shape);
    }

    public void getList() {
        for(int i=0; i<ShapeList.size(); i++){
            System.out.print(i+1+" "+ShapeList.get(i).name+"\n");
        }
    }

    public void editList() {
        int sideA, sideB, radius, n=0, indeks, choice=1,choice1,choice3=1;
        String shapeName;
        Scanner input = new Scanner(System.in);


        while(n!=3){
            System.out.print("MENU:\n1. Dodaj figurę\n2. Wyświetl\n3. Wyjdź\n");
            System.out.print("Podaj liczbę:"); n=input.nextInt();
            switch(n){
                case 1:
                    choice=1;
                    System.out.println("Jaką figurę chcesz dodać?");
                    System.out.print("1. Koło\n2. Prostokąt\n3. Kwadrat\n4. Trójkąt\n5. Powrót do menu głownego\n\nPodaj numer:");

                    while(choice==1){
                        choice1=input.nextInt();
                        switch(choice1){
                            case 1:
                                choice=0;
                                System.out.print("Podaj promień koła:");
                                radius=input.nextInt();
                                System.out.print("Podaj nazwę kształtu:");
                                input = new Scanner(System.in);
                                shapeName=input.nextLine();
                                this.addShape(new Circle(radius,shapeName));
                                break;
                            case 2:
                                choice=0;
                                System.out.print("Podaj bok A:");
                                sideA=input.nextInt();
                                System.out.print("Podaj bok B:");
                                sideB=input.nextInt();
                                System.out.print("Podaj nazwę kształtu:");
                                input = new Scanner(System.in);
                                shapeName=input.nextLine();
                                this.addShape(new Rectangle(sideA,sideB,shapeName));
                                break;
                            case 3:
                                choice=0;
                                System.out.print("Podaj bok A:");
                                sideA=input.nextInt();
                                System.out.print("Podaj nazwę kształtu:");
                                input = new Scanner(System.in);
                                shapeName=input.nextLine();
                                this.addShape(new Square(sideA,shapeName));
                                break;
                            case 4:
                                choice=0;
                                System.out.print("Podaj długość podstawy A:");
                                sideA=input.nextInt();
                                System.out.print("Podaj nazwę kształtu:");
                                input = new Scanner(System.in);
                                shapeName=input.nextLine();
                                this.addShape(new Triangle(sideA,shapeName));
                                break;
                            case 5:
                                choice=0;
                                System.out.println("Powrót do menu głównego!");
                                break;
                            default:
                                System.out.print("Podałeś zły numer! Podaj ponownie:");
                        }
                    }
                    break;
                case 2:
                    do{
                        System.out.print("\nLista kształtów to:\n");
                        this.getList();
                        System.out.print("Podaj numer figury:");
                        indeks=input.nextInt();
                        if(indeks>ShapeList.size()){
                            System.out.println("Podałeś złą wartość! Wprowadź nową:");
                            choice3=1;
                        }else{
                            ShapeList.get(indeks-1);
                            ShapeList.get(indeks-1).draw();
                            System.out.println("\nChcesz wyświetlać dalej?\n1.Następna figura\n2.Powrót do menu głównego\nPodaj operację:");
                            choice3=input.nextInt();
                        }
                    }while(choice3==1);
                    break;
                case 3:
                    System.out.print("\nKoniec programu!");
                    break;
                default:
                    System.out.println("\nPodałeś złą liczbę!!!!");
            }
        }
    }
}
