import java.io.*;
import java.util.regex.Pattern;

public class Delayer {

    /**
     * Delay function
     *
     * @param in  input fie
     * @param out output file
     * @param delay how much we want to speed up or slow down subtitles
     * @param fps frames per second
     *
     * @throws FileNotFoundException  path to file is wrong
     * @throws EmptyFileException file content is empyty
     * @throws ArrayIndexOutOfBoundsException there is no arguments
     * @throws DataFormatException invalid frame sequence
     */

    static void delay(final String in, String out, int delay, int fps) throws EmptyFileException,
            ArrayIndexOutOfBoundsException, DataFormatException, IOException {

        File gravity = new File(in);
        File gravity_result = new File(out);

        BufferedReader input = new BufferedReader(new FileReader(gravity));
        FileWriter output = new FileWriter(gravity_result);

        Integer frameDelay = delay * fps / 1000;

        if (input.readLine()== null) {
            input.close();
            throw new EmptyFileException(in);
        }

        input = new BufferedReader(new FileReader(gravity));
        String tmp;
        Integer start, end;
        int i=0;
        while((tmp = input.readLine()) != null) {
            i++;
            String[] parts = tmp.split("}");

            if((Pattern.matches("\\{[[0-9]]*", parts[0])) && (Pattern.matches("\\{[[0-9]]*", parts[1]))){
                parts[0] = parts[0].substring(1);
                parts[1] = parts[1].substring(1);

                start = Integer.parseInt(parts[0]);
                end = Integer.parseInt(parts[1]);

                if(start >= end){
                    throw new DataFormatException(start, end, i);
                }

                start += frameDelay;
                end += frameDelay;

                output.write("{" + Integer.toString(start) + "}{" + Integer.toString(end) + "}"
                        + parts[2] + "\n");


            }else{
                throw new DataFormatException(i);
            }
        }
        output.close();
        input.close();
        System.out.print("Delay of subtitles edited successfully!");
    }
}
