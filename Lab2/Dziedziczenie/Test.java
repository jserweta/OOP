import java.io.*;
import java.lang.*;
import java.util.LinkedList;
import java.util.Scanner;


public class Test {

    public static void main(String[] args) {
        LinkedList<Punkt3D> points = new LinkedList<Punkt3D>();
        Scanner read = new Scanner(System.in);

        int a=0;

        while(a<5) {
            System.out.print("MENU: \n" +
                    "1. Wczytaj punkt 3D \n" +
                    "2. Wyświetl wszystkie punkty\n" +
                    "3. Oblicz odległość\n" +
                    "4. Zakończ\n");

            System.out.print("Wybierz opcję: ");
            a = read.nextInt();


            switch (a) {
                case 1:
                    System.out.print("Podaj x: ");
                    double x = read.nextDouble();

                    System.out.print("Podaj y: ");
                    double y = read.nextDouble();

                    System.out.print("Podaj z: ");
                    double z = read.nextDouble();

                    Punkt3D punkt3D = new Punkt3D(x, y, z);
                    points.add(punkt3D);
                    break;
                case 2:
                    for (Punkt3D point : points) {
                        System.out.print("X=" + point.getX() + " Y=" + point.getY() + " Z=" + point.getZ() + "\n");

                    }
                    break;
                case 3:
                    for (Punkt3D point : points) {
                        System.out.print("Odległość=" + point.distance() + "\n");
                    }
                    break;
                case 4:
                    System.out.print("Koniec!");
                    System.exit(0);
                default:
                    System.out.print("Podałeś zły numer! \n");
                    a=0;
                    break;
            }
        }
    }
}
