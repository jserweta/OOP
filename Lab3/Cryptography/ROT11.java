public class ROT11 implements Algorithm{

    private final int move = 11;
    private static final char[] alphabet= { 'a', 'b', 'c', 'd',
                                            'e', 'f', 'g', 'h',
                                            'i', 'j', 'k', 'l',
                                            'm', 'n', 'o', 'p',
                                            'q', 'r', 's', 't',
                                            'u', 'v', 'w', 'x',
                                            'y', 'z', 'A', 'B',
                                            'C', 'D', 'E', 'F',
                                            'G', 'H', 'I', 'J',
                                            'K', 'L', 'M', 'N',
                                            'O', 'P', 'Q', 'R',
                                            'S', 'T', 'U', 'V',
                                            'W', 'X', 'Y', 'Z' };

    @Override
    public String crypt(String word) {

        char[] values = word.toCharArray();
        for (int i = 0; i < values.length; i++) {
            char letter = values[i];

            if (letter >= alphabet[0] && letter<= alphabet[25]) {

                if (letter > alphabet[15]) {
                    letter -= 26 - move;
                } else {
                    letter += move;
                }
            } else if (letter >= alphabet[26] && letter <= alphabet[51]) {

                if (letter > alphabet[40]) {
                    letter -= 26- move;
                } else {
                    letter += move;
                }
            }
            values[i] = letter;
        }
        String encryptedWord = new String(values);

        return encryptedWord;

    }

    @Override
    public String decrypt(String word) {

        char[] values = word.toCharArray();
        for (int i = 0; i < values.length; i++) {
            char letter = values[i];

            if (letter >= alphabet[0] && letter<= alphabet[25]) {

                if (letter < alphabet[11]) {
                    letter += 26 - move;
                } else {
                    letter -= move;
                }
            } else if (letter >= alphabet[26] && letter <= alphabet[51]) {

                if (letter < alphabet[35]) {
                    letter += 26- move;
                } else {
                    letter -= move;
                }
            }
            values[i] = letter;
        }
        String decryptedWord = new String(values);

        return decryptedWord;
    }
}
