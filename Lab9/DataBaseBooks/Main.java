import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void Menu(DBManegement dataBase) throws SQLException {
        int choice=1;
        String isbn, date;
        String author, title;
        Scanner input = new Scanner(System.in);
        while(choice != 0) {
            System.out.println("MENU:\n\n" +
                    "1. Wyświetl całą tabele\n" +
                    "2. Wyszukaj po autorze\n" +
                    "3. Wyszukaj po nazwisu autora\n" +
                    "4. Wyszukaj po numerze ISBN\n" +
                    "5. Dodaj nową książkę\n" +
                    "6. Wyjdź\n");
            System.out.print("Podaj wybór:");
            choice = input.nextInt();

            switch (choice){
                case 0:

                    break;
                case 1:
                    dataBase.selectAll();
                    break;
                case 2:
                    Scanner input1 = new Scanner(System.in);
                    System.out.print("Podaj autora: ");
                    author = input1.nextLine();
                    dataBase.selectByAuthor(author);
                    break;
                case 3:
                    Scanner input2 = new Scanner(System.in);
                    String surname;
                    System.out.print("Podaj nazwisko autora: ");
                    surname = input2.nextLine();
                    dataBase.selectByAuthorSurname(surname);
                    break;
                case 4:
                    Scanner input3 = new Scanner(System.in);
                    System.out.print("Podaj ISBN: ");
                    isbn = input3.nextLine();
                    dataBase.selectByIsbn(isbn);
                    break;
                case 5:
                    Scanner input4 = new Scanner(System.in);
                    System.out.print("Podaj ISBN: ");
                    isbn = input4.nextLine();
                    System.out.print("Podaj tytuł: ");
                    title = input4.nextLine();
                    System.out.print("Podaj autora: ");
                    author = input4.nextLine();
                    System.out.print("Podaj rok: ");
                    date = input4.nextLine();

                    while(dataBase.selectIsbn(isbn)){
                        System.out.print("Podany numer ISBN juz istnieje! Podaj nowy:");
                        isbn = input4.nextLine();
                    }

                    dataBase.addNewBook(isbn,author, title,date);

                    break;
                case 6:
                    choice=0;
                    System.out.println("Koniec!");
                    break;

                default:
                    System.out.println("Podałeś złą wartość! Podaj nową:");
                    choice = 1;
            }
        }

    }

    public static void main(String[] args) throws SQLException {
        DBManegement DBConnector = new DBManegement();
        Menu(DBConnector);
    }
}
