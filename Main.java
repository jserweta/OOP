import peselPackage.Pesel;

import java.util.Scanner;


public class Main {
    public static void main (String[] args){
        Scanner odczyt = new Scanner(System.in);
        System.out.print ("Podaj numer PESEL: " );

        String pesel = odczyt.nextLine();

        if(Pesel.check(pesel)==false){
            System.out.println("Twój PESEL jest niepoprawny!");
        }else {
            System.out.println("Twój PESEL jest poprawny!");
        }
    }
}
