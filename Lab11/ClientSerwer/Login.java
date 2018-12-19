import java.util.Random;

import static java.util.Collections.min;

public class Login {
    private static final String login = "admin";
    private static final String password = "qwerty";

    public static boolean LOG(String log, String pass){
        if(log.equals(login) && pass.equals(password)) return true;
        else return false;
    }

    public static String logIN(String log, String pass){
        String result = new String();
        if(log.equals(login) && pass.equals(password)){
            Random random = new Random();
            for(int i = 0; i < 10; i++){
                result += String.valueOf(random.nextInt(9));
            }
        }else{
            result = Levenshtein(pass);
        }

        return result;
    }

    private static String Levenshtein(String s1) {


        int[] v0 = new int[password.length() + 1];
        int[] v1 = new int[password.length() + 1];
        int[] vtemp;


        for (int i = 0; i < v0.length; i++) {
            v0[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            v1[0] = i + 1;

            int minv1 = v1[0];


            for (int j = 0; j < password.length(); j++) {
                int cost = 1;
                if (s1.charAt(i) == password.charAt(j)) {
                    cost = 0;
                }
                v1[j + 1] = Math.min(
                        v1[j] + 1,
                        Math.min(
                                v0[j + 1] + 1,
                                v0[j] + cost));

                minv1 = Math.min(minv1, v1[j + 1]);
            }

            vtemp = v0;
            v0 = v1;
            v1 = vtemp;

        }

        return String.valueOf(v0[password.length()]);
    }
    
}


