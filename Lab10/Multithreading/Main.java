public class Main  {
    public static void main(String[] args) throws InterruptedException {
        MaxMultiThread mlt = new MaxMultiThread(1);
        GenerateRandoms gen = new GenerateRandoms();

        Thread thread1 = new Thread(gen);
        Thread thread2 = new Thread(mlt);

        thread1.start();
        thread2.start();
    }
}