import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxMultiThread implements Runnable{

    MaxMultiThread(){
    }

    public static LinkedList<LinkedList<Integer>> getList(){
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();

        try {
            FileReader reader = new FileReader("randoms.txt");
            Scanner input = new Scanner(reader);


            while(input.hasNextLine()){
                String str;
                str = input.nextLine();
                String number = new String();

                LinkedList<Integer> temp = new LinkedList<>();

                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) == ' '){
                        temp.add(Integer.parseInt(number));
                        number = "";
                        continue;
                    }
                    else{
                        number += str.charAt(i);
                    }
                }
                list.add(temp);
                Thread.sleep(10);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void run(){
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        list = getList();

            for(LinkedList<Integer> l : list){
                for(Integer x : l){
                    System.out.print(function(x) + " ");
                }
                System.out.println();
            }
    }

    public int function(int x){
        return x*x;
    }

}