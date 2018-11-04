/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import LoginPackage.*;
/**
 *
 * @author Jakub
 */
public class LoginProgram {
    public static void main(String[] argv){
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
            if(log.check(login, haslo) == true){
                System.out.print("OK");
            }else{
                System.out.print("Zły login lub hasło!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
