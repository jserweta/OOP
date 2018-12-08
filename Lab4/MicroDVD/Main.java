import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try{
            Delayer.delay(args[0], args[1], 100, 60);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong number of arguments!");
        } catch (EmptyFileException | DataFormatException e) {
            e.getMessage();
        } catch (IOException e) {
           System.out.print("Wrong path to file!/File not found: "+args[0]);
        }

    }
}
