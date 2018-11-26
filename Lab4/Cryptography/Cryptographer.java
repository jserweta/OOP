import java.io.*;
import java.util.Scanner;

public class Cryptographer {
    public static void cryptfile(File source, File result, Algorithm algorithm)throws FileNotFoundException {
        Scanner input = new Scanner(source);
        PrintWriter output = new PrintWriter(result);


        while(input.hasNextLine()){
            Scanner input2 = new Scanner(input.nextLine());
            while(input2.hasNext()){
                output.write(algorithm.crypt(input2.next() ) + " ");
            }output.println();
        }

        input.close();
        output.close();
    }

    public static void decryptfile(File source, File result, Algorithm algorithm) throws FileNotFoundException {
        Scanner input = new Scanner(result);
        PrintWriter output = new PrintWriter(source);

        while(input.hasNextLine()){
            Scanner input2 = new Scanner(input.nextLine());
            while(input2.hasNext()){
                output.append(algorithm.decrypt(input2.next() ) + " ");
            }output.println();
        }

        input.close();
        output.close();
    }
}
