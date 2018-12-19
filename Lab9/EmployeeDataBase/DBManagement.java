import java.awt.event.PaintEvent;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class DBManagement {
    private Connection conn = null;
    private Statement stmt = null;
    private Statement stmt2 = null;
    private Statement stmt3 = null;
    private ResultSet rs = null;


    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/serweta",
                    "serweta","hZCqdxhqM6nUJznQ");



        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){e.printStackTrace();}
    }

    public void selectAll(){
        try {
            connect();
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = stmt.executeQuery("SELECT * FROM Employee");
            boolean ifExists = false;
            while(rs.next()){
                ifExists = true;
                String Pesel = rs.getString(1);
                String Nazwa = rs.getString(2);
                String Rodzaj = rs.getString(3);
                Double Brutto = rs.getDouble(4);
                Double Netto = rs.getDouble(5);
                System.out.println("Pesel: " + Pesel + " | Nazwa: " + Nazwa + " | Typ: " + Rodzaj + " | Wynagrodzenie brutto "
                        + Brutto + " | Wynagrodzenie netto " + Netto);
            }

            if(ifExists == false){
                System.out.println("Żaden pracownik nie pasuje do podanych kryteriów!");
            }
        }catch (SQLException ex){
            // handle any errors

        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
    }

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
                    try {
                        if(checkPeselInDataBase(peselNumber)==-1){
                            System.out.print("\nPodaj nazwę pracownika:");
                            String nazwa=values.nextLine();
                            System.out.print("\nPodaj wynagrodzenie BRUTTO:");
                            double wynagrodzenieBrutto=values.nextDouble();
                            double wynagrodzenieNetto=(wynagrodzenieBrutto*78.5)/100;
                            String typ ="PracownikEtatowy";
                            try {
                                connect();
                                stmt = conn.createStatement();
                                stmt.executeUpdate(
                                        "INSERT INTO Employee "
                                                + "values ('"+ peselNumber +"','"+ nazwa +"','PracownikEtatowy',"+ wynagrodzenieBrutto+","+wynagrodzenieNetto+")");

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }finally{
                                if (stmt != null) {
                                    try {
                                        stmt.close();
                                    } catch (SQLException sqlEx) { } // ignore

                                    stmt = null;
                                }
                            }

                        }else{
                            System.out.print("\nW bazie istnieje już pracownik o takim numerze PESEL!");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
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
                    try {
                        if(checkPeselInDataBase(peselNumber)==-1){
                            System.out.print("\nPodaj nazwę pracownika:");
                            String nazwa=values2.nextLine();

                            System.out.print("\nPodaj wynagrodzenie BRUTTO:");
                            double wynagrodzenieBrutto=values2.nextDouble();
                            double wynagrodzenieNetto=(wynagrodzenieBrutto*87.7)/100;
                            try {
                                connect();
                                stmt = conn.createStatement();
                                stmt.executeUpdate(
                                        "INSERT INTO Employee "
                                                + "values ('"+ peselNumber +"','"+ nazwa +"','Student',"+ wynagrodzenieBrutto+","+wynagrodzenieNetto+")");

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }finally{
                                if (stmt != null) {
                                    try {
                                        stmt.close();
                                    } catch (SQLException sqlEx) { } // ignore

                                    stmt = null;
                                }
                            }

                        }else{
                            System.out.println("\nW bazie istnieje już pracownik o takim numerze PESEL!");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
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

    public int checkPeselInDataBase(String peselNumber) throws SQLException{

        connect();
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT Pesel FROM Employee WHERE Pesel like '" + peselNumber +"'");

        if(rs.next()){
            return 1;
        }
        return -1;
    }

    public void deletePracownik() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nPodaj numer PESEL:");
        String peselNumber = input.nextLine();
        int i= 0;
        try {
            i = checkPeselInDataBase(peselNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(i!=-1){
            try {
                connect();
                stmt = conn.createStatement();
                stmt.executeUpdate(
                        "DELETE FROM Employee WHERE Pesel='"+peselNumber+"'");
                System.out.println("\nPracownik o numerze "+peselNumber+" został usunięty pomyślnie!");
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                if (stmt != null) {
                    try {
                        stmt.close();

                    } catch (SQLException sqlEx) { } // ignore

                    stmt = null;
                }

            }
        }else{
            System.out.println("\nW bazie nie ma pracownika o podanym numerze PESEL!");
        }
    }

    public void searchPracownik() {
        int choice5=1;
        Scanner input = new Scanner(System.in);
        System.out.print("\nPodaj numer PESEL:");
        String peselNumber = input.nextLine();
        int i= 0;
        try {
            i = checkPeselInDataBase(peselNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                        System.out.print("Podaj nowe wynagrodzenie dla pracownika: "+ peselNumber+":");
                        double wynagrodzenieBr=input.nextDouble();

                        try {
                            connect();
                            stmt = conn.createStatement();
                            stmt.executeUpdate(
                                    "UPDATE Employee SET Brutto = "+wynagrodzenieBr + "WHERE Pesel='"+peselNumber+"'");

                            stmt2 = conn.createStatement();
                            String student="Student";
                            if(student.equals(stmt2.executeQuery("SELECT Rodzaj FROM Employee WHERE Pesel='"+peselNumber+"'"))){
                                double wynagrodzenieNe=(wynagrodzenieBr*87.7)/100;
                                stmt3 = conn.createStatement();
                                stmt3.executeUpdate(
                                        "UPDATE Employee SET Netto = "+wynagrodzenieNe + "WHERE Pesel='"+peselNumber+"'");
                            }else{
                                double wynagrodzenieNe=(wynagrodzenieBr*78.5)/100;
                                stmt3 = conn.createStatement();
                                stmt3.executeUpdate(
                                        "UPDATE Employee SET Netto = "+wynagrodzenieNe + "WHERE Pesel='"+peselNumber+"'");
                            }

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }finally{
                            if (stmt != null || stmt2 != null || stmt3 != null) {
                                try {
                                    stmt.close();
                                    stmt2.close();
                                    stmt3.close();
                                } catch (SQLException sqlEx) { } // ignore

                                stmt = null;
                                stmt2 = null;
                                stmt3 = null;
                            }

                        }
                        break;
                    case 2:
                        choice5=1;

                        try {
                            connect();
                            stmt = conn.createStatement();

                            rs = stmt.executeQuery("SELECT Nazwa, Brutto FROM Employee WHERE Pesel= '" + peselNumber + "'");

                            while(rs.next()){

                                String Nazwa = rs.getString(1);
                                Double Brutto = rs.getDouble(2);

                                System.out.println("\nWynagrodzenie brutto pracownika: "+Nazwa+" to: " +Brutto);
                            }

                        }catch (SQLException ex){

                        }finally {
                            if (rs != null) {
                                try {
                                    rs.close();
                                } catch (SQLException sqlEx) { } // ignore
                                rs = null;
                            }

                            if (stmt != null) {
                                try {
                                    stmt.close();
                                } catch (SQLException sqlEx) { } // ignore

                                stmt = null;
                            }
                        }
                        break;
                    case 3:
                        choice5=1;
                        try {
                            connect();
                            stmt = conn.createStatement();

                            rs = stmt.executeQuery("SELECT Nazwa, Netto FROM Employee WHERE Pesel like '" + peselNumber + "'");
                            while(rs.next()){

                                String Nazwa = rs.getString(1);
                                Double Netto = rs.getDouble(2);

                                System.out.println("\nWynagrodzenie brutto pracownika: "+Nazwa+" to: " +Netto);
                            }

                        }catch (SQLException ex){

                        }finally {
                            if (rs != null) {
                                try {
                                    rs.close();
                                } catch (SQLException sqlEx) { } // ignore
                                rs = null;
                            }

                            if (stmt != null) {
                                try {
                                    stmt.close();
                                } catch (SQLException sqlEx) { } // ignore

                                stmt = null;
                            }
                        }
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

    public void sortPracownik() {
        int choice=1;

        do{
            System.out.print("\n1. Sortuj według nazwy\n" +
                    "2. Sortuj według numeru Pesel\n" +
                    "3. Sortuj według wynagrodzenia brutto\n" +
                    "4. Sortuj według wynagrodzenia netto\n" +
                    "5. Powrót do menu głównego\n" +
                    "Podaj numer:" );
            int choice1 = input.nextInt();

            switch (choice1){
                case 1:
                    choice=1;

                    try {
                        connect();
                        stmt = conn.createStatement();

                        // Wyciagamy wszystkie pola z kolumny name
                        // znajdujące się w tabeli users
                        rs = stmt.executeQuery("SELECT * FROM Employee ORDER BY Nazwa ASC");
                        boolean ifExists = false;
                        while(rs.next()){
                            ifExists = true;
                            String Pesel = rs.getString(1);
                            String Nazwa = rs.getString(2);
                            String Rodzaj = rs.getString(3);
                            Double Brutto = rs.getDouble(4);
                            Double Netto = rs.getDouble(5);

                            System.out.println("Nazwa: " + Nazwa + " | Pesel: " + Pesel + " | Typ: " + Rodzaj + " | Wynagrodzenie brutto: "
                                    + Brutto+" | Wynagrodzenie netto: "+ Netto );
                        }

                        if(ifExists == false){
                            System.out.println("Żaden pracownik nie pasuje do podanych kryteriów!");
                        }
                    }catch (SQLException ex){
                        // handle any errors

                    }finally {
                        // zwalniamy zasoby, które nie będą potrzebne
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (SQLException sqlEx) { } // ignore
                            rs = null;
                        }

                        if (stmt != null) {
                            try {
                                stmt.close();
                            } catch (SQLException sqlEx) { } // ignore

                            stmt = null;
                        }
                    }

                    break;
                case 2:
                    choice=1;

                    try {
                        connect();
                        stmt = conn.createStatement();

                        // Wyciagamy wszystkie pola z kolumny name
                        // znajdujące się w tabeli users
                        rs = stmt.executeQuery("SELECT * FROM Employee ORDER BY Pesel ASC");
                        boolean ifExists = false;
                        while(rs.next()){
                            ifExists = true;
                            String Pesel = rs.getString(1);
                            String Nazwa = rs.getString(2);
                            String Rodzaj = rs.getString(3);
                            Double Brutto = rs.getDouble(4);
                            Double Netto = rs.getDouble(5);

                            System.out.println("Pesel: " + Pesel + " | Nazwa: " + Nazwa + " | Typ: " + Rodzaj + " | Wynagrodzenie brutto: "
                                    + Brutto+" | Wynagrodzenie netto: "+ Netto );
                        }

                        if(ifExists == false){
                            System.out.println("Żaden pracownik nie pasuje do podanych kryteriów!");
                        }
                    }catch (SQLException ex){
                        // handle any errors

                    }finally {
                        // zwalniamy zasoby, które nie będą potrzebne
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (SQLException sqlEx) { } // ignore
                            rs = null;
                        }

                        if (stmt != null) {
                            try {
                                stmt.close();
                            } catch (SQLException sqlEx) { } // ignore

                            stmt = null;
                        }
                    }

                    break;
                case 3:
                    choice=1;

                    try {
                        connect();
                        stmt = conn.createStatement();

                        // Wyciagamy wszystkie pola z kolumny name
                        // znajdujące się w tabeli users
                        rs = stmt.executeQuery("SELECT * FROM Employee ORDER BY Brutto ASC");
                        boolean ifExists = false;
                        while(rs.next()){
                            ifExists = true;
                            String Pesel = rs.getString(1);
                            String Nazwa = rs.getString(2);
                            String Rodzaj = rs.getString(3);
                            Double Brutto = rs.getDouble(4);
                            System.out.println("Wynagrodzenie brutto: " + Brutto + " | Pesel: " + Pesel + " | Nazwa: " + Nazwa + " | Typ: "
                                    + Rodzaj );
                        }

                        if(ifExists == false){
                            System.out.println("Żaden pracownik nie pasuje do podanych kryteriów!");
                        }
                    }catch (SQLException ex){
                        // handle any errors

                    }finally {
                        // zwalniamy zasoby, które nie będą potrzebne
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (SQLException sqlEx) { } // ignore
                            rs = null;
                        }

                        if (stmt != null) {
                            try {
                                stmt.close();
                            } catch (SQLException sqlEx) { } // ignore

                            stmt = null;
                        }
                    }

                    break;
                case 4:
                    choice=1;
                    try {
                        connect();
                        stmt = conn.createStatement();

                        // Wyciagamy wszystkie pola z kolumny name
                        // znajdujące się w tabeli users
                        rs = stmt.executeQuery("SELECT * FROM Employee ORDER BY Netto ASC");
                        boolean ifExists = false;
                        while(rs.next()){
                            ifExists = true;
                            String Pesel = rs.getString(1);
                            String Nazwa = rs.getString(2);
                            String Rodzaj = rs.getString(3);
                            Double Netto = rs.getDouble(5);
                            System.out.println("Wynagrodzenie netto: " + Netto + " | Pesel: " + Pesel + " | Nazwa: " + Nazwa + " | Typ: "
                                    + Rodzaj );
                        }

                        if(ifExists == false){
                            System.out.println("Żaden pracownik nie pasuje do podanych kryteriów!");
                        }
                    }catch (SQLException ex){
                        // handle any errors

                    }finally {
                        // zwalniamy zasoby, które nie będą potrzebne
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (SQLException sqlEx) { } // ignore
                            rs = null;
                        }

                        if (stmt != null) {
                            try {
                                stmt.close();
                            } catch (SQLException sqlEx) { } // ignore

                            stmt = null;
                        }
                    }
                    break;
                case 5:
                    choice=0;
                    System.out.println("\nPowrót do menu głownego!");
                    break;
                default:
                    choice=1;
                    System.out.println("\nPodałeś złą wartość!");
            }
        }while(choice==1);

    }
}
