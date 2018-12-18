import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxMultiThread implements Runnable{

    private int choice;

    MaxMultiThread(int function_number){
        this.choice = function_number;
    }

    public static LinkedList<LinkedList<Integer>> getList(){
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();

        try {
            FileReader reader = new FileReader("randoms.txt");
            Scanner scr = new Scanner(reader);


            while(scr.hasNextLine()){
                String str = new String();
                str = scr.nextLine();
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
                Thread.sleep(25);
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
        if(choice == 1){
            for(LinkedList<Integer> l : list){
                for(Integer elem : l){
                    System.out.print(function_firts(elem) + " ");
                }
                System.out.println();
            }
        }else if(choice == 2){
            for(LinkedList<Integer> l : list){
                for(Integer elem : l){
                    System.out.print(function_second(elem) + " ");
                }
                System.out.println();
            }
        }
    }

    public int function_firts(int x){
        return 2*x*x+x+1;
    }

    public int function_second(int x){
        return 7*x+5;
    }
}