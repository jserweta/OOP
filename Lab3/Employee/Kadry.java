import java.io.IOException;
import java.util.*;

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
                        Pracownik pracownik = new PracownikEtatowy(peselNumber,wynagrodzenieBrutto);
                        pracownicyList.add(pracownik);

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

                        pracownicyList.add(new Student(peselNumber,wynagrodzenieBrutto));

                    }else{
                        System.out.println("\nW bazie istnieje już pracownik o takim numerze PESEL!");
                    }
                    break;
                case 3:
                    choice2=0;
                    System.out.println("\nPowrót do menu głównego!");
                    break;
                default:
                    choice2=1;
                    System.out.println("\nPodałeś zły numer!");
            }
        }while(choice2==1);

    }
    public int checkPeselOnList(String peselNumber) {
        for (int i=0; i<pracownicyList.size();i++) {
            if (peselNumber.equals(pracownicyList.get(i).peselNumber)) {
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
        }else{
            System.out.println("\nW bazie nie ma pracownika o podanym numerze PESEL!");
        }
    }

    private void searchPracownik() {
        int choice5=1;
        Scanner input = new Scanner(System.in);
        System.out.print("\nPodaj numer PESEL:");
        String peselNumber = input.nextLine();
        int i=checkPeselOnList(peselNumber);
        if(i!=-1){
            do{
                System.out.print("1. Zmien wynagrodzenie brutto\n" +
                        "2. Pobierz wynagrodzeie brutto\n" +
                        "3. Pobierz wynagrodzenie netto\n" +
                        "4. Wyjdź\n" +
                        "Podaj numer:" );
                int choice1 = input.nextInt();

                switch (choice1){
                    case 1:
                        choice5=1;
                        System.out.print("Podaj nowe wynagrodzenie dla pracownika: "+pracownicyList.get(i).peselNumber+":");
                        double wynagrodzenieBr=input.nextDouble();
                        pracownicyList.get(i).wynagrodzenieBrutto=wynagrodzenieBr;
                        break;
                    case 2:
                        choice5=1;
                        System.out.println("\nWynagrodzenie brutto pracownika: "+pracownicyList.get(i).peselNumber+" to: "+pracownicyList.get(i).wynagrodzenieBrutto);
                        break;
                    case 3:
                        choice5=1;
                        System.out.println("\nWynagrodzenie netto pracownika: "+pracownicyList.get(i).peselNumber+" to: "+pracownicyList.get(i).wynagrodzenieNetto());
                        break;
                    case 4:
                        choice5=0;
                        System.out.println("\nPowrót do menu głownego!");
                        break;
                     default:
                         choice5=1;
                         System.out.println("\nPodałeś złą wartość!");
                }
            }while(choice5==1);
        }else{
            System.out.println("\nW bazie nie ma pracownika o podanym numerze PESEL!");
        }
    }
    private void viewPracownicyList(){
        int c=1;
        if(pracownicyList.size()>0){
            for(int i=0; i<pracownicyList.size(); i++){
                System.out.println("Pracownik nr."+c+":\n     PESEL: "+pracownicyList.get(i).peselNumber+
                        "\n     Wynagrodzenie brutto: "+pracownicyList.get(i).wynagrodzenieBrutto+
                        "\n     Wynagrodzenie netto: "+pracownicyList.get(i).wynagrodzenieNetto());
                c++;
            }
        }else{System.out.println("W bazie nie ma żadnych pracowników!\n");}


    }

    @Override
    public int compare(Pracownik o1, Pracownik o2) {
        return (int)(o1.wynagrodzenieBrutto-o2.wynagrodzenieBrutto);
    }

    private void sortPracownik() {
        Collections.sort(pracownicyList,new Kadry());
        /*viewPracownicyList();*/
    }

    public static void main(String[] args) {
        Kadry kadry = new Kadry();
        Scanner input = new Scanner(System.in);

        kadry.pracownicyList.add(new PracownikEtatowy("97082108391",2000.0));
        kadry.pracownicyList.add(new PracownikEtatowy("81100216357",5500.0));
        kadry.pracownicyList.add(new PracownikEtatowy("90080517455",4500.0));
        kadry.pracownicyList.add(new PracownikEtatowy("80072909146",15000.0));
        kadry.pracownicyList.add(new PracownikEtatowy("90060804786",200.0));

        int choice1=1;
        while (choice1==1){
            System.out.print("MENU:\n1. Dodaj nowego pracownika\n" +
                    "2. Usuń istniejącego pracownika\n" +
                    "3. Wyszukaj pracownika\n" +
                    "4. Sortuj pracowników\n" +
                    "5. Wypisz listę pracowników\n" +
                    "6. Wyjdź\n" +
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
                    choice1=1;
                    kadry.viewPracownicyList();
                    break;
                case 6:
                    choice1=0;
                    System.out.print("\nKoniec programu!");
                    break;
                default:
                    choice1=1;
                    System.out.print("\nPodałeś złą wartość!");
            }

        }
    }
}
