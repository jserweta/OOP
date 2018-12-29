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
/*
    public static boolean emptyString(String login, String haslo){
        if(login.equals("")|| haslo.equals("")){
            return true;
        }else{
            return false;
        }
    }*/

    public static void checkData(String login, String haslo)throws  LoginExceptions{
        Login log = new Login("ala", "makota");

        /*TODO: sprawdzenie czy podane hasło i login zgadzaja sie z tymi
         przechowywanymi w obiekcie log Jeśli tak, to ma zostać
         wyswietlone "OK", jesli nie - prosze wyswietlić informacje o błedzie
         */
        if(log.check(login, haslo)){
            System.out.print("Podano poprawne dane! Logowanie przebiegło pomyślnie!");
        }else if (login.equals("")|| haslo.equals("")){
            throw new LoginExceptions("Wprowadź dane!");
        }else{
            throw new LoginExceptions("Błędny login lub hasło!");
        }
    }

    public static void main(String[] argv) {

        try {
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            // TODO: prosba o wpisanie hasła i loginu
            System.out.print("Podaj login:");
            String login = bfr.readLine();
            System.out.print("Podaj hasło:");
            String haslo = bfr.readLine();

            checkData(login, haslo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}