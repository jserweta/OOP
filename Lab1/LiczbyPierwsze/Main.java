import pierwszePackage.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        int number = JIn.input();
        LiczbyPierwsze primar = new LiczbyPierwsze();
        primar.list(number);
    }
}
