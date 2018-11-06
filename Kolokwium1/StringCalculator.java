package appl;
import java.io.*;
import java.util.Scanner;

public class StringCalculator extends Calculator{

    public StringCalculator(String x) {

    }

    @Override
    public void Add(String x){
        x=x+result;
        System.out.print(x);
    }

    @Override
    public void Subtract(String x){

    }
    @Override
    public void Multipy(int z){
        for(int i=0; i<z; i++){
            x+=x;
        }
    }

    public static void main(String[] args) {
        try{
            int z;
            String x;

            Scanner podaj=new Scanner(System.in);

            System.out.print("Podaj ilosc zwielokrotnienia napisu");
            z=podaj.nextInt();

            System.out.print("Podaj napis");
            x=podaj.nextLine();

        System.out.print("wynik dodawania napisów:");
            Calculator.Add(x);

        }catch(){}
    }
}
