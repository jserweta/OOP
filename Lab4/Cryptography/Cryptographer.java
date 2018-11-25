import java.io.*;
import java.util.Scanner;

public class Cryptographer {
    public static void cryptfile(File source, File result, Algorithm algorithm)throws FileNotFoundException {
        Scanner input = new Scanner(source);
        PrintWriter output = new PrintWriter(result);


        while(input.hasNext()){
            output.write(algorithm.crypt(input.next() ) + " ");
        }

        input.close();
        output.close();
    }

    public static void decryptfile(File source, File result, Algorithm algorithm) throws FileNotFoundException {
        Scanner input = new Scanner(source);
        PrintWriter output = new PrintWriter(result);

        while(input.hasNext()){
            output.write(algorithm.decrypt(input.next() ) + " ");
        }

        input.close();
        output.close();
    }
}
