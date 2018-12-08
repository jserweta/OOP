import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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

    public static void decryptfile(File source, File result, Algorithm algorithm) throws  IOException {
        Files.copy(result.toPath(), source.toPath(), StandardCopyOption.REPLACE_EXISTING);

        Scanner input = new Scanner(source);
        PrintWriter output = new PrintWriter(result);

        while(input.hasNextLine()){
            Scanner input2 = new Scanner(input.nextLine());
            while(input2.hasNext()){
                output.write(algorithm.decrypt(input2.next() ) + " ");
            }output.println();
        }

        input.close();
        output.close();
    }
}
