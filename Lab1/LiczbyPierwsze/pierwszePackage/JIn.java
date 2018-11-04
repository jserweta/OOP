package pierwszePackage;
import java.util.Scanner;

public class JIn {
    public static int input(){
        int num;
        Scanner read = new Scanner(System.in);
        System.out.print("Podaj liczbę: ");
        num = read.nextInt();


        return num;
    }
}
