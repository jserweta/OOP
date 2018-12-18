import java.io.*;
import java.util.Random;

public class GenerateRandoms implements Runnable{
    private FileWriter fw;

    GenerateRandoms(){
        try {
            fw = new FileWriter("randoms.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CreateFile(){
        try {
            Random random = new Random();
            for(int i = 0; i < 100; i++ ){
                for(int j = 0; j < 10_000; j++){
                    fw.write(random.nextInt(1000) + " ");
                }
                fw.write("\r\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run(){
        CreateFile();
    }
}