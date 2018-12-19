import java.io.File;

public class Ls {
    public static String listing(){
        String result = new String();
        File fr = new File("../ClientSerwer/");
        File[] folderEntries = fr.listFiles();

        for(File entry : folderEntries){
            if(entry.isFile()){
                result += entry.getName() + " ";
            }
        }
        String[] sort = result.split(" ");
        result = "";
        for(String s : sort){
            String[] tmp = s.split("\\.");
            if(tmp[1].equals("txt")){
                result += tmp[0] + ";";
            }
        }

        return result;
    }
}