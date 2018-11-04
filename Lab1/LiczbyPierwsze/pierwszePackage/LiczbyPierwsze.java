package pierwszePackage;
import java.lang.*;


public class LiczbyPierwsze {
    public void list(int number){
        if(number < 1){
            System.out.print("Nie ma liczb pierwszych mniejszych od "+number);
        }else if(number == 1) {
            System.out.print("Liczba pierwsza to " + number);
        }else{
            System.out.print("Liczby pierwsze to: ");
            for(int i=2; i<number+1; i++){
                boolean tmp=true;
                for(int j=2; j<Math.sqrt(i)+1; j++){
                    if(i % j == 0){
                        tmp=false;
                    }
                }
                if(tmp) System.out.print(i+" ");
            }
        }


    }
}
