public class EmptyFileException extends Exception {

    public EmptyFileException(String in){
        System.out.println("Attached file is empty! Check content of: " +in);
    }

}
