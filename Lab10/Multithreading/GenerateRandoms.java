import java.io.*;
import java.util.Random;

public class GenerateRandoms implements Runnable{
    private FileWriter writer;

    GenerateRandoms(){
        try {
            writer = new FileWriter("randoms.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void randomFile(){
        try {
            Random randomize = new Random();
            for(int i = 0; i < 100; i++ ){
                for(int j = 0; j < 10000; j++){
                    writer.write(randomize.nextInt(1000) + " ");
                }
                writer.write("\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run(){
        randomFile();
    }
}