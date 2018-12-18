public class Main  {
    public static void main(String[] args){

        MaxMultiThread multithread = new MaxMultiThread();
        GenerateRandoms generate = new GenerateRandoms();

        Thread firstThread = new Thread(generate);
        Thread secondThread = new Thread(multithread);

        firstThread.start();
        secondThread.start();
    }
}