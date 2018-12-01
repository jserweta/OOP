public class DataFormatException extends Exception{

    public DataFormatException(int i){
        System.out.println("Wrong data format in file! Check line: "+i);
    }

    public DataFormatException(int start, int end, int i){
        System.out.println("Invalid start and end frame of subtitles! Start: "+start+" End: "+end+" Line of error: "+ i);
    }
}

