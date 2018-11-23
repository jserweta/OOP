import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Kadry implements Comparator<Pracownik> {
    private LinkedList<Pracownik> pracownicyList = new LinkedList<>();
    Scanner input = new Scanner(System.in);

    void addPracownik(){
        int choice2=1;

        do{
            System.out.print("\n1. Pracownik etatowy\n" +
                    "2. Student\n" +
                    "3. Wyjdź do menu głównego\n" +
                    "Podaj co wybierasz:");

            int choice3 = input.nextInt();
            String peselNumber;
            switch (choice3) {
                case 1:
                    choice2=1;
                    Scanner values = new Scanner(System.in);
                    System.out.print("\nPodaj numer PESEL:");
                    peselNumber=values.nextLine();
                    try{
                        Pesel.checkPesel(peselNumber);
                    }catch (IOException ex){
                        System.out.print(ex.getMessage());
                        return;
                    }
                    if(checkPeselOnList(peselNumber)==-1){
                        System.out.print("\nPodaj wynagrodzenie BRUTTO:");
                        double wynagrodzenieBrutto=values.nextDouble();

                        pracownicyList.add(new PracownikEtatowy(peselNumber,wynagrodzenieBrutto));
                        for(int i=0; i<pracownicyList.size();i++){
                            System.out.print(pracownicyList.get(i)+"\n");
                        }

                    }else{
                        System.out.print("\nW bazie istnieje już pracownik o takim numerze PESEL!");
                    }
                    break;
                case 2:
                    choice2=1;
                    Scanner values2 = new Scanner(System.in);
                    System.out.print("\nPodaj numer PESEL:");
                    peselNumber=values2.nextLine();

                    try{
                        Pesel.checkPesel(peselNumber);
                    }catch (IOException ex){
                        System.out.print(ex.getMessage());
                        return;
                    }
                    if(checkPeselOnList(peselNumber)==-1){
                        System.out.print("\nPodaj wynagrodzenie BRUTTO:");
                        double wynagrodzenieBrutto=values2.nextDouble();
                        pracownicyList.push(new Student(peselNumber,wynagrodzenieBrutto));
                    }else{
                        System.out.print("\nW bazie istnieje już pracownik o takim numerze PESEL!");
                    }
                    break;
                case 3:
                    choice2=0;
                    System.out.print("\nPowrót do menu głównego!");
                    break;
                default:
                    choice2=1;
                    System.out.print("\nPodałeś zły numer!");
            }
        }while(choice2==1);

    }
    public int checkPeselOnList(String peselNumber) {
        for (int i=0; i<pracownicyList.size();i++) {
            if (peselNumber.equals(pracownicyList.get(i))) {
                return i;
            }
        }
        return -1;
    }


    private void deletePracownik() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nPodaj numer PESEL:");
        String peselNumber = input.nextLine();
        int i=checkPeselOnList(peselNumber);
        if(i!=-1){
            pracownicyList.remove(i);
            pracownicyList.remove(i+1);
            pracownicyList.remove(i+2);
        }else{
            System.out.print("\nW bazie nie ma pracownika o podanym numerze PESEL!");
        }
    }

    private void searchPracownik() {
        int choice=1;
        Scanner input = new Scanner(System.in);
        System.out.print("\nPodaj numer PESEL:");
        String peselNumber = input.nextLine();
        int i=checkPeselOnList(peselNumber);

        if(i!=1){
            do{
                System.out.print("1. Zmien wynagrodzenie brutto\n" +
                        "2. Pobierz wynagrodzeie brutto\n" +
                        "3. Pobierz wynagrodzenie netto\n" +
                        "4. Wyjdź\n" +
                        "Podaj numer:" );
                int choice1 = input.nextInt();

                switch (choice1){
                    case 1:
                        choice=1;
                        double wynagrodzenieBr=input.nextDouble();
                        pracownicyList.get(i).wynagrodzenieBrutto=wynagrodzenieBr;

                        break;
                    case 2:
                        choice=1;
                        System.out.print("\n"+pracownicyList.get(i).wynagrodzenieBrutto);
                        break;
                    case 3:
                        choice=1;
                        System.out.print("\n"+pracownicyList.get(i).wynagrodzenieNetto());
                    case 4:
                        choice=0;
                        System.out.print("\nPowrót do menu głownego!");
                        break;
                     default:
                         choice=1;
                         System.out.print("\nPodałeś złą wartość!");
                }
            }while(choice==1);
        }else{
            System.out.printf("\nW bazie nie ma pracownika o podanym numerze PESEL!");
        }
    }


    private void sortPracownik() {

    }

    public static void main(String[] args) {
        Kadry kadry = new Kadry();
        Scanner input = new Scanner(System.in);
        int choice1=1;
        while (choice1==1){
            System.out.print("MENU:\n1. Dodaj nowego pracownika\n" +
                    "2. Usuń istniejącego pracownika\n" +
                    "3. Wyszukaj pracownika\n" +
                    "4. Sortuj pracowników\n" +
                    "5. Wyjdź\n" +
                    "Co wybierasz:");
            choice1 = input.nextInt();

            switch (choice1){
                case 1:
                    choice1=1;
                    kadry.addPracownik();
                    break;
                case 2:
                    choice1=1;
                    kadry.deletePracownik();
                    break;
                case 3:
                    choice1=1;
                    kadry.searchPracownik();
                    break;
                case 4:
                    choice1=1;
                    kadry.sortPracownik();
                    break;
                case 5:
                    choice1=0;
                    System.out.print("\nKoniec programu!");
                    break;
                default:
                    choice1=1;
                    System.out.print("\nPodałeś złą wartość!");
            }

        }
    }


    @Override
    public int compare(Pracownik o1, Pracownik o2) {
        return 0;
    }
}
