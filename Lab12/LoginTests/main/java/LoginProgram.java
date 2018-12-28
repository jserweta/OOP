/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author Jakub Serweta
 */
public class LoginProgram {

    public static int emptyString(String login, String haslo){
        if(login.equals("")|| haslo.equals("")){
            return 0;
        }else{
            return 1;
        }
    }

    public static void main(String[] argv) throws IOException {
        Login log = new Login("ala", "makota");
        try {
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            // TODO: prosba o wpisanie hasła i loginu
            System.out.print("Podaj login:");
            String login = bfr.readLine();
            System.out.print("Podaj hasło:");
            String haslo = bfr.readLine();


        /*TODO: sprawdzenie czy podane hasło i login zgadzaja sie z tymi
         przechowywanymi w obiekcie log Jeśli tak, to ma zostać
         wyswietlone "OK", jesli nie - prosze wyswietlić informacje o błedzie
         */
            if(log.check(login, haslo)){
                System.out.print("Podano poprawne dane! Logowanie przebiegło pomyślnie!");
            }else if (emptyString(login, haslo)==0){
                throw new LoginExceptions("Wprowadź dane!");
            }else{
                throw new LoginExceptions("Błędny login lub hasło!");
            }

        } catch (LoginExceptions e) {
            e.printStackTrace();
        }
    }
}