import java.io.IOException;

public class Pesel {

    public static boolean checkPesel(String pesel) throws IOException {
        int [] PESEL = new int [11];

        if(pesel.length() != 11){
            throw new IOException("PESEL musi mieć 11 cyfr!\n");
        }else if(!pesel.matches("[0-9]+")){
            throw new IOException("PESEL zawiera literę!\n");

        }else{
            for(int i=0; i<11; i++){
                PESEL[i] = Integer.parseInt(pesel.substring(i, i+1));
            }
        }

        int sum=0;

        sum = 1 * PESEL[0] + 3 * PESEL[1] + 7 * PESEL[2] + 9 * PESEL[3] + 1 * PESEL[4] + 3 * PESEL[5] +
                7 * PESEL[6] + 9 * PESEL[7] + 1 * PESEL[8] + 3 * PESEL[9] + 1 * PESEL[10];

        sum %= 10;

        if(sum == 0){
            return true;
        }else{
            throw new IOException("Podałeś zły numer PESEL!\n");
        }

    }
}
