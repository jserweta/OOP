import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Get {
    public static String GetFile(String file){
        String result = new String();
        try {
            FileReader fr = new FileReader("../ClientSerwer/" + file);
            BufferedReader bf = new BufferedReader(fr);

            result += bf.readLine();

            bf.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}