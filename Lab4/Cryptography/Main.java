import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner menu = new Scanner(System.in);

        if(args.length!=2){
            throw new FileNotFoundException();
        }

        File source = new File(args[0]);
        File result = new File(args[1]);

        int choice=1;
        while(choice==1){
            System.out.print("MENU:" +
                    "\n1. Szyfrowanie" +
                    "\n2. Deszyfrowanie" +
                    "\n3. Wyjdź" +
                    "\n Podaj numer: ");

            choice = menu.nextInt();
            switch(choice){
                case 1:
                    int choice1=1;
                    while(choice1==1) {
                        System.out.print("\nWybierz algorytm:" +
                                "\n1. ROT 11" +
                                "\n2. Polibiusz" +
                                "\n3. Powrót do menu głównego" +
                                "\n Podaj swój wybór:");

                        choice1 = menu.nextInt();
                        switch (choice1) {
                            case 1:
                                Cryptographer.cryptfile(source, result, new ROT11());
                                choice1 = 0;
                                break;
                            case 2:
                                Cryptographer.cryptfile(source, result, new Polibiusz());
                                choice1 = 0;
                                break;
                            case 3:
                                System.out.println("\nPowrót do menu głównego!");
                                choice1 = 0;
                                break;
                            default:
                                choice1=1;
                                System.out.println("\nPodałeś złą liczbę!");
                        }
                    }
                    choice=1;
                    break;
                case 2:
                    int choice2=1;
                    while(choice2==1) {
                        System.out.print("\nWybierz algorytm:" +
                                "\n1. ROT 11" +
                                "\n2. Polibiusz" +
                                "\n3. Powrót do menu głównego" +
                                "\n Podaj swój wybór:");

                        choice2 = menu.nextInt();
                        switch (choice2) {
                            case 1:
                                Cryptographer.decryptfile(source, result, new ROT11());
                                choice2 = 0;
                                break;
                            case 2:
                                Cryptographer.decryptfile(source, result, new Polibiusz());
                                choice2 = 0;
                                break;
                            case 3:
                                System.out.println("\nPowrót do menu głównego!");
                                choice2 = 0;
                                break;
                            default:
                                choice2=1;
                                System.out.println("\nPodałeś złą liczbę!");
                        }
                    }
                    choice=1;
                    break;
                case 3:
                    System.out.println("Koniec programu!");
                    choice=0;
                    break;
                default:
                    choice=1;
                    System.out.println("\nPodałeś złą liczbę!");
            }
        }
    }
}
