import java.util.Scanner;

public class Kadry{

    public static void main(String[] args) {
        DBManagement kadry = new DBManagement();
        Scanner input = new Scanner(System.in);

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
                    kadry.selectAll();
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
